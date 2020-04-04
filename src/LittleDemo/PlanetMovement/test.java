package LittleDemo.PlanetMovement;
import java.awt.*;

/**  
* <p>Title: test.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) Mar 22, 2020</p>  
* @author ÂíÀ¤  
* @date Mar 22, 2020  
* @version 1.0  
*/

public class test extends Frame{
	
	public void paint(Graphics g) {
//		g.drawLine();
	}
	
	
	
	
	void launchFrame() {
		setSize(500, 500);
		setLocation(50, 50);
		setTitle("huaxian");
		setBackground(Color.GRAY);
		setVisible(true);
		new PaintThread().start();
	}
	
	public static void main(String[] args) {
		new test().launchFrame();
	}

	
	class PaintThread extends Thread{
		public void run() {
			while(true) {
				repaint();
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
