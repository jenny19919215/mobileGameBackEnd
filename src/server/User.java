package server;

public class User {
	private int id;
    private String login;
    private int location_id;   
    private String usertype;
    private int score;
    private int balles;
    private int usegame_id;
    
	public void userSetId(int id) {this.id=id;}
	public int userGetId(){return this.id;}
	
	public String userGetlogin(){return this.login;}
	public void userSetlogin(String login) {this.login=login;}
	
	public void userSetLocationId(int location_id) {this.location_id=location_id;}
	public int userGetLocationId(){return this.location_id;}
	
	public String userGetType(){return this.usertype;}
	public void userSetType(String usertype) {this.usertype=usertype;}
	
	public void userSetscore(int score) {this.score=score;}
	public int userGetscore(){return this.score;}
	
	public void userSetBalles(int balles) {this.balles=balles;}
	public int userGetBalles(){return this.balles;}
	
	public void userSetUsegame_Id(int usegame_id) {this.usegame_id=usegame_id;}
	public int userGetUsegame_Id(){return this.usegame_id;}
}
