package cz.fav.sar.server.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ccag_systemy")
public class System {
	@Id
	@Column(name="id_systemu", nullable = false)
	Long id;					// not null, pk
	@Column(name="kod_systemu", nullable = false)
	String systemCode;			// not null
	@Column(name="poznamka")
	String note;
	@Column(name="priznak_an_zivy", nullable = false)
	String alive;				// not null (char ?), default 'T'
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSystemCode() {
		return systemCode;
	}
	public void setSystemCode(String systemCode) {
		this.systemCode = systemCode;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getAlive() {
		return alive;
	}
	public void setAlive(String alive) {
		this.alive = alive;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alive == null) ? 0 : alive.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((note == null) ? 0 : note.hashCode());
		result = prime * result
				+ ((systemCode == null) ? 0 : systemCode.hashCode());
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
		if (alive == null) {
			if (other.alive != null)
				return false;
		} else if (!alive.equals(other.alive))
			return false;
		if (id != other.id)
			return false;
		if (note == null) {
			if (other.note != null)
				return false;
		} else if (!note.equals(other.note))
			return false;
		if (systemCode == null) {
			if (other.systemCode != null)
				return false;
		} else if (!systemCode.equals(other.systemCode))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "System [id=" + id + ", systemCode=" + systemCode + ", note="
				+ note + ", alive=" + alive + "]";
	}
}
