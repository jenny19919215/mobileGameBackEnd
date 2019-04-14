package client;

import java.io.IOException;
import java.util.Date;






import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

import server.*;
public class Test {

	/**
	 * @param args
	 * @throws JSONException 
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws JSONException, IOException, InterruptedException {
		ClientResource client = new ClientResource("http://localhost:8183/createGame");
		
		Date mydate = new Date();
		java.sql.Date date = new java.sql.Date(mydate.getTime());
		JSONObject jso = new JSONObject();
		jso.put("NAME","anaconda");
		jso.put("TIMESTAMP",date);
		jso.put("CITY","Paris");
		jso.put("MAP1X","11.11");
		jso.put("MAP1Y","11.22");
		jso.put("MAP2X","22.11");
		jso.put("MAP2Y","22.22");
		
		JsonRepresentation jr = new JsonRepresentation(jso);
		System.out.println("creating game...");
		Representation result = client.wrap(AdminClassInterface.class).createGame(jr);
		System.out.println("game created");
		
	   /*####################################################""
	    * ################################################### */
		ClientResource client1 = new ClientResource("http://localhost:8183/placeObject");
		JSONObject jso1 = new JSONObject();
	    //jso1.put("id","4");
		jso1.put("objectType", "money");
		jso1.put("longitude","27.356");
		jso1.put("latitude","33.015");
		jso1.put("value","10000");
		jso1.put("startTime","00");
		jso1.put("duration","12");
		JsonRepresentation jr1 = new JsonRepresentation(jso1);
		System.out.println("placing object...");
		Representation result1 = client1.wrap(AdminClassInterface.class).placeObject(jr1);
		System.out.println("object placed");
		/*####################################################""
		    * ################################################### */
		ClientResource client2 = new ClientResource("http://localhost:8183/addUser");
		JSONObject jso2 = new JSONObject();
		jso2.put("LONGITUDE", "77.77");
		jso2.put("LATITUDE", "77.77");
		jso2.put("LOGIN", "3asba");
		jso2.put("USERTYPE","voleur");
		jso2.put("SCORE","0");
		jso2.put("BALLES","0");
		jso2.put("USEGAME_ID","1");
		JsonRepresentation jr2 = new JsonRepresentation(jso2);
		System.out.println("adding user...");
		client2.wrap(AdminClassInterface.class).addUser(jr2);
		System.out.println("user added");
		/*####################################################""
		    * ################################################### */
		ClientResource client3 = new ClientResource("http://localhost:8183/addUser");
		JSONObject jso3 = new JSONObject();
		JsonRepresentation jr3 = new JsonRepresentation(jso3);
		 jso3.put("TIMESTAMP",date);
			jso3.put("LONGITUDE", "88.88");
			jso3.put("LATITUDE", "88.88");
			jso3.put("LOGIN", "namm");
			jso3.put("USERTYPE","police");
			jso3.put("SCORE","0");
			jso3.put("BALLES","0");
			jso3.put("USEGAME_ID","1");
		System.out.println("adding user...");
		client3.wrap(AdminClassInterface.class).addUser(jr3);
		System.out.println("user added");
		/*####################################################""
		    * ################################################### */
		ClientResource client4 = new ClientResource("http://localhost:8183/allUser");
		System.out.println("showing  users...");
		Representation result4 = client4.wrap(AdminClassInterface.class).allUser();
		System.out.println(result4.getText());
		System.out.println("users showed");
		/*####################################################""
		    * ################################################### */
		ClientResource client5 = new ClientResource("http://localhost:8183/allObject");
		System.out.println("showing  objects...");
		Representation result5 = client5.wrap(AdminClassInterface.class).allObject();
		System.out.println(result5.getText());
		System.out.println("objectss showed");
	}

}
