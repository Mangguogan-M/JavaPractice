package Study.FileIOOption;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;

import javax.swing.JFileChooser;

public class FileDemo {
	
	public static void main(String[] args) {
		JFileChooser fileChooser = new JFileChooser(new File("."));
		fileChooser.showOpenDialog(null);
		File file = fileChooser.getSelectedFile();
		//System.out.println("文件是否存在:" + file.exists());
		System.out.println("是不是一个文件：" + file.isFile());
		System.out.println("是不是一个文件夹：" + file.isDirectory());
		System.out.println("路径：" + file.getPath());
		System.out.println("绝对路径：" + file.getAbsolutePath());
		System.out.println("所占空间：" + file.length());
		System.out.println("是否隐藏：" + file.isHidden());
		System.out.println("是否可读：" + file.canRead());
		System.out.println("是否可写：" + file.canWrite());
		
		//创建/删除文件/文件夹
//		if (!file.exists()) {
//			try {
//				file.createNewFile();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}else {
//			file.mkdir();
//		}
		
//		if (file.exists()) {
//			file.delete();
//		}
		
		String[] fileNames = file.list(new DirFilter());
		for (int i = 0; i < fileNames.length; i++) {
			System.out.println(fileNames[i]);
		}
		
	}
	
	static class DirFilter implements FilenameFilter{
		@Override
		public boolean accept(File dir, String name) {
			if (name.endsWith("git")) {
				return true;
			}
			return false;
		}
		
	}

}
