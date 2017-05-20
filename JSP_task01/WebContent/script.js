function validateInfo() {
		var surName = document.getElementById('surName');
		var firstName = document.getElementById('firstName');
		var secretPHRASE = document.getElementById('secretPhrase');
		var AGE = document.getElementById('age');
		var course = document.getElementById('courseCombo');
		var teachername = document.getElementById('teachername');
		var assessmentCourse = document.getElementById('assessmentOfaCourseCombo');
		var otherTEXT = document.getElementById('textOtherId');
		var reg1 = /\\d/;
		var reg2 = /[a-zA-Zа-яА-Я]/;
		var reg3 = / /;
		if (surName.value === '' ||
		surName.value === null ||
		surName.value.match(reg3) ) {
		alert('«Фамилия» не может быть пустой');
		return false;
		} else if (surName.value.match(reg1)) {
		alert('«Фамилия» не может содержать числа');
		return false;
		} else if (surName.value.match(reg3)) {
		alert('«Фамилия» не может содержать пробел');
		return false;
		} else if (firstName.value === '' || firstName.value === null ) {
		alert('«Имя» не может быть пустым');
		return false;
		} else if (firstName.value.match(reg1)) {
		alert('«Имя» не может содержать числа');
		return false;
		} else if (firstName.value.match(reg3)) {
		alert('«Имя» не может содержать пробел');
		return false;
		} else if (secretPHRASE.value === '' || secretPHRASE.value === null ) {
		alert('«Секретная фраза» не может быть пустой');
		return false;
		} else if (AGE.value !== '') {
		if (AGE.value.match(reg2)) {
		alert('«Возрост» не может состоять из букв');
		return false;
		} else if (AGE.value <= 0) {
		alert('«Возрост» не может быть меньше 1');
		return false;
		} else if (AGE.value > 120) {
		alert('«Возрост» не может быть больше 120');
		return false;
		}
		} else if (!document.getElementById('gender_Male').checked && !document.getElementById('gender_Female').checked) {
		alert('Укажите пол. Вы хто: М или Ж ?');
		return false;
		} else if (course.value === '') {
		alert('Выберите Курс, который Вы проходили.');
		return false;
		} else if (teachername.value === '') {
		alert('Укажите преподавателя, который вел курс.');
		return false;
		} else if (assessmentCourse.value === '') {
		alert('Укажите, как Вы оценили курс.');
		return false;
		} else if (
		document.getElementById('howDidYouHearAboutUs01').checked === false &&
		document.getElementById('howDidYouHearAboutUs02').checked === false &&
		document.getElementById('howDidYouHearAboutUs03').checked === false &&
		document.getElementById('howDidYouHearAboutUs04').checked === false &&
		document.getElementById('howDidYouHearAboutUs05').checked === false &&
		document.getElementById('howDidYouHearAboutUsOTHER').checked === false) {
		alert('Укажите, как Вы узнали о нас.');
		return false;
		} else if (document.getElementById('textOtherId').disabled === false &&
		/^\\s+$/.test(otherTEXT.value)) {
		alert('Отвергаешь – предлагай!');
		return false;
		}
		else {
		var hiddenValue = parseInt(document.getElementById('secretValue').value);
		if (hiddenValue === 1) {
		alert('Браво, честный человек! Смело отправляйся смотреть результат!');
		return true;
		}
		if (hiddenValue === 2) {
		return confirm('Вообще-то врать не хорошо, даже если не видят… Точно отправляем.');
		}
		}
		return true;
		}
		function saveSecret(button) {
		document.getElementById('secretValue').value = button;
		}
		function otherCheck() {
		// Если поставлен флажок, снимаем блокирование кнопки
		if (!document.getElementById('howDidYouHearAboutUsOTHER').checked) {
		document.getElementById('howDidYouHearAboutUs01').disabled = 0;
		document.getElementById('howDidYouHearAboutUs02').disabled = 0;
		document.getElementById('howDidYouHearAboutUs03').disabled = 0;
		document.getElementById('howDidYouHearAboutUs04').disabled = 0;
		document.getElementById('howDidYouHearAboutUs05').disabled = 0;
		document.getElementById('textOtherId').disabled = 1;
		}
		// В противном случае вновь блокируем кнопку
		else {
		document.getElementById('howDidYouHearAboutUs01').disabled = 1;
		document.getElementById('howDidYouHearAboutUs02').disabled = 1;
		document.getElementById('howDidYouHearAboutUs03').disabled = 1;
		document.getElementById('howDidYouHearAboutUs04').disabled = 1;
		document.getElementById('howDidYouHearAboutUs05').disabled = 1;
		document.getElementById('howDidYouHearAboutUs01').checked = 0;
		document.getElementById('howDidYouHearAboutUs02').checked = 0;
		document.getElementById('howDidYouHearAboutUs03').checked = 0;
		document.getElementById('howDidYouHearAboutUs04').checked = 0;
		document.getElementById('howDidYouHearAboutUs05').checked = 0;
		document.getElementById('textOtherId').disabled = 0;}}
		function showOtherCourses() {
		var valueCourse = document.getElementById('courseCombo');
		if (valueCourse.value === 'Java SE') {
		document.getElementById('otherCourse01').hidden = 1;
		document.getElementById('otherCourse02').hidden = 0;
		document.getElementById('otherCourse03').hidden = 0;
		document.getElementById('otherCourse04').hidden = 0;
		}
		if (valueCourse.value === 'Java EE') {
		document.getElementById('otherCourse02').hidden = 1;
		document.getElementById('otherCourse01').hidden = 0;
		document.getElementById('otherCourse03').hidden = 0;
		document.getElementById('otherCourse04').hidden = 0;
		}
		if (valueCourse.value === 'Тестирование корабельных якорей методом погружения в Северное Море') {
		document.getElementById('otherCourse03').hidden = 1;
		document.getElementById('otherCourse01').hidden = 0;
		document.getElementById('otherCourse02').hidden = 0;
		document.getElementById('otherCourse04').hidden = 0;
		}
		if (valueCourse.value === 'Вышивание крестиком в условиях, близких к невесомости') {
		document.getElementById('otherCourse04').hidden = 1;
		document.getElementById('otherCourse01').hidden = 0;
		document.getElementById('otherCourse02').hidden = 0;
		document.getElementById('otherCourse03').hidden = 0;}}
		function javaScriptEnable() {
		var primaryTable = document.getElementById('primaryTable');
		primaryTable.onsubmit = 'return validateInfo()';}
		function javaScriptDisable() {
		var primaryTable = document.getElementById('primaryTable');
		primaryTable.onsubmit = 'true';}