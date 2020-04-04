package LittleDemo.PlanetMovement;


import java.awt.*;
import java.awt.event.*;

public class BallGameByHand  extends Frame {
	
	Image sun = Toolkit.getDefaultToolkit().getImage("images/sun.jpg");
	
	double x=200;
	double y=200;
	boolean left,right,up,down;
	public void paint(Graphics  g){
		g.drawImage(sun, (int)x, (int)y, null);
		if(left){
			x = x-10;
		}
		if(right){
			x = x+10;
		}
		if(up){
			y = y-10;
		}
		if(down){
			y = y+10;
		}
		
	}
	
	void launchFrame(){
		setSize(500,400);
		setLocation(80, 80);
		setBackground(Color.black);
		setTitle("xx");
		setVisible(true);
		new PaintThread().start();  
		addKeyListener(new KeyMonitor());
	}
	
	public static void main(String[] args){  //args-->argument
		System.out.println("xx");
		new BallGameByHand().launchFrame();
	}
	
	class PaintThread extends Thread {
		public void run(){
			while(true){
				repaint();
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}   //1√Î=1000∫¡√Î£°
			}
		}
	}
	
	class  KeyMonitor extends KeyAdapter {
		public void keyPressed(KeyEvent e){
			if(37==e.getKeyCode()){
				left=true;
			}
			if(39==e.getKeyCode()){
				right = true;
			}
			if(38==e.getKeyCode()){
				up = true;
			}
			if(40==e.getKeyCode()){
				down = true;
			}
		}
		
		public void keyReleased(KeyEvent e){
			if(37==e.getKeyCode()){
				left=false;
			}
			if(39==e.getKeyCode()){
				right = false;
			}
			if(38==e.getKeyCode()){
				up = false;
			}
			if(40==e.getKeyCode()){
				down = false;
			}
		}
	}
}