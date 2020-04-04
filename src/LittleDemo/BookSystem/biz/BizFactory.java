package LittleDemo.BookSystem.biz;

import LittleDemo.BookSystem.biz.BookInfoBizImplV1;

/**
 * 
 * @author ÂíÀ¤
 *
 */
public class BizFactory {
	public static Biz getBiz(String bizName) {
		switch (bizName.toLowerCase()) {
		case "bookinfobiz":
			return new BookInfoBizImplV1();
		case "userbiz":
			
		default:
			break;
		}
		return null;
	}
}
