package Déchets;

import java.util.*;

public abstract class Dechets implements Comparable<Dechets> {

    protected int masseVolumique;
    protected double pourcentageRecyclable;

    public int getMasseVolumique() {
        return masseVolumique;
    }

    public double getPourcentageRecyclable() {
        return pourcentageRecyclable;
    }

    public int compareTo(Dechets o) {
        return masseVolumique - o.getMasseVolumique();
    }
}
