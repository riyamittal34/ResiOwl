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

public class HomePage extends JFrame {

	private JPanel contentPane;
	public String username;

	/**
	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					HomePage frame = new HomePage();
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
	public HomePage(String username) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 577, 421);
		setLocationRelativeTo(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 2, 0, 0));
		
		JButton btnEditProfile = new JButton("Edit Profile");
		btnEditProfile.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				new EditProfile(username).setVisible(true);
			}
		});
		btnEditProfile.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(btnEditProfile);
		
		JButton btnNewButton = new JButton("Check Transection");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				DBInfo1.getTransection(username);
				
				JFrame f=new JFrame();
				f.setSize(900, 500);
				f.setLocationRelativeTo(f);
				JTable table=new JTable(DBInfo1.outer, DBInfo1.header);
				JScrollPane pane=new JScrollPane(table);
				f.getContentPane().add(pane);
				f.setVisible(true);
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(btnNewButton);
		
		JButton btnPayment = new JButton("Transfer");
		btnPayment.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				
				String accountno="";
				String pin="";
				String password="";
				
				String Query="select * from user where username=?";
				
				try
				{
					PreparedStatement ps=DBInfo1.con.prepareStatement(Query);
					ps.setString(1, username);
					ResultSet res=ps.executeQuery();
					
					while(res.next())
					{
						accountno=res.getString(9);
						pin=res.getString(8);
						password=res.getString(3);
						
						
						new Transfer1(username, accountno, pin, password).setVisible(true);
						
						
						break;
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				
				
				
				
			}
		});
		btnPayment.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(btnPayment);
		
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
						JOptionPane.showMessageDialog(HomePage.this, "Your Balance is : "+balance, "Balance", JOptionPane.INFORMATION_MESSAGE);
						
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
		
		JButton btnNewButton_1 = new JButton("Log Out");
		btnNewButton_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				new LoginPage().setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(btnNewButton_1);
	}

}
