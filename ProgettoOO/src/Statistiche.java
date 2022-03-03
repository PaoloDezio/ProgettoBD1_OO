import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Insets;
import javax.swing.JTextField;

public class Statistiche extends JFrame {

	private JPanel contentPane;

	
	public Statistiche() {
		setTitle("Statistiche");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 420);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 424, 0};
		gbl_contentPane.rowHeights = new int[]{14, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel statisticheLabel = new JLabel("Statistiche\r\n");
		statisticheLabel.setFont(new Font("Century", Font.BOLD, 25));
		GridBagConstraints gbc_statisticheLabel = new GridBagConstraints();
		gbc_statisticheLabel.anchor = GridBagConstraints.WEST;
		gbc_statisticheLabel.insets = new Insets(0, 0, 5, 0);
		gbc_statisticheLabel.gridx = 2;
		gbc_statisticheLabel.gridy = 0;
		contentPane.add(statisticheLabel, gbc_statisticheLabel);
	}

}
