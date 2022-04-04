<%@ page import="java.util.HashMap" %>
<%
    HashMap<String, String> errors = (HashMap<String, String>) request.getAttribute("errors");
    if (errors == null) {
        errors = new HashMap<>();
    }
%>
<!DOCTYPE html>
<html>
<title>Create Student</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<body>

<div class="w3-container w3-blue">
    <h2>Input Form</h2>
</div>

<form class="w3-container" action="/students/create" method="post">
    <p>
        <label>RollNumber</label>
        <input class="w3-input" name="rollName" type="text"></p>
    <% if (errors.containsKey("rollName")) {%>
    <span class="w3-text-red"><%=errors.get("rollName")%> </span>
    <% }%>
    <p>
        <label>Name</label>
        <input class="w3-input" name="name" type="text"></p>
    <% if (errors.containsKey("name")) {%>
    <span class="w3-text-red"><%=errors.get("name")%> </span>
    <% }%>
    <p>
        <label>Email</label>
        <input class="w3-input" name="email" type="text"></p>
    <% if (errors.containsKey("email")) {%>
    <span class="w3-text-red"><%=errors.get("email")%> </span>
    <% }%>
    <p>
        <button class="w3-btn w3-blue">Create</button>
        <button type="reset" class="w3-btn w3-khaki">Reset</button>
    </p>
</form>

</body>
</html>
