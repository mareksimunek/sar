package cz.fav.sar.server.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ccag_firma")
public class Company {
	@Id
	@Column(nullable = false)
	long id_firmy;		// not null
	@Column(nullable = false)
	String nazev;		// not null
	
	
	public long getId_firmy() {
		return id_firmy;
	}
	public void setId_firmy(long id_firmy) {
		this.id_firmy = id_firmy;
	}
	public String getNazev() {
		return nazev;
	}
	public void setNazev(String nazev) {
		this.nazev = nazev;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id_firmy ^ (id_firmy >>> 32));
		result = prime * result + ((nazev == null) ? 0 : nazev.hashCode());
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
		Company other = (Company) obj;
		if (id_firmy != other.id_firmy)
			return false;
		if (nazev == null) {
			if (other.nazev != null)
				return false;
		} else if (!nazev.equals(other.nazev))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Company [id_firmy=" + id_firmy + ", nazev=" + nazev + "]";
	}
}
