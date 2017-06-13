function only_email_validate() {
	var email = document.getElementById('email').value;
	
	var regMail = /^([_a-zA-Z0-9-]+)(\.[_a-zA-Z0-9-]+)*@([a-zA-Z0-9-]+\.)+([a-zA-Z]{2,3})$/;

	if (regMail.test(email) == false) {
		document.getElementById("statusEmail").innerHTML    = "<span class='warning'>Email address is not valid yet.</span>";
		return false;

	} else {
		return true;
	}
}