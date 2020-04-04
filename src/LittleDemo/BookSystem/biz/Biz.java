package LittleDemo.BookSystem.biz;
/**
 * 所有业务类的接口
 * 定义了所有业务的通用操作
 * @author 马坤
 *
 */

import java.io.Serializable;
import java.util.Map;

public interface Biz<T> extends Serializable{
	
	public boolean add(T t);
	
	public boolean del(T t);
	
	public T update(T t);
	
	public T findById(String id);
	
	public Map<String, T> findAll();
	
	
}
