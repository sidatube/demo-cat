<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.demo_cat.entity.Product" %>
<%@ page import="java.util.HashSet" %>
<%

    List<Product> listObj = (List<Product>) request.getAttribute("listProducts");
    HashSet<Product> recentView = (HashSet<Product>) session.getAttribute("recentView");
    if (recentView == null) {
        recentView = new HashSet<>();
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

    <a href="/products/create" class="w3-btn w3-blue">Create Product</a>
    <a href="/products/cart" class="w3-btn w3-blue">Cart</a>

    <table class="w3-table-all w3-card-4">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Thumbnail</th>
            <th>Price</th>
            <th>Status</th>
            <th>Action</th>
        </tr>
        <% for (Product obj : listObj
        ) {
        %>
        <tr>
            <td><%=obj.getId()%>
            </td>
            <td><%=obj.getName()%>
            </td>
            <td><img src="<%=obj.getThumbnail()%>" style="width:200px" alt=""></td>
            <td><%=obj.getPrice()%>
            </td>
            <td><%=obj.getStatus()%>
            </td>
            <td><a href="/products/detail?id=<%=obj.getId()%>" class="w3-btn w3-blue">
                Detail
            </a> &nbsp&nbsp<a href="/products/edit?id=<%=obj.getId()%>" class="w3-btn w3-blue">
                Edit
            </a>&nbsp&nbsp<a href="/products/delete?id=<%=obj.getId()%>" class="w3-btn w3-blue btn-delete">
                Delete
            </a></td>
        </tr>
        <%
            }
        %>
    </table>
    <% if (recentView.size() > 0) {%>
    <ul class="w3-ul w3-card-4">
        <% for (Product obj : recentView
        ) {%>
        <li class="w3-bar">
            <span onclick="this.parentElement.style.display='none'"
                  class="w3-bar-item w3-button w3-white w3-xlarge w3-right">×</span>
            <img src="<%=obj.getThumbnail()%>" class="w3-bar-item w3-circle w3-hide-small" style="width:85px">
            <div class="w3-bar-item">
                <span class="w3-large"><%=obj.getName()%></span><br>
                <span><%=obj.getPrice()%> VND</span>
            </div>
        </li>

        <%}%>

    </ul>
    <%}%>
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
                            window.location.href = '/products'
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

