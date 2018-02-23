package DBOpco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Database {

	public static void tc008(String user) throws ClassNotFoundException, SQLException {

		String USER_NAME = user;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@158.234.62.37:1521:rac01sa");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:gdspdba/gdspdbasa@//158.234.62.37:1521/rac01sa");
		if(conn!=null)
		{
			System.out.println("db connected");
		}
		else
		{
			System.out.println("db not connected");
		}
		java.sql.Statement stm =conn.createStatement();
		String sql="select * from t_user where USER_NAME =";
		ResultSet rs= stm.executeQuery(sql + "'"+USER_NAME+"'");
		String count;
		while (rs.next()){
			count = rs.getString(2);
			System.out.println(count);
			System.out.println("user has been verified in DB");
		}
	}
	public static void tc009(String user) throws ClassNotFoundException, SQLException {

		String USER_NAME = user;	
		// Register DB Class		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@158.234.62.41:1521:GDSPDBCC");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:gdspdba/gdspdbasa//158.234.62.37:1521/rac01sa");
		if(conn!=null)
		{
			System.out.println("db connected");
		}
		else 
		{
			System.out.println("db not connected");
		}
		java.sql.Statement stm =conn.createStatement();
		String sql="select * from t_user where USER_NAME =";
		ResultSet rs= stm.executeQuery(sql + "'"+USER_NAME+"'");
		String count;
		while (rs.next()){
			count = rs.getString(2);
			System.out.println(count);
			System.out.println("user has been verified in DB");
		}
	}



	public static void tc010(String user) throws ClassNotFoundException, SQLException {

		String USER_NAME = user;		
		// Register DB Class		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@158.234.62.37:1521:rac01sa");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:gdspdba/gdspdbasa@//158.234.62.37:1521/rac01sa");
		if(conn!=null)
		{

			System.out.println("db connected");

		}
		else 
		{

			System.out.println("db not connected");
		}


		java.sql.Statement stm =conn.createStatement();
		String sql="select * from t_user where USER_NAME =";
		ResultSet rs= stm.executeQuery(sql + "'"+USER_NAME+"'");
		String count;
		while (rs.next()){
			count = rs.getString(2);
			System.out.println(count);
			System.out.println("user has been verified in DB");
		}
	}

	
	
	public static void tc15(String contact) throws ClassNotFoundException, SQLException {

		String CONTACT_NAME = contact;	
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
		String sql="select * from T_CONTACT where contact_name =";
		ResultSet rs= stm.executeQuery(sql + "'"+CONTACT_NAME+"'");
		String cid;
		while (rs.next()){
			cid = rs.getString(1);
			System.out.println(cid);
			String sql1="delete from T_CUSTOMER_CONTACT_MAP where contact_id =";
			ResultSet rs1= stm.executeQuery(sql1 + "'"+cid+"'");
			String sql2="delete from t_contact where contact_name=";
			ResultSet rs2=stm.executeQuery( sql2 + "'"+CONTACT_NAME+"'");
					
		}
	}


	public static void tc022(String user) throws ClassNotFoundException, SQLException {

		String USER_NAME = user;	
		// Register DB Class		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@158.234.62.37:1521:rac01sa");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:gdspdba/gdspdbasa@//158.234.62.37:1521/rac01sa");
		if(conn!=null)
		{

			System.out.println("db connected");

		}
		else 
		{

			System.out.println("db not connected");
		}

		java.sql.Statement stm =conn.createStatement();
		String sql="select * from T_AAA_CLIENT where aaa_client_name =";
		ResultSet rs= stm.executeQuery(sql + "'"+USER_NAME+"'");
		String count;

		while (rs.next()){

			count = rs.getString(2);
			System.out.println(count);
			System.out.println("user has been verified in DB");
		}
	}


	public static void tc023(String user) throws ClassNotFoundException, SQLException {

		String USER_NAME = user;	
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
		String sql="select * from T_SGSN_MAP where sgsn_ip_address =";
		ResultSet rs= stm.executeQuery(sql + "'"+USER_NAME+"'");
		String count;
		while (rs.next()){
			count = rs.getString(2);
			System.out.println(count);
			System.out.println("user has been verified in DB");
			String sql1="delete from T_SGSN_MAP where sgsn_ip_address =";
			ResultSet rs1= stm.executeQuery(sql1 + "'"+USER_NAME+"'");
		}
	}


	public static void tc024(String user) throws ClassNotFoundException, SQLException {

		String USER_NAME = user;	
		// Register DB Class	
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@158.234.62.37:1521:rac01sa");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:gdspdba/gdspdbasa@//158.234.62.37:1521/rac01sa");
		if(conn!=null)
		{

			System.out.println("db connected");

		}
		else 
		{

			System.out.println("db not connected");
		}
		java.sql.Statement stm =conn.createStatement();
		String sql="select * from T_SGSN_MAP where sgsn_ip_address =";
		ResultSet rs= stm.executeQuery(sql + "'"+USER_NAME+"'");
		String count;
		while (rs.next()){
			count = rs.getString(2);
			System.out.println(count);
			System.out.println("user has been verified in DB");
		}
	}



	public static void tc025(String user) throws ClassNotFoundException, SQLException {

		String USER_NAME = user;	
		// Register DB Class	
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@158.234.62.37:1521:rac01sa");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:gdspdba/gdspdbasa@//158.234.62.37:1521/rac01sa");
		if(conn!=null)
		{

			System.out.println("db connected");

		}
		else 
		{

			System.out.println("db not connected");
		}
		java.sql.Statement stm =conn.createStatement();
		String sql="select * from T_ghlr_template where ghlr_template_name =";
		ResultSet rs= stm.executeQuery(sql + "'"+USER_NAME+"'");
		String count;
		while (rs.next()){
			count = rs.getString(2);
			System.out.println(count);
			System.out.println("user has been verified in DB");
		}
	}




	public static void tc026(String user) throws ClassNotFoundException, SQLException {

		String USER_NAME = user;	
		// Register DB Class	
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@158.234.62.37:1521:rac01sa");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:gdspdba/gdspdbasa@//158.234.62.37:1521/rac01sa");
		if(conn!=null)
		{

			System.out.println("db connected");

		}
		else 
		{

			System.out.println("db not connected");
		}
		java.sql.Statement stm =conn.createStatement();
		String sql="select * from T_ghlr_template where ghlr_template_name =";
		ResultSet rs= stm.executeQuery(sql + "'"+USER_NAME+"'");
		String count;
		while (rs.next()){
			count = rs.getString(2);
			System.out.println(count);
			System.out.println("user has been verified in DB");
		}
	}


	public static void tc030(String user) throws ClassNotFoundException, SQLException {

		String USER_NAME = user;	
		// Register DB Class	
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@158.234.62.37:1521:rac01sa");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:gdspdba/gdspdbasa@//158.234.62.37:1521/rac01sa");
		if(conn!=null)
		{

			System.out.println("db connected");

		}
		else 
		{

			System.out.println("db not connected");
		}
		java.sql.Statement stm =conn.createStatement();
		String sql="select * from t_tim_profile where tim_profile_desc =";
		ResultSet rs= stm.executeQuery(sql + "'"+USER_NAME+"'");
		String count;
		while (rs.next()){
			count = rs.getString(2);
			System.out.println(count);
			System.out.println("user has been verified in DB");
		}
	}



	public static void tc031(String user) throws ClassNotFoundException, SQLException {

		String USER_NAME = user;	
		// Register DB Class	
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@158.234.62.37:1521:rac01sa");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:gdspdba/gdspdbasa@//158.234.62.37:1521/rac01sa");
		if(conn!=null)
		{

			System.out.println("db connected");

		}
		else 
		{

			System.out.println("db not connected");
		}
		java.sql.Statement stm =conn.createStatement();
		String sql="select * from t_tim_profile where tim_profile_desc =";
		ResultSet rs= stm.executeQuery(sql + "'"+USER_NAME+"'");
		String count;
		while (rs.next()){
			count = rs.getString(2);
			System.out.println(count);
			System.out.println("user has been verified in DB");
		}
	}


	public static void tc032(String user) throws ClassNotFoundException, SQLException {

		String USER_NAME = user;	
		// Register DB Class	
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@158.234.62.37:1521:rac01sa");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:gdspdba/gdspdbasa@//158.234.62.37:1521/rac01sa");
		if(conn!=null)
		{

			System.out.println("db connected");

		}
		else 
		{

			System.out.println("db not connected");
		}
		java.sql.Statement stm =conn.createStatement();
		String sql="select * from t_imsi_range where range_desc =";
		ResultSet rs= stm.executeQuery(sql + "'"+USER_NAME+"'");
		String count;
		while (rs.next()){
			count = rs.getString(2);
			System.out.println(count);
			System.out.println("user has been verified in DB");
		}
	}



	public static void tc033(String user) throws ClassNotFoundException, SQLException {

		String USER_NAME = user;	
		// Register DB Class	
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@158.234.62.37:1521:rac01sa");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:gdspdba/gdspdbasa@//158.234.62.37:1521/rac01sa");
		if(conn!=null)
		{

			System.out.println("db connected");

		}
		else 
		{

			System.out.println("db not connected");
		}
		java.sql.Statement stm =conn.createStatement();
		String sql="select * from t_imsi_range where range_desc =";
		ResultSet rs= stm.executeQuery(sql + "'"+USER_NAME+"'");
		String count;
		while (rs.next()){
			count = rs.getString(2);
			System.out.println(count);
			System.out.println("user has been verified in DB");
		}
	}



	public static void tc037(String user) throws ClassNotFoundException, SQLException {

		String USER_NAME = user;	
		// Register DB Class	
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@158.234.62.37:1521:rac01sa");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:gdspdba/gdspdbasa@//158.234.62.37:1521/rac01sa");
		if(conn!=null)
		{

			System.out.println("db connected");

		}
		else 
		{

			System.out.println("db not connected");
		}
		java.sql.Statement stm =conn.createStatement();
		String sql="select * from t_vf_opco where vf_opco_code =";
		ResultSet rs= stm.executeQuery(sql + "'"+USER_NAME+"'");
		String count;
		while (rs.next()){
			count = rs.getString(2);
			System.out.println(count);
			System.out.println("user has been verified in DB");
		}
	}



	public static void tc038(String user) throws ClassNotFoundException, SQLException {

		String USER_NAME = user;	
		// Register DB Class	
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@158.234.62.37:1521:rac01sa");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:gdspdba/gdspdbasa@//158.234.62.37:1521/rac01sa");
		if(conn!=null)
		{

			System.out.println("db connected");

		}
		else 
		{

			System.out.println("db not connected");
		}
		java.sql.Statement stm =conn.createStatement();
		String sql="select * from t_vf_opco where vf_opco_code =";
		ResultSet rs= stm.executeQuery(sql + "'"+USER_NAME+"'");
		String count;
		while (rs.next()){
			count = rs.getString(2);
			System.out.println(count);
			System.out.println("user has been verified in DB");
		}
	}


	public static void tc041(String user) throws ClassNotFoundException, SQLException {

		String USER_NAME = user;		
		// Register DB Class	
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@158.234.62.37:1521:rac01sa");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:gdspdba/gdspdbasa@//158.234.62.37:1521/rac01sa");
		if(conn!=null)
		{

			System.out.println("db connected");

		}
		else 
		{

			System.out.println("db not connected");
		}
		java.sql.Statement stm =conn.createStatement();
		String sql="select * from t_vf_opco where vf_opco_code =";
		ResultSet rs= stm.executeQuery(sql + "'"+USER_NAME+"'");
		String count;
		while (rs.next()){
			count = rs.getString(2);
			System.out.println(count);
			System.out.println("user has been verified in DB");
		}
	}



	public static void tc042(String user) throws ClassNotFoundException, SQLException {

		String USER_NAME = user;	
		// Register DB Class	
		// Register DB Class	
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@158.234.62.37:1521:rac01sa");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:gdspdba/gdspdbasa@//158.234.62.37:1521/rac01sa");
		if(conn!=null)
		{

			System.out.println("db connected");

		}
		else 
		{

			System.out.println("db not connected");
		}
		java.sql.Statement stm =conn.createStatement();
		String sql="select * from T_LFT_CONFIGURATION where LFT_CONFIGURATION_NAME =";
		ResultSet rs= stm.executeQuery(sql + "'"+USER_NAME+"'");
		String count;
		while (rs.next()){
			count = rs.getString(2);
			System.out.println(count);
			System.out.println("user has been verified in DB");
		}
	}


	public static void tc043(String user) throws ClassNotFoundException, SQLException {

		String USER_NAME = user;	
		// Register DB Class	
		// Register DB Class	
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@158.234.62.37:1521:rac01sa");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:gdspdba/gdspdbasa@//158.234.62.37:1521/rac01sa");
		if(conn!=null)
		{

			System.out.println("db connected");

		}
		else 
		{

			System.out.println("db not connected");
		}
		java.sql.Statement stm =conn.createStatement();
		String sql="select * from T_LFT_CONFIGURATION where LFT_CONFIGURATION_NAME =";
		ResultSet rs= stm.executeQuery(sql + "'"+USER_NAME+"'");
		String count;
		while (rs.next()){
			count = rs.getString(2);
			System.out.println(count);
			System.out.println("user has been verified in DB");
		}
	}


	public static void tc044(String user) throws ClassNotFoundException, SQLException {

		String USER_NAME = user;	
		// Register DB Class	
		// Register DB Class	
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@158.234.62.37:1521:rac01sa");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:gdspdba/gdspdbasa@//158.234.62.37:1521/rac01sa");
		if(conn!=null)
		{

			System.out.println("db connected");

		}
		else 
		{

			System.out.println("db not connected");
		}
		java.sql.Statement stm =conn.createStatement();
		String sql="select * from T_plmn_list where plmn_list_NAME =";
		ResultSet rs= stm.executeQuery(sql + "'"+USER_NAME+"'");
		String count;
		while (rs.next()){
			count = rs.getString(2);
			System.out.println(count);
			System.out.println("user has been verified in DB");
		}
	}



	public static void tc045(String user) throws ClassNotFoundException, SQLException {

		String USER_NAME = user;	
		// Register DB Class	
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@158.234.62.37:1521:rac01sa");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:gdspdba/gdspdbasa@//158.234.62.37:1521/rac01sa");
		if(conn!=null)
		{

			System.out.println("db connected");

		}
		else 
		{

			System.out.println("db not connected");
		}
		java.sql.Statement stm =conn.createStatement();
		String sql="select * from T_plmn_list where plmn_list_NAME =";
		ResultSet rs= stm.executeQuery(sql + "'"+USER_NAME+"'");
		String count;
		while (rs.next()){
			count = rs.getString(2);
			System.out.println(count);
			System.out.println("user has been verified in DB");
		}
	}



	public static void tc050(String user) throws ClassNotFoundException, SQLException {

		String USER_NAME = user;	
		// Register DB Class	
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@158.234.62.37:1521:rac01sa");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:gdspdba/gdspdbasa@//158.234.62.37:1521/rac01sa");
		if(conn!=null)
		{

			System.out.println("db connected");

		}
		else 
		{

			System.out.println("db not connected");
		}
		java.sql.Statement stm =conn.createStatement();
		String sql="select * from t_user where user_name =";
		ResultSet rs= stm.executeQuery(sql + "'"+USER_NAME+"'");
		String count;
		while (rs.next()){
			count = rs.getString(2);
			System.out.println(count);
			System.out.println("user has been verified in DB");
		}
	}



	public static void tc052(String user) throws ClassNotFoundException, SQLException {

		String USER_NAME = user;	
		// Register DB Class		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@158.234.62.37:1521:rac01sa");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:gdspdba/gdspdbasa@//158.234.62.37:1521/rac01sa");
		if(conn!=null)
		{

			System.out.println("db connected");

		}
		else 
		{

			System.out.println("db not connected");
		}
		java.sql.Statement stm =conn.createStatement();
		String sql="select * from T_SGSN_MAP where sgsn_ip_address =";
		ResultSet rs= stm.executeQuery(sql + "'"+USER_NAME+"'");
		String count;
		while (rs.next()){
			count = rs.getString(2);
			System.out.println(count);
			System.out.println("user has been verified in DB");
		}
	}


	public static void tc053(String user) throws ClassNotFoundException, SQLException {

		String USER_NAME = user;	
		// Register DB Class	
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@158.234.62.37:1521:rac01sa");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:gdspdba/gdspdbasa@//158.234.62.37:1521/rac01sa");
		if(conn!=null)
		{

			System.out.println("db connected");

		}
		else 
		{

			System.out.println("db not connected");
		}
		java.sql.Statement stm =conn.createStatement();
		String sql="select * from T_SERVICE_COVERAGE_GROUP where SERVICE_COVERAGE_GROUP_NAME =";
		ResultSet rs= stm.executeQuery(sql + "'"+USER_NAME+"'");
		String count;
		while (rs.next()){
			count = rs.getString(2);
			System.out.println(count);
			System.out.println("user has been verified in DB");
		}
	}


	public static void tc054(String user) throws ClassNotFoundException, SQLException {

		String USER_NAME = user;	
		// Register DB Class	
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@158.234.62.37:1521:rac01sa");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:gdspdba/gdspdbasa@//158.234.62.37:1521/rac01sa");
		if(conn!=null)
		{

			System.out.println("db connected");

		}
		else 
		{

			System.out.println("db not connected");
		}
		java.sql.Statement stm =conn.createStatement();
		String sql="select * from T_SERVICE_COVERAGE_GROUP where SERVICE_COVERAGE_GROUP_NAME =";
		ResultSet rs= stm.executeQuery(sql + "'"+USER_NAME+"'");
		String count;
		while (rs.next()){
			count = rs.getString(2);
			System.out.println(count);
			System.out.println("user has been verified in DB");
		}
	}



	public static void tc056(String user) throws ClassNotFoundException, SQLException {

		String USER_NAME = user;	
		// Register DB Class	
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@158.234.62.37:1521:rac01sa");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:gdspdba/gdspdbasa@//158.234.62.37:1521/rac01sa");
		if(conn!=null)
		{

			System.out.println("db connected");

		}
		else 
		{

			System.out.println("db not connected");
		}
		java.sql.Statement stm =conn.createStatement();
		String sql="select * from T_CS_CHARGING_SOURCE where VF_OPCO_ID in (select vf_opco_id FROM T_VF_OPCO where VF_OPCO_CODE =";
		ResultSet rs= stm.executeQuery(sql + "'"+USER_NAME+"'"+")");
		String count;
		while (rs.next()){
			count = rs.getString(2);
			System.out.println(count);
			System.out.println("user has been verified in DB");
		}
	}


}

