package gladiatori;

import java.util.List;

public class Colosseum {
    private GladiatorFactory gladFact;

    public Colosseum(GladiatorFactory gladFact){
        this.gladFact = gladFact;
    }

    public void generateGladiators(List<String> concurenti){
        for (String s : concurenti)
            gladFact.generateRandomGladiator(s);
    }

    public void generateGladiators(String concurent){
        gladFact.generateRandomGladiator(concurent);
    }

    public void simulateCombat(Combat lupta){
        lupta.simulate();
        Gladiator a;
        Gladiator b;
        a = lupta.getParticipant(1);
        b = lupta.getParticipant(2);

        if(a != null && b != null)
            System.out.println("Duel " + a.getNume() + " versus " + b.getNume());

        if(a != null)
            a.afisareGladiator();

        if(b != null)
            b.afisareGladiator();

        for(var i : lupta.getCombatLog())
            System.out.println(i);
    }

    void afisareGladiatoriDinColosseum(){
        System.out.println("Concurentii din colosseum");
        gladFact.afisareGladiatori();

    }

    Gladiator getChampion(Tournament tournament){
        tournament.addAll(gladFact.getAllGladiators());
        tournament.startTurneu();
        return tournament.getCastigator();
    }

    List<Gladiator> getParticipanti(){
        return gladFact.getAllGladiators();
    }

    Gladiator getParticipant(int nr){
        return gladFact.getGladiator(nr);
    }
}