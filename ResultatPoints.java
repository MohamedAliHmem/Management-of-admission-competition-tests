package tp9;

public class ResultatPoints implements Resultat{
	int point ;
	
	public ResultatPoints(int a) {
		this.point = a ;
	}
	
	@Override
	public String toString() {
		return "ResultatPoints [point=" + point + "]";
	}
	
	public int compareTo(Resultat r) {
		if(this.point == ((ResultatPoints)r).point)
			return 0;
		else if(this.point < ((ResultatPoints)r).point)
			return -1;
		else
			return 1;
	}
}
