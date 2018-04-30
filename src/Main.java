import CentreDeTri.*;
import Planètes.*;

public class Main {
    public static void main(String[] args) {
        Planetes[] tableauPlanete = {new PlaneteBleue(), new PlaneteJaune(),
                new PlaneteNoire(), new PlaneteRouge(), new PlaneteVerte()};

        CentreDeTri[] listeTris = new CentreDeTri[100];
        for (CentreDeTri emplacement: listeTris)
            emplacement = new CentreDeTri();
    }
}
