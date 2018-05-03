import CentreDeTri.*;
import Planètes.*;
import Vaisseaux.*;


public class Main {
    public static void main(String[] args) {
        Planetes[] tableauPlanete = {new PlaneteBleue(), new PlaneteJaune(),
                new PlaneteNoire(), new PlaneteRouge(), new PlaneteVerte()};

        CentreDeTri[] listeTris = new CentreDeTri[10];

        for (int i = 0; i < listeTris.length; i++)
            listeTris[i] = new CentreDeTri();

        for (CentreDeTri centre : listeTris)
            centre.setListeTris(listeTris);

        Vaisseaux test = new VaisseauLourd();
        test.setListeCentre(listeTris);
        test.chargement(tableauPlanete[(int)Math.random()*5]);

        /*
        Vaisseaux[] listeVaisseauxLourds = new VaisseauLourd[25];
        Vaisseaux[] listeVaisseauxNormaux = new VaisseauNormal[25];
        Vaisseaux[] listeVaisseauxLegers = new VaisseauLeger[25];

        for (int i = 0; i < 25; i++) {
            listeVaisseauxLourds[i] = new VaisseauLourd();
            listeVaisseauxLourds[i].setListeCentre(listeTris);
            listeVaisseauxNormaux[i] = new VaisseauNormal();
            listeVaisseauxNormaux[i].setListeCentre(listeTris);
            listeVaisseauxLegers[i] = new VaisseauLeger();
            listeVaisseauxLegers[i].setListeCentre(listeTris);
            listeVaisseauxLourds[i].chargement(tableauPlanete[(int)Math.random()*5]);
            listeVaisseauxNormaux[i].chargement(tableauPlanete[(int)Math.random()*5]);
            listeVaisseauxLegers[i].chargement(tableauPlanete[(int)Math.random()*5]);
        }
        */
    }
}
