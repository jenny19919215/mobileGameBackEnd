package server;

import java.sql.Date;

public class Game {
	private int id;
    private String name;
    private Date timestamp;
    private String city;
    private String winner;
    private int score;
    private int timetaken;
    private float map1x;
    private float map1y;
    private float map2x;
    private float map2y;
    public Game(){};
    
    public void gameSetId(int id) {this.id=id;}
	public int gameGetId(){return this.id;}
	
	public void gameSetName(String name) {this.name=name;}
	public String gameGetName(){return this.name;}
	
	public void gameSetCity(String city) {this.city=city;}
	public String gameGetCity(){return this.city;}
	
	public void gameSetWinner(String winner) {this.winner=winner;}
	public String gameGetWinner(){return this.winner;}
	
	public void gameSetScore(int score) {this.score=score;}
	public int gameGetScore(){return this.score;}
	
	public void gameSetTimetaken(int timetaken) {this.timetaken=timetaken;}
	public int gameGetTimetaken(){return this.timetaken;}
    
	public void gameSetTimestamp(Date timestamp) {this.timestamp=timestamp;}
	public Date gameGetTimestamp(){return this.timestamp;}
	
	public void gameSetMap1x(float map1x) {this.map1x=map1x;}
	public float gameGetMap1x(){return this.map1x;}
	
	public void gameSetMap1y(float map1y) {this.map1y=map1y;}
	public float gameGetMap1y(){return this.map1y;}
	
	public void gameSetMap2x(float map2x) {this.map2x=map2x;}
	public float gameGetMap2x(){return this.map2x;}
	
	public void gameSetMap2y(float map2y) {this.map2y=map2y;}
	public float gameGetMap2y(){return this.map2y;}
    
}
