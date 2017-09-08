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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Transfer1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Transfer1 frame = new Transfer1();
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
			comboBox.setSelectedIndex(0);
			comboBox_1.setSelectedIndex(0);
			comboBox_2.setSelectedIndex(0);
			
		}
	
	
	
	
	/**
	 * Create the frame.
	 */
	public Transfer1(String username, String accountno, String pin, String password) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 492, 483);
		setLocationRelativeTo(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblTransferMoney = new JLabel("Transfer Money");
		lblTransferMoney.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblAccountNo = new JLabel("Account No");
		lblAccountNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblUsename = new JLabel("Usename");
		lblUsename.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblAmount = new JLabel("Date");
		lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblAmount_1 = new JLabel("Amount");
		lblAmount_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
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
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JButton btnTransfer = new JButton("Transfer");
		btnTransfer.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				String bal="";
				String desAccountno=textField.getText();
				String desUsername=textField_1.getText();
				String amount=textField_2.getText();
				String date=comboBox.getSelectedItem().toString();
				String month=comboBox_1.getSelectedItem().toString();
				String year=comboBox_2.getSelectedItem().toString();
				int i=0,j=0;
				
				if(desAccountno.length()==0 || desUsername.length()==0 || amount.length()==0 || date.equalsIgnoreCase("date") || month.equalsIgnoreCase("month") || year.equalsIgnoreCase("year"))
				{
					JOptionPane.showMessageDialog(Transfer1.this, "Please fill all the fields!!", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					String Query="select * from balance where username=? and accountno=?";
					try
					{
						PreparedStatement ps=DBInfo1.con.prepareStatement(Query);
						ps.setString(1, username);
						ps.setString(2, accountno);
						
						ResultSet res=ps.executeQuery();
						while(res.next())
						{
							bal=res.getString(3);
							
							if(Double.parseDouble(bal)>=Double.parseDouble(amount))
								i=1;											
							break;
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					
					
					if(i==1)
					{
						String Query1="select * from user where username=? and accountno=?";
						
						try
						{
							PreparedStatement ps=DBInfo1.con.prepareStatement(Query1);
							ps.setString(1, desUsername);
							ps.setString(2, desAccountno);
							
							ResultSet res=ps.executeQuery();
							while(res.next())
							{
								j=1;
								break;
							}
							
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
					}
					else
					{
						JOptionPane.showMessageDialog(Transfer1.this, "There is not enough balance in your account!!", "Error", JOptionPane.ERROR_MESSAGE);
					}
					
					if(j==1)
					{
						
						
						int m=DBInfo1.withdraw(accountno,username,date,month,year,amount);
						int n=DBInfo1.deposit(desAccountno,desUsername,date,month,year,amount);
					
						
						if(m==1 && n==1)
						{
							JOptionPane.showMessageDialog(Transfer1.this, "Transfer Completed!!", "Successful", JOptionPane.INFORMATION_MESSAGE);
							reset();
						}
						else
						{
							JOptionPane.showMessageDialog(Transfer1.this, "Transfer Failed!!", "Error", JOptionPane.ERROR_MESSAGE);	
						}
					}
					else
					{
						JOptionPane.showMessageDialog(Transfer1.this, "Destination Username or Password is wrong!!", "Error", JOptionPane.ERROR_MESSAGE);
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
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(169)
					.addComponent(lblTransferMoney)
					.addContainerGap(169, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(65)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnTransfer, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnCancel, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblAccountNo)
								.addComponent(lblUsename)
								.addComponent(lblAmount)
								.addComponent(lblAmount_1))
							.addGap(62)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_2)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(comboBox_2, 0, 55, Short.MAX_VALUE))
								.addComponent(textField_1)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE))))
					.addGap(43))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(37)
					.addComponent(lblTransferMoney)
					.addGap(72)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAccountNo)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsename)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAmount)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(49)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAmount_1)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnTransfer)
						.addComponent(btnReset)
						.addComponent(btnCancel))
					.addGap(34))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
