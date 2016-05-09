package GIT;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class Queries {
	
	static String ConString= "jdbc:mysql://localhost:3307/git";
	static String username= "root";
	static String password= "cumis";
	static Connection connect = null;
	
	public static void check() throws Exception
	{
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			connect= (Connection)DriverManager.getConnection(ConString, username, password);
			if(connect!=null){
				
				JOptionPane.showMessageDialog(null, "Connected");
				
			}
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Not Connected");
	
		}
		
	}
			
	public static  void Retrieve() 
	{		
		String name,  stagename,  album,  award;
		try
		{
			
			PreparedStatement stmt= connect.prepareStatement("SELECT * FROM bestrappers");
			ResultSet results = stmt.executeQuery();
			
			while(results.next())
			{
				
				name= results.getString("Name");
				  stagename = results.getString("StageName");
				  album = results.getString("CurrentAlbum");
				  award = results.getString("GreatestAward");
				 
				  JOptionPane.showMessageDialog(null,"Rapper's Name: "+ name+ "\nStage Name: "
				 + stagename+ "\nCurrent Album: "+album+ "\nAward: "+ award);
			
			}
			
			connect.close();
			
		}catch(Exception e)
		{
			 JOptionPane.showMessageDialog(null,"Error While Retrieving");
		}
	}
			

    

}
