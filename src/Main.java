import CentreDeTri.*;
import Planètes.*;
import Vaisseaux.*;

public class Main {
    public static void main(String[] args) {
        Planetes[] tableauPlanete = {new PlaneteBleue(), new PlaneteJaune(),
                new PlaneteNoire(), new PlaneteRouge(), new PlaneteVerte()};

        CentreDeTri[] listeTris = new CentreDeTri[100];
        for (int i = 0; i < listeTris.length; i++)
            listeTris[i] = new CentreDeTri();

        Vaisseaux test = new VaisseauLourd();
        while (true) {
            test.chargement(tableauPlanete[(int) (Math.random() * 6)]);
            test.dechargement(listeTris);
        }
    }
}
