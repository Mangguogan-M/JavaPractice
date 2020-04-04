package LittleDemo.BookSystem.biz;

import java.util.Map;

import LittleDemo.BookSystem.entity.BookInfo;
import LittleDemo.BookSystem.util.FileUtil;

public class BookInfoBizImplV1 implements BookInfoBiz{
	private static final long serialVersionUID = 8683329796944769870L;
	
	@Override
	public boolean add(BookInfo bookInfo) {
		if(null == bookInfo) return false;
		Map<String, BookInfo> bookInfoMap = findAll();
		if(null == bookInfoMap) return false;
		if (bookInfoMap.containsKey(bookInfo.getIsbn())) {
			return false;
		}
		bookInfoMap.put(bookInfo.getIsbn(), bookInfo);
		FileUtil.SaveBookInfoMap(bookInfoMap);
		return true;
	}

	@Override
	public boolean del(BookInfo bookInfo) {
		if(null == bookInfo) return false;
		Map<String, BookInfo> bookInfoMap = findAll();
		if(null == bookInfoMap) return false;
		if (!bookInfoMap.containsKey(bookInfo.getIsbn())) {
			return false;
		}
		bookInfoMap.remove(bookInfo.getIsbn());
		FileUtil.SaveBookInfoMap(bookInfoMap);
		return true;
	}

	@Override
	public BookInfo update(BookInfo bookInfo) {
		if(null == bookInfo) return null;
		Map<String, BookInfo> bookInfoMap = findAll();
		if(null == bookInfoMap) return null;
		if (!bookInfoMap.containsKey(bookInfo.getIsbn())) {
			return null;
		}
		bookInfoMap.put(bookInfo.getIsbn(), bookInfo);
		FileUtil.SaveBookInfoMap(bookInfoMap);
		return bookInfo;
	}

	@Override
	public BookInfo findById(String id) {
		throw new UnsupportedOperationException("不支持此查询操作");
	}

	@Override
	public Map<String, BookInfo> findAll() {
		return FileUtil.ReadBookInfoMap();
	}

	@Override
	public boolean outStore(String isbn, int outCount) {
		BookInfo bookInfo = findByIsbn(isbn);
		if(null == bookInfo) return false;
		Map<String, BookInfo> bookInfoMap = findAll();
		if(null == bookInfoMap) return false;
		
		
		if(outCount > bookInfo.getInStoreCount()) {
			return false;
		}
		bookInfo.setInStoreCount(bookInfo.getInStoreCount() - outCount);
		bookInfoMap.put(isbn, bookInfo);
		FileUtil.SaveBookInfoMap(bookInfoMap);
		return true;
	}

	@Override
	public boolean inStore(String isbn, int inCount) {
		Map<String, BookInfo> bookInfoMap = findAll();
		if(null == bookInfoMap) return false;
		if(!bookInfoMap.containsKey(isbn)) return false;
		BookInfo bookInfo = bookInfoMap.get(isbn);
		bookInfo.setInStoreCount(bookInfo.getInStoreCount() + inCount);
		bookInfoMap.put(isbn, bookInfo);
		FileUtil.SaveBookInfoMap(bookInfoMap);
		return false;
	}

	@Override
	public BookInfo findByIsbn(String isbn) {
		if(null == isbn || "".equals(isbn)) return null;
		Map<String, BookInfo> bookInfoMap = findAll();
		if(null == bookInfoMap) return null;
		if(!bookInfoMap.containsKey(isbn)) return null;
		return bookInfoMap.get(isbn);
	}

}
