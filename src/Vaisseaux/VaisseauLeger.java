package Vaisseaux;
import Déchets.Dechets;
import java.util.ArrayList;

public class VaisseauLeger extends Vaisseaux {

    public VaisseauLeger() {
        tailleCargaison = 10;
        cargaison = new ArrayList<>(tailleCargaison);
    }
}
