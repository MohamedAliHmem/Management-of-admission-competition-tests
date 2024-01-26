package tp9;

import java.io.IOException;

public class ResultatOral implements Resultat{
	String appreciation ;
	
	public ResultatOral(String a) {
		if(a == "A" || a == "B" || a== "c")
			this.appreciation = a ;
		else
			System.out.println("la resultatOral diff de A B C");
	}

	@Override
	public String toString() {
		return "ResultatOral [appreciation=" + appreciation + "]";
	}
	
	public int compareTo(Resultat r){
		if(r instanceof ResultatOral) {
			return (this.appreciation.compareTo(((ResultatOral)r).appreciation));
		}else
			throw new IllegalArgumentException("deux resultats de type diffrents");
	}
	
}
