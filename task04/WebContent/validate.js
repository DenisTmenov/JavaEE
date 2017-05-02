function validateInfo() {
	var surNameStudent = document.getElementById("surNameStudent");
	var firstNameStudent = document.getElementById("firstNameStudent");
	var patronymicStudent = document.getElementById("patronymicStudent");
	var surNameTeacher = document.getElementById("surNameTeacher");
	var firstNameTeacher = document.getElementById("firstNameTeacher");
	var patronymicTeacher = document.getElementById("patronymicTeacher");
	var dateStart = document.getElementById("dateStart");
	var dateFinish = document.getElementById("dateFinish");
	var listOfTopicsStudiedIndependently = document.getElementById("listOfTopicsStudiedIndependently");
	var courseProjectTheme = document.getElementById("courseProjectTheme");
	var assessmentOfaCourseCombo = document.getElementById("assessmentOfaCourseCombo");
	
	var archive = document.getElementById("archive");
	var archiveType = document.getElementById("archiveType");
	
	
	var reg1 = /\d/;
	var reg2 = /[a-zA-Zа-яА-Я]/;
	var reg3 = / /;
	
	var difference = Date.parse(dateStart.value) - Date.parse(dateFinish.value);
	
	/*if (surNameStudent.value === "" || surNameStudent.value === null) {
		alert("«Фамилия слушателя» не может быть пустой");
		return false;
	} else if (surNameStudent.value.match(reg1)) {
		alert("«Фамилия слушателя» не может содержать числа");
		return false;
	} else if (surNameStudent.value.match(reg3)) {
		alert("«Фамилия слушателя» не может содержать пробел");
		return false;
	}
	 else if (firstNameStudent.value === "" || firstNameStudent.value === null) {
		 alert("«Имя слушателя» не может быть пустым"); 
		 return false; 
	 } else if (firstNameStudent.value.match(reg1)) { 
		 alert("«Имя слушателя» не может содержать числа");
	 	 return false; 
 	 } else if (firstNameStudent.value.match(reg3)) { 
 		 alert("«Имя слушателя» не может содержать пробел"); 
 		 return false; 
	 } 
 	 else if (patronymicStudent.value !== "") { 
 		 if (patronymicStudent.value.match(reg1)) { 
 			alert("«Отчество слушателя» не может содержать числа");
 		 	 return false; 
 			 } else if (patronymicStudent.value.match(reg1)) { 
 				alert("«Отчество слушателя» не может содержать пробел"); 
 		 		 return false; 
			 }
 		 
 		 
 		 
 	 }
	else if (surNameTeacher.value === "" || surNameTeacher.value === null) {
 			alert("«Фамилия преподавателя» не может быть пустой");
 			return false;
	} 
	else if (surNameTeacher.value.match(reg1)) {
 			alert("«Фамилия преподавателя» не может содержать числа");
 			return false;
	} 
	else if (surNameTeacher.value.match(reg3)) {
 			alert("«Фамилия преподавателя» не может содержать пробел");
 			return false;
	}
	 else if (firstNameTeacher.value === "" || firstNameTeacher.value === null) {
		 alert("«Имя преподавателя» не может быть пустым"); 
		 return false; 
	 } else if (firstNameTeacher.value.match(reg1)) { 
		 alert("«Имя преподавателя» не может содержать числа");
	 	 return false; 
 	 } else if (firstNameTeacher.value.match(reg3)) { 
 		 alert("«Имя преподавателя» не может содержать пробел"); 
 		 return false; 
	 } 
 	 else if (patronymicTeacher.value !== "") { 
 		 if (patronymicTeacher.value.match(reg1)) { 
 			alert("«Отчество преподавателя» не может содержать числа");
 		 	return false; 
 			} else if (patronymicTeacher.value.match(reg1)) { 
 				alert("«Отчество преподавателя» не может содержать пробел"); 
 				return false; 
 				}
 		 
 		 
 	 } 
 	 else*/ if (dateStart.value === "" || dateStart.value === null){
 		 alert("«Дата начала занятий» не введена.");
 		 return false; 
 	} 
 	 else if (dateFinish.value === "" || dateeFinish.value === null){
 		 alert("«Дата окончания занятий» не введена.");
 		 return false; 
 	} else if (difference >= 0){
		alert("Вы перепутали даты местами.");
		return false; 
 	}
 			 
	 /*} else if
	 (!document.getElementById('gender_Male').checked &&
	 !document.getElementById('gender_Female').checked) { alert("Укажите пол.
	 Вы хто: М или Ж ?"); return false; } else if (course.value === "") {
	 alert("Выберите Курс, который Вы проходили."); return false; } else if
	 (teacherNAME.value === "") { alert("Укажите преподавателя, который вел
	 курс."); return false; } else if (assessmentCourse.value === "") {
	 alert("Укажите, как Вы оценили курс."); return false; } else if
	 (document.getElementById("howDidYouHearAboutUs01").checked === false &&
	 document.getElementById("howDidYouHearAboutUs02").checked === false &&
	 document.getElementById("howDidYouHearAboutUs03").checked === false &&
	 document.getElementById("howDidYouHearAboutUs04").checked === false &&
	 document.getElementById("howDidYouHearAboutUs05").checked === false &&
	 document.getElementById("howDidYouHearAboutUsOTHER").checked === false) {
	 alert("Укажите, как Вы узнали о нас."); return false; } else if
	 (document.getElementById("textOtherId").disabled === false &&
	 /^\s+$/.test(otherTEXT.value)) { alert("Отвергаешь – предлагай!"); return
	 false; }*/
	 
	else {
		alert("Форма отправлена на сервлет.");
		return true;
	}

}

f