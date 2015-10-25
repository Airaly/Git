package com.briup.event;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MultiListener extends JFrame{
	JTextField field = new JTextField();
	JLabel label = new JLabel("空标签");
	public MultiListener(String title) {
		super(title);
		init();
	}
	public void init(){
		field.setFont(new Font("Gabriola", Font.BOLD, 40));
		add(field,BorderLayout.NORTH);
		label.setFont(new Font("楷体",Font.BOLD,60));
		label.setForeground(Color.red);
		add(label,BorderLayout.CENTER);
		setBounds(200, 100, 600, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		label.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
			}
			public void mousePressed(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
				label.setText("鼠标移出");
				label.setForeground(Color.yellow);
			}
			public void mouseEntered(MouseEvent e) {
				label.setText("鼠标移入");
				label.setForeground(Color.green);
			}
			public void mouseClicked(MouseEvent e) {
				System.out.println(e.getButton());
				if(e.getButton()==1){
					label.setText("左击："+e.getClickCount()+"次");
				}else if(e.getButton()==3){
					label.setText("右击："+e.getClickCount()+"次");
				}
			}
		});
		label.addMouseMotionListener(new MouseMotionListener() {
			public void mouseMoved(MouseEvent e) {
//				System.out.println(e.getSource());
//				field.setText("Moved:X="+e.getX()+",Y="+e.getY());
				field.setText("Moved:X="+e.getXOnScreen()+",Y="+e.getYOnScreen());
			}
			public void mouseDragged(MouseEvent e) {
			}
		});
	}
	public static void main(String[] args) {
		new MultiListener("多事件监听");
	}
}
