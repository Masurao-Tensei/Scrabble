package Scoring;


public class Lettre_Point {
	public  char lettre;
	public int point;
	
	public char getLettre() {
		return lettre;
	}
	public void setLettre(char lettre) {
		this.lettre = lettre;
		
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
	
	public Lettre_Point(char lettre, int point) {
		super();
		this.lettre = lettre;
		this.point = point;
	}
	
	

}
