package register_login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginDialog extends JDialog {
	
	//private MainFrame frame;
	private JTextField username;
	private JPasswordField password;
	//private ImageIcon logo;
	private JButton loginButton;
	private JButton registerButton;
	
	public LoginDialog(MainFrame frame){
		
		this.setTitle("Login");
		this.setSize(500,270);
		this.setLocation(400,100);
		this.setResizable(false);
		this.setVisible(true);
		this.setAlwaysOnTop(true);

		
		this.setLayout(new BorderLayout());
		
		//Assign a logo image
	     ImageIcon logo = new ImageIcon("logo.jpg");
	     JLabel logoLabel = new JLabel("", logo, JLabel.CENTER);
		JPanel logoPanel = new JPanel(new BorderLayout());
		logoPanel.add(logoLabel,BorderLayout.CENTER );
		logoPanel.setBackground(Color.WHITE);
		
		//instantiate all properties and put them in panels
		
		username = new JTextField(25);
		username.setBorder(BorderFactory.createBevelBorder(1));
		password = new JPasswordField(25);
		password.setBorder(BorderFactory.createBevelBorder(1));

		JPanel userFieldPanel = new JPanel(new FlowLayout());
		JPanel passFieldPanel = new JPanel(new FlowLayout());
		JPanel textFieldPanel = new JPanel(new GridLayout(2,1));
		
		JLabel string1 = new JLabel("Username:");
		JLabel string2 = new JLabel("Password:");
		
		userFieldPanel.add(string1);
		passFieldPanel.add(string2);
		userFieldPanel.add(username);
		passFieldPanel.add(password);
		
		textFieldPanel.add(userFieldPanel);
		textFieldPanel.add(passFieldPanel);
		
		//create panel of buttons and add the buttons to it
		loginButton = new JButton("Login");
		registerButton = new JButton("Register!");
		JPanel buttonPanel = new JPanel(new FlowLayout());
		buttonPanel.add(loginButton);
		buttonPanel.add(registerButton);
		
		
		
		//Add all the panels on the dialog window
		this.add(logoPanel, BorderLayout.NORTH);
		this.add(textFieldPanel, BorderLayout.CENTER);
		this.add(buttonPanel, BorderLayout.SOUTH);
		
		//Add an action listener to handle the button action event
		registerButton.addActionListener(new RegisterActionListener(frame));
		loginButton.addActionListener(new LoginActionListener(frame));
		
		
	}
	//Getter for textfields
	public String getUsername() {
		return username.getText();
	}

	public String getPassword() {
		return password.getText();
	}
	
}
