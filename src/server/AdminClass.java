package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.data.MediaType;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.*;


public class AdminClass extends ServerResource implements AdminClassInterface {
	private static  Connection con = null;
	private static ResultSet resultats = null;
	private static String date,city,gameName;
	private static String url="jdbc:mysql://localhost/jeu_mobile";
	private static int game_id;
	private static double map1x,map1y,map2x,map2y;
	private static String Newligne=System.getProperty("line.separator"); 
	
public Representation createGame(JsonRepresentation jsorp) throws JSONException {
		
    	JSONObject jso = jsorp.getJsonObject();
    	
		gameName = jso.getString("NAME");
		date = jso.getString("TIMESTAMP");
		city = jso.getString("CITY");
		map1x = jso.getDouble("MAP1X");
		map1y = jso.getDouble("MAP1Y");
		map2x = jso.getDouble("MAP2X");
		map2y = jso.getDouble("MAP2Y");
		try {
			   Class.forName("com.mysql.jdbc.Driver");
			   try {
			    con = DriverManager.getConnection(url, "root", "");
			    System.out.println("connection succeded");
			    Statement stmt = con.createStatement();
			    String sql = "insert into game (NAME,TIMESTAMP,CITY,MAP1X,MAP1Y,MAP2X,MAP2Y) values('"
			    +gameName+"','"+date+"','"+city+"','"+map1x+"','"+map1y+"','"+map2x+"','"+map2y+"')";
			    stmt.executeUpdate(sql);
			    System.out.println("insertion succeded");
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


	public Representation placeObject(JsonRepresentation jsorp) throws JSONException {
		JSONObject jso = jsorp.getJsonObject();
		String objectType = jso.getString("objectType");
		String latitude = jso.getString("latitude");
		String longitude = jso.getString("longitude");
		String value = jso.getString("value");
		String startTime = jso.getString("startTime");
		String duration = jso.getString("duration");
		try {
			   Class.forName("com.mysql.jdbc.Driver");
			   try {
			    con = DriverManager.getConnection(url, "root", "");
			    Statement stmt = con.createStatement();
			    String sql = "select id from game where name='"+gameName+"'";
			    resultats=stmt.executeQuery(sql);
			    resultats.next();
			   game_id=resultats.getInt(1);
			    resultats.previous();
			    sql = "insert into object (OBJECTTYPE,LATITUDE,LONGITUDE,VALUE,STARTTIME,DURATION,OBJGAME_ID)values"
			    		+ "('"+objectType+"','"+latitude+"','"+longitude+"','"+value+"','"+startTime+"','"+duration+"','"+game_id+"')";
			    stmt.executeUpdate(sql);
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
	public Representation addUser(JsonRepresentation jsorp)throws JSONException{
		
		JSONObject jso = jsorp.getJsonObject();
		date = jso.getString("TIMESTAMP");
		double longitude=jso.getDouble("LONGITUDE");
		double latitude=jso.getDouble("LATITUDE");
    	String login = jso.getString("LOGIN");
    	String usertype = jso.getString("USERTYPE");
    	int score = jso.getInt("SCORE");
    	int balles = jso.getInt("BALLES");
    	try {
			   Class.forName("com.mysql.jdbc.Driver");
			   try {
			    con = DriverManager.getConnection(url, "root", "");
			    Statement stmt = con.createStatement();
			    //getting game_id to insert it in user
			    String sql = "select id from game where name='"+gameName+"'";
			    resultats=stmt.executeQuery(sql);
			    resultats.next();
			    game_id=resultats.getInt(1);
			    //adding user 
			    sql = "insert into user (LOGIN,USERTYPE,SCORE,BALLES,USEGAME_ID)"
					    + " values('"+login+"','"+usertype+"','"/*+location_id+"','"*/+score+"','"+balles+"','"+game_id+"')";
			    stmt.executeUpdate(sql);
			    //getting user_id to insert it in location
			    sql = "select id from user where login='"+login+"'";
			    resultats=stmt.executeQuery(sql);
			    resultats.next();
			    int user_id=resultats.getInt(1);
			    //adding location
			    sql = "insert into location (LONGITUDE,LATITUDE,TIMESTAMP,USER_ID)" + 
					    " values('"+longitude+"','"+latitude+"','"+date+"','"+user_id+"')";
			    stmt.executeUpdate(sql);
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

	
	public Representation allUser()throws JSONException{
		
		
		 ResultSet resultats = null;
		// ArrayList<Information> array_inf=new ArrayList<Information>();
		 String retour="";
		 try {
			   Class.forName("com.mysql.jdbc.Driver");
			   try {
			    con = DriverManager.getConnection(url, "root", "");
			    Statement stmt = con.createStatement();
			    String sql = "select user.USERTYPE,location.LONGITUDE,location.LATITUDE from user join location on user.ID=location.USER_ID";
			    resultats=stmt.executeQuery(sql);
			    	while (resultats.next()) {
			    	retour=retour+resultats.getString("USERTYPE")+"  "+resultats.getString("LONGITUDE")+
			    			"  "+resultats.getString("LATITUDE")+Newligne;
			    	}
				stmt.close();
				con.close();
			} catch (SQLException e) {
			    e.printStackTrace();
			   }
			} catch (ClassNotFoundException e) {
			   e.printStackTrace();
			  }
		 Representation result = new StringRepresentation(retour,MediaType.TEXT_PLAIN);
			return result;}
	
	
	
	public Representation allObject()throws JSONException{
		//List<listnerInterface> listeners = new ArrayList<listnerInterface>();
		String retour="";
		try {
			   Class.forName("com.mysql.jdbc.Driver");
			   try {
			    con = DriverManager.getConnection(url, "root", "");
			    Statement stmt = con.createStatement();
			    String sql = "select OBJECTTYPE,LONGITUDE,LATITUDE,VALUE from object";
			    resultats=stmt.executeQuery(sql);
			    	while (resultats.next()) {
			    		retour=retour+resultats.getString("OBJECTTYPE")+"  "+resultats.getString("LONGITUDE")+
			    			"  "+resultats.getString("LATITUDE")+"  "+resultats.getString("VALUE")+Newligne;
			    	}
				stmt.close();
				con.close();
			} catch (SQLException e) {
			    e.printStackTrace();
			   }
			} catch (ClassNotFoundException e) {
			   e.printStackTrace();
			  }
		Representation result = new StringRepresentation(retour,MediaType.TEXT_PLAIN);
		return result;}
}
