package Vaisseaux;

import Déchets.*;
import Exceptions.FilesAttentePleines;
import Exceptions.TypesMatiereVides;
import Main.*;
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
        Main.log.writeLog("Vaisseau plein\n");
        try {
            this.dechargement();
        } catch (TypesMatiereVides e) {
            Main.log.writeLog("Les piles d'une matière sont pleines\n");
            Main.log.writeLog("Fin du programme\n");
            Main.log.saveLog();
            System.exit(0);
        }

    }

    public void recycler(Dechets dechet) {
        cargaison.add(dechet);
    }

    public void dechargement() throws TypesMatiereVides{
        Main.log.writeLog("Déchargement\n");
        CentreDeTri centre = listeCentre[(int) (Math.random() * 2)];
        ArrayList<Stack> recepteur = centre.getContenu();
        if (!trie) {
            Collections.sort(cargaison);
            trie = true;
        }

        try {
            while (!cargaison.isEmpty()) {
                if (nbMoves >= 10) {
                    throw new TypesMatiereVides();
                }

                try {
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
                        Main.log.writeLog("Contenu vide\n");
                        centre.chargerFileAttente(this);
                        trie = false;
                    }
                } catch (FilesAttentePleines e) {
                    Main.log.writeLog("Files d'attente pleines sans se vider\n");
                    Main.log.writeLog("Fin du programme\n");
                    Main.log.saveLog();
                    System.exit(0);
                }
            }
        } catch (StackOverflowError e) {
            Main.log.writeLog("Fin de la simulation\n");
            Main.log.saveLog();
            System.exit(0);
        }
    }
}
