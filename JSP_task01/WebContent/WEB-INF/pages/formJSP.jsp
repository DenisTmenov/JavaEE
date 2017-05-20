<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	String surName = request.getParameter("surName");
	String firstName = request.getParameter("firstName");
	String patronymic = request.getParameter("patronymic");
	String secretPhrase = request.getParameter("secretPhrase");
	String age = request.getParameter("age");
	String gender = request.getParameter("gender");
	String courseCombo = request.getParameter("courseCombo");
	String teachername = request.getParameter("teachername");
	String assessmentOfaCourseCombo = request.getParameter("assessmentOfaCourseCombo");
	String otherCoursesCombo = request.getParameter("otherCoursesCombo");
	String howDidYouHearAboutUs01 = request.getParameter("howDidYouHearAboutUs01");
	String howDidYouHearAboutUs02 = request.getParameter("howDidYouHearAboutUs02");
	String howDidYouHearAboutUs03 = request.getParameter("howDidYouHearAboutUs03");
	String howDidYouHearAboutUs04 = request.getParameter("howDidYouHearAboutUs04");
	String howDidYouHearAboutUs05 = request.getParameter("howDidYouHearAboutUs05");
	String howDidYouHearAboutUsOTHER = request.getParameter("howDidYouHearAboutUsOTHER");
	String textOtherId = request.getParameter("textOtherId");
	String otherRecommendations = request.getParameter("otherRecommendations");
	String secretValue = request.getParameter("secretValue");
	
	boolean error = false;
	if (surName == "" || surName.matches(" ") || surName.matches(".*\\d+.*")) {
		request.setAttribute("surName", "${ОШИБКА}");
		error = true;
	} else {
		request.setAttribute("surName", surName);
	}
	if (firstName == "" || firstName.matches(" ") || firstName.matches(".*\\d+.*")) {
		request.setAttribute("firstName", "${ОШИБКА}");
		error = true;
	} else {
		request.setAttribute("firstName", firstName);
	}
	if (patronymic.length() > 0) {
		if (patronymic.matches(" ") || patronymic.matches(".*\\d+.*")) {
			request.setAttribute("patronymic", "${ОШИБКА}");
			error = true;
		} else {
			request.setAttribute("patronymic", patronymic);
		}
	}
	if (secretPhrase == "" || secretPhrase.matches(".*\\d+.*")) {
		request.setAttribute("secretPhrase", "${ОШИБКА}");
		error = true;
	} else {
		request.setAttribute("secretPhrase", secretPhrase);
	}
	if (age == "" || age.matches(".*[a-zA-Zа-яА-Я]+.*") || Integer.parseInt(age) < 0
			|| Integer.parseInt(age) > 120) {
		request.setAttribute("age", "${ОШИБКА}");
		error = true;
	} else {
		request.setAttribute("age", age);
	}
	if (gender == "") {
		request.setAttribute("gender", "${ОШИБКА}");
		error = true;
	}
	if (gender != null) {
		if (gender.contains("Male")) {
			request.setAttribute("gender", gender);
		}
		if (gender.contains("Female")) {
			request.setAttribute("gender", gender);
		}
	}

	if (courseCombo == "") {
		request.setAttribute("courseCombo", "${ОШИБКА}");
		error = true;
	}
	if (courseCombo != null) {
		if (courseCombo.contains("Java SE")) {
			request.setAttribute("courseCombo", courseCombo);
		}
		if (courseCombo.contains("Java EE")) {
			request.setAttribute("courseCombo", courseCombo);
		}
		if (courseCombo.contains("Тестирование корабельных якорей методом погружения в Северное Море")) {
			request.setAttribute("courseCombo", courseCombo);
		}
		if (courseCombo.contains("Вышивание крестиком в условиях, близких к невесомости")) {
			request.setAttribute("courseCombo", courseCombo);
		}
	} else
		error = true;
	if (teachername != null) {
		if (teachername.contains("Соколов Андрей Федорович")) {
			request.setAttribute("teachername", teachername);
		}
		if (teachername.contains("Петров Петр Петрович")) {
			request.setAttribute("teachername", teachername);
		}
		if (teachername.contains("Сидоров Сидор Сидорович")) {
			request.setAttribute("teachername", teachername);
		}
	} else
		error = true;
	if (assessmentOfaCourseCombo != null) {
		if (assessmentOfaCourseCombo.contains("10")) {
			request.setAttribute("assessmentOfaCourseCombo", assessmentOfaCourseCombo);
		}
		if (assessmentOfaCourseCombo.contains("100500")) {
			request.setAttribute("assessmentOfaCourseCombo", assessmentOfaCourseCombo);
		}
		if (assessmentOfaCourseCombo.contains("Мильен Мильярдов")) {
			request.setAttribute("assessmentOfaCourseCombo", assessmentOfaCourseCombo);
		}
		if (assessmentOfaCourseCombo.contains("Еще пока нет такого числа")) {
			request.setAttribute("assessmentOfaCourseCombo", assessmentOfaCourseCombo);
		}
		if (assessmentOfaCourseCombo.contains("Это было даже лучше, чем 10 000 люстр от Карлсона!")) {
			request.setAttribute("assessmentOfaCourseCombo", assessmentOfaCourseCombo);
		}
	} else
		error = true;
	if (otherCoursesCombo != null) {
		if (otherCoursesCombo.contains("Java SE")) {
			request.setAttribute("otherCoursesCombo", otherCoursesCombo);
		}
		if (otherCoursesCombo.contains("Java EE")) {
			request.setAttribute("otherCoursesCombo", otherCoursesCombo);
		}
		if (otherCoursesCombo.contains("Тестирование корабельных якорей методом погружения в Северное Море")) {
			request.setAttribute("otherCoursesCombo", otherCoursesCombo);
		}
		if (otherCoursesCombo.contains("Вышивание крестиком в условиях, близких к невесомости")) {
			request.setAttribute("otherCoursesCombo", otherCoursesCombo);
		}
	} else
		error = true;
	if (howDidYouHearAboutUs01 != null) {
		if (howDidYouHearAboutUs01.contains("Реклама по ТВ")) {
			request.setAttribute("howDidYouHearAboutUs01", howDidYouHearAboutUs01);
		} else {
			request.setAttribute("howDidYouHearAboutUs01", null);
		}
	}
	if (howDidYouHearAboutUs02 != null) {
		if (howDidYouHearAboutUs02.contains("Реклама по радио")) {
			request.setAttribute("howDidYouHearAboutUs02", howDidYouHearAboutUs02);
		} else {
			request.setAttribute("howDidYouHearAboutUs02", null);
		}
	}
	if (howDidYouHearAboutUs03 != null) {
		if (howDidYouHearAboutUs03.contains("Реклама в Internet")) {
			request.setAttribute("howDidYouHearAboutUs03", howDidYouHearAboutUs03);
		} else {
			request.setAttribute("howDidYouHearAboutUs03", null);
		}
	}
	if (howDidYouHearAboutUs04 != null) {
		if (howDidYouHearAboutUs04.contains("Реклама в метро")) {
			request.setAttribute("howDidYouHearAboutUs04", howDidYouHearAboutUs04);
		} else {
			request.setAttribute("howDidYouHearAboutUs04", null);
		}
	}
	if (howDidYouHearAboutUs05 != null) {
		if (howDidYouHearAboutUs05.contains("Тварь, какая-то мне этими буклетами весь почтовый ящик зас#%ла")) {
			request.setAttribute("howDidYouHearAboutUs05", howDidYouHearAboutUs05);
		} else {
			request.setAttribute("howDidYouHearAboutUs05", null);
		}
	}
	if (howDidYouHearAboutUs01 == null && howDidYouHearAboutUs02 == null && howDidYouHearAboutUs03 == null
			&& howDidYouHearAboutUs04 == null && howDidYouHearAboutUs05 == null
			&& howDidYouHearAboutUsOTHER == null) {
		error = true;
	}
	if (howDidYouHearAboutUsOTHER != null) {
		request.setAttribute("howDidYouHearAboutUsOTHER", howDidYouHearAboutUsOTHER);
	}
	if(textOtherId !=null){
		request.setAttribute("textOtherId", textOtherId);
	}

	if (error) {
		RequestDispatcher dispatcher = request.getRequestDispatcher("index");
		dispatcher.forward(request, response);
		//response.sendRedirect("index");
	}
%>





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


<script>
	
</script>



<title>Lesson 04. Task 01.</title>
</head>
<body>
	<h1 align='center'>
		Lesson 04 - JSP. Task 01 <br> Электронная анкета для оценки
		качества образования. <br> Форма вывода.
	</h1>



	<div class='container'>
		<div class='col-xs-2'>Menu</div>
		<div class='col-xs-8'>
			<table>
				<tr>
					<td>Фамилия</td>
					<td><%=surName%></td>
				</tr>
				<tr>
					<td>Имя</td>
					<td><%=firstName%></td>
				</tr>
				<tr>
					<td>Отчество</td>
					<td><%=patronymic%></td>
				</tr>
				<tr>
					<td>Секретная фраза:</td>
					<td><%=secretPhrase%></td>
				</tr>
				<tr>
					<td>Возраст</td>
					<td><%=age%></td>
				</tr>
				<tr>
					<td>Пол</td>
					<td><%=gender%></td>
				</tr>
				<tr>
					<td>Курс</td>
					<td><%=courseCombo%></td>
				</tr>
				<tr>
					<td>Преподаватель</td>
					<td><%=teachername%></td>
				</tr>
				<tr>
					<td>Оценка курса</td>
					<td><%=assessmentOfaCourseCombo%></td>
				</tr>
				<tr>
					<td>Прочие курсы</td>
					<td><%=otherCoursesCombo%></td>
				</tr>
				<tr>
					<td>Как Вы о нас узнали</td>
					<td><%=howDidYouHearAboutUs01%></td>
				</tr>
				<tr>
					<td>Прочие Рекомендации</td>
					<td><%=otherRecommendations%></td>
				</tr>
				<tr>
					<td>Была нажата кнопка:</td>
					<td><%=secretValue%></td>
				</tr>
			</table>
		</div>
		<div class='col-xs-2'>реклама</div>
	</div>
</body>

</html>