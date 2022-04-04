<%@ page import="com.example.demo_cat.entity.Product" %>
<%
    Product obj = (Product) request.getAttribute("obj");
    String addSuccess = (String) request.getAttribute("AddSuccess");

%>
<!DOCTYPE html>
<html>
<title>product detail</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<body>

<div class="w3-container">
    <div class="w3-card-4 w3-dark-grey" style="width:50%">
        <%
            if (addSuccess != null && addSuccess.length() > 0) {
        %>
        <div class="w3-panel w3-green">
            <p><%=addSuccess%>
            </p>
        </div>
        <%
            }%>

        <div class="w3-container w3-center">
            <h3><%=obj.getName()%>
            </h3>
            <img src="<%=obj.getThumbnail()%>" alt="Avatar" style="width:500px">
            <h5><%=obj.getPrice()%> VND</h5>

            <form name="submitForm" method="GET" action="/products/addToCart">
                <input type="hidden" name="productId" value="<%=obj.getId()%>">
                <input type="number" name="qty" value="1" >
                <button class="w3-button w3-green" type="submit">Add to cart</button>
            </form>
            <a href="/products" class="w3-button w3-red">Back</a></p>

        </div>

    </div>

</div>


</body>
</html>
