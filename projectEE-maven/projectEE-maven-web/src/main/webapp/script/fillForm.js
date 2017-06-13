function fillRegForm()
{
	var login = document.getElementById('login');
	var email = document.getElementById('email');
    var password = document.getElementById('password');
    var password_confirm = document.getElementById('password_confirm');
    
    login.value = "user01";
    email.value = "user01@gmail.com";
    password.value = "123";
    password_confirm.value = "123";
} 
