package project0;

import java.util.List;

public interface CustomerDao<T> {

		public T add(T t);
		public Integer update(T t);
		public Integer delete(T t);
	
}
