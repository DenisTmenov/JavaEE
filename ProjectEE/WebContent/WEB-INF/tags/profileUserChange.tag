<%@ tag language="java" pageEncoding="UTF-8"%>

<form action="./Action" method="post" name="profileForm" onsubmit="true">
	<table>
		<thead>
			<tr><th colspan="2"></th><th > <h3>New data</h3></th>
		</thead>
		<tr>
			<td><h3>Login</h3></td>
			<td class="td-profile"><h3>${userLogin}</h3></td>
		</tr>
		<tr>
			<td><h3>Password</h3></td>
			<td class="td-profile"><h3>${userPassword}</h3></td>
			<td >
				<h3>
					<input type="text" id="userPasswordNew"	name="userPasswordNew" >
				</h3>
			</td>
		</tr>
		<tr>
			<td><h3>First Name</h3></td>
			<td class="td-profile"><h3>${userFirstName}</h3></td>
			<td id="changeInfoFirstName" >
				<h3>
					<input type="text" id="userFirstNameNew" name="userFirstNameNew" >
				</h3>
			</td>
		</tr>
		<tr>
			<td><h3>Last Name</h3></td>
			<td class="td-profile"><h3>${userLastName}</h3></td>
			<td id="changeInfoLastName" >
				<h3>
					<input type="text" id="userLastNameNew"	name="userLastNameNew" >
				</h3>
			</td>
		</tr>
		<tr>
			<td><h3>Email</h3></td>
			<td class="td-profile"><h3>${userEmail}</h3></td>
		</tr>
	</table>
	
		<input type="submit" name="BtnChangeProfileCansel" value="Cansel" 
		class="btn btn-lg btn-primary">
		<input type="submit" name="BtnChangeProfileSave" value="Save" 
		class="btn btn-lg btn-primary">
	
</form>