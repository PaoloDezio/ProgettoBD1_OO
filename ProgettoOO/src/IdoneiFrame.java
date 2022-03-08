import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IdoneiFrame extends JFrame {

	private JPanel contentPane;
	private Controller controller;
	private JTable IdoneiTable;
	private JButton IndietroButton;
	
		
	/**
	 * Create the frame.
	 */
	public IdoneiFrame(Controller c) {
		controller = c;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 350);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[16.00][251.00,grow][][85.00][]", "[][][122.00,grow][][]"));
		
		JLabel IdoneiLabel = new JLabel("Studenti Idonei");
		IdoneiLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		contentPane.add(IdoneiLabel, "cell 1 0");
		
		IdoneiTable = new JTable();
		contentPane.add(IdoneiTable, "cell 1 2,grow");
		
		IndietroButton = new JButton("Indietro");
		IndietroButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.setVisibleIdonei(false);
			}
		});
		contentPane.add(IndietroButton, "cell 3 3");
	}

}
