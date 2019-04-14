package server;

import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.Put;
import org.json.*;



public interface AdminClassInterface  {
	
	    
	@Put ("?createGame")
	public Representation createGame(JsonRepresentation jsorp)throws JSONException;
	@Put("?placeObject")
	public Representation placeObject(JsonRepresentation jsorp)throws JSONException;
	@Put("?addUser")
	public Representation addUser(JsonRepresentation jsorp)throws JSONException;
	@Get ("?allUser")
	public Representation allUser()throws JSONException;
	@Get("?allObject")
	public Representation allObject()throws JSONException;
}