package Vaisseaux;
import Déchets.Dechets;

public class VaisseauLourd extends Vaisseaux {

    public VaisseauLourd() {
        tailleCargaison = 30;
        cargaison = new Dechets[tailleCargaison];
    }
}
