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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StatisticheFrame extends JFrame {
	private JPanel contentPane;
	private Controller controller;
	private JTextField CorsoTF;
	private JTextField MinStudentiTF;
	private JTextField MediaPercentualeTF;
	private JTextField MediaStudentiTF;
	private JTextField MaxStudentiTF;
	
	public StatisticheFrame(Controller c) {
		controller = c;
		
		setTitle("Statistiche");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 420);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 260, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		
		CorsoTF = new JTextField();
		CorsoTF.setBackground(new Color(30, 144, 255));
		CorsoTF.setEditable(false);
		GridBagConstraints gbc_CorsoTF = new GridBagConstraints();
		gbc_CorsoTF.insets = new Insets(0, 0, 5, 5);
		gbc_CorsoTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_CorsoTF.gridx = 1;
		gbc_CorsoTF.gridy = 3;
		contentPane.add(CorsoTF, gbc_CorsoTF);
		CorsoTF.setColumns(10);
		
		JLabel numMinStudentiLabel = new JLabel("Minor numero di studenti:");
		numMinStudentiLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
		GridBagConstraints gbc_numMinStudentiLabel = new GridBagConstraints();
		gbc_numMinStudentiLabel.anchor = GridBagConstraints.WEST;
		gbc_numMinStudentiLabel.insets = new Insets(0, 0, 5, 5);
		gbc_numMinStudentiLabel.gridx = 1;
		gbc_numMinStudentiLabel.gridy = 4;
		contentPane.add(numMinStudentiLabel, gbc_numMinStudentiLabel);
		
		MinStudentiTF = new JTextField();
		MinStudentiTF.setEditable(false);
		GridBagConstraints gbc_MinStudentiTF = new GridBagConstraints();
		gbc_MinStudentiTF.insets = new Insets(0, 0, 5, 5);
		gbc_MinStudentiTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_MinStudentiTF.gridx = 1;
		gbc_MinStudentiTF.gridy = 5;
		contentPane.add(MinStudentiTF, gbc_MinStudentiTF);
		MinStudentiTF.setColumns(10);
		
		JLabel numMaxStudentiLabel = new JLabel("Massimo numero di studenti :");
		numMaxStudentiLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
		GridBagConstraints gbc_numMaxStudentiLabel = new GridBagConstraints();
		gbc_numMaxStudentiLabel.insets = new Insets(0, 0, 5, 5);
		gbc_numMaxStudentiLabel.anchor = GridBagConstraints.WEST;
		gbc_numMaxStudentiLabel.gridx = 1;
		gbc_numMaxStudentiLabel.gridy = 6;
		contentPane.add(numMaxStudentiLabel, gbc_numMaxStudentiLabel);
		
		MaxStudentiTF = new JTextField();
		MaxStudentiTF.setEditable(false);
		GridBagConstraints gbc_MaxStudentiTF = new GridBagConstraints();
		gbc_MaxStudentiTF.insets = new Insets(0, 0, 5, 5);
		gbc_MaxStudentiTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_MaxStudentiTF.gridx = 1;
		gbc_MaxStudentiTF.gridy = 7;
		contentPane.add(MaxStudentiTF, gbc_MaxStudentiTF);
		MaxStudentiTF.setColumns(10);
		
		JLabel numMedioStudentiLabel = new JLabel("Media degli studenti a lezione :");
		numMedioStudentiLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
		GridBagConstraints gbc_numMedioStudentiLabel = new GridBagConstraints();
		gbc_numMedioStudentiLabel.insets = new Insets(0, 0, 5, 5);
		gbc_numMedioStudentiLabel.anchor = GridBagConstraints.WEST;
		gbc_numMedioStudentiLabel.gridx = 1;
		gbc_numMedioStudentiLabel.gridy = 8;
		contentPane.add(numMedioStudentiLabel, gbc_numMedioStudentiLabel);
		
		MediaStudentiTF = new JTextField();
		MediaStudentiTF.setEditable(false);
		GridBagConstraints gbc_MediaStudentiTF = new GridBagConstraints();
		gbc_MediaStudentiTF.insets = new Insets(0, 0, 5, 5);
		gbc_MediaStudentiTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_MediaStudentiTF.gridx = 1;
		gbc_MediaStudentiTF.gridy = 9;
		contentPane.add(MediaStudentiTF, gbc_MediaStudentiTF);
		MediaStudentiTF.setColumns(10);
		
		JLabel numMedioStudentiPercentualeLabel = new JLabel("Media degli studenti in percentuale :");
		numMedioStudentiPercentualeLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
		GridBagConstraints gbc_numMedioStudentiPercentualeLabel = new GridBagConstraints();
		gbc_numMedioStudentiPercentualeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_numMedioStudentiPercentualeLabel.anchor = GridBagConstraints.WEST;
		gbc_numMedioStudentiPercentualeLabel.gridx = 1;
		gbc_numMedioStudentiPercentualeLabel.gridy = 10;
		contentPane.add(numMedioStudentiPercentualeLabel, gbc_numMedioStudentiPercentualeLabel);
		
		MediaPercentualeTF = new JTextField();
		MediaPercentualeTF.setEditable(false);
		GridBagConstraints gbc_MediaPercentualeTF = new GridBagConstraints();
		gbc_MediaPercentualeTF.insets = new Insets(0, 0, 5, 5);
		gbc_MediaPercentualeTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_MediaPercentualeTF.gridx = 1;
		gbc_MediaPercentualeTF.gridy = 11;
		contentPane.add(MediaPercentualeTF, gbc_MediaPercentualeTF);
		MediaPercentualeTF.setColumns(10);
		
		JButton idoneiButton = new JButton("Idonei");
		idoneiButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.getIdoneiFrame().setVisible(true);
			}
		});
		
		idoneiButton.setFont(new Font("Dialog", Font.PLAIN, 16));
		GridBagConstraints gbc_idoneiButton = new GridBagConstraints();
		gbc_idoneiButton.insets = new Insets(0, 0, 5, 5);
		gbc_idoneiButton.gridx = 1;
		gbc_idoneiButton.gridy = 12;
		contentPane.add(idoneiButton, gbc_idoneiButton);
		
		JButton tornaAllaRicercaCorsoButton = new JButton("Torna alla Ricerca Corso");
		tornaAllaRicercaCorsoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.getStatisticheFrame().setVisible(false);
				c.getIdoneiFrame().setVisible(false);
				c.getRicercaCorsoFrame().setVisible(true);
			}
		});

		tornaAllaRicercaCorsoButton.setFont(new Font("Dialog", Font.PLAIN, 16));
		GridBagConstraints gbc_tornaAllaRicercaCorsoButton = new GridBagConstraints();
		gbc_tornaAllaRicercaCorsoButton.insets = new Insets(0, 0, 5, 5);
		gbc_tornaAllaRicercaCorsoButton.gridx = 2;
		gbc_tornaAllaRicercaCorsoButton.gridy = 12;
		contentPane.add(tornaAllaRicercaCorsoButton, gbc_tornaAllaRicercaCorsoButton);
	}


}
