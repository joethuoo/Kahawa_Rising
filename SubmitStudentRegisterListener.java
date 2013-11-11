 package register_students;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class SubmitStudentRegisterListener implements ActionListener {
	//where the event will trigger form
	private StudentDetail studentDetail;

	public SubmitStudentRegisterListener( ) {
		// TODO Auto-generated constructor stub
		this.studentDetail=studentDetail;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
   
		//check if the fields have been inserted with any data before submitting
		//check if student FIRST NAME is Inserted
		if(studentDetail.getStudentFirstName(null).trim().equals("")){
			studentDetail.setStudentFirstName(null, "enter student First Name");
		}
		//check if student MIDDLE NAME is Inserted
		else if(studentDetail.getStudentMidName(null).trim().equals("")){
			studentDetail.setStudentMidName( null, "enter student Middle Name");
		}
		//check if student SURNAME is Inserted
		else if(studentDetail.getStudentSurName(null).trim().equals("")){
			studentDetail.setStudentSurname("enter student Surname", null);
		}
		//check if student GENDER is checked from RADIOBUTTONS.
		else if(studentDetail.getSfemale().isSelected()==false){
			JOptionPane.showMessageDialog(null, "Select ");
	    }else if(studentDetail.getSmale().isSelected()==false){
			JOptionPane.showMessageDialog(null, "Select a button");
		}
		//check if the parents have been inserted with any data before submitting 
		//check if the Parent Names are inserted.
		else if(studentDetail.getParentFirstName(null).trim().equals("")){
			studentDetail.setParentFirstName("enter parents First name", null);
		}
		else if(studentDetail.getParentMidName(null).trim().equals("")){
			studentDetail.setParentMidName("enter parents Middle name", null);
		}
		else if(studentDetail.getParentSurname(null).trim().equals("")){
			studentDetail.setParentSurname("enter parents Surname", null);
		}
		//check radio buttons for the parents compatment. 
		/*
		else if(firstInterFace.getRegisterStudent().getMale().isSelected()==false){
			
		}*/
		else if(studentDetail.getPhoneNumber(null).trim().equals("")){
			studentDetail.setPhoneNumber("enter parents Phone number", null);
		}
		else if(studentDetail.getEmail(null).trim().equals("")){
			studentDetail.setEmail("enter parents Email", null);
		}
		else if(studentDetail.getResidence(null).trim().equals("")){
			studentDetail.setResidence("enter parents Residence", null);
		}
		/*else if(firstInterFace.getRegisterStudent().studentclass.getSelectedItem()){
			//JComboBox cb= (JComboBox)e.getSource();
			//String passed=(String)cb.getSelectedItem();
		}
*/	}

}
