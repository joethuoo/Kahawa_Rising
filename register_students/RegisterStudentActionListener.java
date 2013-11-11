package register_students;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterStudentActionListener implements ActionListener {
	private FirstInterFace firstInterFace;

	
	public RegisterStudentActionListener(FirstInterFace firstInterFace) {
		super();
		this.firstInterFace = firstInterFace;
	}


	@Override
	public void actionPerformed(ActionEvent f) {
		// TODO Auto-generated method stub
		firstInterFace.getRegisterStudent().setVisible(true);
	}

}
