package gladiatori;

public class Fighter extends Gladiator{
    public Fighter(String nume){
        this.nume = nume;
        this.level = randomNumber(1, 5);
        this.clasa = "Fighter";
        this.hpMult = "medium";
        this.spMult = "medium";
        this.dexMult = "medium";
        this.hp = randomNumber(1, 25);
        this.dex = randomNumber(1, 25);
        this.sp = randomNumber(1, 25);
    }
}