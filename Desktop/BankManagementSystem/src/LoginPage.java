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
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginPage() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 511, 423);
		setLocationRelativeTo(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.addFocusListener(new FocusAdapter()
		{
			    public void focusLost(FocusEvent arg0) 
				{
					String uname=textField.getText();
					char ch[]=passwordField.getPassword();
					String pass=String.copyValueOf(ch);
					String utype=null;
					String accountStatus=null;
					int i=0;
					String Query="select * from Login where username=? and password=?";
					try
					{
						PreparedStatement ps=DBInfo1.con.prepareStatement(Query);
						ps.setString(1, uname);
						ps.setString(2, pass);
						
						ResultSet res=ps.executeQuery();
						if(res.next())
						{
							i=1;
							utype=res.getString(3);
							accountStatus=res.getString(4);
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					
					if(i==1 && utype.equalsIgnoreCase("user") )
					{
						if(accountStatus.equalsIgnoreCase("open"))
						{
							new HomePage(uname).setVisible(true);
							dispose();
						}
						else
						{
							
							JOptionPane.showMessageDialog(LoginPage.this, "Account Is Closed!!", "Error", JOptionPane.ERROR_MESSAGE);
							textField.setText(null);
							passwordField.setText(null);
						}
						
					}
					
					
					
					else if(i==1 && utype.equalsIgnoreCase("accountant"))
					{
						if(accountStatus.equalsIgnoreCase("open"))
						{
							new AccountantPage(uname).setVisible(true);
							dispose();
						}
						else
						{
							
							JOptionPane.showMessageDialog(LoginPage.this, "Account Is Closed!!", "Error", JOptionPane.ERROR_MESSAGE);
							textField.setText(null);
							passwordField.setText(null);
						}
					}
					else
					{
						JOptionPane.showMessageDialog(LoginPage.this, "Username or password are incorrect!!!", "Error", JOptionPane.ERROR_MESSAGE);
						textField.setText(null);
						passwordField.setText(null);
					}
					
					
				}
			});
		
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				String uname=textField.getText();
				char ch[]=passwordField.getPassword();
				String pass=String.copyValueOf(ch);
				String utype=null;
				String accountStatus=null;
				int i=0;
				String Query="select * from Login where username=? and password=?";
				try
				{
					PreparedStatement ps=DBInfo1.con.prepareStatement(Query);
					ps.setString(1, uname);
					ps.setString(2, pass);
					
					ResultSet res=ps.executeQuery();
					if(res.next())
					{
						i=1;
						utype=res.getString(3);
						accountStatus=res.getString(4);
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				if(i==1 && utype.equalsIgnoreCase("user") )
				{
					if(accountStatus.equalsIgnoreCase("open"))
					{
						new HomePage(uname).setVisible(true);
						dispose();
					}
					else
					{
						
						JOptionPane.showMessageDialog(LoginPage.this, "Account Is Closed!!", "Error", JOptionPane.ERROR_MESSAGE);
						textField.setText(null);
						passwordField.setText(null);
					}
					
				}
				
				
				
				else if(i==1 && utype.equalsIgnoreCase("accountant"))
				{
					if(accountStatus.equalsIgnoreCase("open"))
					{
						new AccountantPage(uname).setVisible(true);
						dispose();
					}
					else
					{
						
						JOptionPane.showMessageDialog(LoginPage.this, "Account Is Closed!!", "Error", JOptionPane.ERROR_MESSAGE);
						textField.setText(null);
						passwordField.setText(null);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(LoginPage.this, "Username or password are incorrect!!!", "Error", JOptionPane.ERROR_MESSAGE);
					textField.setText(null);
					passwordField.setText(null);
				}
				
				
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				textField.setText(null);
				passwordField.setText(null);
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				new Registration().setVisible(true);
				dispose();
			}
		});
		btnSignUp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(221, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addGap(216))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(78)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblUsername)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
									.addGap(14)
									.addComponent(btnSignUp, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblPassword)
									.addGap(67)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
										.addComponent(textField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE))))
							.addGap(72))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(51)
					.addComponent(lblNewLabel)
					.addGap(67)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsername)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(41)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(69)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnReset, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnSignUp, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnLogin, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(47))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
