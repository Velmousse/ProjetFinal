package Main;

import CentreDeTri.*;
import Planètes.*;
import Vaisseaux.*;
import Log.*;


public class Main {
    public static Log log = new Log();

    public static void main(String[] args) {
        Planetes[] tableauPlanete = {new PlaneteBleue(), new PlaneteJaune(),
                new PlaneteNoire(), new PlaneteRouge(), new PlaneteVerte()};

        CentreDeTri[] listeTris = new CentreDeTri[2];

        for (int i = 0; i < listeTris.length; i++)
            listeTris[i] = new CentreDeTri();

        for (CentreDeTri centre : listeTris)
            centre.setListeTris(listeTris);


        VaisseauLourd vl = new VaisseauLourd();
        vl.setListeCentre(listeTris);
        VaisseauNormal vn = new VaisseauNormal();
        vn.setListeCentre(listeTris);
        VaisseauLeger vle = new VaisseauLeger();
        vle.setListeCentre(listeTris);

        log.writeLog("Nombre de vaisseaux: " + 3 +
            "\nNombre de centres de tri: " + listeTris.length);

        vl.chargement(tableauPlanete[(int)Math.random()*5]);
        vn.chargement(tableauPlanete[(int)Math.random()*5]);
        vle.chargement(tableauPlanete[(int)Math.random()*5]);

        Main.log.saveLog();
    }
}
