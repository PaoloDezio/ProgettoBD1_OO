import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IscrizioneFrame extends JFrame {

	private JPanel contentPane;
	private Controller controller;
	

	/**
	 * Create the frame.
	 */
	public IscrizioneFrame(Controller c) {
		controller = c;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(375, 175, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JButton tornaHomeButton = new JButton("Indietro");
		tornaHomeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.apriHome();
				c.chiudiIscrizione();
			}
		});
		tornaHomeButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_tornaHomeButton = new GridBagConstraints();
		gbc_tornaHomeButton.insets = new Insets(0, 0, 0, 5);
		gbc_tornaHomeButton.gridx = 15;
		gbc_tornaHomeButton.gridy = 10;
		contentPane.add(tornaHomeButton, gbc_tornaHomeButton);
	}

}
