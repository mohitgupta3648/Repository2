package eupchaar.ui.automation.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;


public class DBUtil {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	private String DB_URL;
	private String DB_SERVER;
	private String DB_PORT;
	private String DB_NAME;
	private String DB_USER;
	private String DB_PASSWORD;
	private ResultSet rSet;
	List<Hashtable<?,?>> resultsTableList;
	
	private Properties prop = new Properties();
	
	public DBUtil()
	{
		try {
			prop.load(new FileInputStream("properties/config.properties"));
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		if(prop.getProperty("DB_SERVER") != null)
			DB_SERVER = prop.getProperty("DB_SERVER");
		
		if(prop.getProperty("DB_PORT") != null)
			DB_PORT = prop.getProperty("DB_PORT");
		
		if(prop.getProperty("DB_NAME") != null)
			DB_NAME = prop.getProperty("DB_NAME");
		
		if(prop.getProperty("DB_USER") != null)
			DB_USER = prop.getProperty("DB_USER");
		
		if(prop.getProperty("DB_PASSWORD") != null)
			DB_PASSWORD = prop.getProperty("DB_PASSWORD");
	}
	
	public DBUtil(String DB_SERVER, String DB_PORT, String DB_NAME, String DB_USER, String DB_PASSWORD)
	{
		
		this.DB_SERVER = DB_SERVER;
		this.DB_PORT = DB_PORT;
		this.DB_NAME = DB_NAME;
		this.DB_USER = DB_USER;
		this.DB_PASSWORD = DB_PASSWORD;
		
	}


   
   Connection conn = null;
   Statement stmt = null;
   
   public void executeQuery(String sql)
   {
	   resultsTableList = new LinkedList<Hashtable<?,?>>();
   try{
      // Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");
      
      DB_URL = "jdbc:mysql://" + DB_SERVER + ":" + DB_PORT + "/" + DB_NAME;

      // Open a connection
      Logger.log("Connecting to Data base : " + DB_URL);
      conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);

      // Execute a query
      Logger.log("Executing the Query >> " + sql);
      stmt = conn.createStatement();     
      rSet = stmt.executeQuery(sql);      
      
    //Stores properties of a ResultSet object, including column count
      ResultSetMetaData rsmd = rSet.getMetaData(); 
      int columnCount = rsmd.getColumnCount();
      
      //Logger.log("Column Count: " + columnCount);
      
      while (rSet.next()) {              
         int i = 1;
         Hashtable<String, String> tmpHash = new Hashtable<String, String>();
         while(i <= columnCount) {

        	 String cName = rsmd.getColumnName(i);
        	 String value = "NULL";    
        	 try{
        	   if(rSet.getString(i) != null)
        		 value = rSet.getString(i); 
        	 }catch(Exception e)
        	 {
        		 // swallow and move on
        	 }
        	 tmpHash.put(cName, value);    
        	 i++;
         }
         
         resultsTableList.add(tmpHash);
      }
      
	   if(resultsTableList.isEmpty())
		   Logger.log("Result Set is empty for the given query");
      
      stmt.close();
      conn.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
      Logger.log(se.getMessage());
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
      Logger.log(e.getMessage());
   }finally{
      //close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }
   }
   Logger.log("DB Connection Closed");
}
   
   public List<String> getResultByColumnName(String columnName)
   {
	   
	   List<String> resultAsList = new LinkedList<String>(); 

	   for(Hashtable<?, ?> thash : resultsTableList)
	   {
		   if(thash.get(columnName) != null)
			   resultAsList.add(thash.get(columnName).toString());
		   else
		   {
			   Logger.log("Column Name \"" + columnName + "\" doesn't exist in the result set");
			   break;
		   }
	   }
	   
	   return resultAsList;
	      
   }

}
