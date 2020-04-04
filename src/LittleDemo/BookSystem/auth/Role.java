package LittleDemo.BookSystem.auth;
/**
 * 角色类
 * @author 马坤
 *
 */

import java.io.Serializable;
import java.util.List;

import LittleDemo.BookSystem.biz.BizFactory;
import LittleDemo.BookSystem.biz.BookInfoBiz;

public class Role implements Serializable{
	private String name;
	private String key;
	private List<String> permisstions;
	private BookInfoBiz bookInfoBiz;
	
	public Role() {
		setName("默认角色");
		setKey("default");
		bookInfoBiz = (BookInfoBiz)BizFactory.getBiz("BookInfoBiz");
		
	}
	
	public Role(String name, String key) {
		setName(name);
		setKey(key);
		
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public List<String> getPermisstions() {
		return permisstions;
	}
	public void setPermisstions(List<String> permisstions) {
		this.permisstions = permisstions;
	}
	public BookInfoBiz getBookInfoBiz() {
		return bookInfoBiz;
	}
	public void setBookInfoBiz(BookInfoBiz bookInfoBiz) {
		this.bookInfoBiz = bookInfoBiz;
	}
	
}
