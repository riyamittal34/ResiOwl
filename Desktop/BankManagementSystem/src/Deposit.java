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
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Deposit extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	private JTextField textField_2;
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Deposit frame = new Deposit();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public void reset()
	{
		textField.setText(null);
		textField_1.setText(null);
		comboBox.setSelectedIndex(0);
		comboBox_1.setSelectedIndex(0);
		comboBox_2.setSelectedIndex(0);	
		textField_2.setText(null);
	}
	
	
	public Deposit() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 576, 541);
		setLocationRelativeTo(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblDeposit = new JLabel("Deposit");
		lblDeposit.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblAccountNo = new JLabel("Account No");
		lblAccountNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textField = new JTextField();
		textField.setColumns(10);
		
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
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				String accountno=textField.getText();
				String date=comboBox.getSelectedItem().toString();
				String month=comboBox_1.getSelectedItem().toString();
				String year=comboBox_2.getSelectedItem().toString();
				String amount=textField_1.getText();
				String username=textField_2.getText();
				
				if(accountno.length()==0 || date.length()==0 ||month.length()==0 || year.length()==0 ||amount.length()==0 || username.length()==0)
				{
					JOptionPane.showMessageDialog(Deposit.this, "Please fill all the fields!!", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else
				{	
					String Query="insert into deposit values(?,?,?,?,?)";
					int i=0;
					try
					{
						PreparedStatement ps=DBInfo1.con.prepareStatement(Query);
						ps.setString(1, accountno);
						ps.setString(2, date);
						ps.setString(3, month);
						ps.setString(4, year);
						ps.setString(5, amount);
						
						
						i=ps.executeUpdate();
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					if(i==1)
					{
						int j=0;
						
						String Query1="insert into transection values(?,?,?,?,?,?)";
						
						try
						{
							PreparedStatement ps=DBInfo1.con.prepareStatement(Query1);
							ps.setString(1, accountno);
							ps.setString(2, date);
							ps.setString(3, month);
							ps.setString(4, year);
							ps.setString(5, amount);
							ps.setString(6, "Deposit");
							
							j=ps.executeUpdate();
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
						
						
						if(j==1)
						{
							String Query2="select * from balance where accountno=?";
							String balance="";
							int k=0;
							try
							{
								PreparedStatement ps=DBInfo1.con.prepareStatement(Query2);
								ps.setString(1, accountno);
								
								ResultSet res=ps.executeQuery();
								
								while(res.next())
								{
									k=1;
									balance=res.getString(3);
									break;
								}
								
							}
							catch(Exception e)
							{
								e.printStackTrace();
							}
							
							if(k==1)
							{
								int l=0;
								String Query3="update balance set balance=? where accountno=? and username=?";
								balance=""+(Double.parseDouble(balance)+Double.parseDouble(amount));
								try
								{
									PreparedStatement ps=DBInfo1.con.prepareStatement(Query3);
									ps.setString(2, accountno);
									ps.setString(3, username);
									ps.setString(1, balance);
									
									
									l=ps.executeUpdate();
								}
								catch(Exception e)
								{
									e.printStackTrace();
								}
								
								if(l==1)
								{
									JOptionPane.showMessageDialog(Deposit.this, "Deposit Completed", "Successful", JOptionPane.INFORMATION_MESSAGE);
									dispose();
								}
							
							}
							
						}
						
					}
					else
					{
						JOptionPane.showMessageDialog(Deposit.this, "Deposit Failed", "Error", JOptionPane.ERROR_MESSAGE);
						
					}
				}
			
				
			}
		});
		btnDeposit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				reset();
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				dispose();
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(230)
							.addComponent(lblDeposit))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(86)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnDeposit, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblAccountNo)
										.addComponent(lblDate)
										.addComponent(lblAmount)
										.addComponent(lblUsername))
									.addGap(55)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(textField_2)
										.addComponent(textField_1)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(comboBox_2, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addComponent(textField, GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE))))))
					.addContainerGap(154, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(39)
					.addComponent(lblDeposit)
					.addGap(47)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAccountNo)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDate)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(41)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAmount)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(53)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsername)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDeposit)
						.addComponent(btnReset)
						.addComponent(btnCancel))
					.addGap(87))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
