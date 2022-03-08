import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
		gbl_contentPane.columnWidths = new int[]{0, 260, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{14, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel statisticheLabel = new JLabel("Statistiche\r\n");
		statisticheLabel.setFont(new Font("Century", Font.BOLD, 25));
		GridBagConstraints gbc_statisticheLabel = new GridBagConstraints();
		gbc_statisticheLabel.anchor = GridBagConstraints.WEST;
		gbc_statisticheLabel.insets = new Insets(0, 0, 5, 5);
		gbc_statisticheLabel.gridx = 1;
		gbc_statisticheLabel.gridy = 0;
		contentPane.add(statisticheLabel, gbc_statisticheLabel);
		
		JLabel nomeCorsoLabel = new JLabel("Corso :");
		nomeCorsoLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
		GridBagConstraints gbc_nomeCorsoLabel = new GridBagConstraints();
		gbc_nomeCorsoLabel.anchor = GridBagConstraints.WEST;
		gbc_nomeCorsoLabel.fill = GridBagConstraints.VERTICAL;
		gbc_nomeCorsoLabel.insets = new Insets(0, 0, 5, 5);
		gbc_nomeCorsoLabel.gridx = 1;
		gbc_nomeCorsoLabel.gridy = 2;
		contentPane.add(nomeCorsoLabel, gbc_nomeCorsoLabel);
		
		JLabel numMinStudentiLabel = new JLabel("Minor numero di studenti:");
		numMinStudentiLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
		GridBagConstraints gbc_numMinStudentiLabel = new GridBagConstraints();
		gbc_numMinStudentiLabel.anchor = GridBagConstraints.WEST;
		gbc_numMinStudentiLabel.insets = new Insets(0, 0, 5, 5);
		gbc_numMinStudentiLabel.gridx = 1;
		gbc_numMinStudentiLabel.gridy = 3;
		contentPane.add(numMinStudentiLabel, gbc_numMinStudentiLabel);
		
		JLabel numMaxStudentiLabel = new JLabel("Massimo numero di studenti :");
		numMaxStudentiLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
		GridBagConstraints gbc_numMaxStudentiLabel = new GridBagConstraints();
		gbc_numMaxStudentiLabel.insets = new Insets(0, 0, 5, 5);
		gbc_numMaxStudentiLabel.anchor = GridBagConstraints.WEST;
		gbc_numMaxStudentiLabel.gridx = 1;
		gbc_numMaxStudentiLabel.gridy = 4;
		contentPane.add(numMaxStudentiLabel, gbc_numMaxStudentiLabel);
		
		JLabel numMedioStudentiLabel = new JLabel("Media degli studenti a lezione :");
		numMedioStudentiLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
		GridBagConstraints gbc_numMedioStudentiLabel = new GridBagConstraints();
		gbc_numMedioStudentiLabel.insets = new Insets(0, 0, 5, 5);
		gbc_numMedioStudentiLabel.anchor = GridBagConstraints.WEST;
		gbc_numMedioStudentiLabel.gridx = 1;
		gbc_numMedioStudentiLabel.gridy = 5;
		contentPane.add(numMedioStudentiLabel, gbc_numMedioStudentiLabel);
		
		JLabel numMedioStudentiPercentualeLabel = new JLabel("Media degli studenti in percentuale :");
		numMedioStudentiPercentualeLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
		GridBagConstraints gbc_numMedioStudentiPercentualeLabel = new GridBagConstraints();
		gbc_numMedioStudentiPercentualeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_numMedioStudentiPercentualeLabel.anchor = GridBagConstraints.WEST;
		gbc_numMedioStudentiPercentualeLabel.gridx = 1;
		gbc_numMedioStudentiPercentualeLabel.gridy = 6;
		contentPane.add(numMedioStudentiPercentualeLabel, gbc_numMedioStudentiPercentualeLabel);
		
		JButton idoneiButton = new JButton("Idonei");
		idoneiButton.setFont(new Font("Dialog", Font.PLAIN, 16));
		GridBagConstraints gbc_idoneiButton = new GridBagConstraints();
		gbc_idoneiButton.insets = new Insets(0, 0, 0, 5);
		gbc_idoneiButton.gridx = 1;
		gbc_idoneiButton.gridy = 8;
		contentPane.add(idoneiButton, gbc_idoneiButton);
		
		JButton tornaAllaRicercaCorsoButton = new JButton("Torna alla Ricerca Corso");
		tornaAllaRicercaCorsoButton.setFont(new Font("Dialog", Font.PLAIN, 16));
		GridBagConstraints gbc_tornaAllaRicercaCorsoButton = new GridBagConstraints();
		gbc_tornaAllaRicercaCorsoButton.insets = new Insets(0, 0, 0, 5);
		gbc_tornaAllaRicercaCorsoButton.gridx = 2;
		gbc_tornaAllaRicercaCorsoButton.gridy = 8;
		contentPane.add(tornaAllaRicercaCorsoButton, gbc_tornaAllaRicercaCorsoButton);
	}

}
