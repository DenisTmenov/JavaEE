<%@page import="com.trainingcenter.projectEE.maven.controllers.WelcomeController"%>
<%@page import="com.trainingcenter.projectEE.maven.utils.HttpUtils"%>
<%@page import="java.util.Map"%>
<!DOCTYPE html>
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
				<form action="welcome.html" onsubmit="true"
					method="post" id="regForm" role="form">
					<div class="form-group">
						<input type="text" required id="username" name="username"
							class="form-control input-lg" placeholder="Username" value="${welcomeDto.username }" /> 
						<%
							Map<String, String> errorMap = HttpUtils.getMapAttribute(request,
									WelcomeController.VALIDATION_ERRORS_ATTR_LOGIN_PAGE);
							Boolean noErrors = errorMap.isEmpty();

							String loginEmpty = null;
							String loginExist = null;
							String loginBloked = null;
							String emptyPassword = null;
							String bedPassword = null;
							if (!noErrors) {
								loginEmpty = errorMap.get(WelcomeController.LOGIN_EMPTY_CODE);
								loginExist = errorMap.get(WelcomeController.LOGIN_NOT_EXISTS_CODE);
								loginBloked = errorMap.get(WelcomeController.LOGIN_IS_BLOCKED_CODE);
								emptyPassword = errorMap.get(WelcomeController.PASSWORD_EMPTY_CODE);
								bedPassword = errorMap.get(WelcomeController.PASSWORD_BED_CODE);
								loginBloked = errorMap.get(WelcomeController.LOGIN_IS_BLOCKED_CODE);
							}

							if (loginEmpty != null) {
								out.print(loginEmpty);
							} else if (loginExist != null) {
								out.print(loginExist);
							} else if (loginBloked != null) {
								out.print(loginBloked);
							}
						%>
					</div>

					<div class="form-group">
						<input type="password" required id="password" name="password"
							class="form-control input-lg" placeholder="Password" />
						<%
							if (emptyPassword != null) {
								out.print(emptyPassword);
							} else	if (bedPassword != null) {
								out.print(bedPassword);
							}
						%>
					</div>

					<%
						if (loginBloked != null) {
					%>
					<div class="form-group">
						<p>You are blocked, contact the administrator:
							admin@projectee.com</p>
					</div>
					<%
						}
					%>


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
