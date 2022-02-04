import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
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
import java.awt.SystemColor;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Window.Type;
import java.awt.Rectangle;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField usernameTF;
	private JPasswordField passwordTF;
	private Controller controller;
	private JLabel loginLabel;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JButton accediButton;
	
	
	/**
	 * Create the frame.
	 */
	public LoginFrame(Controller c) {
		
		controller=c;
		
		setTitle("Login");
		setBackground(new Color(240, 240, 240));
		setBounds(375, 175, 600, 365);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setMaximumSize(new Dimension(20000, 20000));
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{65, 86, 90, 90, 0, 40, 80, 0};
		gbl_contentPane.rowHeights = new int[]{66, 25, 25, 30, 39, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		loginLabel = new JLabel("Login");
		loginLabel.setVerticalAlignment(SwingConstants.TOP);
		loginLabel.setLabelFor(this);
		loginLabel.setHorizontalAlignment(SwingConstants.LEFT);
		loginLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(loginLabel, gbc_lblNewLabel);
		
		usernameLabel = new JLabel("Username");
		usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_usernameLabel = new GridBagConstraints();
		gbc_usernameLabel.anchor = GridBagConstraints.EAST;
		gbc_usernameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_usernameLabel.gridx = 1;
		gbc_usernameLabel.gridy = 1;
		contentPane.add(usernameLabel, gbc_usernameLabel);
		
		usernameTF = new JTextField();
		usernameTF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_usernameTF = new GridBagConstraints();
		gbc_usernameTF.fill = GridBagConstraints.BOTH;
		gbc_usernameTF.gridwidth = 3;
		gbc_usernameTF.insets = new Insets(0, 0, 5, 5);
		gbc_usernameTF.gridx = 2;
		gbc_usernameTF.gridy = 1;
		contentPane.add(usernameTF, gbc_usernameTF);
		usernameTF.setColumns(10);
		
		passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_passwordLabel = new GridBagConstraints();
		gbc_passwordLabel.anchor = GridBagConstraints.EAST;
		gbc_passwordLabel.insets = new Insets(0, 0, 5, 5);
		gbc_passwordLabel.gridx = 1;
		gbc_passwordLabel.gridy = 2;
		contentPane.add(passwordLabel, gbc_passwordLabel);
		
		passwordTF = new JPasswordField();
		passwordTF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_passwordTF = new GridBagConstraints();
		gbc_passwordTF.fill = GridBagConstraints.BOTH;
		gbc_passwordTF.gridwidth = 3;
		gbc_passwordTF.insets = new Insets(0, 0, 5, 5);
		gbc_passwordTF.gridx = 2;
		gbc_passwordTF.gridy = 2;
		contentPane.add(passwordTF, gbc_passwordTF);
		
		accediButton = new JButton("Accedi");
		accediButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernameTF.getText();
				String pwd= new String(passwordTF.getPassword());
				if(username.isEmpty() || pwd.isEmpty()) {
					JOptionPane.showMessageDialog(contentPane,"Inserire un Username e una Password per accedere","",JOptionPane.WARNING_MESSAGE);
				}
				else {
				c.checkResponsabile(username,pwd);
				usernameTF.setText("");
				passwordTF.setText("");
				}
			}
		});
		
		
		accediButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_accediButton = new GridBagConstraints();
		gbc_accediButton.gridx = 6;
		gbc_accediButton.gridy = 4;
		
		contentPane.add(accediButton, gbc_accediButton);
	}

}
