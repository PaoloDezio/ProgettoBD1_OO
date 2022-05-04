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
	private JTextField corsoTF;
	private JTextField minStudentiTF;
	private JTextField mediaPercentualeTF;
	private JTextField mediaStudentiTF;
	private JTextField maxStudentiTF;
	
	public JTextField getCorsoTF() {
		return corsoTF;
	}

	public StatisticheFrame(Controller c) {
		controller = c;
		
		setTitle("Statistiche");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 622, 396);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 168, 130, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel statisticheLabel = new JLabel("Statistiche\r\n");
		statisticheLabel.setFont(new Font("Century", Font.PLAIN, 25));
		GridBagConstraints gbc_statisticheLabel = new GridBagConstraints();
		gbc_statisticheLabel.anchor = GridBagConstraints.WEST;
		gbc_statisticheLabel.insets = new Insets(0, 0, 5, 5);
		gbc_statisticheLabel.gridx = 1;
		gbc_statisticheLabel.gridy = 2;
		contentPane.add(statisticheLabel, gbc_statisticheLabel);
		
		JLabel nomeCorsoLabel = new JLabel("Corso ");
		nomeCorsoLabel.setFont(new Font("Century", Font.PLAIN, 18));
		GridBagConstraints gbc_nomeCorsoLabel = new GridBagConstraints();
		gbc_nomeCorsoLabel.anchor = GridBagConstraints.EAST;
		gbc_nomeCorsoLabel.fill = GridBagConstraints.VERTICAL;
		gbc_nomeCorsoLabel.insets = new Insets(0, 0, 5, 5);
		gbc_nomeCorsoLabel.gridx = 1;
		gbc_nomeCorsoLabel.gridy = 3;
		contentPane.add(nomeCorsoLabel, gbc_nomeCorsoLabel);
		
		corsoTF = new JTextField();
		corsoTF.setBorder(null);
		corsoTF.setEnabled(false);
		corsoTF.setFont(new Font("Century", Font.PLAIN, 18));
		corsoTF.setBackground(new Color(30, 144, 255));
		corsoTF.setEditable(false);
		GridBagConstraints gbc_CorsoTF = new GridBagConstraints();
		gbc_CorsoTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_CorsoTF.insets = new Insets(0, 0, 5, 5);
		gbc_CorsoTF.gridx = 2;
		gbc_CorsoTF.gridy = 3;
		contentPane.add(corsoTF, gbc_CorsoTF);
		corsoTF.setColumns(10);
		
		JLabel presenzeMinimeLabel = new JLabel("Presenze minime");
		presenzeMinimeLabel.setFont(new Font("Century", Font.PLAIN, 18));
		GridBagConstraints gbc_presenzeMinimeLabel = new GridBagConstraints();
		gbc_presenzeMinimeLabel.anchor = GridBagConstraints.EAST;
		gbc_presenzeMinimeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_presenzeMinimeLabel.gridx = 1;
		gbc_presenzeMinimeLabel.gridy = 4;
		contentPane.add(presenzeMinimeLabel, gbc_presenzeMinimeLabel);
		
		minStudentiTF = new JTextField();
		minStudentiTF.setBorder(null);
		minStudentiTF.setBackground(new Color(30, 144, 255));
		minStudentiTF.setFont(new Font("Century", Font.PLAIN, 18));
		minStudentiTF.setEditable(false);
		GridBagConstraints gbc_MinStudentiTF = new GridBagConstraints();
		gbc_MinStudentiTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_MinStudentiTF.gridwidth = 2;
		gbc_MinStudentiTF.insets = new Insets(0, 0, 5, 5);
		gbc_MinStudentiTF.gridx = 2;
		gbc_MinStudentiTF.gridy = 4;
		contentPane.add(minStudentiTF, gbc_MinStudentiTF);
		minStudentiTF.setColumns(10);
		
		JLabel presenzeMassimeLabel = new JLabel("Presenze massime");
		presenzeMassimeLabel.setFont(new Font("Century", Font.PLAIN, 18));
		GridBagConstraints gbc_presenzeMassimeLabel = new GridBagConstraints();
		gbc_presenzeMassimeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_presenzeMassimeLabel.anchor = GridBagConstraints.EAST;
		gbc_presenzeMassimeLabel.gridx = 1;
		gbc_presenzeMassimeLabel.gridy = 5;
		contentPane.add(presenzeMassimeLabel, gbc_presenzeMassimeLabel);
		
		maxStudentiTF = new JTextField();
		maxStudentiTF.setBorder(null);
		maxStudentiTF.setBackground(new Color(30, 144, 255));
		maxStudentiTF.setFont(new Font("Century", Font.PLAIN, 18));
		maxStudentiTF.setEditable(false);
		GridBagConstraints gbc_MaxStudentiTF = new GridBagConstraints();
		gbc_MaxStudentiTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_MaxStudentiTF.insets = new Insets(0, 0, 5, 5);
		gbc_MaxStudentiTF.gridx = 2;
		gbc_MaxStudentiTF.gridy = 5;
		contentPane.add(maxStudentiTF, gbc_MaxStudentiTF);
		maxStudentiTF.setColumns(10);
		
		JLabel mediaStudentiLabel = new JLabel("N\u00B0 presenze medio");
		mediaStudentiLabel.setFont(new Font("Century", Font.PLAIN, 18));
		GridBagConstraints gbc_mediaStudentiLabel = new GridBagConstraints();
		gbc_mediaStudentiLabel.insets = new Insets(0, 0, 5, 5);
		gbc_mediaStudentiLabel.anchor = GridBagConstraints.EAST;
		gbc_mediaStudentiLabel.gridx = 1;
		gbc_mediaStudentiLabel.gridy = 6;
		contentPane.add(mediaStudentiLabel, gbc_mediaStudentiLabel);
		
		mediaStudentiTF = new JTextField();
		mediaStudentiTF.setBorder(null);
		mediaStudentiTF.setBackground(new Color(30, 144, 255));
		mediaStudentiTF.setFont(new Font("Century", Font.PLAIN, 18));
		mediaStudentiTF.setEditable(false);
		GridBagConstraints gbc_MediaStudentiTF = new GridBagConstraints();
		gbc_MediaStudentiTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_MediaStudentiTF.insets = new Insets(0, 0, 5, 5);
		gbc_MediaStudentiTF.gridx = 2;
		gbc_MediaStudentiTF.gridy = 6;
		contentPane.add(mediaStudentiTF, gbc_MediaStudentiTF);
		mediaStudentiTF.setColumns(10);
		
		JLabel mediaStudentiPercentualeLabel = new JLabel("N\u00B0 presenze medio in %");
		mediaStudentiPercentualeLabel.setFont(new Font("Century", Font.PLAIN, 18));
		GridBagConstraints gbc_mediaStudentiPercentualeLabel = new GridBagConstraints();
		gbc_mediaStudentiPercentualeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_mediaStudentiPercentualeLabel.anchor = GridBagConstraints.EAST;
		gbc_mediaStudentiPercentualeLabel.gridx = 1;
		gbc_mediaStudentiPercentualeLabel.gridy = 7;
		contentPane.add(mediaStudentiPercentualeLabel, gbc_mediaStudentiPercentualeLabel);
		
		mediaPercentualeTF = new JTextField();
		mediaPercentualeTF.setBorder(null);
		mediaPercentualeTF.setBackground(new Color(30, 144, 255));
		mediaPercentualeTF.setFont(new Font("Century", Font.PLAIN, 18));
		mediaPercentualeTF.setEditable(false);
		GridBagConstraints gbc_MediaPercentualeTF = new GridBagConstraints();
		gbc_MediaPercentualeTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_MediaPercentualeTF.insets = new Insets(0, 0, 5, 5);
		gbc_MediaPercentualeTF.gridx = 2;
		gbc_MediaPercentualeTF.gridy = 7;
		contentPane.add(mediaPercentualeTF, gbc_MediaPercentualeTF);
		mediaPercentualeTF.setColumns(10);
				
		JButton idoneiButton = new JButton("Idonei");
		idoneiButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.getIdoneiFrame().setVisible(true);
			}
		});

		JButton indietroButton = new JButton("Indietro");
		indietroButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.getStatisticheFrame().setVisible(false);
				controller.getIdoneiFrame().setVisible(false);
				controller.getRicercaCorsoFrame().setVisible(true);
			}
		});
		indietroButton.setFont(new Font("Century", Font.PLAIN, 18));
		GridBagConstraints gbc_indietroButton = new GridBagConstraints();
		gbc_indietroButton.insets = new Insets(0, 0, 5, 5);
		gbc_indietroButton.gridx = 1;
		gbc_indietroButton.gridy = 9;
		contentPane.add(indietroButton, gbc_indietroButton);

		idoneiButton.setFont(new Font("Century", Font.PLAIN, 18));
		GridBagConstraints gbc_idoneiButton = new GridBagConstraints();
		gbc_idoneiButton.insets = new Insets(0, 0, 5, 5);
		gbc_idoneiButton.gridx = 2;
		gbc_idoneiButton.gridy = 9;
		contentPane.add(idoneiButton, gbc_idoneiButton);
		
	}


}
