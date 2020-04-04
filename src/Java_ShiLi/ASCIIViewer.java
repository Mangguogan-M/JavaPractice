/**  
* <p>Title: ASCIIViewer.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.baidudu.com</p>  
* @author shenlan  
* @date Mar 30, 2019  
* @version 1.0  
*/ 
package Java_ShiLi;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;


public class ASCIIViewer extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ASCIIViewer frame = new ASCIIViewer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ASCIIViewer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 236);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(14, 13, 502, 69);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("输入字符：");
		lblNewLabel.setFont(new Font("SimSun", Font.PLAIN, 18));
		lblNewLabel.setBounds(14, 13, 100, 43);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(107, 22, 86, 24);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("转换结果：");
		label_1.setFont(new Font("SimSun", Font.PLAIN, 18));
		label_1.setBounds(204, 12, 100, 43);
		panel.add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(290, 20, 86, 24);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JButton button_1 = new JButton("转换");
		button_1.setBounds(408, 21, 71, 27);
		button_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = textField.getText();
				int i = Character.codePointAt(str, 0);
				textField_2.setText("" + i);
			}
		});
		panel.add(button_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(14, 106, 504, 69);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("输入字符：");
		label.setFont(new Font("SimSun", Font.PLAIN, 18));
		label.setBounds(11, 13, 100, 43);
		panel_1.add(label);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(103, 25, 86, 24);
		panel_1.add(textField_1);
		
		JLabel label_2 = new JLabel("转换结果：");
		label_2.setFont(new Font("SimSun", Font.PLAIN, 18));
		label_2.setBounds(201, 13, 100, 43);
		panel_1.add(label_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(293, 19, 86, 24);
		panel_1.add(textField_3);
		
		JButton button = new JButton("转换");
		button.setBounds(409, 19, 71, 27);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = textField_1.getText();
				char[] a = Character.toChars(Integer.parseInt(str));
				textField_3.setText(new String(a));
			}
		});
		panel_1.add(button);
	}
}
