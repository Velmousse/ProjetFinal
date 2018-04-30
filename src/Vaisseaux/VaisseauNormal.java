package Vaisseaux;
import Déchets.*;
import java.util.ArrayList;

public class VaisseauNormal extends Vaisseaux{

    public VaisseauNormal() {
        tailleCargaison = 20;
        cargaison = new ArrayList<>(tailleCargaison);
    }
}
