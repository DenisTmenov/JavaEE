function activeButton() {

	var btnSave = document.getElementById('btnSave');
	var btnCansel = document.getElementById('btnCansel');

	if (btnSave.disabled === "disabled") {
		btnSave.disabled = 0;
		btnCansel.disabled = 0;
	} else {
		btnSave.disabled = "disabled";
		btnCansel.disabled = "disabled";
	}
}
