package Java_ShiLi;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class SystemPropertiesDemo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					SystemPropertiesDemo frame = new SystemPropertiesDemo();
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
	public SystemPropertiesDemo() {
		setTitle("\u5173\u4E8E\u8FDB\u9500\u5B58\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("JYT");
		lblNewLabel.setFont(new Font("SimSun", Font.BOLD, 54));
		lblNewLabel.setForeground(Color.BLUE);
		contentPane.add(lblNewLabel, BorderLayout.WEST);
		
		JTextArea txtrnmicrosoftWindowsServer = new JTextArea();
		txtrnmicrosoftWindowsServer.setBackground(UIManager.getColor("Button.background"));
		txtrnmicrosoftWindowsServer.setFont(new Font("SimSun", Font.PLAIN, 17));
		txtrnmicrosoftWindowsServer.setWrapStyleWord(true);
		txtrnmicrosoftWindowsServer.setText("\u7CFB\u7EDF\uFF1A \n Microsoft windows server 2003 \n standard edition \n service pack 2 \n\n\n\n\n \u8F6F\u4EF6\uFF1A\u8FDB\u9500\u5B58\u7BA1\u7406\u7CFB\u7EDF \n \u7248\u6743\uFF1A\u660E\u65E5\u79D1\u6280");
		contentPane.add(txtrnmicrosoftWindowsServer, BorderLayout.EAST);
	}

}
