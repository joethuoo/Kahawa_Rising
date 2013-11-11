package register_students;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class RegisterStudentDialog extends JDialog {
	//private StudentDetail studentDetail;
	
	public  static JLabel registerstudent,parent;
	public  static JTextField sname,pfname;
	private static JTextField sMname,pMname;
	private static JTextField ssurname,psurname;
	public  JRadioButton smale,sfemale;
	private static ButtonGroup sgroup;
	private static JComboBox<String[]> studentclass,term;
	private static JLabel contacts_address;
	private static JTextField phonenumber;
	private static JTextField email;
	private static JTextField residence;
	private static JButton submit,update,cancel;

	
	public RegisterStudentDialog() {
		// TODO Auto-generated constructor stub
		
		//setting up properites for the dialog.
		this.setTitle("REGISTER STUDENTS");
		this.setSize(800, 600);
		this.setLocation(250,75);
		this.setResizable(true);
		//this.setLayout(new BorderLayout());
		
		//setting properties for the student form
		registerstudent= new JLabel("REGISTER STUDENT",JLabel.CENTER);
		JPanel studentPanel= new JPanel(new GridLayout(18,1));
		JLabel field1 = new JLabel(" Student First Name:");
		JLabel field2 = new JLabel(" Student Middle Name:");
		JLabel field3 = new JLabel("Student Surname:");
		JLabel field4 = new JLabel("Gender");
		JLabel field5 = new JLabel("Class");
		JLabel field6 = new JLabel("Term");
		
         /*initializing the textfields for student and settinfg the borderlayout and also am
		 adding the radiobuttons to the buttongroup.*/
		
		sname= new JTextField(25);
		sname.setBorder(BorderFactory.createBevelBorder(1));
		
		sMname= new JTextField(25);
		sMname.setBorder(BorderFactory.createBevelBorder(1));
		
		ssurname= new JTextField(25);
		ssurname.setBorder(BorderFactory.createBevelBorder(1));
		
		
		//created radio buttons and added them to a ButtonGroup
		sfemale=new JRadioButton("female",false);
		sfemale.setBorder(BorderFactory.createBevelBorder(1));
		sgroup= new ButtonGroup();
		sgroup.add(sfemale);
		
		smale=new JRadioButton("male",true);
		smale.setBorder(BorderFactory.createBevelBorder(1));
		sgroup.add(smale);
		
		//here the combobox will used to select the class
		studentclass= new JComboBox<String[]>();
		studentclass.setBorder(BorderFactory.createBevelBorder(1));
		 String[] classes={"Baby Class","Pre Unit","Nursery"}; 
		 studentclass.addItem(classes);
		 
		//here the combobox will used for selecting the terms.
		term = new JComboBox<String[]>();
		//term.setBorder(BorderFactory.createBevelBorder(1));
		String[] careeryear={"Term One","Term Two","Term Three"};
		term.addItem(careeryear);
		
		//setting panels with flowlayout for the students form properties and fields.
		JPanel panel1 = new JPanel(new FlowLayout());
		JPanel panel2 = new JPanel(new FlowLayout());
		JPanel panel3 = new JPanel(new FlowLayout());
		JPanel panel4 = new JPanel(new FlowLayout());
		JPanel panel5 = new JPanel(new FlowLayout());
		JPanel panel6 = new JPanel(new FlowLayout());
		
		//add all properties and textField to the panels
	
		panel1.add(field1);
		panel1.add(sname);
		
		panel2.add(field2);
		panel2.add(sMname);
		
		panel3.add(field3);
		panel3.add(ssurname);
		
		panel4.add(field4);
	    panel4.add(smale);
	    panel4.add(sfemale);
		
		panel5.add(field5);
		panel5.add(studentclass);
		
		panel6.add(field6);
		panel6.add(term);
		
		
		//add all panels from the REGISTER STUDENT compatment with propeties and fields to GridLayout
		studentPanel.add(registerstudent);
		studentPanel.add(panel1);
		studentPanel.add(panel2);
		studentPanel.add(panel3);
		studentPanel.add(panel4);
		studentPanel.add(panel5);
		studentPanel.add(panel6);
		
		//set listener for male and female JRadiobutton
		
  
		//setting up the properties for the Parent/Guardian compatment
		parent= new JLabel("PARENT/GUARDIAN",JLabel.CENTER);
		JLabel prop1 = new JLabel("Parent First Name:");
		JLabel prop2 = new JLabel("Parent Middle Name:");
		JLabel prop3 = new JLabel("Parent Surname:");
		
		//initialize fields for the parent/guardian set borderLayout
		pfname= new JTextField(20);
		pfname.setBorder(BorderFactory.createBevelBorder(1));
		
		pMname= new JTextField(20);
		pMname.setBorder(BorderFactory.createBevelBorder(1));
		
		psurname= new JTextField(20);
		psurname.setBorder(BorderFactory.createBevelBorder(1));
		
		//set panel with a flow layout for both property and fields
		JPanel p1 = new JPanel(new FlowLayout());
		JPanel p2 = new JPanel(new FlowLayout());
		JPanel p3 = new JPanel(new FlowLayout());
		
		//add property and fields to the panels
		p1.add(prop1);
		p1.add(pfname);
		p2.add(prop2);
		p2.add(pMname);
		p3.add(prop3);
		p3.add(psurname);
		
		//Now adding the Parents && Guardian panels to the GridLayout
		studentPanel.add(parent);
		studentPanel.add(p1);
		studentPanel.add(p2);
		studentPanel.add(p3);

      //setting proprties for the Contacts form
		contacts_address= new JLabel("CONTACTS AND ADDRESS",JLabel.CENTER);
		JLabel label1= new JLabel("Phone Number:");
		JLabel label2= new JLabel("Email:");
		JLabel label3= new JLabel("Residence:");
		
		//initialize the fields and set borderlayout for the contacts form 
		phonenumber= new JTextField(20);
		phonenumber.setBorder(BorderFactory.createBevelBorder(1));
		email= new JTextField(20);
		email.setBorder(BorderFactory.createBevelBorder(1));
		residence= new JTextField(20);
		residence.setBorder(BorderFactory.createBevelBorder(1));
		
		//setting up panels for property and fields for Contacts and address.
		JPanel  cpanel= new JPanel(new FlowLayout());
		JPanel  cpane2= new JPanel(new FlowLayout());
		JPanel  cpane3 = new JPanel(new FlowLayout());
		
		//add property and fields for Contacts and address to panel
		cpanel.add(label1);
		cpanel.add(phonenumber);
		cpane2.add(label2);
		cpane2.add(email);
		cpane3.add(label3);
		cpane3.add(residence);
		
		//Now adding the panels to the GridLayout
		studentPanel.add(contacts_address);
		studentPanel.add(cpanel);
		studentPanel.add(cpane2);
		studentPanel.add(cpane3);
		
		//create panel of button and add the buttons to it
				JPanel buttonPane = new JPanel(new FlowLayout());
				submit = new JButton("Submit!");
				submit.setPreferredSize(new Dimension(150,50));
				buttonPane.add(submit);
				
				
				update= new JButton("Update");
				update.setPreferredSize(new Dimension(150, 50));
				buttonPane.add(update);
				
				cancel= new JButton("Cancel");
				cancel.setPreferredSize(new Dimension(150, 50));
				buttonPane.add(cancel);
				
				//Add all the panels on the dialog window
				this.add(studentPanel, BorderLayout.CENTER);
				this.add(buttonPane, BorderLayout.SOUTH);
			    
				this.setVisible(true);
				
				//adding an action listener for the button here
				submit.addActionListener(new SubmitStudentRegisterListener());
	}
	/*public static void main(String []args){
		 new RegisterStudentDialog(); 
	}*/
	
}
