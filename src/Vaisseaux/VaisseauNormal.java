package Vaisseaux;
import Déchets.*;

public class VaisseauNormal extends Vaisseaux{

    public VaisseauNormal() {
        tailleCargaison = 30;
        cargaison = new Dechets[tailleCargaison];
    }
}
