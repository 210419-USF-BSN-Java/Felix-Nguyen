package project0;

import java.io.Serializable;
import java.util.ArrayList;

public class Offers implements Serializable{

	public Offers(int offerID, int itemID, String itemName, double offer, int userID, String itemStatus, String time) {
		this.offerID = offerID;
		this.itemID = itemID;
		this.itemName = itemName;
		this.offer = offer;
		this.userID = userID;
		this.itemStatus = itemStatus;
		this.time = time;
	}
	
	public Offers(int offer_id, int itemId, String itemName,int item_offer) {
		
	}
	
	
	public Offers() {}
	
	private int offerID;
	private int itemID;
	private String itemName;
	private double offer;
	private int userID;
	private String itemStatus;
	private String time;
	
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
	public double getOffer() {
		return offer;
	}
	public void setOffer(double offer) {
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
	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + itemID;
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + ((itemStatus == null) ? 0 : itemStatus.hashCode());
		long temp;
		temp = Double.doubleToLongBits(offer);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + offerID;
		result = prime * result + ((time == null) ? 0 : time.hashCode());
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
		if (Double.doubleToLongBits(offer) != Double.doubleToLongBits(other.offer))
			return false;
		if (offerID != other.offerID)
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		if (userID != other.userID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Offers [offerID=" + offerID + ", itemID=" + itemID + ", itemName=" + itemName + ", offer=" + offer
				+ ", userID=" + userID + ", itemStatus=" + itemStatus + ", time=" + time + "]";
	}

	

	
	
	
	
}
