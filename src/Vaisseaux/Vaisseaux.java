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
    protected int nbMoves = 0;

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
        CentreDeTri centre = listeCentre[(int) (Math.random() * 2)];
        ArrayList<Stack> recepteur = centre.getContenu();
        if (!trie) {
            Collections.sort(cargaison);
            trie = true;
        }

        try {
            while (!cargaison.isEmpty()) {
                if (nbMoves >= 10) {
                    System.out.println("Trop nombreuses tentatives d'accès aux centre");
                    System.out.println("Fin du programme");
                    System.exit(0);
                }

                if (cargaison.get(0).getMasseVolumique() == 8) {
                    if (recepteur.get(0).size() < 10) {
                        recepteur.get(0).add(cargaison.get(0));
                        cargaison.remove(0);
                    } else {
                        centre.recyclage(0);
                        nbMoves++;
                        this.dechargement();
                    }
                } else if (cargaison.get(0).getMasseVolumique() == 9) {
                    if (recepteur.get(3).size() < 10) {
                        recepteur.get(3).add(cargaison.get(0));
                        cargaison.remove(0);

                    } else {
                        centre.recyclage(3);
                        nbMoves++;
                        this.dechargement();
                    }
                } else if (cargaison.get(0).getMasseVolumique() == 10) {
                    if (recepteur.get(4).size() < 10) {
                        recepteur.get(4).add(cargaison.get(0));
                        cargaison.remove(0);
                    } else {
                        centre.recyclage(4);
                        nbMoves++;
                        this.dechargement();
                    }
                } else if (cargaison.get(0).getMasseVolumique() == 20) {
                    if (recepteur.get(2).size() < 10) {
                        recepteur.get(2).add(cargaison.get(0));
                        cargaison.remove(0);
                    } else {
                        centre.recyclage(2);
                        nbMoves++;
                        this.dechargement();
                    }
                } else if (cargaison.get(0).getMasseVolumique() == 21) {
                    if (recepteur.get(1).size() < 10) {
                        recepteur.get(1).add(cargaison.get(0));
                        cargaison.remove(0);
                    } else {
                        centre.recyclage(1);
                        nbMoves++;
                        this.dechargement();
                    }
                }
                if (cargaison.isEmpty()) {
                    System.out.println("Contenu vide");
                    centre.chargerFileAttente(this);
                    trie = false;
                }
            }
        } catch (StackOverflowError e) {
            System.out.println("Fin de la simulation");
            System.exit(0);
        }
    }
}
