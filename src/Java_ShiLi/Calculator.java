package Java_ShiLi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class Calculator extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Calculator frame = new Calculator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Calculator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 443, 315);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(14, 13, 404, 24);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("sqrt");
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setBounds(341, 105, 65, 27);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("%");
		btnNewButton_1.setForeground(Color.BLUE);
		btnNewButton_1.setBounds(341, 145, 65, 27);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("1/x");
		btnNewButton_2.setForeground(Color.BLUE);
		btnNewButton_2.setBounds(341, 185, 65, 27);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("=");
		btnNewButton_3.setForeground(Color.RED);
		btnNewButton_3.setBounds(341, 225, 65, 27);
		contentPane.add(btnNewButton_3);

		JButton button = new JButton("/");
		button.setForeground(Color.BLUE);
		button.setBounds(286, 105, 41, 27);
		contentPane.add(button);

		JButton button_1 = new JButton("*");
		button_1.setForeground(Color.BLUE);
		button_1.setBounds(286, 145, 41, 27);
		contentPane.add(button_1);

		JButton button_2 = new JButton("-");
		button_2.setForeground(Color.BLUE);
		button_2.setBounds(286, 185, 41, 27);
		contentPane.add(button_2);

		JButton button_3 = new JButton("+");
		button_3.setForeground(Color.RED);
		button_3.setBounds(286, 225, 41, 27);
		contentPane.add(button_3);

		JButton button_4 = new JButton("9");
		button_4.setForeground(Color.BLUE);
		button_4.setBounds(223, 105, 41, 27);
		contentPane.add(button_4);

		JButton button_5 = new JButton("6");
		button_5.setForeground(Color.BLUE);
		button_5.setBounds(223, 145, 41, 27);
		contentPane.add(button_5);

		JButton button_6 = new JButton("3");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_6.setForeground(Color.BLUE);
		button_6.setBounds(223, 185, 41, 27);
		contentPane.add(button_6);

		JButton button_7 = new JButton(".");
		button_7.setForeground(Color.BLUE);
		button_7.setBounds(223, 225, 41, 27);
		contentPane.add(button_7);

		JButton button_8 = new JButton("8");
		button_8.setForeground(Color.BLUE);
		button_8.setBounds(159, 105, 41, 27);
		contentPane.add(button_8);

		JButton button_9 = new JButton("5");
		button_9.setForeground(Color.BLUE);
		button_9.setBounds(159, 145, 41, 27);
		contentPane.add(button_9);

		JButton button_10 = new JButton("2");
		button_10.setForeground(Color.BLUE);
		button_10.setBounds(159, 185, 41, 27);
		contentPane.add(button_10);

		JButton button_11 = new JButton("+/-");
		button_11.setForeground(Color.BLUE);
		button_11.setBounds(159, 225, 41, 27);
		contentPane.add(button_11);

		JButton button_12 = new JButton("7");
		button_12.setForeground(Color.BLUE);
		button_12.setBounds(93, 105, 41, 27);
		contentPane.add(button_12);

		JButton button_13 = new JButton("4");
		button_13.setForeground(Color.BLUE);
		button_13.setBounds(93, 145, 41, 27);
		contentPane.add(button_13);

		JButton button_14 = new JButton("1");
		button_14.setForeground(Color.BLUE);
		button_14.setBounds(93, 185, 41, 27);
		contentPane.add(button_14);

		JButton button_15 = new JButton("0");
		button_15.setForeground(Color.BLUE);
		button_15.setBounds(93, 225, 41, 27);
		contentPane.add(button_15);

		JButton btnMc = new JButton("MC");
		btnMc.setForeground(Color.BLUE);
		btnMc.setBounds(14, 105, 65, 27);
		contentPane.add(btnMc);

		JButton btnMr = new JButton("MR");
		btnMr.setForeground(Color.BLUE);
		btnMr.setBounds(14, 145, 65, 27);
		contentPane.add(btnMr);

		JButton btnMs = new JButton("MS");
		btnMs.setForeground(Color.BLUE);
		btnMs.setBounds(14, 185, 65, 27);
		contentPane.add(btnMs);

		JButton btnM = new JButton("M+");
		btnM.setForeground(Color.BLUE);
		btnM.setBounds(14, 225, 65, 27);
		contentPane.add(btnM);

		JButton btnNewButton_4 = new JButton("C");
		btnNewButton_4.setForeground(Color.ORANGE);
		btnNewButton_4.setBounds(348, 65, 58, 27);
		contentPane.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("CE");
		btnNewButton_5.setForeground(Color.ORANGE);
		btnNewButton_5.setBounds(269, 65, 58, 27);
		contentPane.add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("Backspace");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_6.setForeground(Color.ORANGE);
		btnNewButton_6.setBounds(139, 65, 105, 27);
		contentPane.add(btnNewButton_6);
	}
}
