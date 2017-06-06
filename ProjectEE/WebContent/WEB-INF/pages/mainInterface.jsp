<%@page import="com.trainingcenter.projectee.utils.HttpUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="css/styles.css">
<script src="script/validateReg.js"></script>


<script src="script/fillForm.js"></script>


<title>Registration</title>
</head>
<body class="main-interface">
	<div class="page-header">
		<h1>
			Example page header <small>Subtext for header</small>
		</h1>
	</div>

	<div class='container'>
		<div class='col-xs-2'>
			<p>
				<a href="./" class='btn btn-primary'>Кнопка меню 1</a>
			</p>
			<p>
				<a href="./" class='btn btn-primary'>Кнопка меню 2</a>
			</p>
			<p>
				<a href="./" class='btn btn-primary'>Кнопка меню 3</a>
			</p>
		</div>

		<div class='col-xs-8'>
			<form id="primaryTable" method="post" class="form-group"
				onsubmit="true" action="jdbcDB">
				<table>
					<tr>
						<td colspan="3"><h3>В базе содержатся следующие
								продукты:</h3></td>
					</tr>


					<tr>
						<td><label for="newProduct">Добавить товар:&nbsp;</label></td>
						<td><input type="text" size="30" maxlength="50"
							class="form-control" id="Product" name="Product"></td>
						<td>&nbsp;
							<button name="button" type="submit" value="Add"
								class="btn btn-primary">Добавить</button>
						</td>
					</tr>
				</table>
			</form>
		</div>


		<div class='col-xs-2'>
			<p>реклама</p>
		</div>
	</div>
	<div class='footer' align='center'>
		<p>This page was developed by Denis Tmenov.</p>
	</div>



</body>
</html>