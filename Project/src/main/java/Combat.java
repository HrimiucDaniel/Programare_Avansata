import javafx.scene.control.skin.ComboBoxListViewSkin;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Combat {
   private Gladiator gladiator1;
   private Gladiator gladiator2;
   private Gladiator castigator;
   private List<String> CombatLog = new ArrayList<>();

    public Combat(Gladiator a, Gladiator b){
        gladiator1 = a;
        gladiator2 = b;
    }

    void simulate(){
        double HPglad1, HPglad2;
        if (gladiator1 == null && gladiator2 == null) castigator = null;
        if (gladiator1 == null) {
            gladiator2.levelUp();
            castigator = gladiator2;
        }
        if (gladiator2 == null) {
            gladiator1.levelUp();
            castigator = gladiator1;
        }
        CombatLog.add("Begin!");
        gladiator1.setCurrentHp();
        gladiator2.setCurrentHp();
        Random rand = new Random();

        int number = rand.nextInt(1)+1;
        int nr = 1;
        while (gladiator1.isDead() == false && gladiator2.isDead() == false  && nr <=100){
            nr++;
            HPglad1 = gladiator1.getCurrentHp();
            HPglad2 = gladiator2.getCurrentHp();
            if (number == 1) {
                gladiator2 = gladiator1.attack(gladiator2);
                if (HPglad2 == gladiator2.getCurrentHp())
                    CombatLog.add(gladiator1.getFullName()+" missed");
                else
                    CombatLog.add(gladiator1.getFullName()+ " deals " + Double.toString(HPglad2 - gladiator2.getCurrentHp()) + " damage");

                if (gladiator2.isDead() == false) {
                    gladiator1 = gladiator2.attack(gladiator1);
                    if (HPglad1 == gladiator1.getCurrentHp())
                        CombatLog.add(gladiator2.getFullName() + " missed");
                    else
                        CombatLog.add(gladiator2.getFullName() + " deals " + Double.toString(HPglad1 - gladiator1.getCurrentHp()) + " damage");
                }
            }else{
                gladiator1 = gladiator2.attack(gladiator1);
                if (HPglad1 == gladiator1.getCurrentHp())
                    CombatLog.add(gladiator2.getFullName() + " missed");
                else
                    CombatLog.add(gladiator2.getFullName() + " deals " + Double.toString(HPglad1 - gladiator1.getCurrentHp()) + " damage");

                if (gladiator1.isDead() == false) {
                    gladiator2 = gladiator1.attack(gladiator2);
                    if (HPglad2 == gladiator2.getCurrentHp())
                        CombatLog.add(gladiator1.getFullName() + " missed");
                    else
                        CombatLog.add(gladiator1.getFullName() + " deals " + Double.toString(HPglad2 - gladiator2.getCurrentHp()) + " damage");
                }

            }
            if (gladiator1.isDead() == false) {
                CombatLog.add(gladiator2.getFullName() + " has died, " + gladiator1.getFullName() + " wins!");
                gladiator1.levelUp();
                castigator = gladiator1;
            }else {
                CombatLog.add(gladiator1.getFullName() + " has died, " + gladiator2.getFullName() + " wins!");
                gladiator2.levelUp();
                castigator = gladiator2;
            }
        }
    }

    List<String> getCombatLog() {
        return CombatLog;
    }

    Gladiator getCastigator() {
        return castigator;
    }

    Gladiator getParticipant(int nr) {
        if (nr == 1) return gladiator1;
        return gladiator2;
    }
}
