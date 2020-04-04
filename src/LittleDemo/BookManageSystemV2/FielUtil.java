package LittleDemo.BookManageSystemV2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.text.AbstractDocument.Content;

public class FielUtil {
	
	private static final String BookFile ="src/LittleDemo/BookManageSystemV2/BookInfo";
	private static final String SepAttr = ",";		//属性分隔符
	private static final String SepLine = System.getProperty("line.separater");	//行分隔符
	
	public static void SaveBooks(Book ...bookArray) {
		
		
		if (bookArray == null && bookArray.length == 0) {
			return;
		}
		BookBiz bookBiz = new BookBiz();
		File bookFile = new File(BookFile);
		if (!bookFile.exists()) {
			try {
				bookFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try(FileWriter fout = new FileWriter(bookFile);
			BufferedWriter out = new BufferedWriter(fout);
			){
				StringBuffer content = new StringBuffer();
				int bookCount = bookBiz.getBookCount(bookArray);
				for (int i = 0; i < bookCount; i++) {
					content.append(bookArray[i].getBookId());
					content.append(SepAttr);
					content.append(bookArray[i].getBookName());
					content.append(SepAttr);
					content.append(bookArray[i].getCount());
					content.append(SepLine);
				}
				//将字符写入到文件中去
				out.write(content.toString());
			}catch(FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static Book[] loadBooks() {
		File bookFile = new File(BookFile);
		if (!bookFile.exists()) {
			return null;
		}
		Book[] bookArray = new Book[999];
		try(FileReader fReader = new FileReader(bookFile);
				BufferedReader reader = new BufferedReader(fReader);
			){
				String line = null;
				int count = 0;
				while((line = reader.readLine()) != null) {
					Book currBook = new Book();
					String[] attrs = line.split(SepAttr);
					currBook.setBookId(attrs[0].trim());
					currBook.setBookName(attrs[1].trim());
					currBook.setCount(Integer.parseInt(attrs[2].trim()));
					bookArray[count++] = currBook;
					
				}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bookArray;
	}
	
}
