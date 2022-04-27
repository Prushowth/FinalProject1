<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"% isELIgnored="false"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset=""UTF-8">
<title>Insert title here</title>
</head>
<body>

<div align="center">
<h1>Medicine</h1>
<br>
<a href = "/new">Add Medicine details</a>
<table>
<thead>
<tr>
<td>ID</td>
<td>Name</td>
<td>Brand</td>
<td>Quantity</td>
<td>Price</td>
<td>Category</td>
<td>Activate</td>
<td>Edit</td>
</tr>
</thead>
<tbody>
<tr th:each="med:${medicineList}" >
<td th:text="${med.id}">id</td>
<td th:text="${med.name}">id</td>
<td th:text="${med.brand}">id</td>
<td th:text="${med.availableQuantity}">id</td>
<td th:text="${med.unitPrice}">id</td>
<td th:text="${med.category}">id</td>
<td>
<a th:href="">Activate</a>
</td>
<td>
<a th:href="">Edit</a>
</td>









</tbody>

</table>
</div>

</body>
</html>