package Vaisseaux;

import Déchets.*;
import Planètes.*;
import CentreDeTri.*;

import java.util.*;

public abstract class Vaisseaux {
    protected ArrayList<Dechets> cargaison;
    protected int tailleCargaison;
    protected CentreDeTri[] listeCentre = new CentreDeTri[10];
    protected boolean trie = false;

    public void setListeCentre(CentreDeTri[] listeCentre) {
        this.listeCentre = listeCentre;
    }

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
        System.out.println("Vaisseau plein");
        this.dechargement();
    }

    public void recycler(Dechets dechet) {
        cargaison.add(dechet);
    }

    public void dechargement() {
        System.out.println("Déchargement");
        CentreDeTri centre = listeCentre[(int) (Math.random() * 10)];
        ArrayList<Stack> recepteur = centre.getContenu();
        if (!trie) {
            Collections.sort(cargaison);
            trie = true;
        }

        Iterator<Dechets> i = cargaison.iterator();

            while (i.hasNext()){
                Dechets dechet = i.next();

                if (dechet.getMasseVolumique() == 8) {
                    if (recepteur.get(0).size() < 10) {
                        recepteur.get(0).add(dechet);
                        i.remove();
                    } else {
                        centre.recyclage(0);
                        dechargement();
                    }
                } else if (dechet.getMasseVolumique() == 9) {
                    if (recepteur.get(3).size() < 10) {
                        recepteur.get(3).add(dechet);
                        i.remove();

                    } else {
                        centre.recyclage(3);
                        dechargement();
                    }
                } else if (dechet.getMasseVolumique() == 10) {
                    if (recepteur.get(4).size() < 10) {
                        recepteur.get(4).add(dechet);
                        i.remove();
                    } else {
                        centre.recyclage(4);
                        dechargement();
                    }
                } else if (dechet.getMasseVolumique() == 20) {
                    if (recepteur.get(2).size() < 10) {
                        recepteur.get(2).add(dechet);
                        i.remove();
                    } else {
                        centre.recyclage(2);
                        dechargement();
                    }
                } else if (dechet.getMasseVolumique() == 21) {
                    if (recepteur.get(1).size() < 10) {
                        recepteur.get(1).add(dechet);
                        i.remove();
                    } else {
                        centre.recyclage(1);
                        dechargement();
                    }
                }
                if (cargaison.isEmpty()) {
                    System.out.println("Contenu vide");
                    trie = false;
                }

        }
    }
}
