package Déchets;

import Main.Main;
import org.w3c.dom.Node;

public class Neptunium extends Dechets{
    public Neptunium() {
        Node noeud = Main.nodeListe.item(3).getChildNodes().item(1).getChildNodes().item(0);
        masseVolumique = Integer.parseInt(noeud.getTextContent());
        noeud = Main.nodeListe.item(3).getChildNodes().item(1).getChildNodes().item(1);
        pourcentageRecyclable = Float.parseFloat(noeud.getTextContent());
    }
}
