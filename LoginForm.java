import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class LoginForm extends Frame implements ActionListener {
	
	List listPlayer = new List(6);
	Label title = new Label("Register new player");
	Button submit = new Button("Submit");
	Button count = new Button("Count");
	Label name = new Label("User Name");
	Label pass = new Label("password");
	
	TextField Tname = new TextField(20);
	TextField Tpass = new TextField(20);
	TextField TCount = new TextField(20);
	Label Message = new Label("");
	Label lblamount = new Label("Amount player");
	Label lbllist = new Label("List of Player");


	public LoginForm() {
		
		title.setBounds(180, 30, 200, 20);
		add(title);
		
		name.setBounds(20,70,100,30);
		add(name);
		Tname.setBounds(180,70,200,30);
		add(Tname);
		
		pass.setBounds(20,95,100,30);
		add(pass);
		Tpass.setBounds(180,95,200,30);
		add(Tpass);
		
		submit.setBounds(180,145,70,20);
		add(submit);
		
		count.setBounds(260,145,100,20);
		add(count);
		
		lblamount.setBounds(20, 180, 100, 20);
		add(lblamount);
		TCount.setBounds(180, 180, 70, 20);
		add(TCount);
		
		lbllist.setBounds(20, 250, 100, 20);
		add(lbllist);
		listPlayer.setBounds(180, 250, 200, 100);
		add(listPlayer);
		
		Message.setBounds(20, 300, 200, 50);
		add(Message);
		Message.setForeground(Color.red);
		Tpass.setEchoChar('*');
		submit.addActionListener(this);
		count.addActionListener(this);
		addWindowListener(new windowA());
		

	}

	public void actionPerformed(ActionEvent e)
	{ 
		Object obj = e.getSource();

		Message.setText("");
		TCount.setText("");
		if(obj == submit)
			addPlayer();
		if(obj == count)
			displayPlayerCount();
	}
	
	
	public void addPlayer()
	{
		//add string
		String strAdd = new String(Tname.getText());
		
		if(strAdd.compareTo("")== 0)
		{
			Message.setText("Enter player to add");
			Tname.requestFocus();
		}
		else{
			//see player already have on the list
			boolean blnFound = findDuplicate(strAdd);
			if(blnFound){
				//already in  list
				Message.setText("Duplicate Player");
			}
			else{
				listPlayer.add(strAdd);
				Tname.setText("");
				Tpass.setText("");
			}
		}
	}
	
	public boolean findDuplicate(String strFind){
		
		boolean blnItemFound = false;
		int intItemIndex = 0;
		int intNumberPlayer = listPlayer.getItemCount();
		String strListElement;
		
		while(!blnItemFound && intItemIndex < intNumberPlayer){
			strListElement = listPlayer.getItem(intItemIndex++);
			if(strFind.equalsIgnoreCase(strListElement))
				blnItemFound = true;
		}
		
		return blnItemFound;
	}
	
	public void displayPlayerCount()
	{
		String strCount;
		strCount = new String(""+listPlayer.getItemCount());
		TCount.setText(strCount);
	}

	public static void main(String s[])
	{
		LoginForm loginTitle=new LoginForm();
		loginTitle.setSize(new Dimension(600,600));
		loginTitle.setTitle("Register Player Login");
		loginTitle.setVisible(true);

	}
}
class windowA extends WindowAdapter
{ 
	public windowA(){

	}
	public void windowClosing(WindowEvent e)
	{ 
		System.exit(0);
	}
}


