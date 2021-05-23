package com.revature.models;

import java.io.Serializable;

public class Reimbursement implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	private double amount;
	private String submitDate;
	private String resolvedDate;
	private String desc;
	private String receipt;
	private String author;
	private int authorId;
	private String resolver;
	private String status;
	private String type;
	


	public Reimbursement(int id, double amount, String submitDate, String resolvedDate, String desc, String receipt,
			String author, int authorId, String resolver, String status, String type) {
		super();
		this.id = id;
		this.amount = amount;
		this.submitDate = submitDate;
		this.resolvedDate = resolvedDate;
		this.desc = desc;
		this.receipt = receipt;
		this.author = author;
		this.authorId = authorId;
		this.resolver = resolver;
		this.status = status;
		this.type = type;
	}
	public Reimbursement() {};


	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public double getAmount() {
		return amount;
	}



	public void setAmount(double d) {
		this.amount = d;
	}



	public String getSubmitDate() {
		return submitDate;
	}



	public void setSubmitDate(String submitDate) {
		this.submitDate = submitDate;
	}



	public String getResolvedDate() {
		return resolvedDate;
	}



	public void setResolvedDate(String resolvedDate) {
		this.resolvedDate = resolvedDate;
	}



	public String getDesc() {
		return desc;
	}



	public void setDesc(String desc) {
		this.desc = desc;
	}



	public String getReceipt() {
		return receipt;
	}



	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}



	public String getAuthor() {
		return author;
	}



	public void setAuthor(String author) {
		this.author = author;
	}



	public String getResolver() {
		return resolver;
	}



	public void setResolver(String resolver) {
		this.resolver = resolver;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}


	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + authorId;
		result = prime * result + ((desc == null) ? 0 : desc.hashCode());
		result = prime * result + id;
		result = prime * result + ((receipt == null) ? 0 : receipt.hashCode());
		result = prime * result + ((resolvedDate == null) ? 0 : resolvedDate.hashCode());
		result = prime * result + ((resolver == null) ? 0 : resolver.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((submitDate == null) ? 0 : submitDate.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Reimbursement other = (Reimbursement) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (authorId != other.authorId)
			return false;
		if (desc == null) {
			if (other.desc != null)
				return false;
		} else if (!desc.equals(other.desc))
			return false;
		if (id != other.id)
			return false;
		if (receipt == null) {
			if (other.receipt != null)
				return false;
		} else if (!receipt.equals(other.receipt))
			return false;
		if (resolvedDate == null) {
			if (other.resolvedDate != null)
				return false;
		} else if (!resolvedDate.equals(other.resolvedDate))
			return false;
		if (resolver == null) {
			if (other.resolver != null)
				return false;
		} else if (!resolver.equals(other.resolver))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (submitDate == null) {
			if (other.submitDate != null)
				return false;
		} else if (!submitDate.equals(other.submitDate))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", amount=" + amount + ", submitDate=" + submitDate + ", resolvedDate="
				+ resolvedDate + ", desc=" + desc + ", receipt=" + receipt + ", author=" + author + ", authorId="
				+ authorId + ", resolver=" + resolver + ", status=" + status + ", type=" + type + "]";
	}


	
	
	
}
