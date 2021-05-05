package project0;

public interface CustomerDao<T> {

		public T makeOffer();
		public T viewList();
		public T viewOwnedItems();
		public T viewOtherOffers();
	
}
