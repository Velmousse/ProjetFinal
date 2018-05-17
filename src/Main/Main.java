package Main;

import CentreDeTri.*;
import Planètes.*;
import Vaisseaux.*;
import Log.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.net.Socket;


public class Main {
    public static Log log = new Log();
    public static NodeList nodeListe;

    public static void main(String[] args) throws Exception{

        Socket socket = new Socket("127.0.0.1", 8080);
        OutputStream fluxSortant = socket.getOutputStream();
        OutputStreamWriter sortie = new OutputStreamWriter(fluxSortant);
        sortie.write("Connection\n");
        sortie.flush();

        InputStream fluxEntrant = socket.getInputStream();
        BufferedReader entree = new BufferedReader(new InputStreamReader(fluxEntrant));
        String message = entree.readLine();

        File file = new File("src/Configuration.xml");

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbf.newDocumentBuilder();
        Document doc = dBuilder.parse(file);

        Node root = doc.getDocumentElement();
        clean(root);
        nodeListe = root.getChildNodes();


        //Planètes
        int compteur = 0;

        for (int i = 0; i <= 4; i++)
            compteur += Integer.parseInt(nodeListe.item(1).getChildNodes().item(i).getChildNodes().item(0).getTextContent());
        Planetes[] tableauPlanete  = new Planetes[compteur];

        int tick = 0;
        for (int i = 0; i < Integer.parseInt(nodeListe.item(1).getChildNodes().item(0).getChildNodes().item(0).getTextContent()); i++)
            tableauPlanete[i] = new PlaneteBleue();
        tick += Integer.parseInt(nodeListe.item(1).getChildNodes().item(0).getChildNodes().item(0).getTextContent());

        for (int i = 0; i < Integer.parseInt(nodeListe.item(1).getChildNodes().item(1).getChildNodes().item(0).getTextContent()); i++)
            tableauPlanete[i] = new PlaneteJaune();
        tick += Integer.parseInt(nodeListe.item(1).getChildNodes().item(1).getChildNodes().item(0).getTextContent());

        for (int i = 0; i < Integer.parseInt(nodeListe.item(1).getChildNodes().item(2).getChildNodes().item(0).getTextContent()); i++)
            tableauPlanete[i] = new PlaneteVerte();
        tick += Integer.parseInt(nodeListe.item(1).getChildNodes().item(2).getChildNodes().item(0).getTextContent());

        for (int i = 0; i < Integer.parseInt(nodeListe.item(1).getChildNodes().item(3).getChildNodes().item(0).getTextContent()); i++)
            tableauPlanete[i] = new PlaneteRouge();
        tick += Integer.parseInt(nodeListe.item(1).getChildNodes().item(3).getChildNodes().item(0).getTextContent());

        for (int i = 0; i < Integer.parseInt(nodeListe.item(1).getChildNodes().item(4).getChildNodes().item(0).getTextContent()); i++)
            tableauPlanete[i] = new PlaneteNoire();
        tick += Integer.parseInt(nodeListe.item(1).getChildNodes().item(4).getChildNodes().item(0).getTextContent());




        //Centres de tris
        CentreDeTri[] listeTris = new CentreDeTri[Integer.parseInt(nodeListe.item(2).getChildNodes().item(0).getTextContent())];

        for (int i = 0; i < listeTris.length; i++)
            listeTris[i] = new CentreDeTri();

        for (CentreDeTri centre : listeTris)
            centre.setListeTris(listeTris);




        //Vaisseaux
        compteur = 0;

        for (int i = 0; i <= 2; i++)
            compteur += Integer.parseInt(nodeListe.item(0).getChildNodes().item(i).getChildNodes().item(0).getTextContent());
        Vaisseaux[] tableauVaisseaux = new Vaisseaux[compteur];

        tick = 0;
        for (int i = 0; i < Integer.parseInt(nodeListe.item(0).getChildNodes().item(0).getChildNodes().item(0).getTextContent()); i++)
            tableauVaisseaux[i] = new VaisseauLourd();
        tick += Integer.parseInt(nodeListe.item(0).getChildNodes().item(0).getChildNodes().item(0).getTextContent());

        for (int i = 0; i < Integer.parseInt(nodeListe.item(0).getChildNodes().item(1).getChildNodes().item(0).getTextContent()); i++)
            tableauVaisseaux[i + tick] = new VaisseauNormal();
        tick += Integer.parseInt(nodeListe.item(0).getChildNodes().item(1).getChildNodes().item(0).getTextContent());

        for (int i = 0; i < Integer.parseInt(nodeListe.item(0).getChildNodes().item(2).getChildNodes().item(0).getTextContent()); i++)
            tableauVaisseaux[i + tick] = new VaisseauLeger();



        log.writeLog("Nombre de vaisseaux: " + compteur +
            "\nNombre de centres de tri: " + listeTris.length + "\n" +
                "Nombre de planètes: " + tableauPlanete.length + "\n");

        Main.log.saveLog();


        for (int i = 0; i < tableauVaisseaux.length; i++) {
            tableauVaisseaux[i].setListeCentre(listeTris);
            tableauVaisseaux[i].chargement(tableauPlanete[(int) Math.random()*(tableauPlanete.length + 1)]);
        }
    }

    public static void clean(Node node) { //Merci Internet
        NodeList childNodes = node.getChildNodes();
        for (int n = childNodes.getLength() - 1; n >= 0; n--)
        {
            Node child = childNodes.item(n);
            short nodeType = child.getNodeType();

            if (nodeType == Node.ELEMENT_NODE)
                clean(child);
            else if (nodeType == Node.TEXT_NODE)
            {
                String trimmedNodeVal = child.getNodeValue().trim();
                if (trimmedNodeVal.length() == 0)
                    node.removeChild(child);
                else
                    child.setNodeValue(trimmedNodeVal);
            }
            else if (nodeType == Node.COMMENT_NODE)
                node.removeChild(child);
        }
    }
}
