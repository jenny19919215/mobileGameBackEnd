package server;

import java.sql.Date;

public class Information {
	
    private String usertype;
    private float latitude;
    private float longitude;
    public Information(){}
    
    public Information(String usertype,float latitude,float longitude){
    	this.usertype=usertype;
    	this.latitude=latitude;
    	this.longitude=longitude;
    }
    
    public String userGetType(){return this.usertype;}
	public void userSetType(String usertype) {this.usertype=usertype;}
	
	
	public void objetSetLat(long latitude) {this.latitude=latitude;}
	public float objetGetLat(){return this.latitude;}
	
	public void objetSetLong(long longitude) {this.longitude=longitude;}
	public float objetGetLong(){return this.longitude;}
}
