package register_students;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import register_login.MainFrame;


public class FirstInterFace extends JFrame{
	private StudentDetail studentDetail;
    private RegisterStudentDialog regiStudent;
	private JButton registerstudent;
	private JPanel panel;

	public FirstInterFace(MainFrame mainFrame){  
		panel = new JPanel(new FlowLayout());
		registerstudent=new JButton("REGISTER STUDENTS");
		registerstudent.setPreferredSize(new Dimension(150, 50));
		//regiStudent= new RegisterStudent(this);
		
		// adding button to the panel
		panel.add(registerstudent);
		//adding panel with button to the frame
		this.add(panel,BorderLayout.NORTH);
		
		//add lister to button.
		registerstudent.addActionListener(new RegisterStudentActionListener(this));

}

	public RegisterStudentDialog getRegisterStudent() {
		// TODO Auto-generated method stub
		return regiStudent;
	}
	/*public StudentDetail getStudentDetail(){
		return studentDetail;
	}*/

	
	 
	
	

	
	
	
	
	
}

