package main.java.com.trainingcenter.projectEE.maven.entity;

import java.io.Serializable;

public class UserRoleEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idRole;
	private String nameRole;
	private Boolean add;
	private Boolean delete;
	private Boolean modify;
	private Boolean read;

	public UserRoleEntity() {
		super();
	}

	public Integer getIdRole() {
		return idRole;
	}

	public void setIdRole(Integer idRole) {
		this.idRole = idRole;
	}

	public String getNameRole() {
		return nameRole;
	}

	public void setNameRole(String nameRole) {
		this.nameRole = nameRole;
	}

	public Boolean getAdd() {
		return add;
	}

	public void setAdd(Boolean add) {
		this.add = add;
	}

	public Boolean getDelete() {
		return delete;
	}

	public void setDelete(Boolean delete) {
		this.delete = delete;
	}

	public Boolean getModify() {
		return modify;
	}

	public void setModify(Boolean modify) {
		this.modify = modify;
	}

	public Boolean getRead() {
		return read;
	}

	public void setRead(Boolean read) {
		this.read = read;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((add == null) ? 0 : add.hashCode());
		result = prime * result + ((delete == null) ? 0 : delete.hashCode());
		result = prime * result + ((idRole == null) ? 0 : idRole.hashCode());
		result = prime * result + ((modify == null) ? 0 : modify.hashCode());
		result = prime * result + ((nameRole == null) ? 0 : nameRole.hashCode());
		result = prime * result + ((read == null) ? 0 : read.hashCode());
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
		UserRoleEntity other = (UserRoleEntity) obj;
		if (add == null) {
			if (other.add != null)
				return false;
		} else if (!add.equals(other.add))
			return false;
		if (delete == null) {
			if (other.delete != null)
				return false;
		} else if (!delete.equals(other.delete))
			return false;
		if (idRole == null) {
			if (other.idRole != null)
				return false;
		} else if (!idRole.equals(other.idRole))
			return false;
		if (modify == null) {
			if (other.modify != null)
				return false;
		} else if (!modify.equals(other.modify))
			return false;
		if (nameRole == null) {
			if (other.nameRole != null)
				return false;
		} else if (!nameRole.equals(other.nameRole))
			return false;
		if (read == null) {
			if (other.read != null)
				return false;
		} else if (!read.equals(other.read))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserRoleBean: idRole=" + idRole + ", nameRole=" + nameRole + ", add=" + add + ", delete=" + delete
				+ ", modify=" + modify + ", read=" + read;
	}

}
