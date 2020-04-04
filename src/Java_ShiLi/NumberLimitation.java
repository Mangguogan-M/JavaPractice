/**  
* <p>Title: NumberLimitation.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.baidudu.com</p>  
* @author shenlan  
* @date Mar 30, 2019  
* @version 1.0  
*/ 
package Java_ShiLi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.acl.Group;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JRadioButton;

/**  
* <p>Title: NumberLimitation</p>  
* <p>Description: </p>  
* @author 马坤  
* @date Mar 30, 2019  
*/
public class NumberLimitation extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NumberLimitation frame = new NumberLimitation();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NumberLimitation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(14, 13, 404, 53);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("byte\u7C7B\u578B\u7684\u6700\u5927\u503C\uFF1A");
		lblNewLabel.setFont(new Font("SimSun", Font.PLAIN, 18));
		lblNewLabel.setBounds(14, 11, 188, 27);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(203, 20, 187, 18);
		panel.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(14, 79, 404, 60);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("byte\u7C7B\u578B\u7684\u6700\u5C0F\u503C\uFF1A");
		lblNewLabel_1.setFont(new Font("SimSun", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(12, 13, 188, 26);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(214, 21, 176, 18);
		panel_1.add(lblNewLabel_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(14, 152, 404, 88);
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JRadioButton rdbtnByte = new JRadioButton("byte\u7C7B\u578B");
		rdbtnByte.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setText("byte类型的最大值：");
		        lblNewLabel_1.setText("byte类型的最小值：");
		        lblNewLabel_2.setText(Byte.MAX_VALUE + "");
		        lblNewLabel_3.setText(Byte.MIN_VALUE + "");
			}
		});
		rdbtnByte.setBounds(10, 9, 91, 27);
		panel_2.add(rdbtnByte);
		
		JRadioButton rdbtnShort = new JRadioButton("short\u7C7B\u578B");
		rdbtnShort.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setText("short类型的最大值：");
		        lblNewLabel_1.setText("short类型的最小值：");
		        lblNewLabel_2.setText(Short.MAX_VALUE + "");
		        lblNewLabel_3.setText(Short.MIN_VALUE + "");
			}
		});
		rdbtnShort.setBounds(140, 9, 99, 27);
		panel_2.add(rdbtnShort);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("int\u7C7B\u578B");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setText("int类型的最大值：");
		        lblNewLabel_1.setText("int类型的最小值：");
		        lblNewLabel_2.setText(Integer.MAX_VALUE + "");
		        lblNewLabel_3.setText(Integer.MIN_VALUE + "");
			}
		});
		rdbtnNewRadioButton.setBounds(268, 9, 91, 27);
		panel_2.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnLong = new JRadioButton("long\u7C7B\u578B");
		rdbtnLong.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setText("long类型的最大值：");
		        lblNewLabel_1.setText("long类型的最小值：");
		        lblNewLabel_2.setText(Long.MAX_VALUE + "");
		        lblNewLabel_3.setText(Long.MIN_VALUE + "");
			}
		});
		rdbtnLong.setBounds(10, 52, 91, 27);
		panel_2.add(rdbtnLong);
		
		JRadioButton rdbtnFloat = new JRadioButton("float\u7C7B\u578B");
		rdbtnFloat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setText("float类型的最大值：");
		        lblNewLabel_1.setText("float类型的最小值：");
		        lblNewLabel_2.setText(Float.MAX_VALUE + "");
		        lblNewLabel_3.setText(Float.MIN_VALUE + "");
			}
		});
		rdbtnFloat.setBounds(140, 52, 105, 27);
		panel_2.add(rdbtnFloat);
		
		JRadioButton rdbtnDouble = new JRadioButton("double\u7C7B\u578B");
		rdbtnDouble.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setText("double类型的最大值：");
		        lblNewLabel_1.setText("double类型的最小值：");
		        lblNewLabel_2.setText(Double.MAX_VALUE + "");
		        lblNewLabel_3.setText(Double.MIN_VALUE + "");
			}
		});
		rdbtnDouble.setBounds(268, 52, 114, 27);
		panel_2.add(rdbtnDouble);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnByte);
		buttonGroup.add(rdbtnShort);
		buttonGroup.add(rdbtnNewRadioButton);
		buttonGroup.add(rdbtnLong);
		buttonGroup.add(rdbtnFloat);
		buttonGroup.add(rdbtnDouble);
	}
}
