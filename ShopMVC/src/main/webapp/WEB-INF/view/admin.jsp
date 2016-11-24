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
		<h1>Admin Page</h1>
		<p class="lead">Description: ${product.description}</p>
	</div>

	<div class="col-md-8">
		<h3><a href='<c:url value="/admin/products"/>'>Manage Products</a></h3>
	</div>

	<br />

	<!-- End of productList -->
	<%@ include file="/WEB-INF/view/footer.jsp"%>