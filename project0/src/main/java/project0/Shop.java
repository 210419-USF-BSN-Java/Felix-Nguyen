package project0;

public class Shop {
	
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

	
	

}
