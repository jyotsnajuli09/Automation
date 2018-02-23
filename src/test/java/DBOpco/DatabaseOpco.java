package DBOpco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DatabaseOpco {

	public static void usercertificatevarifiaction (String user) throws ClassNotFoundException, SQLException {

		String NAME =user;
		
		// Register DB Class
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@158.234.62.41:1521:GDSPDBCC");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:gdspdba/gdspdbahp09@//158.234.62.43:1521/HP09");
		if(conn!=null)
		{
			System.out.println("db connected");
		}
		else 
		{

			System.out.println("db not connected");
		}

		//Statement stm = conn.createStatement();

		java.sql.Statement stm =conn.createStatement();
		
		// Select * from t_ssl_certificate where ssl_certificate_name='%{ssl_certificate_name}%'; 

		String sql="Select * from t_ssl_certificates where ssl_certificate_name =";

		//ResultSet rs= stm.executeQuery("select * from t_user where USER_NAME = " );
		ResultSet rs= stm.executeQuery(sql + "'"+NAME+"'");

		String count;

		while (rs.next()){

			count = rs.getString(2);

			System.out.println(count);
			System.out.println("user has been verified in DB");
			//System.out.println(" The Total Number of IMSIs is " + rs.getString("CUSTOMER_CODE"));
		}

	}
	public static void tc033(String cname) throws ClassNotFoundException, SQLException {

        String CERTIFICATE_NAME = cname;       
        // Register DB Class         
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@158.234.62.37:1521:rac01sa");
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:gdspdba/gdspdbahp09@//158.234.62.43:1521/HP09");
        if(conn!=null)
        {

                        System.out.println("db connected");

        }
        else 
        {

                        System.out.println("db not connected");
        }
        java.sql.Statement stm =conn.createStatement();
        String sql="delete from t_ssl_certificates where ssl_certificate_name =";
        ResultSet rs= stm.executeQuery(sql + "'"+CERTIFICATE_NAME+"'");
                System.out.println("certificate deleted successfully");                                                        
        }

public static void tc101(String vpn_name) throws ClassNotFoundException, SQLException
{
	String  Vpn_name=vpn_name;
	 Class.forName("oracle.jdbc.driver.OracleDriver");
	 Connection conn = DriverManager.getConnection("jdbc:oracle:thin:gdspdba/gdspdbahp09@//158.234.62.43:1521/HP09");
	 if(conn!=null)
	 {
		  System.out.println("db connected");
	 }
	 else
	 {
		 System.out.println("db not connected"); 
	 }
	 java.sql.Statement stm =conn.createStatement();
	 //delete from t_ngin_vpn_group where customer_id=456;
	 //commit;

     String sql="delete from t_ngin_vpn_group where ngin_vpn_group_name=";
     ResultSet rs= stm.executeQuery(sql + "'"+Vpn_name+"'");
             System.out.println("vpn group deleted successfully");    
}
public static void tc103(String vpn_name) throws ClassNotFoundException, SQLException
{
	String  Vpn_name=vpn_name;
	 Class.forName("oracle.jdbc.driver.OracleDriver");
	 Connection conn = DriverManager.getConnection("jdbc:oracle:thin:gdspdba/gdspdbahp09@//158.234.62.43:1521/HP09");
	 if(conn!=null)
	 {
		  System.out.println("db connected");
	 }
	 else
	 {
		 System.out.println("db not connected"); 
	 }
	 java.sql.Statement stm =conn.createStatement();
	 //delete from t_ngin_vpn_group where customer_id=456;
	 //commit;

     String sql="delete from t_ngin_vpn_group where ngin_vpn_group_name=";
     ResultSet rs= stm.executeQuery(sql + "'"+Vpn_name+"'");
             System.out.println("copied vpn group deleted successfully");    
}

public static void tc107(String numlist_name,String custcode) throws ClassNotFoundException, SQLException
{
	String  Numlist_name=numlist_name;
	String ccode=custcode;
	 Class.forName("oracle.jdbc.driver.OracleDriver");
	 Connection conn = DriverManager.getConnection("jdbc:oracle:thin:gdspdba/gdspdbahp09@//158.234.62.43:1521/HP09");
	 if(conn!=null)
	 {
		  System.out.println("db connected");
	 }
	 else
	 {
		 System.out.println("db not connected"); 
	 }
	 java.sql.Statement stm =conn.createStatement();
	 //delete from t_ngin_vpn_group where customer_id=456;
	 //commit;

     String sql="select * from t_ngin_number_list where ngin_number_list_name=";
     ResultSet rs= stm.executeQuery(sql + "'"+Numlist_name+"'");
     String ngin_id;

		while (rs.next()){

			ngin_id = rs.getString(1);
			System.out.println(ngin_id);
			String sql3="delete from t_ngin_number where ngin_number_list_id=";
			ResultSet rs2= stm.executeQuery(sql3 + "'"+ngin_id+"'");
			String sql4="commit";
			ResultSet rs5=stm.executeQuery(sql4);
			String sql5="delete from t_ngin_number_list where ngin_number_list_id=";
			ResultSet rs3= stm.executeQuery(sql5 + "'"+ngin_id+"'");
			String sql6="commit";
				ResultSet rs4=stm.executeQuery(sql6);
			
			
		}
		
                
}

public static void tc109(String numlist_name,String custcode) throws ClassNotFoundException, SQLException
{
	String  Numlist_name=numlist_name;
   String ccode=custcode;
	 Class.forName("oracle.jdbc.driver.OracleDriver");
	 Connection conn = DriverManager.getConnection("jdbc:oracle:thin:gdspdba/gdspdbahp09@//158.234.62.43:1521/HP09");
	 if(conn!=null)
	 {
		  System.out.println("db connected");
	 }
	 else
	 {
		 System.out.println("db not connected"); 
	 }
	 java.sql.Statement stm =conn.createStatement();
	 //delete from t_ngin_vpn_group where customer_id=456;
	 //commit;

     String sql="select * from t_ngin_number_list where ngin_number_list_name=";
     ResultSet rs= stm.executeQuery(sql + "'"+Numlist_name+"'");
     String ngin_id;

		while (rs.next()){

			ngin_id = rs.getString(1);
			System.out.println(ngin_id);
			String sql3="delete from t_ngin_number where ngin_number_list_id=";
			ResultSet rs2= stm.executeQuery(sql3 + "'"+ngin_id+"'");
			String sql4="commit";
			ResultSet rs5=stm.executeQuery(sql4);
			String sql5="delete from t_ngin_number_list where ngin_number_list_id=";
			ResultSet rs3= stm.executeQuery(sql5 + "'"+ngin_id+"'");
			String sql6="commit";
				ResultSet rs4=stm.executeQuery(sql6);
			
			
		}
		
                
}
public static void tc112(String vpn_barring_name) throws ClassNotFoundException, SQLException
{
	String  VPN_barring_name=vpn_barring_name;
   //String ccode=custcode;
	 Class.forName("oracle.jdbc.driver.OracleDriver");
	 Connection conn = DriverManager.getConnection("jdbc:oracle:thin:gdspdba/gdspdbahp09@//158.234.62.43:1521/HP09");
	 if(conn!=null)
	 {
		  System.out.println("db connected");
	 }
	 else
	 {
		 System.out.println("db not connected"); 
	 }
	 java.sql.Statement stm =conn.createStatement();
	 //delete from t_ngin_vpn_group where customer_id=456;
	 //commit;

     String sql="Delete from t_ngin_barring where ngin_barring_name=";
     ResultSet rs= stm.executeQuery(sql + "'"+VPN_barring_name+"'");
     System.out.println(VPN_barring_name);
     System.out.println("deleted");
     String sql6="commit";
		ResultSet rs4=stm.executeQuery(sql6);
     
                
}
public static void tc128(String endpointname) throws ClassNotFoundException, SQLException
{
	String  EndPointName=endpointname;
   //String ccode=custcode;
	 Class.forName("oracle.jdbc.driver.OracleDriver");
	 Connection conn = DriverManager.getConnection("jdbc:oracle:thin:gdspdba/gdspdbahp09@//158.234.62.43:1521/HP09");
	 if(conn!=null)
	 {
		  System.out.println("db connected");
	 }
	 else
	 {
		 System.out.println("db not connected"); 
	 }
	 java.sql.Statement stm =conn.createStatement();
	 //delete from t_ngin_vpn_group where customer_id=456;
	 //commit;

     String sql="delete from t_web_service where ws_name=";
     ResultSet rs= stm.executeQuery(sql + "'"+EndPointName+"'");
     System.out.println(EndPointName);
     System.out.println("deleted");
     String sql6="commit";
		ResultSet rs4=stm.executeQuery(sql6);
     
                
}
	public static void customereditapi (String user) throws ClassNotFoundException, SQLException {

		String custid =user;
		
		// Register DB Class
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@158.234.62.41:1521:GDSPDBCC");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:gdspdba/gdspdbahp09@//158.234.62.43:1521/HP09");
		if(conn!=null)
		{
			System.out.println("db connected");
		}
		else 
		{

			System.out.println("db not connected");
		}

		//Statement stm = conn.createStatement();

		java.sql.Statement stm =conn.createStatement();
		
		// Select * from t_ssl_certificate where ssl_certificate_name='%{ssl_certificate_name}%'; 

		String sql="Select * from t_api_limits entity where customer_id=";

		//ResultSet rs= stm.executeQuery("select * from t_user where USER_NAME = " );
		ResultSet rs= stm.executeQuery(sql + "'"+custid+"'");

		String count;

		while (rs.next()){

			count = rs.getString(2);

			System.out.println(count);
			System.out.println("user has been verified in DB");
		
		}

	}
}
