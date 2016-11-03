package cz.fav.sar.server.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import cz.fav.sar.server.utils.IdGenerator;

@Entity
@Table(name="ccag_hlaseni")
public class Report {
	@Id
	@Column(name="id_hlaseni", nullable = false)
	long id;					// not null, pkey
	@Column(name="cislo_hlaseni", nullable = false)
	long reportNumber;			// not null
	@Column(name="rok_hlaseni", nullable = false)
	long reportYear;			// not null
	@Column(name="druh_hlaseni", nullable = false)
	String reportType;			// not null
	@Column(name="datum_vzniku", nullable = false)
	Date dateOfCreation;		// not null
	@Column(name="id_firmy", nullable = false)
	long companyId;				// not null, fk
	@Column(name="id_zakaznika", nullable = false)
	long customerId;			// not null, fk
	@Column(name="termin")
	Date dueDate;
	@Column(name="pracnost")
	long difficulty;
	@Column(name="text_hlaseni", nullable = false)
	String reportText;			// not null
	@Column(name="text_vyrizeni")
	String solutionText;
	@Column(name="kod_uzivatele_resi")
	String solvingUserCode;
	@Column(name="kod_uzivatele_vyridil")
	String solvedUserCode;
	@Column(name="datum_vyrizeni_hlaseni")
	Date solutionDate;
	@Column(name="kodpra_i", nullable = false)
	String creatorUserCode;		// not null
	@Column(name="datum_i", nullable = false)
	Date lastChangeDate;		// not null
	@Column(name="kodpra_u")
	String lastChangeUserCode;
	@Column(name="datum_u")
	Date lastUpdateDate;
	@Column(name="kod_uzivatele_garant")
	String garantUserCode;
	@Column(name="kod_uzivatele_vyridil_garant")
	String garantSolvedUserCode;
	@Column(name="datum_vyrizeni_hlaseni_garant")
	Date solutionDateGarant;
	@Column(name="priorita")
	long priority;
	@Column(name="nazev")
	String name;
	@Column(name="id_systemu")
	long systemId;				// fk
	
	public Report()
	{
		this.id = IdGenerator.generateId("GEN_CISLO_HLASENI");
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getReportNumber() {
		return reportNumber;
	}
	public void setReportNumber(long reportNumber) {
		this.reportNumber = reportNumber;
	}
	public long getReportYear() {
		return reportYear;
	}
	public void setReportYear(long reportYear) {
		this.reportYear = reportYear;
	}
	public String getReportType() {
		return reportType;
	}
	public void setReportType(String reportType) {
		this.reportType = reportType;
	}
	public Date getDateOfCreation() {
		return dateOfCreation;
	}
	public void setDateOfCreation(Date dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}
	public long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public long getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(long difficulty) {
		this.difficulty = difficulty;
	}
	public String getReportText() {
		return reportText;
	}
	public void setReportText(String reportText) {
		this.reportText = reportText;
	}
	public String getSolutionText() {
		return solutionText;
	}
	public void setSolutionText(String solutionText) {
		this.solutionText = solutionText;
	}
	public String getSolvingUserCode() {
		return solvingUserCode;
	}
	public void setSolvingUserCode(String solvingUserCode) {
		this.solvingUserCode = solvingUserCode;
	}
	public String getSolvedUserCode() {
		return solvedUserCode;
	}
	public void setSolvedUserCode(String solvedUserCode) {
		this.solvedUserCode = solvedUserCode;
	}
	public Date getSolutionDate() {
		return solutionDate;
	}
	public void setSolutionDate(Date solutionDate) {
		this.solutionDate = solutionDate;
	}
	public String getCreatorUserCode() {
		return creatorUserCode;
	}
	public void setCreatorUserCode(String creatorUserCode) {
		this.creatorUserCode = creatorUserCode;
	}
	public Date getLastChangeDate() {
		return lastChangeDate;
	}
	public void setLastChangeDate(Date lastChangeDate) {
		this.lastChangeDate = lastChangeDate;
	}
	public String getLastChangeUserCode() {
		return lastChangeUserCode;
	}
	public void setLastChangeUserCode(String lastChangeUserCode) {
		this.lastChangeUserCode = lastChangeUserCode;
	}
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}
	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	public String getGarantUserCode() {
		return garantUserCode;
	}
	public void setGarantUserCode(String garantUserCode) {
		this.garantUserCode = garantUserCode;
	}
	public String getGarantSolvedUserCode() {
		return garantSolvedUserCode;
	}
	public void setGarantSolvedUserCode(String garantSolvedUserCode) {
		this.garantSolvedUserCode = garantSolvedUserCode;
	}
	public Date getSolutionDateGarant() {
		return solutionDateGarant;
	}
	public void setSolutionDateGarant(Date solutionDateGarant) {
		this.solutionDateGarant = solutionDateGarant;
	}
	public long getPriority() {
		return priority;
	}
	public void setPriority(long priority) {
		this.priority = priority;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getSystemId() {
		return systemId;
	}
	public void setSystemId(long systemId) {
		this.systemId = systemId;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (companyId ^ (companyId >>> 32));
		result = prime * result
				+ ((creatorUserCode == null) ? 0 : creatorUserCode.hashCode());
		result = prime * result + (int) (customerId ^ (customerId >>> 32));
		result = prime * result
				+ ((dateOfCreation == null) ? 0 : dateOfCreation.hashCode());
		result = prime * result + (int) (difficulty ^ (difficulty >>> 32));
		result = prime * result + ((dueDate == null) ? 0 : dueDate.hashCode());
		result = prime
				* result
				+ ((garantSolvedUserCode == null) ? 0 : garantSolvedUserCode
						.hashCode());
		result = prime * result
				+ ((garantUserCode == null) ? 0 : garantUserCode.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result
				+ ((lastChangeDate == null) ? 0 : lastChangeDate.hashCode());
		result = prime
				* result
				+ ((lastChangeUserCode == null) ? 0 : lastChangeUserCode
						.hashCode());
		result = prime * result
				+ ((lastUpdateDate == null) ? 0 : lastUpdateDate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (int) (priority ^ (priority >>> 32));
		result = prime * result + (int) (reportNumber ^ (reportNumber >>> 32));
		result = prime * result
				+ ((reportText == null) ? 0 : reportText.hashCode());
		result = prime * result
				+ ((reportType == null) ? 0 : reportType.hashCode());
		result = prime * result + (int) (reportYear ^ (reportYear >>> 32));
		result = prime * result
				+ ((solutionDate == null) ? 0 : solutionDate.hashCode());
		result = prime
				* result
				+ ((solutionDateGarant == null) ? 0 : solutionDateGarant
						.hashCode());
		result = prime * result
				+ ((solutionText == null) ? 0 : solutionText.hashCode());
		result = prime * result
				+ ((solvedUserCode == null) ? 0 : solvedUserCode.hashCode());
		result = prime * result
				+ ((solvingUserCode == null) ? 0 : solvingUserCode.hashCode());
		result = prime * result + (int) (systemId ^ (systemId >>> 32));
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
		if (companyId != other.companyId)
			return false;
		if (creatorUserCode == null) {
			if (other.creatorUserCode != null)
				return false;
		} else if (!creatorUserCode.equals(other.creatorUserCode))
			return false;
		if (customerId != other.customerId)
			return false;
		if (dateOfCreation == null) {
			if (other.dateOfCreation != null)
				return false;
		} else if (!dateOfCreation.equals(other.dateOfCreation))
			return false;
		if (difficulty != other.difficulty)
			return false;
		if (dueDate == null) {
			if (other.dueDate != null)
				return false;
		} else if (!dueDate.equals(other.dueDate))
			return false;
		if (garantSolvedUserCode == null) {
			if (other.garantSolvedUserCode != null)
				return false;
		} else if (!garantSolvedUserCode.equals(other.garantSolvedUserCode))
			return false;
		if (garantUserCode == null) {
			if (other.garantUserCode != null)
				return false;
		} else if (!garantUserCode.equals(other.garantUserCode))
			return false;
		if (id != other.id)
			return false;
		if (lastChangeDate == null) {
			if (other.lastChangeDate != null)
				return false;
		} else if (!lastChangeDate.equals(other.lastChangeDate))
			return false;
		if (lastChangeUserCode == null) {
			if (other.lastChangeUserCode != null)
				return false;
		} else if (!lastChangeUserCode.equals(other.lastChangeUserCode))
			return false;
		if (lastUpdateDate == null) {
			if (other.lastUpdateDate != null)
				return false;
		} else if (!lastUpdateDate.equals(other.lastUpdateDate))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (priority != other.priority)
			return false;
		if (reportNumber != other.reportNumber)
			return false;
		if (reportText == null) {
			if (other.reportText != null)
				return false;
		} else if (!reportText.equals(other.reportText))
			return false;
		if (reportType == null) {
			if (other.reportType != null)
				return false;
		} else if (!reportType.equals(other.reportType))
			return false;
		if (reportYear != other.reportYear)
			return false;
		if (solutionDate == null) {
			if (other.solutionDate != null)
				return false;
		} else if (!solutionDate.equals(other.solutionDate))
			return false;
		if (solutionDateGarant == null) {
			if (other.solutionDateGarant != null)
				return false;
		} else if (!solutionDateGarant.equals(other.solutionDateGarant))
			return false;
		if (solutionText == null) {
			if (other.solutionText != null)
				return false;
		} else if (!solutionText.equals(other.solutionText))
			return false;
		if (solvedUserCode == null) {
			if (other.solvedUserCode != null)
				return false;
		} else if (!solvedUserCode.equals(other.solvedUserCode))
			return false;
		if (solvingUserCode == null) {
			if (other.solvingUserCode != null)
				return false;
		} else if (!solvingUserCode.equals(other.solvingUserCode))
			return false;
		if (systemId != other.systemId)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Report [id=" + id + ", reportNumber=" + reportNumber
				+ ", reportYear=" + reportYear + ", reportType=" + reportType
				+ ", dateOfCreation=" + dateOfCreation + ", companyId="
				+ companyId + ", customerId=" + customerId + ", dueDate="
				+ dueDate + ", difficulty=" + difficulty + ", reportText="
				+ reportText + ", solutionText=" + solutionText
				+ ", solvingUserCode=" + solvingUserCode + ", solvedUserCode="
				+ solvedUserCode + ", solutionDate=" + solutionDate
				+ ", creatorUserCode=" + creatorUserCode + ", lastChangeDate="
				+ lastChangeDate + ", lastChangeUserCode=" + lastChangeUserCode
				+ ", lastUpdateDate=" + lastUpdateDate + ", garantUserCode="
				+ garantUserCode + ", garantSolvedUserCode="
				+ garantSolvedUserCode + ", solutionDateGarant="
				+ solutionDateGarant + ", priority=" + priority + ", name="
				+ name + ", systemId=" + systemId + "]";
	}
}
