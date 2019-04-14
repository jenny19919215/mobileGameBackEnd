package server;

import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.Put;
import org.json.*;



public interface UserLocationInterface  {
	@Put
	public Representation inscriptionUser(JsonRepresentation jsorp)throws JSONException;
	    
	@Post
	public Representation localisation(JsonRepresentation jsorp);


}