package gladiatori;

public class Assasin extends Gladiator{
    public Assasin(String nume){
        this.nume = nume;
        this.level = randomNumber(1, 5);
        this.clasa = "Assasin";
        this.hpMult = "low";
        this.spMult = "high";
        this.dexMult = "high";
        this.hp = randomNumber(1, 25);
        this.dex = randomNumber(1, 25);
        this.sp = randomNumber(1, 25);
    }
}