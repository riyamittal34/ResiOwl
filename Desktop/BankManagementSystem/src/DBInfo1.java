import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;

import javax.swing.JOptionPane;




public class DBInfo1 
{
	
	
	static Vector<String> header;
	static Vector<Vector<String>> outer;
	static Connection con;
	static
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			//System.out.println("drivers Loaded");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem","root","riya");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public static void loginValue(String username, String password, String usertype) 
	{
		String Query="insert into login values(?,?,?,?)";
		
		try
		{
			PreparedStatement ps=con.prepareStatement(Query);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, usertype);
			ps.setString(4, "open");
			
			ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public static void updateLogin(String pass, String Username) 
	{
		String Query="update login set password=? where username=?";
		
		try
		{
			PreparedStatement ps=con.prepareStatement(Query);
			ps.setString(1, pass);
			ps.setString(2, Username);
			
			ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void setBalance(String accountno, String username)
	{
		String Query="insert into balance values(?,?,?)";
		
		try
		{
			PreparedStatement ps=con.prepareStatement(Query);
			ps.setString(1, accountno);
			ps.setString(2, username);
			ps.setString(3, "0");
			
			ps.executeUpdate();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public static void getAllTransection()
	{
		header=new Vector<>();
		outer= new Vector<>();
		
		String Query="select * from transection";
		
		try
		{
			PreparedStatement ps=con.prepareStatement(Query);
			ResultSet res=ps.executeQuery();
			ResultSetMetaData rsmd=res.getMetaData();
			int colCount=rsmd.getColumnCount();
			for(int i=1;i<=colCount;i++)
			{
				header.add(rsmd.getColumnName(i));
			}
			
			while(res.next())
			{
				Vector<String> record=new Vector<>();
				for(int i=1;i<=colCount;i++)
				{
					record.add(res.getString(i));
				}
				outer.add(record);				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	public static void getTransection(String username)
	{
		header=new Vector<>();
		outer= new Vector<>();
		String accountno="";
		
		String Query1="select accountno from user where username=?";
		try
		{
			PreparedStatement ps=con.prepareStatement(Query1);
			ps.setString(1, username);
			ResultSet r=ps.executeQuery();
			while(r.next())
			{
				accountno=r.getString(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		String Query="select * from transection where accountno=?";
		
		try
		{
			PreparedStatement ps=con.prepareStatement(Query);
			ps.setString(1, accountno);
			ResultSet res=ps.executeQuery();
			ResultSetMetaData rsmd=res.getMetaData();
			int colCount=rsmd.getColumnCount();
			for(int i=1;i<=colCount;i++)
			{
				header.add(rsmd.getColumnName(i));
			}
			
			while(res.next())
			{
				Vector<String> record=new Vector<>();
				for(int i=1;i<=colCount;i++)
				{
					record.add(res.getString(i));
				}
				outer.add(record);				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	public static void searchBy(String searchBy, String value) 
	{
		String Query="select * from user where "+searchBy+"=?";
		header=new Vector<>();
		outer=new Vector<>();
		
		try
		{
			PreparedStatement ps=con.prepareStatement(Query);
			ps.setString(1, value);
			ResultSet res=ps.executeQuery();
			ResultSetMetaData rsmd=res.getMetaData();
			int colCount=rsmd.getColumnCount();
			for(int i=1;i<=colCount;i++)
			{
				header.add(rsmd.getColumnName(i));
			}
			
			while(res.next())
			{
				Vector<String> record=new Vector<>();
				for(int i=1;i<=colCount;i++)
				{
					record.add(res.getString(i));
				}
				outer.add(record);				
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	
	
	public static int withdraw(String accountno, String username, String date, String month, String year, String amount)
	{
		
		String Query="insert into withdraw values(?,?,?,?,?)";
		int i=0,j=0,k=0,l=0;
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
			
			
			String Query1="insert into transection values(?,?,?,?,?,?)";
			
			try
			{
				PreparedStatement ps=DBInfo1.con.prepareStatement(Query1);
				ps.setString(1, accountno);
				ps.setString(2, date);
				ps.setString(3, month);
				ps.setString(4, year);
				ps.setString(5, amount);
				ps.setString(6, "Withdraw");
				
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
					String Query3="update balance set balance=? where accountno=? and username=?";
					balance=""+((Double.parseDouble(balance)-Double.parseDouble(amount)));
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
				}
				
			}
			
		}
		return l;
	}
	
	
	
	public static int deposit(String accountNo, String username, String date, String month, String year,
			String amount) 
	{
		String Query="insert into deposit values(?,?,?,?,?)";
		int i=0,j=0,k=0,l=0;
		try
		{
			PreparedStatement ps=DBInfo1.con.prepareStatement(Query);
			ps.setString(1, accountNo);
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
			
			String Query1="insert into transection values(?,?,?,?,?,?)";
			
			try
			{
				PreparedStatement ps=DBInfo1.con.prepareStatement(Query1);
				ps.setString(1, accountNo);
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
				try
				{
					PreparedStatement ps=DBInfo1.con.prepareStatement(Query2);
					ps.setString(1, accountNo);
					
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
					String Query3="update balance set balance=? where accountno=? and username=?";
					balance=""+(Double.parseDouble(balance)+Double.parseDouble(amount));
					try
					{
						PreparedStatement ps=DBInfo1.con.prepareStatement(Query3);
						ps.setString(2, accountNo);
						ps.setString(3, username);
						ps.setString(1, balance);
						
						
						l=ps.executeUpdate();
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					
				}
				
			}
			
		}
		
		
		return l;
	}

}
