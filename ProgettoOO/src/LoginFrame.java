import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField usernameTF;
	private JPasswordField passwordTF;
	private Controller controller;
	private JLabel loginLabel;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JButton accediButton;
	private JCheckBox mostraPasswordCheckBox;
	

	public LoginFrame(Controller mainController) {
		controller=mainController;
		
		setTitle("Login");
		setBackground(new Color(240, 240, 240));
		setBounds(375, 175, 580, 285);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setMaximumSize(new Dimension(20000, 20000));
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{49, 86, 150, 90, 0, 25, 0, 53, 0};
		gbl_contentPane.rowHeights = new int[]{56, 25, 25, 20, 0, 28, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		loginLabel = new JLabel("Login");
		loginLabel.setVerticalAlignment(SwingConstants.TOP);
		loginLabel.setLabelFor(this);
		loginLabel.setHorizontalAlignment(SwingConstants.LEFT);
		loginLabel.setFont(new Font("Century", Font.BOLD, 25));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(loginLabel, gbc_lblNewLabel);
		
		usernameLabel = new JLabel("Username");
		usernameLabel.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_usernameLabel = new GridBagConstraints();
		gbc_usernameLabel.anchor = GridBagConstraints.EAST;
		gbc_usernameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_usernameLabel.gridx = 1;
		gbc_usernameLabel.gridy = 1;
		contentPane.add(usernameLabel, gbc_usernameLabel);
		
		usernameTF = new JTextField();
		usernameTF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_usernameTF = new GridBagConstraints();
		gbc_usernameTF.fill = GridBagConstraints.BOTH;
		gbc_usernameTF.gridwidth = 3;
		gbc_usernameTF.insets = new Insets(0, 0, 5, 5);
		gbc_usernameTF.gridx = 2;
		gbc_usernameTF.gridy = 1;
		contentPane.add(usernameTF, gbc_usernameTF);
		usernameTF.setColumns(10);
		
		passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_passwordLabel = new GridBagConstraints();
		gbc_passwordLabel.anchor = GridBagConstraints.EAST;
		gbc_passwordLabel.insets = new Insets(0, 0, 5, 5);
		gbc_passwordLabel.gridx = 1;
		gbc_passwordLabel.gridy = 2;
		contentPane.add(passwordLabel, gbc_passwordLabel);
		
		passwordTF = new JPasswordField();
		passwordTF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_passwordTF = new GridBagConstraints();
		gbc_passwordTF.fill = GridBagConstraints.BOTH;
		gbc_passwordTF.gridwidth = 3;
		gbc_passwordTF.insets = new Insets(0, 0, 5, 5);
		gbc_passwordTF.gridx = 2;
		gbc_passwordTF.gridy = 2;
		contentPane.add(passwordTF, gbc_passwordTF);
		mostraPasswordCheckBox = new JCheckBox("Mostra Password");
		mostraPasswordCheckBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1)
					passwordTF.setEchoChar((char)0);
				else
					passwordTF.setEchoChar('\u25CF');
			}
		});
		mostraPasswordCheckBox.setFont(new Font("Century", Font.PLAIN, 14));
		mostraPasswordCheckBox.setBackground(new Color(30, 144, 255));
		GridBagConstraints gbc_mostraPasswordCheckBox = new GridBagConstraints();
		gbc_mostraPasswordCheckBox.anchor = GridBagConstraints.WEST;
		gbc_mostraPasswordCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_mostraPasswordCheckBox.gridx = 2;
		gbc_mostraPasswordCheckBox.gridy = 3;
		contentPane.add(mostraPasswordCheckBox, gbc_mostraPasswordCheckBox);
		
		accediButton = new JButton("Accedi");
		accediButton.setBackground(new Color(255, 255, 255));
		accediButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernameTF.getText();
				String password= new String(passwordTF.getPassword());
				if(username.isEmpty() && password.isEmpty()) {
					JOptionPane.showMessageDialog(contentPane,"Inserire un Username e una Password","",JOptionPane.WARNING_MESSAGE);
				}
				else {
					if(mainController.checkResponsabile(username,password)==true) {
						mainController.getLoginFrame().setVisible(false);
						mainController.getHomeFrame().setVisible(true);
						usernameTF.setText("");
						passwordTF.setText("");
					}
					else {
						JOptionPane.showMessageDialog(contentPane,"Username e Password non validi","",JOptionPane.ERROR_MESSAGE);
						usernameTF.setText("");
						passwordTF.setText("");
					}			
				}				
			}
		});
		
		
		accediButton.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_accediButton = new GridBagConstraints();
		gbc_accediButton.insets = new Insets(0, 0, 5, 5);
		gbc_accediButton.gridx = 6;
		gbc_accediButton.gridy = 4;
		
		contentPane.add(accediButton, gbc_accediButton);
	}

}
