public class Brutal extends Gladiator{
    public Brutal(String nume){
        this.nume = nume;
        this.level = randomNumber(1, 5);
        this.clasa = "Brutal";
        this.hpMult = "high";
        this.spMult = "high";
        this.dexMult = "low";
        this.hp = randomNumber(1, 25);
        this.dex = randomNumber(1, 25);
        this.sp = randomNumber(1, 25);
    }
}