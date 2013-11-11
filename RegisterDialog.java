package register_login;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.sql.Array;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class RegisterDialog extends JDialog {

	private MainFrame frame;
	private JLabel information;
	private JTextField fname;
	private JTextField Mname;
	private JTextField surname;
	private JTextField idNum;
	private JTextField phoneNum;
	//private JTextField address;
	private JCheckBox male,female;
	private JButton submit;
	private JPasswordField password;
	
	
	public RegisterDialog(MainFrame frame){
		
		//set properties of registerDialog
		this.setTitle("Staff Registration");
		this.setSize(800,600);
		this.setLocation(250,75);
		this.setResizable(false);
		this.setVisible(false);
		this.setLayout(new BorderLayout());
		
		
		//set up properties of form
		information = new JLabel("Enter All the Details:", JLabel.CENTER);
		JPanel middlePanel = new JPanel(new GridLayout(8,1));
		JLabel field1 = new JLabel("First Name:");
		JLabel field2 = new JLabel("Middle Name:");
		JLabel field3 = new JLabel("Surname:");
		JLabel field4 = new JLabel ("Id Number");
		JLabel field5 = new JLabel("Phone Number:");
		JLabel field6 = new JLabel("Gender:");
		JLabel field7 = new JLabel("Password");
		
		fname = new JTextField(25);
		fname.setBorder(BorderFactory.createBevelBorder(1));
		Mname = new JTextField(25);
		Mname.setBorder(BorderFactory.createBevelBorder(1));
		idNum = new JTextField(25);
		idNum.setBorder(BorderFactory.createBevelBorder(1));
		//address= new JTextField(25);
		//address.setBorder(BorderFactory.createBevelBorder(1));
		phoneNum = new JTextField(25);
		phoneNum.setBorder(BorderFactory.createBevelBorder(1));
		male = new JCheckBox();
		male.setBorder(BorderFactory.createBevelBorder(1));
		female=new JCheckBox();
		female.setBorder(BorderFactory.createBevelBorder(1));
		surname = new JTextField(25);
		surname.setBorder(BorderFactory.createBevelBorder(1));
		password= new JPasswordField(25);
		password.setBorder(BorderFactory.createBevelBorder(1));
		
		//create JPanels and add textFields to them
		JPanel fieldPanel1 = new JPanel(new FlowLayout());
		JPanel fieldPanel2 = new JPanel(new FlowLayout());
		JPanel fieldPanel3 = new JPanel(new FlowLayout());
		JPanel fieldPanel4 = new JPanel(new FlowLayout());
		JPanel fieldPanel5 = new JPanel(new FlowLayout());
		JPanel fieldPanel6 = new JPanel(new FlowLayout());
		JPanel fieldPanel7= new JPanel(new FlowLayout());
		
		fieldPanel1.add(field1);
		fieldPanel1.add(fname);
		fieldPanel2.add(field2);
		fieldPanel2.add(Mname);
		fieldPanel3.add(field3);
		fieldPanel3.add(surname);
		
		fieldPanel4.add(field6);
		fieldPanel4.add(male);
		fieldPanel4.add(female);
		
		fieldPanel5.add(field4);
		fieldPanel5.add(idNum);
		fieldPanel6.add(field5);
		fieldPanel6.add(phoneNum);
		fieldPanel7.add(field7);
		fieldPanel7.add(password);
		
		//add textfield panels to middlepanel
		middlePanel.add(information);
		middlePanel.add(fieldPanel1);
		middlePanel.add(fieldPanel2);
		middlePanel.add(fieldPanel3);
		middlePanel.add(fieldPanel4);
		middlePanel.add(fieldPanel5);
		middlePanel.add(fieldPanel6);
		middlePanel.add(fieldPanel7);
		
		//create panel of buttons and add the buttons to it
		JPanel buttonPanel = new JPanel();
		submit = new JButton("submit!");
		submit.setPreferredSize(new Dimension(150,50));
		buttonPanel.add(submit);
				
		
		//Add all the panels on the dialog window
		this.add(middlePanel, BorderLayout.CENTER);
		this.add(buttonPanel, BorderLayout.SOUTH);
		
		//add welcome action listener for the button here
		submit.addActionListener(new SubmitActionListener(frame));
		
		
	}

	//getter  methods for all textfields

	public JLabel getInformation() {
		return information;
	}
	//set method for putting infor in the textfields 
	public void setInformation(String message) {
		information.setText(message);
		information.setForeground(Color.RED);
	}	
	
	//getter and setter methods for the fields
	public void setFname(String message){
		fname.setText(message);
	}
	public String getFname() {
		return fname.getText();
	}
	
	public void setMname(String message){
		Mname.setText(message);
	}
	public String getMname() {
		return Mname.getText();
	}
	
	public void setSurname(String message){
		surname.setText(message);
	}

	public String getSurname() {
		return surname.getText();
	}
	
	public void setPhoneNum(String message){
		phoneNum.setText(message);
	}
	public String getPhoneNum(){
		return phoneNum.getText();
	}
	
	public void setIdNum(String message){
		idNum.setText(message);
	}

	public String getIdNum() {
		return idNum.getText();
	}
	public void setRegPassword(String message){
		password.setText(message);
	}
	public String getRegPassword() {
		return password.getText();
	}

	
}
