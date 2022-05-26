import java.util.Random;

public abstract class Gladiator {
    public double currentHp;
    protected String clasa;
    protected String nume;
    protected int level;
    protected int hp, sp, dex;
    protected String hpMult, spMult, dexMult;

    public void levelUp(){
        this.level++;
    }
    public String getFullName(){
        return this.getNume() + " " + getClasa();
    }
    public void decreasaHpBy(int dmg){
        this.currentHp = this.currentHp - dmg;
    }

    public boolean isDead(){
        if(this.currentHp <= 0)
            return true;

        return  false;
    }

    public void healUp(int heal){
        this.currentHp += heal;
    }

    public void afisareGladiator(){
        System.out.println(getClasa() + " " + getNume() + " " +  " HP: " + getHp() + " SP: " + getSp() + " DEX: " + getDex() + " level: " + getLevel());
    }

    Gladiator attack(Gladiator defender){
        boolean mis;
        int dex = this.getDex() - defender.getDex();
        if(dex < 10) dex = 10;
        if(dex > 100) dex = 100;

        Random r = new Random();
        if(randomNumber(1, 100) <= dex)
            mis =  false;
        else
            mis = true;

        if(!mis){
            int atk = this.getSp() * (randomNumber(1,5)) / 10;
        }

        return defender;
    }

    public int randomNumber(int low, int high){
        Random r = new Random();
        return r.nextInt(high - low) + low;
    }

    public int getMaxDex(){
        String mult = this.getDexMult();
        if(mult == "low")
            return (int) (this.getDex() * 0.75 * level);

        if(mult == "medium")
            return this.getDex() * 1 * level;

        return (int) (this.getDex() * 1.25 * level);
    }

    public int getMaxSp(){
        String mult = this.getSpMult();
        if(mult == "low")
            return (int) (this.getSp() * 0.75 * level);

        if(mult == "medium")
            return this.getSp() * 1 * level;

        return (int) (this.getSp() * 1.25 * level);
    }

    public int getMaxHp(){
        String mult = this.getHpMult();
        if(mult == "low")
            return (int) (this.getHp() * 0.75 * level);

        if(mult == "medium")
            return this.getHp() * 1 * level;

        return (int) (this.getHp() * 1.25 * level);
    }

    public double getCurrentHp() {
        return currentHp;
    }

    public void setCurrentHp() {
        this.currentHp = getMaxHp();
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getSp() {
        return sp;
    }

    public void setSp(int sp) {
        this.sp = sp;
    }

    public int getDex() {
        return dex;
    }

    public void setDex(int dex) {
        this.dex = dex;
    }

    public int getLevel() {
        return level;
    }

    public String getClasa() {
        return clasa;
    }

    public void setClasa(String clasa) {
        this.clasa = clasa;
    }

    public String getHpMult() {
        return hpMult;
    }

    public void setHpMult(String hpMult) {
        this.hpMult = hpMult;
    }

    public String getSpMult() {
        return spMult;
    }

    public void setSpMult(String spMult) {
        this.spMult = spMult;
    }

    public String getDexMult() {
        return dexMult;
    }

    public void setDexMult(String dexMult) {
        this.dexMult = dexMult;
    }
}