<%@page import="com.trainingcenter.projectee.controllers.RegistrationServlet"%>
<%@page import="java.util.Map"%>

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
<body>
	<div class="container">
		<div class="row centered-form">
			<div
				class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Please register in ProjectEE</h3>
					</div>
					<div class="panel-body">
						<form action="./RegistrationServlet" onsubmit="return validate()"
							method="post" id="regForm" >
							<div class="form-group">
								<input required type="text" name="login" id="login"
									class="form-control input-sm" placeholder="Login">
								<%
									Map<String, String> errorMap = HttpUtils.getMapAttribute(session,
											RegistrationServlet.VALIDATION_ERRORS_ATTR);
									if (!errorMap.isEmpty()) {
										String emptyLogin = errorMap.get(RegistrationServlet.LOGIN_EMPTY_CODE);
										String existLogin = errorMap.get(RegistrationServlet.LOGIN_EXISTS_CODE);
										if (emptyLogin != null) {
											out.print(emptyLogin);
										}
										if (existLogin != null) {
											out.print(existLogin);
										}
									}
								%>
							</div>

							<div class="form-group">
								<input required type="text" name="email" id="email"
									class="form-control input-sm" placeholder="Email Address">
								<%
									if (!errorMap.isEmpty()) {
										String emptyEmail = errorMap.get(RegistrationServlet.EMAIL_EMPTY_CODE);
										String existEmail = errorMap.get(RegistrationServlet.EMAIL_EXISTS_CODE);
										if (emptyEmail != null) {
											out.print(emptyEmail);
										}
										if (existEmail != null) {
											out.print(existEmail);
										}
									}
								%>
								<div class="status" id="status"></div>
							</div>

							<div class="row">
								<div class="col-xs-6 col-sm-6 col-md-6">
									<div class="form-group">
										<input required type="password" name="password" id="password"
											class="form-control input-sm" placeholder="Password">
										<%
											if (!errorMap.isEmpty()) {
												String emptyPassword = errorMap.get(RegistrationServlet.PASSWORD_EMPTY_CODE);
												String notMatchPasswords = errorMap.get(RegistrationServlet.PASSWORDS_NOT_MATCH_CODE);
												if (emptyPassword != null) {
													out.print(emptyPassword);
												}
												if (notMatchPasswords != null) {
													out.print(notMatchPasswords);
												}
											}
										%>
									</div>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6">
									<div class="form-group">
										<input  type="password" name="password_confirm" required 
											id="password_confirm" class="form-control input-sm"
											placeholder="Confirm Password">
										<%
											if (!errorMap.isEmpty()) {
												String emptyPasswordConfirm = errorMap.get(RegistrationServlet.PASSWORD_CONFIRM_EMPTY_CODE);
												String notMatchPasswords = errorMap.get(RegistrationServlet.PASSWORDS_NOT_MATCH_CODE);
												if (emptyPasswordConfirm != null) {
													out.print(emptyPasswordConfirm);
												}
												if (notMatchPasswords != null) {
													out.print(notMatchPasswords);
												}
											}
										%><span id="confirmMessage" class="confirmMessage"></span>
									</div>
								</div>
							</div>

							<input type="submit" id="btn_register" name="btn_register"
								value="Register" class="btn btn-info btn-block"> <input
								type="button" value="Fill in the form"
								class="btn btn-info btn-block" onclick="fillRegForm()">

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>s