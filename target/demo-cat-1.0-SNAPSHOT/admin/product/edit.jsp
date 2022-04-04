<%@ page import="com.example.demo_cat.entity.Product" %>
<% Product obj =(Product) request.getAttribute("obj");
    String url = "/products/create";
%>
<!DOCTYPE html>
<html>
<title>Create Student</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<body>

<div class="w3-container w3-blue">
    <h2>Edit product</h2>
</div>

<form class="w3-container" action="/products/edit" method="post">
    <input type="hidden" value="<%=obj.getId()%>" name="id">
    <p>
        <label>Name </label>
        <input class="w3-input" name="name" value="<%=obj.getName()%>" type="text"></p>
    <p>
        <label>Thumbnail </label>
        <input class="w3-input" name="thumbnail" value="<%=obj.getThumbnail()%>" type="text"></p>
    <p>
        <label>Price</label>
        <input class="w3-input" step="0.001" name="price" value="<%=obj.getPrice()%>" type="number"></p>
    <p>
        <label>Status</label>
        <input class="w3-input" name="status" value="<%=obj.getStatus()%>" type="number"></p>
    <p>
        <button class="w3-btn w3-blue">
            Update
          </button>
    <button type="reset" class="w3-btn w3-khaki">Reset</button></p>
</form>

</body>
</html>
