package project0;

public interface ShopDao<T> {

	public T add(T t);
	public T delete(T t);
	public T update(T t);
	
}
