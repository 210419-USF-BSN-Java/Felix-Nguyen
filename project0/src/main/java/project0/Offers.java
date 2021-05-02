package project0;

import java.io.Serializable;
import java.util.ArrayList;

public class Offers implements Serializable{

	public Offers(int offerID, int itemID, String itemName, int offer, int userID, String itemStatus) {
		this.offerID = offerID;
		this.itemID = itemID;
		this.itemName = itemName;
		this.offer = offer;
		this.userID = userID;
		this.itemStatus = itemStatus;
	}
	
	public Offers() {}
	
	private int offerID;
	private int itemID;
	private String itemName;
	private int offer;
	private int userID;
	private String itemStatus;
	
	public int getOfferID() {
		return offerID;
	}
	public void setOfferID(int offerID) {
		this.offerID = offerID;
	}
	public int getItemID() {
		return itemID;
	}
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getOffer() {
		return offer;
	}
	public void setOffer(int offer) {
		this.offer = offer;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getItemStatus() {
		return itemStatus;
	}
	public void setItemStatus(String itemStatus) {
		this.itemStatus = itemStatus;
	}
	@Override
	public String toString() {
		return "Offers [offerID=" + offerID + ", itemID=" + itemID + ", itemName=" + itemName + ", offer=" + offer
				+ ", userID=" + userID + ", itemStatus=" + itemStatus + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + itemID;
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + ((itemStatus == null) ? 0 : itemStatus.hashCode());
		result = prime * result + offer;
		result = prime * result + offerID;
		result = prime * result + userID;
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
		Offers other = (Offers) obj;
		if (itemID != other.itemID)
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (itemStatus == null) {
			if (other.itemStatus != null)
				return false;
		} else if (!itemStatus.equals(other.itemStatus))
			return false;
		if (offer != other.offer)
			return false;
		if (offerID != other.offerID)
			return false;
		if (userID != other.userID)
			return false;
		return true;
	}
	
	
	
}
