function letterClean() {
	var surNameStudent = document.getElementById("surNameStudent");
	var firstNameStudent = document.getElementById("firstNameStudent");
	var patronymicStudent = document.getElementById("patronymicStudent");
	
	var surNameTeacher = document.getElementById("surNameTeacher");
	var firstNameTeacher = document.getElementById("firstNameTeacher");
	var patronymicTeacher = document.getElementById("patronymicTeacher");
	
	var dateStart = document.getElementById("dateStart");
	var dateFinish = document.getElementById("dateFinish");
	
	var theme01 = document.getElementById("theme01");
	var theme02 = document.getElementById("theme02");

	var courseProjectTheme = document.getElementById("courseProjectTheme");
	var assessmentOfaCourseCombo = document.getElementById("assessmentOfaCourseCombo");
	
	surNameStudent.value = "";
	firstNameStudent.value = "";
	patronymicStudent.value = "";
	
	surNameTeacher.value = "";
	firstNameTeacher.value = "";
	patronymicTeacher.value = "";
	
	dateStart.value = "";
	dateFinish.value = "";
	
	courseProjectTheme.value = "";
	assessmentOfaCourseCombo.value = "";
	
	theme1.checked = "";
	theme2.checked = "";
}

function letterFull() {
	var surNameStudent = document.getElementById("surNameStudent");
	var firstNameStudent = document.getElementById("firstNameStudent");
	var patronymicStudent = document.getElementById("patronymicStudent");
	var surNameTeacher = document.getElementById("surNameTeacher");
	var firstNameTeacher = document.getElementById("firstNameTeacher");
	var patronymicTeacher = document.getElementById("patronymicTeacher");
	var dateStart = document.getElementById("dateStart");
	var dateFinish = document.getElementById("dateFinish");
	
	var theme1 = document.getElementById("theme1");
	var theme2 = document.getElementById("theme2");

	var courseProjectTheme = document.getElementById("courseProjectTheme");
	var assessmentOfaCourseCombo = document.getElementById("assessmentOfaCourseCombo");

		
	surNameStudent.value = "Иванов";
	firstNameStudent.value = "Иван";
	patronymicStudent.value = "Иванович";
	
	surNameTeacher.value = "Редька";
	firstNameTeacher.value = "Клубень";
	patronymicTeacher.value = "Корешков";
	
	dateStart.value = "2017-01-01";
	dateFinish.value = "2017-05-01";

	courseProjectTheme.value = "Секретная тема";
	assessmentOfaCourseCombo.value = "Отлично";
	
	theme1.checked = "checked";
	theme2.checked = "checked";
	
}