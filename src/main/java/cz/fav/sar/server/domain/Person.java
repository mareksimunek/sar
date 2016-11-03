package cz.fav.sar.server.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ccag_osoba")
public class Person {
	@Id
	@Column(name="id_osoby", nullable = false)
	long id;				// not null, pk
	@Column(name="jmeno")
	String name;			
	@Column(name="prijmeni", nullable = false)
	String surename;		// not null
	@Column(name="id_firmy", nullable = false)
	long companyId;			// not null, fk
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurename() {
		return surename;
	}
	public void setSurename(String surename) {
		this.surename = surename;
	}
	public long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (companyId ^ (companyId >>> 32));
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((surename == null) ? 0 : surename.hashCode());
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
		Person other = (Person) obj;
		if (companyId != other.companyId)
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (surename == null) {
			if (other.surename != null)
				return false;
		} else if (!surename.equals(other.surename))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", surename=" + surename
				+ ", companyId=" + companyId + "]";
	}

}
