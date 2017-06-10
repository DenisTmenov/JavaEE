<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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


<script src="/JSP_task01/script.js">
	
</script>



<title>Lesson 04. Task 01.</title>
</head>
<body onload="showOtherCourses()">
	<h1 align='center'>
		Lesson 04 - JSP. Task 01 <br> Электронная анкета для оценки
		качества образования.
	</h1>



	<div class='container'>
		<div class='col-xs-2'>Menu</div>
		<div class='col-xs-8'>

			<form id='primaryTable' class='form-group' method='post'
				onsubmit='return validateInfo()' action='./formOut'>
				<%
					request.setCharacterEncoding("UTF-8");
					response.setCharacterEncoding("UTF-8");
					String surName = (String) request.getAttribute("surName");
					String firstName = (String) request.getAttribute("firstName");
					String patronymic = (String) request.getAttribute("patronymic");
					String secretPhrase = (String) request.getAttribute("secretPhrase");
					String age = (String) request.getAttribute("age");
					String gender = (String) request.getAttribute("gender");
					String courseCombo = (String) request.getAttribute("courseCombo");
					String teachername = (String) request.getAttribute("teachername");
					String assessmentOfaCourseCombo = (String) request.getAttribute("assessmentOfaCourseCombo");
					String otherCoursesCombo = (String) request.getAttribute("otherCoursesCombo");

					String howDidYouHearAboutUs01 = request.getParameter("howDidYouHearAboutUs01");
					String howDidYouHearAboutUs02 = request.getParameter("howDidYouHearAboutUs02");
					String howDidYouHearAboutUs03 = request.getParameter("howDidYouHearAboutUs03");
					String howDidYouHearAboutUs04 = request.getParameter("howDidYouHearAboutUs04");
					String howDidYouHearAboutUs05 = request.getParameter("howDidYouHearAboutUs05");
					String howDidYouHearAboutUsOTHER = request.getParameter("howDidYouHearAboutUsOTHER");
					String textOtherId = request.getParameter("textOtherId");
					String otherRecommendations = request.getParameter("otherRecommendations");
					String secretValue = request.getParameter("secretValue");
				%>
				<table>
					<tr>
						<td><label for='surName'>Фамилия </label></td>
						<td><input type='text' class='form-control' id='surName'
							name='surName' <%if (surName == null || surName.equals("")) {%>
							placeholder='Коморов' <%}%>
							<%if (surName != null) {
				if (surName.equals("${ОШИБКА}")) {%>
							placeholder='Вы ошиблись!!!' <%}
			}%>
							<%if (surName != null) {
				if (!surName.equals("${ОШИБКА}")) {%>
							value="<%=surName%>" <%}
			}%> /></td>
					</tr>
					<tr>
						<td><label for='firstName'>Имя</label></td>
						<td><input type='text' class='form-control' id='firstName'
							name='firstName'
							<%if (firstName == null || firstName.equals("")) {%>
							placeholder='Артем' <%}%>
							<%if (firstName != null) {
				if (firstName.contains("${ОШИБКА}")) {%>
							placeholder='Вы ошиблись!!!' <%}
			}%>
							<%if (firstName != null) {
				if (!firstName.contains("${ОШИБКА}")) {%>
							value="<%=firstName%>" <%}
			}%> /></td>
					</tr>
					<tr>
						<td><label for='patronymic'>Отчество </label></td>
						<td><input type='text' class='form-control' id='patronymic'
							name='patronymic'
							<%if (patronymic == null || patronymic.equals("")) {%>
							placeholder='Абрамович' <%}%>
							<%if (patronymic != null) {
				if (patronymic.contains("${ОШИБКА}")) {%>
							placeholder='Вы ошиблись!!!' <%}
			}%>
							<%if (patronymic != null) {
				if (!patronymic.contains("${ОШИБКА}")) {%>
							value="<%=patronymic%>" <%}
			}%>></td>
					</tr>
					<tr>
						<td><label for='secretPhrase'>Секретная фраза : </label></td>
						<td><input type='password' class='form-control'
							id='secretPhrase' name='secretPhrase'
							<%if (secretPhrase == null || secretPhrase.equals("")) {%>
							placeholder='Всемирный секрет' <%}%>
							<%if (secretPhrase != null) {
				if (secretPhrase.contains("${ОШИБКА}")) {%>
							placeholder='Вы ошиблись!!!' <%}
			}%> /></td>
					</tr>
					<tr>
						<td><label for='age'>Возраст</label></td>
						<td><input type='text' class='form-control' id='age'
							name='age' <%if (age == null || age.equals("")) {%>
							placeholder='33' <%}%>
							<%if (age != null) {
				if (age.contains("${ОШИБКА}")) {%>
							placeholder='Вы ошиблись!!!' <%}
			}%>
							<%if (age != null) {
				if (!age.contains("${ОШИБКА}")) {%>
							value="<%=age%>" <%}
			}%> /></td>
					</tr>
					<tr>
						<td><label>Пол</label></td>
						<td><input type='radio' name='gender' id='gender_Male'
							value='Male'
							<%if (gender != null) {
				if (gender.contains("Male")) {%>
							checked="checked" <%}
			}%> /> <label for='gender_Male'>Мужчина</label>
							<br> <input type='radio' name='gender' id='gender_Female'
							value='Female'
							<%if (gender != null) {
				if (gender.contains("Female")) {%>
							checked="checked" <%}
			}%> /> <label for='gender_Female'>Женщина</label></td>
					</tr>
					<tr>
						<td><label>Курс</label></td>
						<td><label for='courseCombo'></label><select id='courseCombo'
							name='courseCombo' class='form-control'
						onchange='showOtherCourses()' >
								<option value='' disabled
									<%if (courseCombo == null || courseCombo.equals("")) {%>
									selected="selected" <%}%>></option>
								<option value='Java SE'
									<%if (courseCombo != null) {
				if (courseCombo.equals("Java SE")) {%>
									selected="selected" <%}
			}%>>Java SE</option>
								<option value='Java EE'
									<%if (courseCombo != null) {
				if (courseCombo.equals("Java EE")) {%>
									selected="selected" <%}
			}%>>Java EE</option>
								<option
									value='Тестирование корабельных якорей методом погружения в Северное Море'
									<%if (courseCombo != null) {
				if (courseCombo.equals("Тестирование корабельных якорей методом погружения в Северное Море")) {%>
									selected="selected" <%}
			}%>>Тестирование
									корабельных якорей методом погружения в Северное Море</option>
								<option
									value='Вышивание крестиком в условиях, близких к невесомости'
									<%if (courseCombo != null) {
				if (courseCombo.equals("Вышивание крестиком в условиях, близких к невесомости")) {%>
									selected="selected" <%}
			}%>>Вышивание крестиком в
									условиях, близких к невесомости</option>
						</select></td>
					</tr>
					<tr>
						<td><label>Преподаватель </label></td>
						<td><label for='teachername'></label><select id='teachername'
							name='teachername' class='form-control' size='3'>
								<option value='Соколов Андрей Федорович'
									<%if (teachername != null) {
				if (teachername.equals("Соколов Андрей Федорович")) {%>
									selected="selected" <%}
			}%>>Соколов Андрей
									Федорович</option>
								<option value='Петров Петр Петрович'
									<%if (teachername != null) {
				if (teachername.equals("Петров Петр Петрович")) {%>
									selected="selected" <%}
			}%>>Петров Петр Петрович</option>
								<option value='Сидоров Сидор Сидорович'
									<%if (teachername != null) {
				if (teachername.equals("Сидоров Сидор Сидорович")) {%>
									selected="selected" <%}
			}%>>Сидоров Сидор
									Сидорович</option>
						</select></td>
					</tr>
					<tr>
						<td><label for='assessmentOfaCourseCombo'>Оценка
								курса</label></td>
						<td><select id='assessmentOfaCourseCombo'
							name='assessmentOfaCourseCombo' class='form-control'>
								<option value='' disabled
									<%if (assessmentOfaCourseCombo == null || assessmentOfaCourseCombo.equals("")) {%>
									selected="selected" <%}%>></option>

								<option value='10'
									<%if (assessmentOfaCourseCombo != null && assessmentOfaCourseCombo.equals("10")) {%>
									selected="selected" <%}%>>10</option>
								<option value='100500'
									<%if (assessmentOfaCourseCombo != null && assessmentOfaCourseCombo.equals("100500")) {%>
									selected="selected" <%}%>>100500</option>
								<option value='Мильен Мильярдов'
									<%if (assessmentOfaCourseCombo != null && assessmentOfaCourseCombo.equals("Мильен Мильярдов")) {%>
									selected="selected" <%}%>>Мильен Мильярдов</option>
								<option value='Еще пока нет такого числа'
									<%if (assessmentOfaCourseCombo != null && assessmentOfaCourseCombo.equals("Еще пока нет такого числа")) {%>
									selected="selected" <%}%>>Еще пока нет такого числа</option>
								<option
									value='Это было даже лучше, чем 10 000 люстр от Карлсона!'
									<%if (assessmentOfaCourseCombo != null
					&& assessmentOfaCourseCombo.equals("Это было даже лучше, чем 10 000 люстр от Карлсона!")) {%>
									selected="selected" <%}%>>Это было даже лучше, чем 10
									000 люстр от Карлсона!</option>
						</select></td>
					</tr>
					<tr>
						<td><label>Прочие курсы</label></td>
						<td><label for='otherCoursesCombo'></label><select
							id='otherCoursesCombo' name='otherCoursesCombo' multiple
							class='form-control'>
								<option value='Java SE' id='otherCourse01' hidden=1
									<%if (otherCoursesCombo != null && otherCoursesCombo.equals("Java SE")) {%>
									selected="selected" <%}%>>Java SE</option>
								<option value='Java EE' id='otherCourse02' hidden=1
									<%if (otherCoursesCombo != null && otherCoursesCombo.equals("Java EE")) {%>
									selected="selected" <%}%>>Java EE</option>
								<option
									value='Тестирование корабельных якорей методом погружения в Северное Море'
									id='otherCourse03' hidden=1
									<%if (otherCoursesCombo != null
					&& otherCoursesCombo.equals("Тестирование корабельных якорей методом погружения в Северное Море")) {%>
									selected="selected" <%}%>>Тестирование корабельных
									якорей методом погружения в Северное Море</option>
								<option
									value='Вышивание крестиком в условиях, близких к невесомости'
									id='otherCourse04' hidden=1
									<%if (otherCoursesCombo != null
					&& otherCoursesCombo.equals("Вышивание крестиком в условиях, близких к невесомости")) {%>
									selected="selected" <%}%>>Вышивание крестиком в
									условиях, близких к невесомости</option>
						</select></td>
					</tr>
					<tr>
						<td><label>Как Вы о нас узнали </label></td>
						<td>
							<p>
								<label> <input type='checkbox'
									name='howDidYouHearAboutUs01' id='howDidYouHearAboutUs01'
									value='Реклама по ТВ'
									<%if (howDidYouHearAboutUs01 != null && howDidYouHearAboutUs01.equals("Реклама по ТВ")) {%>
									checked="checked" <%}%>>
								</label> Реклама по ТВ
							</p>
							<p>
								<label> <input type='checkbox'
									name='howDidYouHearAboutUs02' id='howDidYouHearAboutUs02'
									value='Реклама по радио'
									<%if (howDidYouHearAboutUs02 != null && howDidYouHearAboutUs02.equals("Реклама по радио")) {%>
									checked="checked" <%}%>>
								</label> Реклама по радио
							</p>
							<p>
								<label> <input type='checkbox'
									name='howDidYouHearAboutUs03' id='howDidYouHearAboutUs03'
									value='Реклама в Internet'
									<%if (howDidYouHearAboutUs03 != null && howDidYouHearAboutUs03.equals("Реклама в Internet")) {%>
									checked="checked" <%}%>>
								</label> Реклама в Internet
							</p>
							<p>
								<label> <input type='checkbox'
									name='howDidYouHearAboutUs04' id='howDidYouHearAboutUs04'
									value='Реклама в метро'
									<%if (howDidYouHearAboutUs04 != null && howDidYouHearAboutUs04.equals("Реклама в метро")) {%>
									checked="checked" <%}%>>
								</label> Реклама в метро
							</p>
							<p>
								<label> <input type='checkbox'
									name='howDidYouHearAboutUs05' id='howDidYouHearAboutUs05'
									value='Тварь, какая-то мне этими буклетами весь почтовый ящик зас#%ла'
									<%if (howDidYouHearAboutUs05 != null && howDidYouHearAboutUs05
					.equals("Тварь, какая-то мне этими буклетами весь почтовый ящик зас#%ла")) {%>
									checked="checked" <%}%>>
								</label> Тварь, какая-то мне этими буклетами весь почтовый ящик зас#%ла
							</p>
							<p>
								<label> <input type='checkbox'
									id='howDidYouHearAboutUsOTHER' name='howDidYouHearAboutUsOTHER'
									value='Другое' onclick='otherCheck()'
									<%if (howDidYouHearAboutUsOTHER != null && howDidYouHearAboutUsOTHER.equals("Другое")) {%>
									checked="checked" <%}%>>
								</label> Другое
							</p> <label for='textOtherId'></label> <textarea class='form-control'
								name='textOtherId' id='textOtherId' disabled>
								<%if (textOtherId != null) {%><%=textOtherId%><%}%>
							</textarea>

						</td>
					</tr>
					<tr>
						<td><label>Прочие Рекомендации </label></td>
						<td><label for='otherRecommendations'></label> <textarea
								class='form-control' name='otherRecommendations'
								id='otherRecommendations'></textarea></td>
					</tr>
				</table>
				<p>
					<input id='secretValue' name='secretValue' type='hidden' value='' />
					<input type='submit' id='button01' class='btn btn-primary'
						onclick='saveSecret(1);' value='Отправить – здесь все правда' />
					<input type='submit' id='button02' class='btn btn-primary'
						onclick='saveSecret(2);'
						value='Отправить – я все равно все наврал' />

				</p>
				<p>
					<label>Управление валидацией на странице при помощи
						JavaScript:</label> <label for='onOffnameON'></label><input type='radio'
						name='onOff' id='onOffnameON' value='on' checked
						onchange='javaScriptEnable()'> ON <label
						for='onOffnameOFF'></label><input type='radio' name='onOff'
						id='onOffnameOFF' value='off' onchange='javaScriptDisable()'>
					OFF
				</p>
				
			</form>
		</div>
		<div class='col-xs-2'>реклама</div>
	</div>
</body>

</html>