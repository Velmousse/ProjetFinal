package Vaisseaux;
import Déchets.Dechets;
import java.util.ArrayList;

public class VaisseauLourd extends Vaisseaux {

    public VaisseauLourd() {
        tailleCargaison = 30;
        cargaison = new ArrayList<>(tailleCargaison);
    }
}
