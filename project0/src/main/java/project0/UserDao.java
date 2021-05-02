package project0;

public interface UserDao<T> {
	
	public T add(T t);
	public User delete(T t);
	public Integer update(T t);

}
