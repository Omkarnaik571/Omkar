package com.capgemini.forestmanagementsystem.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="schedulerdetails")
public class SchedulerDetailsDto {
	@Id
	@Column
	private int schedulerid;
	@Column
	private String schedulername;
	@Column
	private String password;
	public int getSchedulerid() {
		return schedulerid;
	}
	public void setSchedulerid(int schedulerid) {
		this.schedulerid = schedulerid;
	}
	public String getSchedulername() {
		return schedulername;
	}
	public void setSchedulername(String schedulername) {
		this.schedulername = schedulername;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Schedulerid : " + schedulerid + "\nSchedulername : " + schedulername + "\nPassword="
				+ password;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + schedulerid;
		result = prime * result + ((schedulername == null) ? 0 : schedulername.hashCode());
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
		SchedulerDetailsDto other = (SchedulerDetailsDto) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (schedulerid != other.schedulerid)
			return false;
		if (schedulername == null) {
			if (other.schedulername != null)
				return false;
		} else if (!schedulername.equals(other.schedulername))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
	
	
}
