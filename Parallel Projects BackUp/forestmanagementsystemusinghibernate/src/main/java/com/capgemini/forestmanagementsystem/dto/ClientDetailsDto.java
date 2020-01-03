package com.capgemini.forestmanagementsystem.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="clientdetails")
public class ClientDetailsDto {
	@Id
	@Column
	private int clientid;
	@Column
	private String clientname;
	@Column
	private String password;
	public int getClientid() {
		return clientid;
	}
	public void setClientid(int clientid) {
		this.clientid = clientid;
	}
	public String getClientname() {
		return clientname;
	}
	public void setClientname(String clientname) {
		this.clientname = clientname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Client id : " + clientid + "\nClient Name : " + clientname + "\nPSassword : " + password;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + clientid;
		result = prime * result + ((clientname == null) ? 0 : clientname.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		ClientDetailsDto other = (ClientDetailsDto) obj;
		if (clientid != other.clientid)
			return false;
		if (clientname == null) {
			if (other.clientname != null)
				return false;
		} else if (!clientname.equals(other.clientname))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

   
	
	


	
}
