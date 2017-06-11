<!-- Page Heading -->
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Your PROFILE</h1>
		<div class="col-lg-12">
			<form action="profile.html" method="post" name="profileForm" onsubmit="true">
				<table>
					<thead>
						<tr><th colspan="2"></th><th > <h3>New data</h3></th>
					</thead>
					<tr>
						<td><h3>Login</h3></td>
						<td class="td-profile"><h3>${profileDto.login}</h3></td>
						<td >
							<h3>
								<input type="text" id="userLoginNew" name="userLoginNew" >
							</h3>
						</td>
					</tr>
					<tr>
						<td><h3>Password</h3></td>
						<td class="td-profile"><h3>${profileDto.password}</h3></td>
						<td >
							<h3>
								<input type="text" id="userPasswordNew"	name="userPasswordNew" >
							</h3>
						</td>
					</tr>
					<tr>
						<td><h3>First Name</h3></td>
						<td class="td-profile"><h3>${profileDto.firstName}</h3></td>
						<td >
							<h3>
								<input type="text" id="userFirstNameNew"	name="userFirstNameNew" >
							</h3>
						</td>
					</tr>
					<tr>
						<td><h3>Last Name</h3></td>
						<td class="td-profile"><h3>${profileDto.lastName}</h3></td>
						<td >
							<h3>
								<input type="text" id="userLastNameNew"	name="userLastNameNew" >
							</h3>
						</td>
					</tr>
					<tr>
						<td><h3>Email</h3></td>
						<td class="td-profile"><h3>${profileDto.email}</h3></td>
						<td >
							<h3>
								<input type="text" id="userEmailNew"	name="userEmailNew" >
							</h3>
						</td>
					</tr>
					<tr>
						<td><h3>Del status</h3></td>
						<td class="td-profile"><h3>${profileDto.delStatus}</h3></td>
						<td >
							<h3>
								<select class="select-width" id="userDelStatusNew" name="userDelStatusNew">
									<option value="" disabled selected="selected"></option>
									<option value="True">True</option>
									<option value="False">False</option>
								</select>
							</h3>
						</td>
					</tr>
					<tr>
						<td><h3>Role</h3></td>
						<td class="td-profile"><h3>${profileDto.role}</h3></td>
						<td >
							<h3>
								<select class="select-width" id="userRoleNew"	name="userRoleNew">
									<option value="" disabled selected="selected"></option>
									<option value="Administrator">Administrator</option>
									<option value="Moderator">Moderator</option>
									<option value="User">User</option>
								</select>
							</h3>
						</td>
					</tr>
				</table>
				
					<input type="submit" name="BtnChangeProfileCansel" value="Cansel" 
					class="btn btn-lg btn-primary">
					<input type="submit" name="BtnChangeProfileSave" value="Save" 
					class="btn btn-lg btn-primary">
				
			</form>					
		</div>
	</div>
</div>
<!-- /.row -->

