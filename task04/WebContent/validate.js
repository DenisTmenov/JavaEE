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
	var archiveType = document.getElementById("archiveType");

	var reg1 = /\d/;
	var reg2 = /[a-zA-Zа-яА-Я]/;
	var reg3 = / /;

	var difference = Date.parse(dateStart.value) - Date.parse(dateFinish.value);

	if (surNameStudent.value === "" || surNameStudent.value === null) {
		alert("«Фамилия слушателя» не может быть пустой");
		return false;
	} else if (surNameStudent.value.match(reg1)) {
		alert("«Фамилия слушателя» не может содержать числа");
		return false;
	} else if (surNameStudent.value.match(reg3)) {
		alert("«Фамилия слушателя» не может содержать пробел");
		return false;
	} else if (firstNameStudent.value === "" || firstNameStudent.value === null) {
		alert("«Имя слушателя» не может быть пустым");
		return false;
	} else if (firstNameStudent.value.match(reg1)) {
		alert("«Имя слушателя» не может содержать числа");
		return false;
	} else if (firstNameStudent.value.match(reg3)) {
		alert("«Имя слушателя» не может содержать пробел");
		return false;
	} else if (patronymicStudent.value !== "") {
		if (patronymicStudent.value.match(reg1)) {
			alert("«Отчество слушателя» не может содержать числа");
			return false;
		} else if (patronymicStudent.value.match(reg1)) {
			alert("«Отчество слушателя» не может содержать пробел");
			return false;
		}

	} else if (surNameTeacher.value === "" || surNameTeacher.value === null) {
		alert("«Фамилия преподавателя» не может быть пустой");
		return false;
	} else if (surNameTeacher.value.match(reg1)) {
		alert("«Фамилия преподавателя» не может содержать числа");
		return false;
	} else if (surNameTeacher.value.match(reg3)) {
		alert("«Фамилия преподавателя» не может содержать пробел");
		return false;
	} else if (firstNameTeacher.value === "" || firstNameTeacher.value === null) {
		alert("«Имя преподавателя» не может быть пустым");
		return false;
	} else if (firstNameTeacher.value.match(reg1)) {
		alert("«Имя преподавателя» не может содержать числа");
		return false;
	} else if (firstNameTeacher.value.match(reg3)) {
		alert("«Имя преподавателя» не может содержать пробел");
		return false;
	} else if (patronymicTeacher.value !== "") {
		if (patronymicTeacher.value.match(reg1)) {
			alert("«Отчество преподавателя» не может содержать числа");
			return false;
		} else if (patronymicTeacher.value.match(reg1)) {
			alert("«Отчество преподавателя» не может содержать пробел");
			return false;
		}

	} else if (courseProjectTheme.value === ""
			|| courseProjectTheme.value === null) {
		alert("«Тема курсового проекта» не может быть пустой");
		return false;
	} else if (assessmentOfaCourseCombo.value === ""
			|| assessmentOfaCourseCombo.value === null) {
		alert("Укажите «оценку курсового проекта»");
		return false;
	} else if (archive.checked === false) {
		alert("Выберите «Упаковать в архив»");
		return false;
	} else if (!document.getElementById('ZIP').checked
			&& !document.getElementById('JAR').checked) {
		alert("Выберите «Тип архива»");
		return false;

	} else if (dateStart.value === "" || dateStart.value === null) {
		alert("«Дата начала занятий» не введена.");
		return false;
	} else if (dateFinish.value === "" || dateFinish.value === null) {
		alert("«Дата окончания занятий» не введена.");
		return false;
	} else if (difference >= 0) {
		alert("Вы перепутали даты местами.");
		return false;
	}

	else {
		alert("Форма отправлена на сервлет.");
		return true;
	}

}