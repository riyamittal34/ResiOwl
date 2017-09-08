import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class AccountantPage extends JFrame {

	private JPanel contentPane;
	public String username;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AccountantPage frame = new AccountantPage();
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
	public AccountantPage(String username) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 663, 490);
		setLocationRelativeTo(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(5, 2, 0, 0));
		
		JButton btnEditProfile = new JButton("Edit profile");
		btnEditProfile.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				new EditProfile(username).setVisible(true);
			}
		});
		btnEditProfile.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(btnEditProfile);
		
		JButton btnCheckTransection = new JButton("Check Transection");
		btnCheckTransection.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				
				DBInfo1.getAllTransection();
				
				JFrame f=new JFrame();
				f.setSize(900, 500);
				f.setLocationRelativeTo(AccountantPage.this);
				JTable table=new JTable(DBInfo1.outer, DBInfo1.header);
				JScrollPane pane=new JScrollPane(table);
				f.getContentPane().add(pane);
				f.setVisible(true);
				
			}
		});
		btnCheckTransection.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(btnCheckTransection);
		
		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				new Deposit().setVisible(true);
				
			}
		});
		btnDeposit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(btnDeposit);
		
		JButton btnWithdraw = new JButton("Withdraw");
		btnWithdraw.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				new Withdraw().setVisible(true);
				
			}
		});
		
		JButton btnCheckBalance = new JButton("Check Balance");
		btnCheckBalance.addActionListener(new ActionListener()
		{
			
				public void actionPerformed(ActionEvent arg0)
				{
					String Query="select * from balance where username=?";
					
					try
					{
						PreparedStatement ps=DBInfo1.con.prepareStatement(Query);
						ps.setString(1, username);
						ResultSet rs=ps.executeQuery();
						
						while(rs.next())
						{
							String balance=rs.getString(3);
							JOptionPane.showMessageDialog(AccountantPage.this, "Your Balance is : "+balance, "Balance", JOptionPane.INFORMATION_MESSAGE);
							
						}
						
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					
			}
		});
		btnCheckBalance.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(btnCheckBalance);
		btnWithdraw.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(btnWithdraw);
		
		JButton btnCloseAccount = new JButton("Close Account");
		btnCloseAccount.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				new CloseAccount().setVisible(true);
			}
		});
		
		JButton btnTransferMoney = new JButton("Transfer Money");
		btnTransferMoney.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				new Transfer().setVisible(true);
				
			}
		});
		btnTransferMoney.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(btnTransferMoney);
		btnCloseAccount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(btnCloseAccount);
		
		JButton btnNewButton = new JButton("Search User");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				new SearchUser().setVisible(true);
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ReOpen Account");
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				new ReOpenAccount().setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Log Out");
		btnNewButton_2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				new LoginPage().setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(btnNewButton_2);
	}

}
