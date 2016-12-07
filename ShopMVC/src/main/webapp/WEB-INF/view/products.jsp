<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
 <%@ include file="/WEB-INF/view/header.jsp" %>
	    <br />
    <br />
    <br />

   <!-- Product List  -->
   <div class="container">
   <div class="page-header">
   <h1>Product List</h1>
   <p class="lead">This is the list of the products in the store</p>
   </div>
   <table class="table table-striped"> 
   	<thead>
   		<tr>
   			<th>Picture</th>
   			<th>Name</th>
   			<th>Description</th>
   			<th>Manufacturier</th>
   			<th>Condition</th>
   			<th>Status</th>
   			<th>Price</th>
   			<th>Units in Stock</th>
   			<th>Details</th>
   		</tr>
   	</thead>
   	<tbody>
   		<c:forEach items="${products}" var="p">
   		<tr>
   			<td><img class="img-thumbnail" src='<c:url value="/resources/images/${p.id}.png"/>' alt="image" width="50" height="50"/></td>
   			<td>${p.name}</td>
   			<td>${p.description}</td>
   			<td>${p.manufacturier}</td>
   			<td>${p.condition}</td>
   			<td>${p.status}</td>
   			<td>${p.price} $</td>
   			<td>${p.unitsInStock}</td>
   			<td>
   				<a href="<c:url value="/productDetail/${p.id}"/>"><span class="glyphicon glyphicon-info-sign"></span></a>
   				<a href="<c:url value="/admin/delete/${p.id}"/>"><span class="glyphicon glyphicon-trash"></span></a>
   				<a href="<c:url value="/admin/edit/${p.id}"/>"><span class="glyphicon glyphicon-pencil"></span></a>
   			</td>
   		</tr>
   		</c:forEach>
   	</tbody>
   </table>
   
   <br />
   <a class="btn btn-primary" href="<c:url value="/admin/addProduct"/>">Add Product</a>
	<br />
	<!-- End of productList -->
 <%@ include file="/WEB-INF/view/footer.jsp" %>
