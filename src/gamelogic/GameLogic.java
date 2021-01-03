package gamelogic;

import ability.Ability;
import ability.HalfDamage;
import ability.MoreAttackPower;
import ability.PlusFiveHp;
import entity.Player;

import java.util.List;
import java.util.Random;

public class GameLogic {

    private double lostHealth;
    private double initialHealth;
    private double finalHealth;
    private double damage;
    private Random randnom;

    boolean attackPlayerActivBuff;
    boolean defendPlayerActivBuff;

    public GameLogic() {
        this.randnom = new Random();
    }

    public void playerVSplayer(Player attackPlayer, Player defendPlayer, List<Ability> abilities){
        setSelectedAbilities(attackPlayer, defendPlayer, abilities);
        startFight3(attackPlayer, defendPlayer);
        CombatLog.combatLog(attackPlayer, defendPlayer, attackPlayerActivBuff, defendPlayerActivBuff, initialHealth);
    }


                //fac sa selectez abilitatile random dupa fiecare runda
    private void setSelectedAbilities(Player attackPlayer, Player defendPlayer, List<Ability> abilities){


        if(attackPlayer.isAbilitySelectedRandom()){
            attackPlayer.setAbility(abilities.get(randnom.nextInt(abilities.size())));
        }

        if(defendPlayer.isAbilitySelectedRandom()){
            defendPlayer.setAbility(abilities.get(randnom.nextInt(abilities.size())));
        }
    }


    public void startFight3(Player attackPlayer, Player defendPlayer){
        randomBuff(attackPlayer, defendPlayer);
        damage = attackPlayer.getAttackPower();

                //2 activ
        if(attackPlayerActivBuff && attackPlayer.getAbility() instanceof MoreAttackPower) {
                damage = attackPlayer.getAttackPower() * 1.5;
        }

            //1 activ
        if(defendPlayerActivBuff &&defendPlayer.getAbility() instanceof HalfDamage) {
                lostHealth = (defendPlayer.getDefensePower() - damage) * 0.5;
        }

        lostHealth = defendPlayer.getDefensePower() - damage;

            //3 activ
        if(defendPlayerActivBuff &&defendPlayer.getAbility() instanceof PlusFiveHp) {

                initialHealth = defendPlayer.getHealth();
                lostHealth = defendPlayer.getDefensePower() - damage;
                finalHealth = defendPlayer.getHealth() + lostHealth;

                if (initialHealth >= 30 && finalHealth < 30) {
                    lostHealth = (defendPlayer.getDefensePower() - damage + 5);
                }
        }
        defendPlayer.setHealth(defendPlayer.getHealth() + lostHealth);
    }


    private void randomBuff(Player attackPlayer, Player defendPlayer){
        attackPlayerActivBuff = attackPlayer.getAbility().activBuff();
        defendPlayerActivBuff = defendPlayer.getAbility().activBuff();
    }

    public boolean isAttackPlayerActivBuff() {
        return attackPlayerActivBuff;
    }

    public boolean isDefendPlayerActivBuff() {
        return defendPlayerActivBuff;
    }
}
