package Java_ShiLi;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class ArrayReverseString extends JFrame {
    
    private JPanel contentPane;
    private JTextField inputField;
    private JTextField outputField;
    private JTextArea infoArea;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            UIManager
                    .setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ArrayReverseString frame = new ArrayReverseString();
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
    public ArrayReverseString() {
        setTitle("用数组把字符串反转");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 270);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 5));
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.NORTH);
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[] { 90, 325, 0 };
        gbl_panel.rowHeights = new int[] { 30, 30, 0 };
        gbl_panel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
        gbl_panel.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
        panel.setLayout(gbl_panel);
        
        JLabel label = new JLabel(
                "输入一个字符串：");
        GridBagConstraints gbc_label = new GridBagConstraints();
        gbc_label.ipadx = 1;
        gbc_label.anchor = GridBagConstraints.WEST;
        gbc_label.insets = new Insets(0, 0, 5, 0);
        gbc_label.gridx = 0;
        gbc_label.gridy = 0;
        panel.add(label, gbc_label);
        
        inputField = new JTextField();
        GridBagConstraints gbc_inputField = new GridBagConstraints();
        gbc_inputField.anchor = GridBagConstraints.NORTH;
        gbc_inputField.fill = GridBagConstraints.HORIZONTAL;
        gbc_inputField.insets = new Insets(0, 0, 5, 0);
        gbc_inputField.gridx = 1;
        gbc_inputField.gridy = 0;
        panel.add(inputField, gbc_inputField);
        inputField.setColumns(10);
        
        JButton button = new JButton("反转");
        GridBagConstraints gbc_button = new GridBagConstraints();
        gbc_button.anchor = GridBagConstraints.NORTH;
        gbc_button.insets = new Insets(0, 0, 0, 5);
        gbc_button.gridx = 0;
        gbc_button.gridy = 1;
        panel.add(button, gbc_button);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        
        outputField = new JTextField();
        GridBagConstraints gbc_outputField = new GridBagConstraints();
        gbc_outputField.anchor = GridBagConstraints.NORTH;
        gbc_outputField.fill = GridBagConstraints.HORIZONTAL;
        gbc_outputField.gridx = 1;
        gbc_outputField.gridy = 1;
        panel.add(outputField, gbc_outputField);
        outputField.setColumns(10);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        infoArea = new JTextArea();
        scrollPane.setViewportView(infoArea);
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
        String inputStr = inputField.getText();// 获取用户输入字符串
        char[] strArray = inputStr.toCharArray();// 提取字符数组
        infoArea.setText("");// 清空文本域控件文本
        for (int i = 0; i < strArray.length / 2; i++) {// 数组反转算法
            char temp = strArray[i];// 交换数组元素
            strArray[i] = strArray[strArray.length - i - 1];
            strArray[strArray.length - i - 1] = temp;
            infoArea.append("第" + (i + 1) + "次循环:\t");// 显示循环反转过程
            for (char c : strArray) {// 显示每次反转数组的结果
                infoArea.append(c + "");
            }
            infoArea.append("\n");// 文本域换行
        }
        String outputStr = new String(strArray);// 把字符数组转换为字符串
        outputField.setText(outputStr);// 显示反转后的字符串
    }
}
