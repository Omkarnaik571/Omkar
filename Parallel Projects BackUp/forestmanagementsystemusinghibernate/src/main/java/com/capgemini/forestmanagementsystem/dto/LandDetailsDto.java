package com.capgemini.forestmanagementsystem.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="landdetails")
public class LandDetailsDto {
	@Id
	@Column
	private int plotnumber;
	@Column
	private String acquireddate;
	@Column
	private String landvalue;
	@Column
	private String location;
	public int getPlotnumber() {
		return plotnumber;
	}
	public void setPlotnumber(int plotnumber) {
		this.plotnumber = plotnumber;
	}
	public String getAcquireddate() {
		return acquireddate;
	}
	public void setAcquireddate(String acquireddate) {
		this.acquireddate = acquireddate;
	}
	public String getLandvalue() {
		return landvalue;
	}
	public void setLandvalue(String landvalue) {
		this.landvalue = landvalue;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Plot Number : " + plotnumber + "\nAcquired Date : " + acquireddate + "\nLand Value : "
				+ landvalue + "Loocation : " + location;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acquireddate == null) ? 0 : acquireddate.hashCode());
		result = prime * result + ((landvalue == null) ? 0 : landvalue.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + plotnumber;
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
		LandDetailsDto other = (LandDetailsDto) obj;
		if (acquireddate == null) {
			if (other.acquireddate != null)
				return false;
		} else if (!acquireddate.equals(other.acquireddate))
			return false;
		if (landvalue == null) {
			if (other.landvalue != null)
				return false;
		} else if (!landvalue.equals(other.landvalue))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (plotnumber != other.plotnumber)
			return false;
		return true;
	}

    
	
	
	
	
	


}
