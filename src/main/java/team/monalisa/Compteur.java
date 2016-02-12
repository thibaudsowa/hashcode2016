package team.monalisa;

/**
 * Created by gbilley on 11/02/2016.
 */
public class Compteur {
    private int nbTours = 0;
    private int nbAction = 0;
    
    public int getNbAction() {
        return nbAction;
    }
    
    public void setNbAction(int nbAction) {
        this.nbAction = nbAction;
    }
    
    public int getNbTours() {
        return nbTours;
    }
    
    public void setNbTours(int nbTours) {
        this.nbTours = nbTours;
    }
    
    public void add(Integer tours) {
        nbTours+=tours;
        if(tours > 0) {
            nbAction++;
        }
    }
}
