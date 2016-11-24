<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="en">
<%@ include file="/WEB-INF/view/header.jsp"%>

<br />
<br />
<br />

<!-- Product List  -->
<div class="container">
	<div class="page-header">
		<h1>Add product</h1>
		<p class="lead">This is the add product form</p>
	</div>

	<form:form class="form-horizontal" action="addProduct" commandName="product"
		method="post">
		<div class="form-group">
			<label for="name" class="col-sm-2 control-label">Product Name</label>
			<div class="col-sm-10">
				<form:input type="text" class="form-control" id="name" placeholder="Name"
					path="name"/>
			</div>
		</div>
		<div class="form-group">
			<label for="description" class="col-sm-2 control-label">Product
				Description</label>
			<div class="col-sm-10">
				<textarea class="form-control" id="description"
					placeholder="Description" name="description" rows="5" cols="40"></textarea>
			</div>
		</div>
		
		<div class="form-group">
			<label for="category" class="col-sm-2 control-label">Product
				Category</label>
			<div class="checkbox checkbox-inline">
				<label><form:radiobutton class="form-control" id="description"
					path="category" value="Instruments" checked="true"/>Instruments</label>
			</div>
			<div class="checkbox checkbox-inline">
				<label><form:radiobutton class="form-control" id="description"
					 path="category" value="Accesories"/>Accesories</label>
			</div>
		</div>
		
		<div class="form-group">
			<label for="condition" class="col-sm-2 control-label">Product
				Condition</label>
				<div class="checkbox checkbox-inline">
					<label> <form:checkbox path="condition" id="condition"
						value="New" checked="true"/>Product is New
					</label>
				</div>
				<div class="checkbox checkbox-inline">
					<label> <form:checkbox path="condition" id="condition"
						value="Used"/>Product is Used
					</label>
				</div>
		</div>

		<div class="form-group">
			<label for="unitsInStock" class="col-sm-2 control-label">Stocks</label>
			<div class="col-sm-10">
				<form:input type="text" class="form-control" id="unitsInStock"
					placeholder="Stock" path="unitsInStock"/>
			</div>
		</div>
		
		<div class="form-group">
			<label for="manufacturier" class="col-sm-2 control-label">Product
				Manufacturier</label>
			<div class="col-sm-10">
				<form:input type="text" class="form-control" id="manufacturier"
					placeholder="Manufacturier" path="manufacturier"/>
			</div>
		</div>

		<div class="form-group">
			<label for="price" class="col-sm-2 control-label">Product
				Price</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="price"
					placeholder="price $" name="price">
			</div>
		</div>
		
		<!-- <div class="form-group">
			<label for="photo" class="col-sm-2 control-label">Product
				Photo</label>
			<div class="col-sm-10">
				<input type="file" class="form-control" id="photo"
					name="photo">
			</div>
		</div> -->

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-primary">Add Product</button>
			</div>
		</div>
	</form:form>

	<br />

	<!-- End of productList -->
	<%@ include file="/WEB-INF/view/footer.jsp"%>