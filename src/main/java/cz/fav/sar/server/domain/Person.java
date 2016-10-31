package cz.fav.sar.server.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ccag_osoba")
public class Person {
	@Id
	@Column(nullable = false)
	long id_osoby;			// not null, pk
	String jmeno;			
	@Column(nullable = false)
	String prijmeni;		// not null
	@Column(nullable = false)
	long id_firmy;			// not null, fk
	
	
	public long getId_osoby() {
		return id_osoby;
	}
	public void setId_osoby(long id_osoby) {
		this.id_osoby = id_osoby;
	}
	public String getJmeno() {
		return jmeno;
	}
	public void setJmeno(String jmeno) {
		this.jmeno = jmeno;
	}
	public String getPrijmeni() {
		return prijmeni;
	}
	public void setPrijmeni(String prijmeni) {
		this.prijmeni = prijmeni;
	}
	public long getId_firmy() {
		return id_firmy;
	}
	public void setId_firmy(long id_firmy) {
		this.id_firmy = id_firmy;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id_firmy ^ (id_firmy >>> 32));
		result = prime * result + (int) (id_osoby ^ (id_osoby >>> 32));
		result = prime * result + ((jmeno == null) ? 0 : jmeno.hashCode());
		result = prime * result
				+ ((prijmeni == null) ? 0 : prijmeni.hashCode());
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
		if (id_firmy != other.id_firmy)
			return false;
		if (id_osoby != other.id_osoby)
			return false;
		if (jmeno == null) {
			if (other.jmeno != null)
				return false;
		} else if (!jmeno.equals(other.jmeno))
			return false;
		if (prijmeni == null) {
			if (other.prijmeni != null)
				return false;
		} else if (!prijmeni.equals(other.prijmeni))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Person [id_osoby=" + id_osoby + ", jmeno=" + jmeno
				+ ", prijmeni=" + prijmeni + ", id_firmy=" + id_firmy + "]";
	}
	
	
}
