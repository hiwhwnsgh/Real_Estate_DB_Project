package Login;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NewTest extends JFrame{

	private JFrame frame;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public NewTest(String labelText) {
		initialize(labelText);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String labelText) {
		JPanel jp = new JPanel();
		frame = new JFrame();
		frame.setContentPane(jp);
		frame.setVisible(true);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jp.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(labelText);
		lblNewLabel.setBounds(146, 107, 155, 35);
		jp.add(lblNewLabel);
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 30));
		
	}
}
