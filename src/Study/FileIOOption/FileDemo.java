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
		//System.out.println("�ļ��Ƿ����:" + file.exists());
		System.out.println("�ǲ���һ���ļ���" + file.isFile());
		System.out.println("�ǲ���һ���ļ��У�" + file.isDirectory());
		System.out.println("·����" + file.getPath());
		System.out.println("����·����" + file.getAbsolutePath());
		System.out.println("��ռ�ռ䣺" + file.length());
		System.out.println("�Ƿ����أ�" + file.isHidden());
		System.out.println("�Ƿ�ɶ���" + file.canRead());
		System.out.println("�Ƿ��д��" + file.canWrite());
		
		//����/ɾ���ļ�/�ļ���
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
