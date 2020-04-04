package Java_ShiLi;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class RunDialogDemo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					RunDialogDemo frame = new RunDialogDemo();
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
	public RunDialogDemo() {
		setTitle("\u7B2C\u4E00\u4E2A");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 278);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\\u9A6C\u5764\\Pictures\\Saved Pictures\\WuTa_2018-06-17_11-14-58_0.jpg"));
		lblNewLabel.setBounds(16, 11, 124, 91);
		contentPane.add(lblNewLabel);
		
		JTextArea txtrinternetwindows = new JTextArea();
		txtrinternetwindows.setLineWrap(true);
		txtrinternetwindows.setFont(new Font("SimSun", Font.PLAIN, 15));
		txtrinternetwindows.setTabSize(30);
		txtrinternetwindows.setText("\u8BF7\u8F93\u5165\u7A0B\u5E8F\u3001\u6587\u4EF6\u5939\u3001\u6587\u6863\u6216Internet\u8D44\u6E90\u7684\u540D\u79F0\uFF0CWindows\u5C06\u4E3A\u60A8\u6253\u5F00");
		txtrinternetwindows.setBounds(156, 48, 266, 51);
		contentPane.add(txtrinternetwindows);
		
		JLabel lblNewLabel_1 = new JLabel("\u6253\u5F00\uFF08O\uFF09\uFF1A");
		lblNewLabel_1.setBounds(22, 135, 92, 18);
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("");
		comboBox.setBounds(133, 130, 251, 24);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("\u53D6\u6D88");
		btnNewButton.setBounds(280, 188, 62, 27);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u6D4F\u89C8");
		btnNewButton_1.setBounds(361, 188, 62, 27);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u786E\u5B9A");
		btnNewButton_2.setBounds(200, 188, 62, 27);
		contentPane.add(btnNewButton_2);
	}
}
