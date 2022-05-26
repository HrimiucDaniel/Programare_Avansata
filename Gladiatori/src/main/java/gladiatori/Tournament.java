package gladiatori;

import java.util.ArrayList;
import java.util.List;

public class Tournament {
    private int nrConcurenti, multiplu;
    private List<Gladiator> Concurenti = new ArrayList<>();
    private List<Gladiator> Turneu = new ArrayList<>();
    private Gladiator Castigator;

    public Tournament(){
        nrConcurenti = 0;
    }

    public void add(Gladiator a){
        Concurenti.add(a);
    }

    public void addAll(List<Gladiator> a) {
        for(Gladiator x : a) Concurenti.add(x);
    }

    public void ResetVector() {
        Turneu.clear();
        int nr = 1;
        while (nr < Concurenti.size()) nr *= 2;
        for (int i = 0; i < nr; i++) Turneu.add(null);
        multiplu = nr;
    }

    public void AranjareConcurenti() {
        int j = 0;
        int multiplicator = multiplu/2;
        while (j < Concurenti.size()) {
            for(int i = 0; i < multiplu && j < Concurenti.size(); i = i + multiplicator) {
                if (Turneu.get(i) == null) Turneu.add(i,Concurenti.get(j++));
                multiplicator /= 2;
            }
        }
    }

    public void AfisareConcurenti() {
        System.out.println("Concurentii:");
    }

    public void startTurneu(){
        AfisareConcurenti();
        while (Concurenti.size() > 1) {
            ResetVector();
            AranjareConcurenti();
            Concurenti.clear();
            for (int i = 0; i < Turneu.size()/2;i+=2) {
                Combat fight = new Combat(Turneu.get(i),Turneu.get(i+1));
                fight.simulate();
                Gladiator aux = fight.getCastigator();
                if (aux != null) Concurenti.add(aux);
            }
            multiplu /= 2;
        }
        Castigator = Concurenti.get(0);
    }

    public Gladiator getCastigator(){
        return Castigator;
    }

}

