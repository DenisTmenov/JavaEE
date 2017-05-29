<!DOCTYPE html>
<%@page import="com.trainingcenter.projectee.utils.HttpUtils"%>
<%@page import="com.trainingcenter.projectee.controllers.WelcomeServlet"%>
<%@page import="java.util.Map"%>
<html lang='eng'>
<head>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<meta charset='UTF-8'>

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
<title>Project EE</title>
</head>
<body>
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h1 class="text-center">Welcome</h1>
			</div>
			<div class="modal-body">
				<form action="./WelcomeServlet" onsubmit="return validateLogIn()"
					method="post" id="regForm" role="form">
					<div class="form-group">
						<input type="text" required id="username" name="username"
							class="form-control input-lg" placeholder="Username" />
						<%
							Map<String, String> errorMap = HttpUtils.getMapAttribute(session, WelcomeServlet.VALIDATION_ERRORS_ATTR_LOGIN_PAGE);
							if (!errorMap.isEmpty()) {
								String emptyLogin = errorMap.get(WelcomeServlet.LOGIN_EMPTY_CODE);
								String existLogin = errorMap.get(WelcomeServlet.LOGIN_NOT_EXISTS_CODE);
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
						<input type="password" required id="password" name="password"
							class="form-control input-lg" placeholder="Password" />
						<%
							if (!errorMap.isEmpty()) {
								String emptyPassword = errorMap.get(WelcomeServlet.PASSWORD_EMPTY_CODE);
								String bedPassword = errorMap.get(WelcomeServlet.PASSWORD_BED_CODE);
								if (emptyPassword != null) {
									out.print(emptyPassword);
								}
								if (bedPassword != null) {
									out.print(bedPassword);
								}
							}
						%>
					</div>

					<div class="form-group">
						<input type="submit" class="btn btn-block btn-lg btn-primary"
							name="BtnLogIn" id="BtnLogIn" value="Log_in" /> <span
							class="pull-right"> <a href="registration.html">Register</a>
						</span> <span> <a href="forgot.html">Forgot Password</a>
						</span>
					</div>
				</form>
			</div>

		</div>
	</div>

</body>
</html>
