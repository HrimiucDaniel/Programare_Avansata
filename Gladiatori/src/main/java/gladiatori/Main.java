package gladiatori;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        GladiatorFactory a = new GladiatorFactory();
        Colosseum b = new Colosseum(a);
        List<String> c = new ArrayList<>();
        c.add("Bogdan");
        c.add("Dorin");
        b.generateGladiators("Ion");
        b.generateGladiators("Vasile");
        b.generateGladiators("Andrei");
        b.generateGladiators("Florin");
        b.generateGladiators("Marin");
        b.generateGladiators(c);
        b.afisareGladiatoriDinColosseum();

        Tournament d = new Tournament();

        Gladiator e = b.getChampion(d);
        System.out.println("Castigatorul Turneului este: ");
        e.afisareGladiator();
        System.out.println();
        System.out.println();

        b.simulateCombat(new Combat(b.getParticipant(1), b.getParticipant(2)));
    }
}
