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
						<form action="./RegistrationServlet" onsubmit="return validate()" method="post" id="regForm" role="form">
							<div class="form-group">
								<input required type="login" name="login" id="login"
									class="form-control input-sm" placeholder="Login">
							</div>

							<div class="form-group">
								<input required type="email" name="email" id="email"
									class="form-control input-sm" placeholder="Email Address">
								<div class="status" id="status"></div>
							</div>

							<div class="row">
								<div class="col-xs-6 col-sm-6 col-md-6">
									<div class="form-group">
										<input required type="password" name="password" id="password"
											class="form-control input-sm" placeholder="Password" >
									</div>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6">
									<div class="form-group">
										<input required type="password" name="password_confirm"
											id="password_confirm" class="form-control input-sm"
											placeholder="Confirm Password">
										<span id="confirmMessage" class="confirmMessage"></span>
									</div>
								</div>
							</div>

							<input type="submit" id="btn_register" name="btn_register" value="Register"
								class="btn btn-info btn-block">
							<input type="button" value="Fill in the form"
								class="btn btn-info btn-block" onclick="fillRegForm()">

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>