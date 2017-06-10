<%@ tag language="java" pageEncoding="UTF-8"%>

<form action="./Action" method="post" name="profileForm">
	<table>
		<tr>
			<td><h3>Login</h3></td>
			<td class="td-profile"><h3>${userLogin}</h3></td>
		</tr>
		<tr>
			<td><h3>Password</h3></td>
			<td class="td-profile"><h3>${userPassword}</h3></td>
		</tr>
		<tr>
			<td><h3>First Name</h3></td>
			<td class="td-profile"><h3>${userFirstName}</h3></td>
		</tr>
		<tr>
			<td><h3>Last Name</h3></td>
			<td class="td-profile"><h3>${userLastName}</h3></td>
		</tr>
		<tr>
			<td><h3>Email</h3></td>
			<td class="td-profile"><h3>${userEmail}</h3></td>
		</tr>
	</table>
	<div>
		<input type="submit" name="BtnChangeProfile" value="Change profile information" 
		class="btn btn-lg btn-primary">
	</div>
</form>