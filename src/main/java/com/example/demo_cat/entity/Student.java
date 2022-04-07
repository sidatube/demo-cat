package com.example.demo_cat.entity;

import com.example.demo_cat.annotation.Column;
import com.example.demo_cat.annotation.Id;
import com.example.demo_cat.annotation.Table;
import com.example.demo_cat.ulti.ValidateUtil;

import java.util.HashMap;

@Table(name = "students")
public class Student {
    @Id(AutoIncrement = true)
    @Column(name = "id", type = "INT")
    private int id;
    @Column(name = "rollName", type = "VARCHAR(250)")
    private String rollName;
    @Column(name = "email", type = "VARCHAR(250)")
    private String email;
    @Column(name = "name", type = "VARCHAR(250)")
    private String name;
    @Column(name = "status", type = "INT")
    private int status;

    private HashMap<String ,String > errors ;
    private void  checkValid(){
        this.errors=new HashMap<>();
        if (this.name==null||this.name.length()==0){
            this.errors.put("name","Name is required");
        }
        if (this.rollName==null||this.rollName.length()==0){
            this.errors.put("rollName","RollName is required");
        }
        if (this.email==null||this.email.length()==0){
            this.errors.put("email","Email is required");
        }
        if (ValidateUtil.checkEmail(this.email)){
            this.errors.put("email","Email is error");
        }
    }
    public HashMap<String ,String >getErrors(){
        checkValid();
        return errors;
    }
    public boolean isValid(){
        checkValid();
        return errors==null||errors.size()==0;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Student() {
    }

    public Student(String rollName, String email, String name) {
        this.rollName = rollName;
        this.email = email;
        this.name = name;
        this.status=1;
    }

    public Student(int id, String rollName, String email, String name) {
        this.id = id;
        this.rollName = rollName;
        this.email = email;
        this.name = name;
        this.status=1;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRollName() {
        return rollName;
    }

    public void setRollName(String rollName) {
        this.rollName = rollName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", rollName='" + rollName + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", status=" + status +
                '}';
    }
}
