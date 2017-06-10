<%@page import="com.trainingcenter.projectee.controllers.helpers.LinkKeeper"%>
<%@ page import="com.trainingcenter.projectee.utils.HttpUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
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
					data-toggle="dropdown"><i class="fa fa-user"></i> ${userLogin} <b
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
					<li class="active"><a href="main.html">Main Page</a></li>

				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</nav>

		<div id="page-wrapper">

			<div class="container-fluid">

				<!-- Page Heading -->
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">Your PROFILE</h1>
						<div class="col-lg-12">
							<%
							String role = (String) session.getAttribute(LinkKeeper.SESSION_USER_BEAN_ROLE);
							String changeProfile = (String) session.getAttribute("actionInSession");
							if(role.equals("User")){
								if(changeProfile == null || changeProfile.equals("Profile")){%>
									<my:profileUserClean></my:profileUserClean>
								<%} else if(changeProfile.equals("ProfileChange")){%>
									<my:profileUserChange></my:profileUserChange>
									<%} 
							}
							
							if(role.equals("Administrator")){
								if(changeProfile == null || changeProfile.equals("Profile")){%>
									<my:profileAdministratorClean></my:profileAdministratorClean>
								<%} else if(changeProfile.equals("ProfileChange")){%>
									<my:profileAdministratorChange></my:profileAdministratorChange>
									<%} 
							}
							
							if(role.equals("Moderator")){
								if(changeProfile == null || changeProfile.equals("Profile")){%>
									//<my:profileUserClean></my:profileUserClean>
								<%} else if(changeProfile.equals("ProfileChange")){%>
									//<my:profileUserChange></my:profileUserChange>
									<%} 
							}
								
							%>
									
								
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