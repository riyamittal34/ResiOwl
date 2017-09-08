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
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Transfer extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Transfer frame = new Transfer();
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
		textField_3.setText(null);
		textField_4.setText(null);
		textField_5.setText(null);
		passwordField.setText(null);
		comboBox.setSelectedIndex(0);
		comboBox_1.setSelectedIndex(0);
		comboBox_2.setSelectedIndex(0);
		
	}
	
	
	
	
	/**
	 * Create the frame.
	 */
	public Transfer() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 536, 750);
		setLocationRelativeTo(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblPayment = new JLabel("Transfer");
		lblPayment.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblAccountNo = new JLabel("Account No");
		lblAccountNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblUsernamae = new JLabel("Username");
		lblUsernamae.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblPin = new JLabel("Pin");
		lblPin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblDistination = new JLabel("Transfer To Acc. No");
		lblDistination.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		passwordField = new JPasswordField();
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		JButton btnTransfer = new JButton("Transfer");
		btnTransfer.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				String accountno=textField.getText();
				String username=textField_1.getText();
				char ch[]=passwordField.getPassword();
				String password=String.copyValueOf(ch);
				String pin=textField_2.getText();
				String desAccountNo=textField_3.getText();
				String amount=textField_4.getText();
				String date=comboBox.getSelectedItem().toString();
				String month=comboBox_1.getSelectedItem().toString();
				String year=comboBox_2.getSelectedItem().toString();
				String desUsername=textField_5.getText();
				int m=0,n=0,l=0;
				String bal="";
				
				if(accountno.length()==0 || username.length()==0 || password.length()==0 || pin.length()==0 ||desAccountNo.length()==0 ||desUsername.length()==0 ||amount.length()==0 || date.equalsIgnoreCase("date")|| month.equalsIgnoreCase("month")|| year.equalsIgnoreCase("year"))
				{
					JOptionPane.showMessageDialog(Transfer.this, "Please fill all the fields", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					String query="select * from user where username=? and accountno=? and password=? and pin=?";
					try
					{
						PreparedStatement ps=DBInfo1.con.prepareStatement(query);
						ps.setString(1, username);
						ps.setString(2, accountno);
						ps.setString(3, password);
						ps.setString(4, pin);
						
						ResultSet res=ps.executeQuery();
						while(res.next())
						{
							m=1;
							
							String Query1="select * from user where accountno=? and username=?";
							
							PreparedStatement ps1=DBInfo1.con.prepareStatement(Query1);
							ps1.setString(1, desAccountNo);
							ps1.setString(2, desUsername);
							
							ResultSet rs=ps1.executeQuery();
							while(rs.next())
							{
								n=1;
								
								
								String Query2="select * from balance where username=? and accountno=?";
								
								PreparedStatement ps2=DBInfo1.con.prepareStatement(Query2);
								ps2.setString(1, username);
								ps2.setString(2, accountno);
								ResultSet r=ps2.executeQuery();
								while(r.next())
								{
									bal=r.getString(3);
									
									if(Double.parseDouble(bal)>=Double.parseDouble(amount))
									{
										l=1;
									}
									
								}
								
								
								
							}
							break;
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					if(m==0)
					{
						JOptionPane.showMessageDialog(Transfer.this, "Username or password is wrong!!", "Error", JOptionPane.ERROR_MESSAGE);	
					}
					
					if(l==1)
					{
						int i=DBInfo1.withdraw(accountno,username,date,month,year,amount);
						int j=DBInfo1.deposit(desAccountNo,desUsername,date,month,year,amount);
					
						
						if(i==1 && j==1)
						{
							JOptionPane.showMessageDialog(Transfer.this, "Transfer Completed!!", "Successful", JOptionPane.INFORMATION_MESSAGE);
							reset();
						}
						else
						{
							JOptionPane.showMessageDialog(Transfer.this, "Transfer Failed!!", "Error", JOptionPane.ERROR_MESSAGE);	
							passwordField.setText(null);
						}
					
						
						
					}	
					if(n==0)
					{
						JOptionPane.showMessageDialog(Transfer.this, "Destination username or password is wrong!!", "Error", JOptionPane.ERROR_MESSAGE);	
					}
					if(l==0)
					{
						JOptionPane.showMessageDialog(Transfer.this, "There is not enough balance in the account!!", "Error", JOptionPane.ERROR_MESSAGE);
					}
					
				}
			}
		});
		btnTransfer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				reset();
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				dispose();
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		comboBox = new JComboBox();
		comboBox.addItem("Date");
		for(int i=1;i<=31;i++)
		{
			comboBox.addItem(i);
		}
		
		comboBox_1 = new JComboBox();
		comboBox_1.addItem("Month");
		for(int i=1;i<=12;i++)
		{
			comboBox_1.addItem(i);
		}
		
		comboBox_2 = new JComboBox();
		comboBox_2.addItem("Year");
		for(int i=1900;i<=2100;i++)
		{
			comboBox_2.addItem(i);
		}
		
		JLabel lblDesUsername = new JLabel("Des. Username");
		lblDesUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(226)
							.addComponent(lblPayment))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(80)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblAccountNo)
								.addComponent(lblUsernamae)
								.addComponent(lblPassword)
								.addComponent(lblPin)
								.addComponent(lblDistination)
								.addComponent(btnTransfer, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDate)
								.addComponent(lblDesUsername)
								.addComponent(lblAmount))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(30)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(textField_3)
										.addComponent(textField_2)
										.addComponent(passwordField)
										.addComponent(textField_1)
										.addComponent(textField, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(comboBox_2, 0, 59, Short.MAX_VALUE))
										.addComponent(textField_5, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
										.addComponent(textField_4)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(19)
									.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnCancel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
					.addContainerGap(46, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(44)
					.addComponent(lblPayment)
					.addGap(60)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAccountNo)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsernamae)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(44)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPin)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDistination)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(52)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDesUsername)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(41)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAmount)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(55)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDate)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnTransfer)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnReset)
							.addComponent(btnCancel)))
					.addGap(29))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
