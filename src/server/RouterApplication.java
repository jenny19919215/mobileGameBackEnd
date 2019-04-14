package server;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;
 
public class RouterApplication extends Application{
	
	@Override
	public synchronized Restlet createInboundRoot() {
		// Create a router Restlet that routes each call to a new respective instance of resource.
		Router router = new Router(getContext());
		// Defines only two routes
		router.attach("/users", UserLocation.class);
		
		router.attach("/createGame",AdminClass.class);
		router.attach("/placeObject",AdminClass.class);
		router.attach("/addUser",AdminClass.class);
		router.attach("/allUser",AdminClass.class);
		router.attach("/allObject",AdminClass.class);
		//router.attach("/users/{uid}/items", UserItemResource.class);
		return router;
	}
} 