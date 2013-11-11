package register_students;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class StudentDetail {
	//private RegisterStudentDialog regDialog;
	
	/*	public StudentDetail(RegisterStudentDialog regDialog) {
		super();
		this.regDialog = regDialog;
	}
		//get method for register 
		public JLabel getRegStudent(JLabel registerstudent){
			return registerstudent;
		}
		//set method for the textfields in student
		public void setRegStudent(String message, JLabel registerstudent){
			registerstudent.setText(message);
			registerstudent.setForeground(Color.RED);
		}*/
		
		//get snd set method for fname
		public String getStudentFirstName(JTextField sname){
			return sname.getText();
		}
		public void setStudentFirstName(JLabel sname,String text){
			sname.setText(text);
			sname.setForeground(Color.BLUE);
		}
		
		//set and get method for midname
		public String getStudentMidName(JTextField sMname){
			return sMname.getText();
		}
		public void setStudentMidName(JLabel sMname,String txt){
			sMname.setText(txt);
			sMname.setForeground(Color.BLUE);
		}
		
		//set and get method for student surname
		public String getStudentSurName(JTextField ssurname){
			return ssurname.getText();
		}
		public void setStudentSurname(String text, JLabel ssurname){
			ssurname.setText(text);
			ssurname.setForeground(Color.BLUE);
		}
		
		//get and set methods for parents name 
		public String getParentFirstName(JTextField pfname){
			return pfname.getText();
		}
		public void setParentFirstName(String text, JLabel pfname){
			pfname.setText(text);
			pfname.setForeground(Color.BLUE);
		}
		
		
		public String getParentMidName(JTextField pMname){
			return pMname.getText();
		}
		public void setParentMidName(String text, JLabel pMname){
			pMname.setText(text);
			pMname.setForeground(Color.BLUE);
		}
		
		public String getParentSurname(JTextField psurname){
			return psurname.getText();
		}
		public void setParentSurname(String text, JLabel psurname){
			psurname.setText(text);
			psurname.setForeground(Color.BLUE);
		}
		
		//get and set methods for contacts and residence
		public String getPhoneNumber(JTextField phonenumber){
			return phonenumber.getText();
		}
		public void setPhoneNumber(String text, JLabel phonenumber){
			phonenumber.setText(text);
			phonenumber.setForeground(Color.BLUE);
		}
		
		public String getEmail(JTextField email){
			return email.getText();
		}
		public void setEmail(String text, JLabel email){
			email.setText(text);
			email.setForeground(Color.BLUE);
		}
		
		public String getResidence(JTextField residence){
			return residence.getText();
		}
		public void setResidence(String text, JLabel residence){
			residence.setText(text);
			residence.setForeground(Color.BLUE);
		}
		
		

		//get and set methods for both gender JRadioButtons  
		public JRadioButton getSfemale() {
			return getSfemale();
		}
		
		public void setSfemale(JRadioButton sfemale) {
			// TODO Auto-generated method stub	
		}
		
		public JRadioButton getSmale() {
			return getSmale();
		}
		public void setSmale(JRadioButton smale) {
			// TODO Auto-generated method stub
			
		}

		
	
}
