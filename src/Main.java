
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;

public class Main extends JFrame {

	private Container c;
	private JTextField in1, in2, in3;
	private JButton bt1, bt2, bt3;
	private JLabel disp1, disp2, disp3;
	private Font f = new Font("Times New Roman", Font.BOLD, 12);
	private double rate = 70.00, usd = 0.00, bdt = 0.00;
	
	public Main() {
		setVisible(true);
		setBounds(100, 100, 415, 600);
		setDefaultCloseOperation(Main.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Credit Management Application Version 1.0.0 (by Arnab)");
		setResizable(false);
		initC();
	}
	
	public void initC() {

		c = getContentPane();
		c.setLayout(null);
		c.setBackground(Color.gray);

		ImageIcon ico = new ImageIcon(getClass().getResource("Main_Page.png"));
		this.setIconImage(ico.getImage());
		repaint();
		
		setHomePage();
	}
	
	public void setHomePage() {
		
		ImageIcon img = new ImageIcon(getClass().getResource("MainP.png"));
		JLabel page = new JLabel(img);
		page.setBounds(0, 0, 400, 600);
		page.setOpaque(true);
		
		disp1 = new JLabel();
		disp1.setText("Current USD : "+String.valueOf(usd));
		disp1.setBounds(20, 20, 200, 200);
		disp1.setFont(f);
		disp1.setForeground(Color.white);
		c.add(disp1);
		
		disp2 = new JLabel();
		disp2.setText("Current BDT : "+String.valueOf(bdt));
		disp2.setBounds(20, 50, 200, 200);
		disp2.setFont(f);
		disp2.setForeground(Color.white);
		c.add(disp2);
		
		disp3 = new JLabel();
		disp3.setText("Rate : "+String.valueOf(rate));
		disp3.setBounds(290, 20, 200, 200);
		disp3.setFont(f);
		disp3.setForeground(Color.red);
		c.add(disp3);
		
		in1 = new JTextField();
		in1.setText(Double.toString(rate));
		in1.setBounds(290, 140, 70, 30);
		c.add(in1);
		
		bt1 = new JButton();
		bt1.setText("Update");
		bt1.setFont(f);
		bt1.setBounds(290, 180, 70, 30);
		bt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rate = Double.parseDouble(String.valueOf(in1.getText()));
				c.removeAll();
				repaint();
				setHomePage();
			}
		});
		c.add(bt1);
		
		c.add(page);
		repaint();
	}
	public static void main(String[] args) {
		new Main();
	}

}
