package CentreDeTri;

import Déchets.*;
import Exceptions.FilesAttentePleines;
import Exceptions.TypesMatiereVides;
import Planètes.*;
import Vaisseaux.*;
import Main.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CentreDeTri {
    private ArrayList<Stack> contenu = new ArrayList<>(5);
    private Queue<Vaisseaux> fileAttente = new LinkedList<Vaisseaux>();
    private Planetes[] tableauPlanete = {new PlaneteBleue(), new PlaneteJaune(),
            new PlaneteNoire(), new PlaneteRouge(), new PlaneteVerte()};
    CentreDeTri[] listeTris;



    public CentreDeTri() {
        contenu.add(new Stack<Gadolinium>());
        contenu.add(new Stack<Neptunium>());
        contenu.add(new Stack<Plutonium>());
        contenu.add(new Stack<Thulium>());
        contenu.add(new Stack<Terbium>());
    }

    public void setListeTris(CentreDeTri[] listeTris) {
        this.listeTris = listeTris;
    }

    public void chargerFileAttente(Vaisseaux vaisseau) {
        if (fileAttente.size() < 1) {
            Main.log.writeLog("Ajout à la file d'attente\n");
            fileAttente.add(vaisseau);
        }
        else {
            Main.log.writeLog("Vaisseau quitte la file d'attente\n");
            fileAttente.peek().chargement(tableauPlanete[(int) (Math.random() * 1)]);
        }
    }

    public ArrayList<Stack> getContenu() {
        return contenu;
    }

    public Queue<Vaisseaux> getFileAttente() {
        return fileAttente;
    }

    public void recyclage(int stack) throws FilesAttentePleines{
        if (!fileAttente.isEmpty()) {
            Main.log.writeLog("Recyclage\n");
            Stack<Dechets> aVider = contenu.get(stack);
            int ceQuOnVide = (int) aVider.peek().getPourcentageRecyclable() * 10;
            Vaisseaux videur = fileAttente.poll();
            for (int i = 0; i < ceQuOnVide; i++)
                videur.recycler(aVider.pop());
            Main.log.writeLog("Vaisseau plein (recyclage)\n");
            try {
                videur.dechargement();
            } catch (TypesMatiereVides e) {
                Main.log.writeLog("Les piles d'une matière sont pleines\n");
                Main.log.writeLog("Fin du programme\n");
                Main.log.saveLog();
                System.exit(0);
            }

        } else if (fileAttente.size() == 10) {
            throw new FilesAttentePleines();
        } else {
            Main.log.writeLog("La file d'attente est vide\n");
        }
    }
}
