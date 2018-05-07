package CentreDeTri;

import Déchets.*;
import Planètes.*;
import Vaisseaux.*;

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
            System.out.println("Ajout à la file d'attente");
            fileAttente.add(vaisseau);
        }
        else {
            System.out.println("Vaisseau quitte la file d'attente");
            fileAttente.peek().chargement(tableauPlanete[(int) (Math.random() * 1)]);
        }
    }

    public ArrayList<Stack> getContenu() {
        return contenu;
    }

    public Queue<Vaisseaux> getFileAttente() {
        return fileAttente;
    }

    public void recyclage(int stack) {
        if (!fileAttente.isEmpty()) {
            System.out.println("Recyclage");
            Stack<Dechets> aVider = contenu.get(stack);
            int ceQuOnVide = (int) aVider.peek().getPourcentageRecyclable() * 10;
            Vaisseaux videur = fileAttente.poll();
            for (int i = 0; i < ceQuOnVide; i++)
                videur.recycler(aVider.pop());
            System.out.println("Vaisseau plein (recyclage)");
            videur.dechargement();
        }
        else {
            System.out.println("La file d'attente est vide");
        }
    }
}
