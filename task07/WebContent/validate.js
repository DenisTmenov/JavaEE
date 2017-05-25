function validateInfo() {
	var addressSender = document.getElementById("addressSender");
	var addressRecipient = document.getElementById("addressRecipient");
	var buttonSend = document.getElementById("buttonSend");

	var stringReturn = false;

	var reg1 = /^\w+([\.-]?\w+)*@gmail\.com/;
	var reg2 = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})/;

	if (buttonSend.value == 'Send Mail') {
		if (addressSender.value.match(reg1)) {
			stringReturn = true;
			if (addressRecipient.value.match(reg2)) {
				stringReturn = true;
			} else {
				alert("Вы ввели неправильный адрес получателя электронной почты!!!");
				stringReturn = false;
			}
		} else {
			alert("Вы ввели неправильный адрес электронной почты!!!");
			stringReturn = false;
		}
	}

	return stringReturn;

}