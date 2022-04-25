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
		
		CorsoTF = new JTextField();
		CorsoTF.setEnabled(false);
		CorsoTF.setFont(new Font("Century", Font.PLAIN, 18));
		CorsoTF.setBackground(new Color(30, 144, 255));
		CorsoTF.setEditable(false);
		GridBagConstraints gbc_CorsoTF = new GridBagConstraints();
		gbc_CorsoTF.anchor = GridBagConstraints.WEST;
		gbc_CorsoTF.insets = new Insets(0, 0, 5, 5);
		gbc_CorsoTF.gridx = 2;
		gbc_CorsoTF.gridy = 3;
		contentPane.add(CorsoTF, gbc_CorsoTF);
		CorsoTF.setColumns(10);
		
		JLabel presenzeMinimeLabel = new JLabel("Presenze minime");
		presenzeMinimeLabel.setFont(new Font("Century", Font.PLAIN, 18));
		GridBagConstraints gbc_presenzeMinimeLabel = new GridBagConstraints();
		gbc_presenzeMinimeLabel.anchor = GridBagConstraints.EAST;
		gbc_presenzeMinimeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_presenzeMinimeLabel.gridx = 1;
		gbc_presenzeMinimeLabel.gridy = 4;
		contentPane.add(presenzeMinimeLabel, gbc_presenzeMinimeLabel);
		
		MinStudentiTF = new JTextField();
		MinStudentiTF.setBackground(new Color(30, 144, 255));
		MinStudentiTF.setFont(new Font("Century", Font.PLAIN, 18));
		MinStudentiTF.setEditable(false);
		GridBagConstraints gbc_MinStudentiTF = new GridBagConstraints();
		gbc_MinStudentiTF.anchor = GridBagConstraints.WEST;
		gbc_MinStudentiTF.gridwidth = 2;
		gbc_MinStudentiTF.insets = new Insets(0, 0, 5, 5);
		gbc_MinStudentiTF.gridx = 2;
		gbc_MinStudentiTF.gridy = 4;
		contentPane.add(MinStudentiTF, gbc_MinStudentiTF);
		MinStudentiTF.setColumns(10);
		
		JLabel presenzeMassimeLabel = new JLabel("Presenze massime");
		presenzeMassimeLabel.setFont(new Font("Century", Font.PLAIN, 18));
		GridBagConstraints gbc_presenzeMassimeLabel = new GridBagConstraints();
		gbc_presenzeMassimeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_presenzeMassimeLabel.anchor = GridBagConstraints.EAST;
		gbc_presenzeMassimeLabel.gridx = 1;
		gbc_presenzeMassimeLabel.gridy = 5;
		contentPane.add(presenzeMassimeLabel, gbc_presenzeMassimeLabel);
		
		MaxStudentiTF = new JTextField();
		MaxStudentiTF.setBackground(new Color(30, 144, 255));
		MaxStudentiTF.setFont(new Font("Century", Font.PLAIN, 18));
		MaxStudentiTF.setEditable(false);
		GridBagConstraints gbc_MaxStudentiTF = new GridBagConstraints();
		gbc_MaxStudentiTF.anchor = GridBagConstraints.WEST;
		gbc_MaxStudentiTF.insets = new Insets(0, 0, 5, 5);
		gbc_MaxStudentiTF.gridx = 2;
		gbc_MaxStudentiTF.gridy = 5;
		contentPane.add(MaxStudentiTF, gbc_MaxStudentiTF);
		MaxStudentiTF.setColumns(10);
		
		JLabel mediaStudentiLabel = new JLabel("N\u00B0 presenze medio");
		mediaStudentiLabel.setFont(new Font("Century", Font.PLAIN, 18));
		GridBagConstraints gbc_mediaStudentiLabel = new GridBagConstraints();
		gbc_mediaStudentiLabel.insets = new Insets(0, 0, 5, 5);
		gbc_mediaStudentiLabel.anchor = GridBagConstraints.EAST;
		gbc_mediaStudentiLabel.gridx = 1;
		gbc_mediaStudentiLabel.gridy = 6;
		contentPane.add(mediaStudentiLabel, gbc_mediaStudentiLabel);
		
		MediaStudentiTF = new JTextField();
		MediaStudentiTF.setBackground(new Color(30, 144, 255));
		MediaStudentiTF.setFont(new Font("Century", Font.PLAIN, 18));
		MediaStudentiTF.setEditable(false);
		GridBagConstraints gbc_MediaStudentiTF = new GridBagConstraints();
		gbc_MediaStudentiTF.anchor = GridBagConstraints.WEST;
		gbc_MediaStudentiTF.insets = new Insets(0, 0, 5, 5);
		gbc_MediaStudentiTF.gridx = 2;
		gbc_MediaStudentiTF.gridy = 6;
		contentPane.add(MediaStudentiTF, gbc_MediaStudentiTF);
		MediaStudentiTF.setColumns(10);
		
		JLabel mediaStudentiPercentualeLabel = new JLabel("N\u00B0 presenze medio in %");
		mediaStudentiPercentualeLabel.setFont(new Font("Century", Font.PLAIN, 18));
		GridBagConstraints gbc_mediaStudentiPercentualeLabel = new GridBagConstraints();
		gbc_mediaStudentiPercentualeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_mediaStudentiPercentualeLabel.anchor = GridBagConstraints.EAST;
		gbc_mediaStudentiPercentualeLabel.gridx = 1;
		gbc_mediaStudentiPercentualeLabel.gridy = 7;
		contentPane.add(mediaStudentiPercentualeLabel, gbc_mediaStudentiPercentualeLabel);
		
		MediaPercentualeTF = new JTextField();
		MediaPercentualeTF.setBackground(new Color(30, 144, 255));
		MediaPercentualeTF.setFont(new Font("Century", Font.PLAIN, 18));
		MediaPercentualeTF.setEditable(false);
		GridBagConstraints gbc_MediaPercentualeTF = new GridBagConstraints();
		gbc_MediaPercentualeTF.anchor = GridBagConstraints.WEST;
		gbc_MediaPercentualeTF.insets = new Insets(0, 0, 5, 5);
		gbc_MediaPercentualeTF.gridx = 2;
		gbc_MediaPercentualeTF.gridy = 7;
		contentPane.add(MediaPercentualeTF, gbc_MediaPercentualeTF);
		MediaPercentualeTF.setColumns(10);
				
				JButton idoneiButton = new JButton("Idonei");
				idoneiButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						c.getIdoneiFrame().setVisible(true);
					}
				});
				
				JButton indietroButton = new JButton("Indietro");
				indietroButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						c.getStatisticheFrame().setVisible(false);
						c.getIdoneiFrame().setVisible(false);
						c.getRicercaCorsoFrame().setVisible(true);
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
