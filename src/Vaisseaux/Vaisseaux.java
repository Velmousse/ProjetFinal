package Vaisseaux;

import Déchets.*;
import Planètes.*;
import CentreDeTri.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public abstract class Vaisseaux {
    protected ArrayList<Dechets> cargaison;
    protected int tailleCargaison;

    public void chargement(Planetes planete) {
        int rndNumber;

        for (int i = 0; i < tailleCargaison; i++) {
            rndNumber = (int) (Math.random() * 101);

            if (rndNumber < planete.getQteGadolinium())
                cargaison.add(new Gadolinium());
            else if (rndNumber < planete.getQteNeptunium())
                cargaison.add(new Neptunium());
            else if (rndNumber < planete.getQtePlutonium())
                cargaison.add(new Plutonium());
            else if (rndNumber < planete.getQteTerbium())
                cargaison.add(new Terbium());
            else
                cargaison.add(new Thulium());
        }
    }

    public void dechargement(CentreDeTri[] listeCentre) {
        boolean peutVider = true;
        CentreDeTri centre = listeCentre[(int) (Math.random() * 101)];
        ArrayList<Stack> recepteur = centre.getContenu();
        Collections.sort(cargaison);


        while (peutVider) {
            for (Dechets dechet : cargaison) {
                if (dechet.getMasseVolumique() == 8) {
                    if (recepteur.get(0).size() < 10) {
                        recepteur.get(0).add(dechet);
                        cargaison.remove(dechet);
                    } else dechargement(listeCentre);
                } else if (dechet.getMasseVolumique() == 9) {
                    if (recepteur.get(3).size() < 10) {
                        recepteur.get(3).add(dechet);
                        cargaison.remove(dechet);
                    } else dechargement(listeCentre);
                } else if (dechet.getMasseVolumique() == 10) {
                    if (recepteur.get(4).size() < 10) {
                        recepteur.get(4).add(dechet);
                        cargaison.remove(dechet);
                    } else dechargement(listeCentre);
                } else if (dechet.getMasseVolumique() == 20) {
                    if (recepteur.get(2).size() < 10) {
                        recepteur.get(2).add(dechet);
                        cargaison.remove(dechet);
                    } else dechargement(listeCentre);
                } else {
                    if (recepteur.get(1).size() < 10) {
                        recepteur.get(1).add(dechet);
                        cargaison.remove(dechet);
                    } else dechargement(listeCentre);
                }
            }
        }

        if (cargaison.isEmpty()) {
            peutVider = false;
            centre.chargerFileAttente(this);
        }
    }
}
