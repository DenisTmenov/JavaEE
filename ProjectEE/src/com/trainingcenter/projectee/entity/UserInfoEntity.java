package com.trainingcenter.projectee.entity;

import java.io.Serializable;

public class UserInfoEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idInfo;
	private String firstName;
	private String lastName;
	private String email;
	private Integer fkIdUser;

	public UserInfoEntity() {
		super();
	}

	public Integer getIdInfo() {
		return idInfo;
	}

	public void setIdInfo(Integer idInfo) {
		this.idInfo = idInfo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getFkIdUser() {
		return fkIdUser;
	}

	public void setFkIdUser(Integer fkIdUser) {
		this.fkIdUser = fkIdUser;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((fkIdUser == null) ? 0 : fkIdUser.hashCode());
		result = prime * result + ((idInfo == null) ? 0 : idInfo.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
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
		UserInfoEntity other = (UserInfoEntity) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (fkIdUser == null) {
			if (other.fkIdUser != null)
				return false;
		} else if (!fkIdUser.equals(other.fkIdUser))
			return false;
		if (idInfo == null) {
			if (other.idInfo != null)
				return false;
		} else if (!idInfo.equals(other.idInfo))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserInfoBean [idInfo=" + idInfo + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", fkIdUser=" + fkIdUser + "]";
	}

}
