import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class Registration extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	private JComboBox comboBox_3;
	private JComboBox comboBox_4;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Registration frame = new Registration();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	public void reset()
	{
		textField.setText(null);
		textField_1.setText(null);
		textField_2.setText(null);
		textField_3.setText(getAccountNo());
		textField_4.setText(null);
		textField_5.setText(null);
		comboBox.setSelectedIndex(0);
		comboBox_1.setSelectedIndex(0);
		comboBox_2.setSelectedIndex(0);
		comboBox_3.setSelectedIndex(0);
		comboBox_4.setSelectedIndex(0);
		passwordField.setText(null);
		passwordField_1.setText(null);
	}
	
	public String getAccountNo()
	{
		String id="";
		for(int i=1;i<=9;i++)
		{
			id+=(int)(Math.random()*9)+1;	
		}
		
		return id;
	}
	
	
	/**
	 * Create the frame.
	 */
	public Registration() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 510, 842);
		setLocationRelativeTo(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblDob = new JLabel("DOB");
		lblDob.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblPin = new JLabel("Pin");
		lblPin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblAccountNo = new JLabel("Account No");
		lblAccountNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblContactNo = new JLabel("Contact No");
		lblContactNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblRepassword = new JLabel("Re-Password");
		lblRepassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				String name=textField.getText();
				String username=textField_1.getText();
				char ch[]=passwordField.getPassword();
				String password=String.copyValueOf(ch);
				char ch1[]=passwordField_1.getPassword();
				String repass=String.copyValueOf(ch1);
				String date=comboBox.getSelectedItem().toString();
				String month=comboBox_2.getSelectedItem().toString();
				String year=comboBox_1.getSelectedItem().toString();
				String gender=comboBox_3.getSelectedItem().toString();
				String pin=textField_2.getText();
				String accountno=textField_3.getText();
				String contactno=textField_4.getText();
				String address=textField_5.getText();
				String usertype=comboBox_4.getSelectedItem().toString();
				int i=0;
				
				if(name.length()==0 || username.length()==0 || password.length()==0 || repass.length()==0 || date.length()==0 || month.length()==0 || year.length()==0 || gender.length()==0 || pin.length()==0 || accountno.length()==0 || contactno.length()==0 || address.length()==0 || usertype.equalsIgnoreCase("Select"))
				{
					JOptionPane.showMessageDialog(Registration.this, "Please fill all the fields!!", "Error", JOptionPane.ERROR_MESSAGE);
					passwordField.setText(null);
					passwordField_1.setText(null);
				}
				else
				{
					if(!password.equals(repass))
					{
						JOptionPane.showMessageDialog(Registration.this, "Password and Re-Password Don't match!!", "Error", JOptionPane.ERROR_MESSAGE);
						passwordField.setText(null);
						passwordField_1.setText(null);
					}
					else
					{
						String Query="insert into user values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
						try
						{
							PreparedStatement ps=DBInfo1.con.prepareStatement(Query);
							ps.setString(1, name);
							ps.setString(2, username);
							ps.setString(3, password);
							ps.setString(4, date);
							ps.setString(5, month);
							ps.setString(6, year);
							ps.setString(7, gender);
							ps.setString(8, pin);
							ps.setString(9, accountno);
							ps.setString(10, contactno);
							ps.setString(11, address);
							ps.setString(12, usertype);
							ps.setString(13, "open");
							
							i=ps.executeUpdate();
						}
						catch(Exception ea)
						{
							ea.printStackTrace();
						}
						
						
						if(i==1)
						{
							JOptionPane.showMessageDialog(Registration.this, "Record inserted", "Successful", JOptionPane.INFORMATION_MESSAGE);
							DBInfo1.loginValue(username,password,usertype);
							DBInfo1.setBalance(accountno,username);
							reset();		
						}
						else
						{
							JOptionPane.showMessageDialog(Registration.this, "Insertion Filed!!", "Error", JOptionPane.ERROR_MESSAGE);
							passwordField.setText(null);
							passwordField_1.setText(null);
						}
					}
				}
			}
		});
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				reset();
			}
		});
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		passwordField = new JPasswordField();
		
		passwordField_1 = new JPasswordField();
		
		comboBox = new JComboBox();
		comboBox.addItem("Date");
		for(int i=1;i<=31;i++)
		{
			comboBox.addItem(i);
		}
		
		comboBox_2 = new JComboBox();
		comboBox_2.addItem("Month");
		for(int i=1;i<=12;i++)
		{
			comboBox_2.addItem(i);
		}
		
		comboBox_1 = new JComboBox();
		comboBox_1.addItem("Year");
		for(int i=1900;i<=2100;i++)
		{
			comboBox_1.addItem(i);
		}
		
		comboBox_3 = new JComboBox();
		comboBox_3.addItem("Select");
		comboBox_3.addItem("Male");
		comboBox_3.addItem("Female");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setText(getAccountNo());
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		JLabel lblUserType = new JLabel("User Type");
		lblUserType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		comboBox_4 = new JComboBox();
		comboBox_4.addItem("Select");
		comboBox_4.addItem("Accoutant");
		comboBox_4.addItem("User");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(81)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnRegister, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblUserType)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblAddress)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblContactNo)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblUsername)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblRepassword)
							.addContainerGap())
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblPassword)
								.addContainerGap())
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblDob)
									.addContainerGap())
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblPin)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblGender)
												.addComponent(lblNewLabel)
												.addComponent(lblAccountNo))
											.addGap(58)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_contentPane.createSequentialGroup()
															.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
															.addGap(18)
															.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
															.addPreferredGap(ComponentPlacement.UNRELATED)
															.addComponent(comboBox_1, 0, 68, Short.MAX_VALUE))
														.addComponent(passwordField, 221, 221, 221)
														.addComponent(passwordField_1, 221, 221, 221)
														.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
															.addComponent(textField, Alignment.LEADING)
															.addComponent(textField_1, Alignment.LEADING, 221, 221, Short.MAX_VALUE))
														.addComponent(comboBox_3, 0, 227, Short.MAX_VALUE)
														.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
														.addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
														.addComponent(textField_5, GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
														.addGroup(gl_contentPane.createSequentialGroup()
															.addGap(117)
															.addComponent(btnReset, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
														.addComponent(comboBox_4, 0, 227, Short.MAX_VALUE))
													.addPreferredGap(ComponentPlacement.RELATED)))))
									.addGap(43))))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(66)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(46)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsername)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(44)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRepassword)
						.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(43)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDob)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(42)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGender)
						.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPin)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAccountNo)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblContactNo)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(43)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAddress)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(49)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUserType)
						.addComponent(comboBox_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnRegister)
						.addComponent(btnReset))
					.addGap(28))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
