package cz.fav.sar.server.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ccag_hlaseni")
public class Report {
	@Id
	@Column(nullable = false)
	long id_hlaseni;			// not null, pkey
	@Column(nullable = false)
	long cislo_hlaseni;			// not null
	@Column(nullable = false)
	long rok_hlaseni;			// not null
	@Column(nullable = false)
	String druh_hlaseni;		// not null
	@Column(nullable = false)
	Date datum_vzniku;			// not null
	@Column(nullable = false)
	long id_firmy;				// not null, fk
	@Column(nullable = false)
	long id_zakaznika;			// not null, fk
	Date termin;
	long pracnost;
	@Column(nullable = false)
	String text_hlaseni;		// not null
	String text_vyrizeni;		
	String kod_uzivatele_resi;
	String kod_uzivatele_vyridil;
	Date datum_vyrizeni_hlaseni;
	@Column(nullable = false)
	String kodpra_i;			// not null
	@Column(nullable = false)
	Date datum_i;				// not null
	String kodpra_u;
	Date datum_u;
	String kod_uzivatele_garant;
	String kod_uzivatele_vyridil_garant;
	Date datum_vyrizeni_hlaseni_garant;
	long priorita;
	String nazev;
	long id_systemu;			// fk
	
	
	public long getId_hlaseni() {
		return id_hlaseni;
	}
	public void setId_hlaseni(long id_hlaseni) {
		this.id_hlaseni = id_hlaseni;
	}
	public long getCislo_hlaseni() {
		return cislo_hlaseni;
	}
	public void setCislo_hlaseni(long cislo_hlaseni) {
		this.cislo_hlaseni = cislo_hlaseni;
	}
	public long getRok_hlaseni() {
		return rok_hlaseni;
	}
	public void setRok_hlaseni(long rok_hlaseni) {
		this.rok_hlaseni = rok_hlaseni;
	}
	public String getDruh_hlaseni() {
		return druh_hlaseni;
	}
	public void setDruh_hlaseni(String druh_hlaseni) {
		this.druh_hlaseni = druh_hlaseni;
	}
	public Date getDatum_vzniku() {
		return datum_vzniku;
	}
	public void setDatum_vzniku(Date datum_vzniku) {
		this.datum_vzniku = datum_vzniku;
	}
	public long getId_firmy() {
		return id_firmy;
	}
	public void setId_firmy(long id_firmy) {
		this.id_firmy = id_firmy;
	}
	public long getId_zakaznika() {
		return id_zakaznika;
	}
	public void setId_zakaznika(long id_zakaznika) {
		this.id_zakaznika = id_zakaznika;
	}
	public Date getTermin() {
		return termin;
	}
	public void setTermin(Date termin) {
		this.termin = termin;
	}
	public long getPracnost() {
		return pracnost;
	}
	public void setPracnost(long pracnost) {
		this.pracnost = pracnost;
	}
	public String getText_hlaseni() {
		return text_hlaseni;
	}
	public void setText_hlaseni(String text_hlaseni) {
		this.text_hlaseni = text_hlaseni;
	}
	public String getText_vyrizeni() {
		return text_vyrizeni;
	}
	public void setText_vyrizeni(String text_vyrizeni) {
		this.text_vyrizeni = text_vyrizeni;
	}
	public String getKod_uzivatele_resi() {
		return kod_uzivatele_resi;
	}
	public void setKod_uzivatele_resi(String kod_uzivatele_resi) {
		this.kod_uzivatele_resi = kod_uzivatele_resi;
	}
	public String getKod_uzivatele_vyridil() {
		return kod_uzivatele_vyridil;
	}
	public void setKod_uzivatele_vyridil(String kod_uzivatele_vyridil) {
		this.kod_uzivatele_vyridil = kod_uzivatele_vyridil;
	}
	public Date getDatum_vyrizeni_hlaseni() {
		return datum_vyrizeni_hlaseni;
	}
	public void setDatum_vyrizeni_hlaseni(Date datum_vyrizeni_hlaseni) {
		this.datum_vyrizeni_hlaseni = datum_vyrizeni_hlaseni;
	}
	public String getKodpra_i() {
		return kodpra_i;
	}
	public void setKodpra_i(String kodpra_i) {
		this.kodpra_i = kodpra_i;
	}
	public Date getDatum_i() {
		return datum_i;
	}
	public void setDatum_i(Date datum_i) {
		this.datum_i = datum_i;
	}
	public String getKodpra_u() {
		return kodpra_u;
	}
	public void setKodpra_u(String kodpra_u) {
		this.kodpra_u = kodpra_u;
	}
	public Date getDatum_u() {
		return datum_u;
	}
	public void setDatum_u(Date datum_u) {
		this.datum_u = datum_u;
	}
	public String getKod_uzivatele_garant() {
		return kod_uzivatele_garant;
	}
	public void setKod_uzivatele_garant(String kod_uzivatele_garant) {
		this.kod_uzivatele_garant = kod_uzivatele_garant;
	}
	public String getKod_uzivatele_vyridil_garant() {
		return kod_uzivatele_vyridil_garant;
	}
	public void setKod_uzivatele_vyridil_garant(String kod_uzivatele_vyridil_garant) {
		this.kod_uzivatele_vyridil_garant = kod_uzivatele_vyridil_garant;
	}
	public Date getDatum_vyrizeni_hlaseni_garant() {
		return datum_vyrizeni_hlaseni_garant;
	}
	public void setDatum_vyrizeni_hlaseni_garant(Date datum_vyrizeni_hlaseni_garant) {
		this.datum_vyrizeni_hlaseni_garant = datum_vyrizeni_hlaseni_garant;
	}
	public long getPriorita() {
		return priorita;
	}
	public void setPriorita(long priorita) {
		this.priorita = priorita;
	}
	public String getNazev() {
		return nazev;
	}
	public void setNazev(String nazev) {
		this.nazev = nazev;
	}
	public long getId_systemu() {
		return id_systemu;
	}
	public void setId_systemu(long id_systemu) {
		this.id_systemu = id_systemu;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (int) (cislo_hlaseni ^ (cislo_hlaseni >>> 32));
		result = prime * result + ((datum_i == null) ? 0 : datum_i.hashCode());
		result = prime * result + ((datum_u == null) ? 0 : datum_u.hashCode());
		result = prime
				* result
				+ ((datum_vyrizeni_hlaseni == null) ? 0
						: datum_vyrizeni_hlaseni.hashCode());
		result = prime
				* result
				+ ((datum_vyrizeni_hlaseni_garant == null) ? 0
						: datum_vyrizeni_hlaseni_garant.hashCode());
		result = prime * result
				+ ((datum_vzniku == null) ? 0 : datum_vzniku.hashCode());
		result = prime * result
				+ ((druh_hlaseni == null) ? 0 : druh_hlaseni.hashCode());
		result = prime * result + (int) (id_firmy ^ (id_firmy >>> 32));
		result = prime * result + (int) (id_hlaseni ^ (id_hlaseni >>> 32));
		result = prime * result + (int) (id_systemu ^ (id_systemu >>> 32));
		result = prime * result + (int) (id_zakaznika ^ (id_zakaznika >>> 32));
		result = prime
				* result
				+ ((kod_uzivatele_garant == null) ? 0 : kod_uzivatele_garant
						.hashCode());
		result = prime
				* result
				+ ((kod_uzivatele_resi == null) ? 0 : kod_uzivatele_resi
						.hashCode());
		result = prime
				* result
				+ ((kod_uzivatele_vyridil == null) ? 0 : kod_uzivatele_vyridil
						.hashCode());
		result = prime
				* result
				+ ((kod_uzivatele_vyridil_garant == null) ? 0
						: kod_uzivatele_vyridil_garant.hashCode());
		result = prime * result
				+ ((kodpra_i == null) ? 0 : kodpra_i.hashCode());
		result = prime * result
				+ ((kodpra_u == null) ? 0 : kodpra_u.hashCode());
		result = prime * result + ((nazev == null) ? 0 : nazev.hashCode());
		result = prime * result + (int) (pracnost ^ (pracnost >>> 32));
		result = prime * result + (int) (priorita ^ (priorita >>> 32));
		result = prime * result + (int) (rok_hlaseni ^ (rok_hlaseni >>> 32));
		result = prime * result + ((termin == null) ? 0 : termin.hashCode());
		result = prime * result
				+ ((text_hlaseni == null) ? 0 : text_hlaseni.hashCode());
		result = prime * result
				+ ((text_vyrizeni == null) ? 0 : text_vyrizeni.hashCode());
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
		Report other = (Report) obj;
		if (cislo_hlaseni != other.cislo_hlaseni)
			return false;
		if (datum_i == null) {
			if (other.datum_i != null)
				return false;
		} else if (!datum_i.equals(other.datum_i))
			return false;
		if (datum_u == null) {
			if (other.datum_u != null)
				return false;
		} else if (!datum_u.equals(other.datum_u))
			return false;
		if (datum_vyrizeni_hlaseni == null) {
			if (other.datum_vyrizeni_hlaseni != null)
				return false;
		} else if (!datum_vyrizeni_hlaseni.equals(other.datum_vyrizeni_hlaseni))
			return false;
		if (datum_vyrizeni_hlaseni_garant == null) {
			if (other.datum_vyrizeni_hlaseni_garant != null)
				return false;
		} else if (!datum_vyrizeni_hlaseni_garant
				.equals(other.datum_vyrizeni_hlaseni_garant))
			return false;
		if (datum_vzniku == null) {
			if (other.datum_vzniku != null)
				return false;
		} else if (!datum_vzniku.equals(other.datum_vzniku))
			return false;
		if (druh_hlaseni == null) {
			if (other.druh_hlaseni != null)
				return false;
		} else if (!druh_hlaseni.equals(other.druh_hlaseni))
			return false;
		if (id_firmy != other.id_firmy)
			return false;
		if (id_hlaseni != other.id_hlaseni)
			return false;
		if (id_systemu != other.id_systemu)
			return false;
		if (id_zakaznika != other.id_zakaznika)
			return false;
		if (kod_uzivatele_garant == null) {
			if (other.kod_uzivatele_garant != null)
				return false;
		} else if (!kod_uzivatele_garant.equals(other.kod_uzivatele_garant))
			return false;
		if (kod_uzivatele_resi == null) {
			if (other.kod_uzivatele_resi != null)
				return false;
		} else if (!kod_uzivatele_resi.equals(other.kod_uzivatele_resi))
			return false;
		if (kod_uzivatele_vyridil == null) {
			if (other.kod_uzivatele_vyridil != null)
				return false;
		} else if (!kod_uzivatele_vyridil.equals(other.kod_uzivatele_vyridil))
			return false;
		if (kod_uzivatele_vyridil_garant == null) {
			if (other.kod_uzivatele_vyridil_garant != null)
				return false;
		} else if (!kod_uzivatele_vyridil_garant
				.equals(other.kod_uzivatele_vyridil_garant))
			return false;
		if (kodpra_i == null) {
			if (other.kodpra_i != null)
				return false;
		} else if (!kodpra_i.equals(other.kodpra_i))
			return false;
		if (kodpra_u == null) {
			if (other.kodpra_u != null)
				return false;
		} else if (!kodpra_u.equals(other.kodpra_u))
			return false;
		if (nazev == null) {
			if (other.nazev != null)
				return false;
		} else if (!nazev.equals(other.nazev))
			return false;
		if (pracnost != other.pracnost)
			return false;
		if (priorita != other.priorita)
			return false;
		if (rok_hlaseni != other.rok_hlaseni)
			return false;
		if (termin == null) {
			if (other.termin != null)
				return false;
		} else if (!termin.equals(other.termin))
			return false;
		if (text_hlaseni == null) {
			if (other.text_hlaseni != null)
				return false;
		} else if (!text_hlaseni.equals(other.text_hlaseni))
			return false;
		if (text_vyrizeni == null) {
			if (other.text_vyrizeni != null)
				return false;
		} else if (!text_vyrizeni.equals(other.text_vyrizeni))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Report [id_hlaseni=" + id_hlaseni + ", cislo_hlaseni="
				+ cislo_hlaseni + ", rok_hlaseni=" + rok_hlaseni
				+ ", druh_hlaseni=" + druh_hlaseni + ", datum_vzniku="
				+ datum_vzniku + ", id_firmy=" + id_firmy + ", id_zakaznika="
				+ id_zakaznika + ", termin=" + termin + ", pracnost="
				+ pracnost + ", text_hlaseni=" + text_hlaseni
				+ ", text_vyrizeni=" + text_vyrizeni + ", kod_uzivatele_resi="
				+ kod_uzivatele_resi + ", kod_uzivatele_vyridil="
				+ kod_uzivatele_vyridil + ", datum_vyrizeni_hlaseni="
				+ datum_vyrizeni_hlaseni + ", kodpra_i=" + kodpra_i
				+ ", datum_i=" + datum_i + ", kodpra_u=" + kodpra_u
				+ ", datum_u=" + datum_u + ", kod_uzivatele_garant="
				+ kod_uzivatele_garant + ", kod_uzivatele_vyridil_garant="
				+ kod_uzivatele_vyridil_garant
				+ ", datum_vyrizeni_hlaseni_garant="
				+ datum_vyrizeni_hlaseni_garant + ", priorita=" + priorita
				+ ", nazev=" + nazev + ", id_systemu=" + id_systemu + "]";
	}
}
