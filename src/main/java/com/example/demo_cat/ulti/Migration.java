package com.example.demo_cat.ulti;

import com.example.demo_cat.annotation.Column;
import com.example.demo_cat.annotation.ForeignKey;
import com.example.demo_cat.annotation.Id;
import com.example.demo_cat.annotation.Table;
import com.example.demo_cat.entity.NhanVien;
import com.example.demo_cat.ulti.Config.Config;
import com.example.demo_cat.ulti.Config.ConfigSql;
import org.reflections.Reflections;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.Set;

public class Migration {
    private static Connection connection;

    {
        try {
            connection = ConnectionHelper.createConnection();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Reflections reflections = new Reflections("com.example.demo_cat");
        Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(Table.class);
        for (Class<?> table : annotated
        ) {
            createTable(table);
//            dropTable(table);
        }


    }

    public static boolean isExistsTable(String tableName) {
        try {
            String checkSql = ConfigSql.SELECT +
                    ConfigSql.SPACE +
                    ConfigSql.COUNT +
                    ConfigSql.OPEN_BRACKET +
                    ConfigSql.STAR +
                    ConfigSql.CLOSE_BRACKET +
                    ConfigSql.SPACE +
                    ConfigSql.FROM +
                    ConfigSql.SPACE +
                    ConfigSql.INFORMATION_SCHEMA +
                    ConfigSql.SPACE +
                    ConfigSql.WHERE +
                    ConfigSql.SPACE +
                    ConfigSql.TABLE_SCHEMA +
                    ConfigSql.SPACE +
                    ConfigSql.EQUAL_SIGN +
                    ConfigSql.SPACE +
                    ConfigSql.QUESTION +
                    ConfigSql.SPACE +
                    ConfigSql.AND +
                    ConfigSql.SPACE +
                    ConfigSql.TABLE_NAME +
                    ConfigSql.EQUAL_SIGN +
                    ConfigSql.SPACE +
                    ConfigSql.QUESTION;
            PreparedStatement stt = connection.prepareStatement(checkSql);
            stt.setString(1, Config.DB_NAME);
            stt.setString(2, tableName);
            ResultSet resultSet = stt.executeQuery();

            if (resultSet.next()) {
                if (resultSet.getInt(1) > 0)
                    return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }
    public static void dropTable(Class clazz){
        if (!clazz.isAnnotationPresent(Table.class)) {
            return;
        }
        StringBuilder sqlString = new StringBuilder();
        sqlString.append(ConfigSql.CREATE_TABLE);
        sqlString.append(ConfigSql.SPACE);
        String tableName = clazz.getSimpleName().toLowerCase() + "s";
        Table table = (Table) clazz.getDeclaredAnnotation(Table.class);
        if (table.name().length() > 0) {
            tableName = table.name();
        }
        if (!isExistsTable(tableName)) {
            return;
        }
        try {
            Statement DropStt = connection.createStatement();
            DropStt.execute(String.format(ConfigSql.DROP_TABLE+" %s",tableName));
            System.out.printf("Delete table %s success\n",tableName);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void createTable(Class clazz) {
        if (!clazz.isAnnotationPresent(Table.class)) {
            return;
        }
        StringBuilder sqlString = new StringBuilder();
        sqlString.append(ConfigSql.CREATE_TABLE);
        sqlString.append(ConfigSql.SPACE);
        String tableName = clazz.getSimpleName().toLowerCase() + "s";
        Table table = (Table) clazz.getDeclaredAnnotation(Table.class);
        if (table.name().length() > 0) {
            tableName = table.name();
        }
        if (isExistsTable(tableName)) {
            return;
        }
        sqlString.append(tableName);
        sqlString.append(ConfigSql.SPACE);
        sqlString.append(ConfigSql.OPEN_BRACKET);
        Field[] listField = clazz.getDeclaredFields();
        for (Field field : listField
        ) {
            String columnName = field.getName();
            String columnType = "";
            if (field.getType().getSimpleName().contains("String")) {
                columnType = "VARCHAR(250)";
            } else {
                columnType = field.getType().getSimpleName();
            }
            if (field.isAnnotationPresent(Column.class)) {
                Column column = field.getDeclaredAnnotation(Column.class);
                columnName = column.name();
                columnType = column.type();
                sqlString.append(columnName);
                sqlString.append(ConfigSql.SPACE);
//            sqlString.append(field.getType().getSimpleName());
                sqlString.append(columnType);
                sqlString.append(ConfigSql.SPACE);
                if (field.isAnnotationPresent(Id.class)) {
                    Id id = field.getDeclaredAnnotation(Id.class);
                    sqlString.append(ConfigSql.PRIMARY_KEY);
                    sqlString.append(ConfigSql.SPACE);
                    if (id.AutoIncrement()) {
                        sqlString.append(ConfigSql.AUTO_INCREMENT);
                        sqlString.append(ConfigSql.SPACE);
                    }
                }
                if (field.isAnnotationPresent(ForeignKey.class)) {
                    ForeignKey foreignKey = field.getAnnotation(ForeignKey.class);
                    // check có bảng hay chưa
                    if (isExistsTable(foreignKey.referenceTable())) {
                        Reflections reflections = new Reflections("com.example.demo_cat");
                        Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(Table.class);
                        for (Class<?> preTable : annotated
                        ) {
                            Table preTableName= preTable.getDeclaredAnnotation(Table.class);
                            if (preTableName.name().equals(foreignKey.referenceTable())){
                                createTable(preTable);
                            }
                        }
                    }
                    //end
                    sqlString.append(ConfigSql.COMMA);
                    sqlString.append(ConfigSql.FOREIGN_KEY);
                    sqlString.append(ConfigSql.SPACE);
                    sqlString.append(ConfigSql.OPEN_BRACKET);
                    sqlString.append(columnName);
                    sqlString.append(ConfigSql.CLOSE_BRACKET);
                    sqlString.append(ConfigSql.SPACE);
                    sqlString.append(ConfigSql.REFERENCES);
                    sqlString.append(ConfigSql.SPACE);
                    sqlString.append(foreignKey.referenceTable());
                    sqlString.append(ConfigSql.OPEN_BRACKET);
                    sqlString.append(foreignKey.referenceColumn());
                    sqlString.append(ConfigSql.CLOSE_BRACKET);
                }
                sqlString.append(ConfigSql.COMMA);
            }

        }
        sqlString.setLength(sqlString.length() - 1);
        sqlString.append(ConfigSql.CLOSE_BRACKET);
        System.out.println(sqlString.toString());

        try {
            PreparedStatement statement = connection.prepareStatement(sqlString.toString());
            statement.execute();
            System.out.printf(ConfigSql.CREATE_TABLE+" %s success%n", tableName);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
