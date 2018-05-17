package Planètes;

import Main.Main;
import org.w3c.dom.Attr;
import org.w3c.dom.Node;

public class PlaneteJaune extends Planetes{
    public PlaneteJaune() {

        Node noeud = Main.nodeListe.item(1).getChildNodes().item(1).getChildNodes().item(1);
        qteGadolinium = Integer.parseInt(noeud.getTextContent());
        noeud = Main.nodeListe.item(1).getChildNodes().item(1).getChildNodes().item(2);
        qteNeptunium = Integer.parseInt(noeud.getTextContent());
        noeud = Main.nodeListe.item(1).getChildNodes().item(1).getChildNodes().item(3);
        qtePlutonium = Integer.parseInt(noeud.getTextContent());
        noeud = Main.nodeListe.item(1).getChildNodes().item(1).getChildNodes().item(4);
        qteThulium = Integer.parseInt(noeud.getTextContent());
        noeud = Main.nodeListe.item(1).getChildNodes().item(1).getChildNodes().item(5);
        qteTerbium = Integer.parseInt(noeud.getTextContent());

    }
}
