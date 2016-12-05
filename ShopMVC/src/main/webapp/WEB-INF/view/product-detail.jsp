<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<%@ include file="/WEB-INF/view/header.jsp"%>

<br />
<br />
<br />

<!-- Product List  -->
<div class="container">
	<div class="page-header">
		<h1>${product.name}</h1>
		<p class="lead">Description: ${product.description}</p>
	</div>
	<div class="col-sm-4">
		<img alt="image"
			src='<c:url value="/resources/images/${product.id}.png"/>'
			class="img-rounded" width="200" height="200">
	</div>
	<div class="col-sm-8">
		<p>Manufacturier: ${product.manufacturier}</p>
		<p>Condition: ${product.condition}</p>
		<p>Status: ${product.status}</p>
		<p>Units in stock: ${product.unitsInStock }</p>
		<h3>Price: $ ${product.price }</h3>
	</div>


	
	<!-- End of productList -->
	<%@ include file="/WEB-INF/view/footer.jsp"%>