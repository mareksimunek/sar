package cz.fav.sar.server.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ccag_systemy")
public class System {
	@Id
	@Column(nullable = false)
	long id_systemu;		// not null, pk
	@Column(nullable = false)
	String kod_systemu;		// not null
	String poznamka;
	@Column(nullable = false)
	String priznak_an_zivy;	// not null (char ?), default 'T'
	
	
	public long getId_systemu() {
		return id_systemu;
	}
	public void setId_systemu(long id_systemu) {
		this.id_systemu = id_systemu;
	}
	public String getKod_systemu() {
		return kod_systemu;
	}
	public void setKod_systemu(String kod_systemu) {
		this.kod_systemu = kod_systemu;
	}
	public String getPoznamka() {
		return poznamka;
	}
	public void setPoznamka(String poznamka) {
		this.poznamka = poznamka;
	}
	public String getPriznak_an_zivy() {
		return priznak_an_zivy;
	}
	public void setPriznak_an_zivy(String priznak_an_zivy) {
		this.priznak_an_zivy = priznak_an_zivy;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id_systemu ^ (id_systemu >>> 32));
		result = prime * result
				+ ((kod_systemu == null) ? 0 : kod_systemu.hashCode());
		result = prime * result
				+ ((poznamka == null) ? 0 : poznamka.hashCode());
		result = prime * result
				+ ((priznak_an_zivy == null) ? 0 : priznak_an_zivy.hashCode());
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
		System other = (System) obj;
		if (id_systemu != other.id_systemu)
			return false;
		if (kod_systemu == null) {
			if (other.kod_systemu != null)
				return false;
		} else if (!kod_systemu.equals(other.kod_systemu))
			return false;
		if (poznamka == null) {
			if (other.poznamka != null)
				return false;
		} else if (!poznamka.equals(other.poznamka))
			return false;
		if (priznak_an_zivy == null) {
			if (other.priznak_an_zivy != null)
				return false;
		} else if (!priznak_an_zivy.equals(other.priznak_an_zivy))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "System [id_systemu=" + id_systemu + ", kod_systemu="
				+ kod_systemu + ", poznamka=" + poznamka + ", priznak_an_zivy="
				+ priznak_an_zivy + "]";
	}
}
