package register_login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class LoginActionListener implements ActionListener {

	//frame where the event will be triggered from
	private MainFrame frame;
	
	public LoginActionListener(MainFrame frame){
		
		this.frame = frame;
	}
	//@Override
	public void actionPerformed(ActionEvent e) {
		
		SQLException i = new SQLException("Please enter your username and password!");
		if (frame.getLoginDialog().getUsername().trim().equals("") || frame.getLoginDialog().getPassword().trim().equals("")){
			DBUtil.processException(i);
			
		}
		else{

		//call checklogin method
		try {

			DBUtil.checkLogin(frame.getConnection(),frame.getLoginDialog().getUsername(),frame.getLoginDialog().getPassword());
			//if username and password exists, start game here
			frame.getLoginDialog().setVisible(false);
			
		} catch (SQLException loginexception) {

			//if there was a problem, throw error here
			DBUtil.processException(loginexception);
			System.out.println("loginexception called");
		}
		


	}

	}

}
