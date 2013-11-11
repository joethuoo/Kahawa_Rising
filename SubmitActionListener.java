package register_login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SubmitActionListener implements ActionListener {
      //declare where the event will be triggered from 
	 private MainFrame frame;
	
	public  SubmitActionListener(MainFrame frame ) {
		// TODO Auto-generated method stub
            this.frame=frame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//check if the fields have been inserted with any data
		
		if(frame.getRegisterDialog().getFname().trim().equals("")){
			frame.getRegisterDialog().setFname("enter you're First Name");
		
		}else if(frame.getRegisterDialog().getMname().trim().equals("")){
			frame.getRegisterDialog().setMname("enter you're Last Name");
		
		}else if(frame.getRegisterDialog().getSurname().trim().equals("")){
			frame.getRegisterDialog().setSurname("enter you're Address");
			
		}else if(frame.getRegisterDialog().getPhoneNum().trim().equals("")){
			frame.getRegisterDialog().setPhoneNum("enter you're Phone Number");
		
		}else if(frame.getRegisterDialog().getIdNum().trim().equals("")){
			frame.getRegisterDialog().setIdNum("enter you're national ID Number");
		
		}/*else if(frame.getRegisterDialog().getRegUsername().trim().equals("")){
			frame.getRegisterDialog().setInformation("enter you're User Name");
		
		}*/else{
			//check if the user already exist in the db.
			try{
				DBUtil.checkUsername(frame.getConnection(), frame.getRegisterDialog().getFname());
				
				//If she or he doesn't exist. we create a new user in the db
				DBUtil.updateDatabase(frame.getConnection(), frame.getRegisterDialog().getFname(), 
				frame.getRegisterDialog().getMname(), frame.getRegisterDialog().getSurname(),
				frame.getRegisterDialog().getPhoneNum(), frame.getRegisterDialog().getIdNum(),
				frame.getRegisterDialog().getFname(),frame.getRegisterDialog().getRegPassword());
				frame.getRegisterDialog().setVisible(false);
			}catch(SQLException se){
				System.out.println("Exception from Welcomelistener");
				DBUtil.processException(se);
			}
			
		}
			
	}

}
