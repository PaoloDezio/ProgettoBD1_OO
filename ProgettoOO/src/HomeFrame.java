import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class HomeFrame extends JFrame {

	private JPanel contentPane;
	private Controller controller;
	

	public HomeFrame(Controller c) {
		setTitle("Home");
		controller = c;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(375, 175, 592, 279);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 40, 0, 118, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{40, 32, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JButton ricercaCorsoButton = new JButton("Ricerca Corso");
		ricercaCorsoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.getRicercaCorsoFrame().setVisible(true);
				c.getHomeFrame().setVisible(false);

			}});
		
		JLabel homeLabel = new JLabel("Home");
		homeLabel.setFont(new Font("Century", Font.BOLD, 25));
		GridBagConstraints gbc_homeLabel = new GridBagConstraints();
		gbc_homeLabel.anchor = GridBagConstraints.NORTH;
		gbc_homeLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_homeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_homeLabel.gridx = 1;
		gbc_homeLabel.gridy = 0;
		contentPane.add(homeLabel, gbc_homeLabel);
		ricercaCorsoButton.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_ricercaCorsoButton = new GridBagConstraints();
		gbc_ricercaCorsoButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_ricercaCorsoButton.gridwidth = 2;
		gbc_ricercaCorsoButton.insets = new Insets(0, 0, 5, 5);
		gbc_ricercaCorsoButton.gridx = 1;
		gbc_ricercaCorsoButton.gridy = 1;
		contentPane.add(ricercaCorsoButton, gbc_ricercaCorsoButton);
		
		JButton iscriviStudenteButton = new JButton("Iscrivi Studente");
		iscriviStudenteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.getIscriviStudenteFrame().setVisible(true);
				c.getHomeFrame().setVisible(false);			
				}
		});
		iscriviStudenteButton.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_iscriviStudenteButton = new GridBagConstraints();
		gbc_iscriviStudenteButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_iscriviStudenteButton.insets = new Insets(0, 0, 5, 5);
		gbc_iscriviStudenteButton.gridx = 3;
		gbc_iscriviStudenteButton.gridy = 1;
		contentPane.add(iscriviStudenteButton, gbc_iscriviStudenteButton);
		
		JButton tornaAlLoginButton = new JButton("Torna al Login");
		tornaAlLoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.getHomeFrame().setVisible(false);	
				c.getLoginFrame().setVisible(true);
			}
		});
		
		JButton aggiungiAreaTematicaButton = new JButton("Aggiungi Area Tematica");
		aggiungiAreaTematicaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.getHomeFrame().setVisible(false);	
				c.getAggiungiAreaTematicaFrame().setVisible(true);
			}
		});
		aggiungiAreaTematicaButton.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_aggiungiAreaTematicaButton = new GridBagConstraints();
		gbc_aggiungiAreaTematicaButton.gridwidth = 3;
		gbc_aggiungiAreaTematicaButton.insets = new Insets(0, 0, 5, 5);
		gbc_aggiungiAreaTematicaButton.gridx = 1;
		gbc_aggiungiAreaTematicaButton.gridy = 2;
		contentPane.add(aggiungiAreaTematicaButton, gbc_aggiungiAreaTematicaButton);
		tornaAlLoginButton.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_tornaAlLoginButton = new GridBagConstraints();
		gbc_tornaAlLoginButton.gridwidth = 2;
		gbc_tornaAlLoginButton.insets = new Insets(0, 0, 5, 5);
		gbc_tornaAlLoginButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_tornaAlLoginButton.gridx = 4;
		gbc_tornaAlLoginButton.gridy = 3;
		contentPane.add(tornaAlLoginButton, gbc_tornaAlLoginButton);
	}

}
