package LittleDemo.BookSystem.biz;
/**
 * ����ҵ����Ľӿ�
 * ����������ҵ���ͨ�ò���
 * @author ����
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
