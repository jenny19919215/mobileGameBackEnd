package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.data.MediaType;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.*;

public class UserLocation extends ServerResource implements UserLocationInterface {
	private static  Connection con = null;

	@Put
	public Representation inscriptionUser(JsonRepresentation jsorp) throws JSONException {
		JSONObject jso = jsorp.getJsonObject();
		String name = jso.getString("name");
		String type = jso.getString("type");
		System.out.println(name);
		try {
			   Class.forName("com.mysql.jdbc.Driver");
			   try {
			    con = DriverManager.getConnection("jdbc:mysql://localhost/jeu_mobile", "root", "");
			    if(!con.isClosed())  
			        System.out.println("sucessful connect with database");
			    Statement stmt = con.createStatement();
			    String sql = "insert into users (NAME ,TYPE_USER  ,ID_LOCATION  ,ARGENT  ,BALLE)values('"+name+"','"+type+"','0','0','0')";
			    stmt.executeUpdate(sql);
			    /*while(rs.next()){
			    	nameR = rs.getString("NAME");
			    	
			    	}*/
			   // rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
			    
			    e.printStackTrace();
			   }

			} catch (ClassNotFoundException e) {
			   
			   e.printStackTrace();
			  }
		Representation result = new StringRepresentation("DB updated",MediaType.TEXT_PLAIN);
		return result;
	}

    @Post
	public Representation localisation(JsonRepresentation jsorp) {
    	Representation result = new StringRepresentation("DB updated",MediaType.TEXT_PLAIN);
		return result; 		
	}
}
