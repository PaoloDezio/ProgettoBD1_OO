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
import java.awt.event.ActionEvent;

public class HomeFrame extends JFrame {

	private JPanel contentPane;
	private Controller controller;
	

	/**
	 * Create the frame.
	 */
	public HomeFrame(Controller c) {
		setTitle("Home");
		controller = c;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(375, 175, 600, 365);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 61, 0, 118, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{53, 52, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel homeLabel = new JLabel("Home");
		homeLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_homeLabel = new GridBagConstraints();
		gbc_homeLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_homeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_homeLabel.gridx = 2;
		gbc_homeLabel.gridy = 0;
		contentPane.add(homeLabel, gbc_homeLabel);
		
		JButton tornaAlLoginButton = new JButton("Torna al Login");
		tornaAlLoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.tornaAlLoginFrame();
			}
		});
		
		JButton ricercaCorsoButton = new JButton("Ricerca Corso");
		ricercaCorsoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.setVisibleRicercaCorso(true);
				
			}
		});
		ricercaCorsoButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_ricercaCorsoButton = new GridBagConstraints();
		gbc_ricercaCorsoButton.fill = GridBagConstraints.BOTH;
		gbc_ricercaCorsoButton.insets = new Insets(0, 0, 5, 5);
		gbc_ricercaCorsoButton.gridx = 2;
		gbc_ricercaCorsoButton.gridy = 1;
		contentPane.add(ricercaCorsoButton, gbc_ricercaCorsoButton);
		
		JButton iscriviStudenteButton = new JButton("Iscrivi Studente");
		iscriviStudenteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.setVisibleIscriviStudente(true);
			}
		});
		iscriviStudenteButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_iscriviStudenteButton = new GridBagConstraints();
		gbc_iscriviStudenteButton.insets = new Insets(0, 0, 5, 5);
		gbc_iscriviStudenteButton.fill = GridBagConstraints.VERTICAL;
		gbc_iscriviStudenteButton.gridx = 3;
		gbc_iscriviStudenteButton.gridy = 1;
		contentPane.add(iscriviStudenteButton, gbc_iscriviStudenteButton);
		tornaAlLoginButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_tornaAlLoginButton = new GridBagConstraints();
		gbc_tornaAlLoginButton.insets = new Insets(0, 0, 5, 5);
		gbc_tornaAlLoginButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_tornaAlLoginButton.gridx = 5;
		gbc_tornaAlLoginButton.gridy = 4;
		contentPane.add(tornaAlLoginButton, gbc_tornaAlLoginButton);
	}

}
