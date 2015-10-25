package com.briup.gui;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class SecondGUI {
	public static void main(String[] args) {
		//1.选择容器
		JFrame frame = new JFrame("SecondGUI");
//		2.选择布局管理器
		System.out.println(frame.getLayout());
//		3.添加组件
		JButton btn = new JButton("btn 2");
		ImageIcon icon = new ImageIcon("1.jpg");
		Image temp = icon.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
		btn.setIcon(new ImageIcon(temp));
		frame.add(btn);
//		4.添加事件处理
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("btn click...");
			}
		});
		frame.setBounds(200, 100, 300, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}






