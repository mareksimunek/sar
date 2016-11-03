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
	@Column(name="id_komunikace", nullable = false)
	private long id;					// not null, pk
	@Column(name="id_hlaseni", nullable = false)
	private long reportId;				// not null, fk
	@Column(name="id_zakaznika")
	private String customerId;
	@Column(name="poradove_cislo", nullable = false)
	private long orderNumber;			// not null
	@Column(name="obsah_komunikace")
	private String content;
	@Column(name="datum_vlozeni", nullable = false)
	private Date insertionDate;			// not null
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getReportId() {
		return reportId;
	}
	public void setReportId(long reportId) {
		this.reportId = reportId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public long getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(long orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getInsertionDate() {
		return insertionDate;
	}
	public void setInsertionDate(Date insertionDate) {
		this.insertionDate = insertionDate;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result
				+ ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result
				+ ((insertionDate == null) ? 0 : insertionDate.hashCode());
		result = prime * result + (int) (orderNumber ^ (orderNumber >>> 32));
		result = prime * result + (int) (reportId ^ (reportId >>> 32));
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
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (id != other.id)
			return false;
		if (insertionDate == null) {
			if (other.insertionDate != null)
				return false;
		} else if (!insertionDate.equals(other.insertionDate))
			return false;
		if (orderNumber != other.orderNumber)
			return false;
		if (reportId != other.reportId)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Communication [id=" + id + ", reportId=" + reportId
				+ ", customerId=" + customerId + ", orderNumber=" + orderNumber
				+ ", content=" + content + ", insertionDate=" + insertionDate
				+ "]";
	}
}
