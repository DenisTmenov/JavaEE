package com.trainingcenter.projectee.entity;

import java.io.Serializable;

public class UserEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idUser;
	private String Login;
	private String Password;
	private Boolean delStatus;
	private Integer fkRole;

	public UserEntity() {
		super();
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getLogin() {
		return Login;
	}

	public void setLogin(String login) {
		Login = login;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public Boolean getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(Boolean delStatus) {
		this.delStatus = delStatus;
	}

	public Integer getFkRole() {
		return fkRole;
	}

	public void setFkRole(Integer fkRole) {
		this.fkRole = fkRole;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Login == null) ? 0 : Login.hashCode());
		result = prime * result + ((Password == null) ? 0 : Password.hashCode());
		result = prime * result + ((delStatus == null) ? 0 : delStatus.hashCode());
		result = prime * result + ((fkRole == null) ? 0 : fkRole.hashCode());
		result = prime * result + ((idUser == null) ? 0 : idUser.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserEntity other = (UserEntity) obj;
		if (Login == null) {
			if (other.Login != null)
				return false;
		} else if (!Login.equals(other.Login))
			return false;
		if (Password == null) {
			if (other.Password != null)
				return false;
		} else if (!Password.equals(other.Password))
			return false;
		if (delStatus == null) {
			if (other.delStatus != null)
				return false;
		} else if (!delStatus.equals(other.delStatus))
			return false;
		if (fkRole == null) {
			if (other.fkRole != null)
				return false;
		} else if (!fkRole.equals(other.fkRole))
			return false;
		if (idUser == null) {
			if (other.idUser != null)
				return false;
		} else if (!idUser.equals(other.idUser))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserBean [idUser=" + idUser + ", Login=" + Login + ", Password=" + Password + ", delStatus=" + delStatus
				+ ", fkRole=" + fkRole + "]";
	}

}