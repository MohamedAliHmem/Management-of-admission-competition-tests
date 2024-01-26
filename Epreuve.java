package tp9;

import java.util.Arrays;

public class Epreuve {
	String denomination;
	Candidat [] tabC ;
	int nbMax ;
	int nbEff = 0 ;
	boolean etat ;
	
	public Epreuve(String denomination, int max) {
		this.nbMax = max ;
		this.denomination = denomination ;
		this.tabC = new Candidat[max] ;
	}
	
	

	@Override
	public String toString() {
		String s= this.denomination+" "+this.etat+" ";
	for(int i=0;i<this.nbEff;i++) {
			s+=this.tabC[i].getNon()+ "- ";
		}
	return s;
	}
	
	void ajoutCandidat(Candidat c) {
		if(this.nbEff<=this.nbMax) {
			this.tabC[nbEff] = c ;
			this.nbEff++;
		}else {
			System.out.println("le tableau est plein");
		}
			
	}
	
	void terminer() {
		this.etat = true ;
	}
	boolean estTerminer() {
		return this.etat ;
	}
	
	Resultat getRecord() {
		Resultat r = this.tabC[0].getResultat();
		for (int i=1 ; i<this.nbEff;i++) {
			if(this.tabC[i].getResultat().compareTo(r)==1){
				r = this.tabC[i].getResultat();
			}}
		return r ;
	}

	 Candidat getVinqueur() {
		 if(this.estTerminer()) {
			 Resultat r = this.getRecord();
			 for(int i=0 ; i<this.nbEff;i++) {
				 if(this.tabC[i].getResultat().compareTo(r)==0) {
					 return this.tabC[i];
				 }
			 }
			 
		 }return null;
	 }

	 void fixeResultat(int id, Resultat r) throws IllegalUpdateException{
		 if (this.estTerminer()) {
			 throw new IllegalUpdateException("est terminer");
		 }else {
			 for(int i=0; i<this.nbEff ; i++) {
				 if(this.tabC[i].getId() == id) {
					 this.tabC[i].setResultat(r);
					 break;
				 }
			 }
		 }
	 }
	 
	 Resultat getResultat(int id) {
		 for(int i=0; i<this.nbEff ; i++) {
			 if(this.tabC[i].getId() == id) {
				 if(this.tabC[i].getResultat()!=null) {
					 return this.tabC[i].getResultat();
				 }
				 break;
			 }
		 }
		 return null;
	 }

	public static void main(String[] args) {
		Epreuve e = new Epreuve("aa",5);
		Candidat c1 = new Candidat(1,"dali");
		Candidat c2 = new Candidat(2,"moh");
		Candidat c3 = new Candidat(3,"ali");
		
		Resultat r1 = new ResultatPoints(4);
		Resultat r2 = new ResultatPoints(5);
		Resultat r3 = new ResultatPoints(6);
		
		e.ajoutCandidat(c1);
		e.ajoutCandidat(c2);
		e.ajoutCandidat(c3);
		
		try {
		e.fixeResultat(c1.getId(), r1);
		e.fixeResultat(c2.getId(), r2);
		e.fixeResultat(c3.getId(), r3);
		
		}catch(Exception m) {
			m.getMessage();
		}
		
	
		
		e.terminer();
		
		System.out.println("vainqueur : "+e.getVinqueur().getNon());

	}

}
