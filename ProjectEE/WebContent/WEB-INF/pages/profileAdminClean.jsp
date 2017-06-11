<!-- Page Heading -->
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Your PROFILE</h1>
		<div class="col-lg-12">
			<form action="profile.html" method="post" name="profileForm" onsubmit="true">
				<table>
					<tr>
						<td><h3>Login</h3></td>
						<td class="td-profile"><h3>${profileDto.login}</h3></td>
					</tr>
					<tr>
						<td><h3>Password</h3></td>
						<td class="td-profile"><h3>${profileDto.password}</h3></td>
					</tr>
					<tr>
						<td><h3>First Name</h3></td>
						<td class="td-profile"><h3>${profileDto.firstName}</h3></td>
					</tr>
					<tr>
						<td><h3>Last Name</h3></td>
						<td class="td-profile"><h3>${profileDto.lastName}</h3></td>
					</tr>
					<tr>
						<td><h3>Email</h3></td>
						<td class="td-profile"><h3>${profileDto.email}</h3></td>
					</tr>
					<tr>
						<td><h3>Del status</h3></td>
						<td class="td-profile"><h3>${profileDto.delStatus}</h3></td>
					</tr>
					<tr>
						<td><h3>Role</h3></td>
						<td class="td-profile"><h3>${profileDto.role}</h3></td>
					</tr>
				</table>
				<div>
					<input type="submit" name="BtnChangeProfile" value="Change profile information" 
					class="btn btn-lg btn-primary">
				</div>
			</form>						
				
		</div>
	</div>
</div>
<!-- /.row -->

