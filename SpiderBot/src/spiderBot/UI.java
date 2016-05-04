package spiderBot;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Label;
import java.awt.Panel;

import javax.swing.*;



@SuppressWarnings("serial")
public class UI extends JFrame{

	//TODO Design UI with options for Link depth, threads to use, Origin URL,...
	public static void start() {
		GuiSpider();
	}
	
	public static void GuiSpider()
	{
		JFrame guiFrame = new JFrame();
		
		// Frame options
		guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		guiFrame.setResizable(false);
		guiFrame.setTitle("SpiderBot");
		guiFrame.setSize(600, 500);
		guiFrame.setLocationRelativeTo(null);
		guiFrame.setVisible(true);
		
		Panel main = new Panel(); //Main panel
		Panel start = new Panel(); //Panel including start button
		
		//Labels, Buttons, and Text Field
		Button startBttn = new Button("Start");
		Label thrdLbl = new Label("Number of threads to use:");
		start.add(startBttn);
		main.add(thrdLbl);
		
		main.setVisible(true);
		start.setVisible(true);
		
		guiFrame.add(main);
		guiFrame.add(start, BorderLayout.SOUTH);
	}
}
