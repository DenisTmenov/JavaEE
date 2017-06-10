<%@page import="java.util.Map"%>
<%@page import="com.trainingcenter.projectee.controllers.ForgotController"%>
<%@page import="com.trainingcenter.projectee.utils.HttpUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name='viewport' content='width=device-width, initial-scale=1'>

<!-- Latest compiled and minified CSS -->
<link rel='stylesheet'
	href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'
	integrity='sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u'
	crossorigin='anonymous'>
<!-- Optional theme -->
<link rel='stylesheet'
	href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css'
	integrity='sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp'
	crossorigin='anonymous'>
<!-- Latest compiled and minified JavaScript -->
<script
	src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'
	integrity='sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa'
	crossorigin='anonymous'></script>
<link rel="stylesheet" href="css/styles.css">
<script src="script/validateEmail.js"></script>
<title>Forgot</title>
</head>
<body>
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h1 class="text-center">Enter your email, please.</h1>
			</div>
			<div class="modal-body">
				<form action="forgot.html"
					onsubmit="return only_email_validate()" method="post" id="regForm">
					<div class="form-group">
						<input type="text" required id="email" name="email"
							class="form-control input-lg" placeholder="123@gmail.com" value="${forgotDto.email }"/>
						<div class="status" id="statusEmail"></div>
						<%
							Map<String, String> errorMap = HttpUtils.getMapAttribute(session,
									ForgotController.VALIDATION_ERRORS_ATTR_FORGOT);
							if (!errorMap.isEmpty()) {
								String notEmail = errorMap.get(ForgotController.EMAIL_NOT_EXISTS_CODE);
								if (!notEmail.isEmpty()) {
						%>
						<span class='warning'><%=ForgotController.EMAIL_NOT_EXISTS_VALUE %></span>
						<%
							}
							}
						%>

					</div>
					<div class="form-group">
						<input type="submit" class="btn btn-block btn-lg btn-primary"
							name="BtnForgot" id="BtnForgot" value="Forgot"
							onclick="only_email_validate()" />
						<p>
							<span> <a href="index.html">Go back to Homepage</a>
							</span>
						</p>
					</div>
				</form>
			</div>

		</div>
	</div>
</body>
</html>
