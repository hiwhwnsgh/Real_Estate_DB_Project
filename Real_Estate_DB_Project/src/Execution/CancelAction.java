package Execution;

import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;

public class CancelAction extends WindowAdapter {
	public void windowClosing(WindowEvent e) {
		JFrame frame = (JFrame) e.getWindow();
		frame.dispose();
		System.out.println("windowClosing()");
	}
}