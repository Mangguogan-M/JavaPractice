/**  
* <p>Title: BallGame.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) Mar 22, 2020</p>  
* @author ÂíÀ¤  
* @date Mar 22, 2020  
* @version 1.0  
*/ 
package LittleDemo.PlanetMovement;

import java.awt.*;

public class BallGameAuto extends Frame{
	
	Image sun = Toolkit.getDefaultToolkit().getImage("images/sun.jpg");//µ¼ÈëÍ¼Æ¬
	double x = 100;
	double y = 100;
	double degree = 3.14/3;
	public void paint(Graphics g) {
		g.drawImage(sun, (int)x, (int)y, null);
		x = x + 10*Math.cos(degree);
		y = y + 10*Math.sin(degree);
		
		if (x > 450) {
			degree = 3.14 - degree;
		}if (x < 0) {
			degree = 3.14 - degree;
		}if (y < 50) {
			degree = -degree;
		}if (y > 250) {
			degree = -degree;
		}
	}
	
	void launchFrame() {
		setSize(500, 300);
		setLocation(50, 50);
		setTitle("zuoping");
		setBackground(Color.BLACK);
		setVisible(true);
		new PaintThread().start();
	}
	
	public static void main(String[] args) {
		new BallGameAuto().launchFrame();
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
			}}
	
}
