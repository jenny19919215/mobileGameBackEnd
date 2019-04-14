package server;

public class Objet {
	private long id;
    private String type;
    private float latitude;
    private float longitude;
    private long valeur;
    private int debut;
    private int duree;
    
    public Objet (){}
    
	public void objetSetId(long id) {this.id=id;}
	public long objetGetId(){return this.id;}

	public String objetGetType(){return this.type;}
	public void objetSetType(String type) {this.type=type;}
	
	public void objetSetLat(long latitude) {this.latitude=latitude;}
	public float objetGetLat(){return this.latitude;}
	
	public void objetSetLong(long longitude) {this.longitude=longitude;}
	public float objetGetLong(){return this.longitude;}
	
	public void objetSetvaleur(long valeur) {this.valeur=valeur;}
	public long objetGetvaleur(){return this.valeur;}
	
	public void objetSetDebut(int debut) {this.debut=debut;}
	public int objetGetDebut(){return this.debut;}
	
	public void objetSetDuree(int duree) {this.duree=duree;}
	public int objetGetDuree(){return this.duree;}
	
}
