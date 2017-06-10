<%@page import="com.trainingcenter.projectee.utils.HttpUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Main</title>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/sb-admin.css" rel="stylesheet">

<!-- Morris Charts CSS -->
<link href="css/plugins/morris.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">


</head>

<body>

	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-ex1-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<h3 class="h3-white">${userRole}</h3>

			</div>
			<!-- Top Menu Items -->
			<ul class="nav navbar-right top-nav">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"><i class="fa fa-user"></i> ${userName} <b
						class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="profile.html"><i class="fa fa-fw fa-user"></i>
								Profile</a></li>
						<li class="divider"></li>
						<li><a href="LogOutFromSession"><i
								class="fa fa-fw fa-power-off"></i> Log Out</a></li>
					</ul></li>
			</ul>
			<!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav side-nav">
					<li class="active"><a href="index.html"><i
							class="fa fa-fw fa-dashboard"></i> Dashboard</a></li>

				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</nav>

		<div id="page-wrapper">

			<div class="container-fluid">

				<!-- Page Heading -->
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">Your PROFILE <input type="button" id="btnChange" name="btnChange" value="Change" class="btn btn-lg btn-primary" onclick="changeInfo()"/></h1> 
						<div class="col-lg-12">
							<form action="./ForgotServlet" onsubmit="return only_email_validate()" method="post" id="regForm">
								<table>
									<tr>
										<td><h3>Login</h3></td>
										<td class="td-profile"><h3>${loginUser}</h3></td>
										<td id="changeInfoLogin" hidden="true">
											<h3>
												<input type="text" id="loginUserNew" name="loginUserNew" />
											</h3>
										</td>
									</tr>
									<tr>
										<td><h3>Password</h3></td>
										<td class="td-profile"><h3>${passwordUser}</h3></td>
										<td id="changeInfoPassword" hidden="true">
											<h3>
												<input type="text" id="passwordUserNew"	name="passwordUserNew" />
											</h3>
										</td>
									</tr>
									<tr>
										<td><h3>First Name</h3></td>
										<td class="td-profile"><h3>${firstNameUser}</h3></td>
										<td id="changeInfoFirstName" hidden="true">
											<h3>
												<input type="text" id="firstNameUserNew" name="firstNameUserNew" />
											</h3>
										</td>
									</tr>
									<tr>
										<td><h3>Last Name</h3></td>
										<td class="td-profile"><h3>${lastNameUser}</h3></td>
										<td id="changeInfoLastName" hidden="true">
											<h3>
												<input type="text" id="lastNameUserNew"	name="lastNameUserNew" />
											</h3>
										</td>
									</tr>
									<tr>
										<td><h3>Role</h3></td>
										<td class="td-profile"><h3>${roleUser}</h3></td>
										<td id="changeInfoRole" hidden="true">
											<h3>
												<input type="text" id="roleUserNew" name="roleUserNew" />
											</h3></td>
									</tr>
									<tr>
										<td><h3>Email</h3></td>
										<td class="td-profile"><h3>${emailUser}</h3></td>
										<td id="changeInfoEmail" hidden="true">
											<h3>
												<input type="text" id="emailUserNew" name="emailUserNew" />
											</h3>
										</td>
									</tr>
								</table>
							</form>
							<div class="form-group">
								<input type="submit" id="btnSave" name="btnSave" value="Save" class="btn btn-lg btn-primary" disabled="disabled"/> 
								<input type="submit" id="btnCansel" name="btnCansel" value="Cansel" class="btn btn-lg btn-primary" disabled="disabled"/>
							</div>
						</div>
					</div>
				</div>
				<!-- /.row -->



			</div>
			<!-- /.container-fluid -->

		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- jQuery -->
	<script src="js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>

	<!-- Morris Charts JavaScript -->
	<script src="js/plugins/morris/raphael.min.js"></script>
	<script src="js/plugins/morris/morris.min.js"></script>
	<script src="js/plugins/morris/morris-data.js"></script>
	<script src="script/profileChange.js"></script>

</body>

</html>