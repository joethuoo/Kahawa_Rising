package register_login;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterActionListener implements ActionListener {

	//frame where the event will be triggered from
		private MainFrame frame;
		
		public RegisterActionListener(MainFrame frame){
			this.frame = frame;
		}
	@Override
	public void actionPerformed(ActionEvent e) {

		frame.getRegisterDialog().setVisible(true);
		
		

	}

}
