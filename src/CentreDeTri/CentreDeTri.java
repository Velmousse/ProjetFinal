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

    public CentreDeTri() {
        contenu.add(new Stack<Gadolinium>());
        contenu.get(0).setSize(10);
        contenu.add(new Stack<Neptunium>());
        contenu.get(1).setSize(10);
        contenu.add(new Stack<Plutonium>());
        contenu.get(2).setSize(10);
        contenu.add(new Stack<Thulium>());
        contenu.get(3).setSize(10);
        contenu.add(new Stack<Terbium>());
        contenu.get(4).setSize(10);
    }

    public void chargerFileAttente(Vaisseaux vaisseau) {
        if (fileAttente.size() < 10)
            fileAttente.add(vaisseau);
        else {
            fileAttente.peek().chargement(tableauPlanete[(int) (Math.random() * 5)]);
        }
    }

    public ArrayList<Stack> getContenu() {
        return contenu;
    }

    public Queue<Vaisseaux> getFileAttente() {
        return fileAttente;
    }
}
