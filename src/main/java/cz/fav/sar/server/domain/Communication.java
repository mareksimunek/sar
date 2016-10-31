package cz.fav.sar.server.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ccag_hlaseni_komunikace")
public class Communication {
	@Id
	@Column(nullable = false)
	long id_komunikace;			// not null, pk
	@Column(nullable = false)
	long id_hlaseni;			// not null, fk
	String id_zakaznika;
	@Column(nullable = false)
	long poradove_cislo;		// not null
	String obsah_komunikace;
	@Column(nullable = false)
	Date datum_vlozeni;			// not null
	
	
	public long getId_komunikace() {
		return id_komunikace;
	}
	public void setId_komunikace(long id_komunikace) {
		this.id_komunikace = id_komunikace;
	}
	public long getId_hlaseni() {
		return id_hlaseni;
	}
	public void setId_hlaseni(long id_hlaseni) {
		this.id_hlaseni = id_hlaseni;
	}
	public String getId_zakaznika() {
		return id_zakaznika;
	}
	public void setId_zakaznika(String id_zakaznika) {
		this.id_zakaznika = id_zakaznika;
	}
	public long getPoradove_cislo() {
		return poradove_cislo;
	}
	public void setPoradove_cislo(long poradove_cislo) {
		this.poradove_cislo = poradove_cislo;
	}
	public String getObsah_komunikace() {
		return obsah_komunikace;
	}
	public void setObsah_komunikace(String obsah_komunikace) {
		this.obsah_komunikace = obsah_komunikace;
	}
	public Date getDatum_vlozeni() {
		return datum_vlozeni;
	}
	public void setDatum_vlozeni(Date datum_vlozeni) {
		this.datum_vlozeni = datum_vlozeni;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((datum_vlozeni == null) ? 0 : datum_vlozeni.hashCode());
		result = prime * result + (int) (id_hlaseni ^ (id_hlaseni >>> 32));
		result = prime * result
				+ (int) (id_komunikace ^ (id_komunikace >>> 32));
		result = prime * result
				+ ((id_zakaznika == null) ? 0 : id_zakaznika.hashCode());
		result = prime
				* result
				+ ((obsah_komunikace == null) ? 0 : obsah_komunikace.hashCode());
		result = prime * result
				+ (int) (poradove_cislo ^ (poradove_cislo >>> 32));
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
		Communication other = (Communication) obj;
		if (datum_vlozeni == null) {
			if (other.datum_vlozeni != null)
				return false;
		} else if (!datum_vlozeni.equals(other.datum_vlozeni))
			return false;
		if (id_hlaseni != other.id_hlaseni)
			return false;
		if (id_komunikace != other.id_komunikace)
			return false;
		if (id_zakaznika == null) {
			if (other.id_zakaznika != null)
				return false;
		} else if (!id_zakaznika.equals(other.id_zakaznika))
			return false;
		if (obsah_komunikace == null) {
			if (other.obsah_komunikace != null)
				return false;
		} else if (!obsah_komunikace.equals(other.obsah_komunikace))
			return false;
		if (poradove_cislo != other.poradove_cislo)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Communication [id_komunikace=" + id_komunikace
				+ ", id_hlaseni=" + id_hlaseni + ", id_zakaznika="
				+ id_zakaznika + ", poradove_cislo=" + poradove_cislo
				+ ", obsah_komunikace=" + obsah_komunikace + ", datum_vlozeni="
				+ datum_vlozeni + "]";
	}
	
	
}
