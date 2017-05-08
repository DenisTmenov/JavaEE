function validateInfo() {
	var surNameStudent = document.getElementById("surNameStudent");
	var firstNameStudent = document.getElementById("firstNameStudent");
	var patronymicStudent = document.getElementById("patronymicStudent");
	var surNameTeacher = document.getElementById("surNameTeacher");
	var firstNameTeacher = document.getElementById("firstNameTeacher");
	var patronymicTeacher = document.getElementById("patronymicTeacher");
	var dateStart = document.getElementById("dateStart");
	var dateFinish = document.getElementById("dateFinish");

	var courseProjectTheme = document.getElementById("courseProjectTheme");
	var assessmentOfaCourseCombo = document
			.getElementById("assessmentOfaCourseCombo");

	var archive = document.getElementById("archive");

	var reg1 = /\d/;
	var reg2 = /[a-zA-Zа-яА-Я]/;
	var reg3 = / /;

	var difference = Date.parse(dateStart.value) - Date.parse(dateFinish.value);
	var stringReturn = true;

	if (surNameStudent.value === "" || surNameStudent.value === null) {
		alert("«Фамилия слушателя» не может быть пустой");
		stringReturn = false;
	} else if (surNameStudent.value.match(reg1)) {
		alert("«Фамилия слушателя» не может содержать числа");
		stringReturn = false;
	} else if (surNameStudent.value.match(reg3)) {
		alert("«Фамилия слушателя» не может содержать пробел");
		stringReturn = false;
	} else if (firstNameStudent.value === "" || firstNameStudent.value === null) {
		alert("«Имя слушателя» не может быть пустым");
		stringReturn = false;
	} else if (firstNameStudent.value.match(reg1)) {
		alert("«Имя слушателя» не может содержать числа");
		stringReturn = false;
	} else if (firstNameStudent.value.match(reg3)) {
		alert("«Имя слушателя» не может содержать пробел");
		stringReturn = false;
	} else if (patronymicStudent.value !== "") {
		if (patronymicStudent.value.match(reg1)) {
			alert("«Отчество слушателя» не может содержать числа");
			stringReturn = false;
		} else if (patronymicStudent.value.match(reg1)) {
			alert("«Отчество слушателя» не может содержать пробел");
			stringReturn = false;
		}
	} else if (surNameTeacher.value === "" || surNameTeacher.value === null) {
		alert("«Фамилия преподавателя» не может быть пустой");
		stringReturn = false;
	} else if (surNameTeacher.value.match(reg1)) {
		alert("«Фамилия преподавателя» не может содержать числа");
		stringReturn = false;
	} else if (surNameTeacher.value.match(reg3)) {
		alert("«Фамилия преподавателя» не может содержать пробел");
		stringReturn = false;
	} else if (firstNameTeacher.value === "" || firstNameTeacher.value === null) {
		alert("«Имя преподавателя» не может быть пустым");
		stringReturn = false;
	} else if (firstNameTeacher.value.match(reg1)) {
		alert("«Имя преподавателя» не может содержать числа");
		stringReturn = false;
	} else if (firstNameTeacher.value.match(reg3)) {
		alert("«Имя преподавателя» не может содержать пробел");
		stringReturn = false;
	} else if (patronymicTeacher.value !== "") {
		if (patronymicTeacher.value.match(reg1)) {
			alert("«Отчество преподавателя» не может содержать числа");
			stringReturn = false;
		} else if (patronymicTeacher.value.match(reg1)) {
			alert("«Отчество преподавателя» не может содержать пробел");
			stringReturn = false;
		}
	} else if (courseProjectTheme.value === ""
			|| courseProjectTheme.value === null) {
		alert("«Тема курсового проекта» не может быть пустой");
		stringReturn = false;
	} else if (assessmentOfaCourseCombo.value === ""
			|| assessmentOfaCourseCombo.value === null) {
		alert("Укажите «оценку курсового проекта»");
		stringReturn = false;

	} else if (archive.checked === true) {
		if (!document.getElementById('ZIP').checked
				&& !document.getElementById('JAR').checked) {
			alert("Выберите «Тип архива»");
			stringReturn = false;
		}
		else if (!document.getElementById('TXT').checked
				&& !document.getElementById('DOC').checked
				&& !document.getElementById('DOCX').checked) {
			alert("Выберите «Тип файла»");
			stringReturn = false;
		}

	} else if (dateStart.value === "" || dateStart.value === null) {
		alert("«Дата начала занятий» не введена.");
		stringReturn = false;
	} else if (dateFinish.value === "" || dateFinish.value === null) {
		alert("«Дата окончания занятий» не введена.");
		stringReturn = false;
	} else if (difference >= 0) {
		alert("Вы перепутали даты местами.");
		stringReturn = false;
	}

	if (stringReturn === true) {

		alert("Форма отправлена на сервлет.");

	}
	return stringReturn;

}