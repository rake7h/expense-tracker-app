package com.bharatonjava.expense.domain;

import java.io.Serializable;
import java.util.Date;

public class Entry implements Serializable{
	
	private static final long serialVersionUID = -4412424248861480211L;
	
	private int entryId;
	private Date entryDate;
	private String entryDetail;
	private Group group;
	private double amount;

	public Entry() {
		group = new Group();
	}

	public int getEntryId() {
		return entryId;
	}

	public void setEntryId(int entryId) {
		this.entryId = entryId;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public String getEntryDetail() {
		return entryDetail;
	}

	public void setEntryDetail(String entryDetail) {
		this.entryDetail = entryDetail;
	}

	public Group getGroup() {
		return group;
	}
	
	public void setGroup(Group group) {
		this.group = group;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Entry [entryId=" + entryId + ", entryDate=" + entryDate
				+ ", entryDetail=" + entryDetail + ", group=" + group
				+ ", amount=" + amount + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((entryDate == null) ? 0 : entryDate.hashCode());
		result = prime * result
				+ ((entryDetail == null) ? 0 : entryDetail.hashCode());
		result = prime * result + entryId;
		result = prime * result + ((group == null) ? 0 : group.hashCode());
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
		Entry other = (Entry) obj;
		if (Double.doubleToLongBits(amount) != Double
				.doubleToLongBits(other.amount))
			return false;
		if (entryDate == null) {
			if (other.entryDate != null)
				return false;
		} else if (!entryDate.equals(other.entryDate))
			return false;
		if (entryDetail == null) {
			if (other.entryDetail != null)
				return false;
		} else if (!entryDetail.equals(other.entryDetail))
			return false;
		if (entryId != other.entryId)
			return false;
		if (group == null) {
			if (other.group != null)
				return false;
		} else if (!group.equals(other.group))
			return false;
		return true;
	}

}
