package project0;

import java.util.List;

public interface CustomerDao<T> {

		public T makeOffer();
		public T viewList();
		public T viewOwnedItems();
		public T viewOtherOffers();
	
}
