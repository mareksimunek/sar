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
	Long id;				// not null, pk
	@Column(name="jmeno")
	String name;			
	@Column(name="prijmeni", nullable = false)
	String surename;		// not null
	@Column(name="id_firmy", nullable = false)
	Long companyId;			// not null, fk

	@Column(name="heslo")
	String passwordHash;
	
	@Column(name="email", nullable = false)
	String email;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}
	public String getPasswordHash() {
		return passwordHash;
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
		if (id == other.id)
			return true;
		return false;
	}
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", surename=" + surename
				+ ", companyId=" + companyId + "]";
	}

}
