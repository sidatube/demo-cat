<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.example.demo_cat.entity.CartItem" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.demo_cat.entity.Cart" %>
<%

    Cart cart = (Cart) session.getAttribute("cartShopping");
    if (cart==null){
        cart = new Cart();
    }
%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<head>
    <meta charset="UTF-8">
</head>
<body>
<div class="w3-container">
    <h2>HTML Table</h2>

    <a href="/products" class="w3-btn w3-blue">Back</a>
    <table class="w3-table-all w3-card-4">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Thumbnail</th>
            <th>Price</th>
            <th>Qty</th>
            <th>Total</th>
            <th>Action</th>
        </tr>
        <% for (CartItem obj : cart.getListItem()
        ) {
        %>
        <tr>
            <td><%=obj.getProductId()%>
            </td>
            <td><%=obj.getProductName()%>
            </td>
            <td><img src="<%=obj.getThumbnail()%>" style="width:200px" alt=""></td>
            <td><%=obj.getUtilPRice()%> VND
            </td>
            <td><%=obj.getQty()%>
            </td>
            <td><%=obj.getTotal()%>
            </td>
            <td><a href="/products/removeCart?id=<%=obj.getProductId()%>" class="w3-btn w3-blue btn-delete">
                Delete
            </a></td>
        </tr>
        <%
            }
        %>
    </table>



</div>


</body>
<script>
    document.addEventListener('DOMContentLoaded', function () {
        let listDeleteBtn = document.querySelectorAll('.btn-delete');
        for (let i = 0; i < listDeleteBtn.length; i++) {
            listDeleteBtn[i].addEventListener('click', function (event) {
                event.preventDefault();
                if (confirm("Are U sure?")) {
                    let xhr = new XMLHttpRequest();
                    xhr.onreadystatechange = function () {
                        if (xhr.readyState == 4 && xhr.status == 200) {
                            alert("Deleted!")
                            window.location.href = '/products/cart'
                        }
                    }
                    xhr.open('POST', this.href, false);
                    xhr.send();

                }
            })
        }
    })
</script>
</html>

