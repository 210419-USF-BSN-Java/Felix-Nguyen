package project0;

import java.io.Serializable;

public class Shop implements Serializable{
	
	private int itemID;
	private String item = "";
	private String itemStatus = "";
	private Boolean itemOwned;
	private int itemOffer;
	
	public Shop(int id, String item, String status, Boolean owned, int offer) {
		this.itemID = id;
		this.item = item;
		this.itemStatus = status;
		this.itemOwned = owned;
		this.itemOffer = offer;
	}
	
	public Shop() {};
	
	public int getItemID() {
		return itemID;
	}
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getItemStatus() {
		return itemStatus;
	}
	public void setItemStatus(String itemStatus) {
		this.itemStatus = itemStatus;
	}
	public Boolean getItemOwned() {
		return itemOwned;
	}
	public void setItemOwned(Boolean itemOwned) {
		this.itemOwned = itemOwned;
	}
	public int getItemOffer() {
		return itemOffer;
	}
	public void setItemOffer(int itemOffer) {
		this.itemOffer = itemOffer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + itemID;
		result = prime * result + itemOffer;
		result = prime * result + ((itemOwned == null) ? 0 : itemOwned.hashCode());
		result = prime * result + ((itemStatus == null) ? 0 : itemStatus.hashCode());
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
		Shop other = (Shop) obj;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (itemID != other.itemID)
			return false;
		if (itemOffer != other.itemOffer)
			return false;
		if (itemOwned == null) {
			if (other.itemOwned != null)
				return false;
		} else if (!itemOwned.equals(other.itemOwned))
			return false;
		if (itemStatus == null) {
			if (other.itemStatus != null)
				return false;
		} else if (!itemStatus.equals(other.itemStatus))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Shop [itemID=" + itemID + ", item=" + item + ", itemStatus=" + itemStatus + ", itemOwned=" + itemOwned
				+ ", itemOffer=" + itemOffer + "]";
	}

	
	

}
