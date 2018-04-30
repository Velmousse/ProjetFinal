package Vaisseaux;

import Déchets.Dechets;

public class VaisseauLeger extends Vaisseaux {

    public VaisseauLeger() {
        tailleCargaison = 10;
        cargaison = new Dechets[tailleCargaison];
    }
}
