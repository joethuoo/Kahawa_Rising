package register_login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JFrame;

import register_students.FirstInterFace;

public class MainFrame extends JFrame {
	
	private LoginDialog login;
	private RegisterDialog register;
	//private FirstInterFace firstInterFace;
	
	//Declaring access to the database
	private static final String USERNAME = "dbuser";
	private static final String PASSWORD = "dbpassword";
	// we are connecting to a localhost.
	private static final String CONN_STRING = "jdbc:mysql://localhost/logincredentials";
	
	
	public MainFrame(){
    	//instantiate the login and register dialogs
		login = new LoginDialog(this);
		//register = new RegisterDialog(this);
	//	firstInterFace= new FirstInterFace(this);
		//firstInterFace= new FirstInterFace(this);
		//register.setVisible(false);
		login.setVisible(true);
		
		
	}
	//get method for logindialog
	public LoginDialog getLoginDialog(){
		
		return login;
		}
	//get method for registerdialog
	public RegisterDialog getRegisterDialog(){
		
		return register;
		}
	
	//getter method for the connection
	public Connection getConnection() throws SQLException{
		
		return DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
		
	}

}
