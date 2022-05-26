public class Archer extends Gladiator{
    public Archer(String nume){
        this.nume = nume;
        this.level = randomNumber(1, 5);
        this.clasa = "Archer";
        this.hpMult = "medium";
        this.spMult = "medium";
        this.dexMult = "high";
        this.hp = randomNumber(1, 25);
        this.dex = randomNumber(1, 25);
        this.sp = randomNumber(1, 25);
    }
}