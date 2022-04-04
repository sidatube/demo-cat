<%@ page import="java.util.List" %>
<%@ page import="com.example.demo_cat.entity.Student" %><%

    List<Student> listSt= (List<Student>) request.getAttribute("listStudents");
%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<head>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
</head>
<body>

<h2>HTML Table</h2>

<a href="/students/create" class="w3-btn w3-blue">Create Student</a>

<table>
    <tr>
        <th>RollNumber</th>
        <th>Name</th>
        <th>Email</th>
    </tr>
    <% for (Student st: listSt
            ) {
        %>
    <tr>
        <td><%=st.getRollName()%></td>
        <td><%=st.getName()%></td>
        <td><%=st.getEmail()%></td>
    </tr>
    <%
    }
    %>


</table>

</body>
</html>

