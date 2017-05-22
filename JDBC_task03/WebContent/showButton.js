function hideShow(nameHide, nameShow) {
	var buttonHide = document.getElementById(nameHide.id);
	var buttonShow = document.getElementById(nameShow.id);
	
	buttonHide.hidden = true;
	buttonShow.hidden = false;
}
