package gamelogic;

import ability.HalfDamage;
import ability.MoreAttackPower;
import ability.PlusFiveHp;
import entity.Player;

public class CombatLog {

    private static int roundCount;


    public static void combatLog(Player attackPlayer, Player defendPlayer, boolean attackPlayerActivBuff, boolean defendPlayerActivBuff, double initialHealth) {


        roudCount(attackPlayer);

        if(attackPlayer.getAbility() instanceof MoreAttackPower) {
            if (attackPlayerActivBuff) {
                showAttackPlayerLog(attackPlayer);
            }
        }

        if (defendPlayerActivBuff && defendPlayer.getAbility() instanceof HalfDamage) {
            showDefendPlayerLog(defendPlayer);
            return;
        }

        if (initialHealth >= 30 && defendPlayer.getHealth() < 30) {
            if (defendPlayerActivBuff && defendPlayer.getAbility() instanceof PlusFiveHp) {
                showDefendPlayerLog(defendPlayer);
                return;
            }
        }

        if(attackPlayer.getAbility() instanceof MoreAttackPower) {
            if (attackPlayerActivBuff) {
                System.out.println(defendPlayer.getCharacterName() + " has now " + defendPlayer.getHealth() + "\n");
                return;
            }
        }

        showNoAbilityActovLog(defendPlayer);
    }

    private static void roudCount(Player attackPlayer){
        roundCount++;
        System.out.println("Round " + roundCount + ":");
        System.out.println(attackPlayer.getCharacterName() + " attacks");
    }


    private  static void showDefendPlayerLog(Player defendPlayer){
        System.out.println(defendPlayer.getCharacterName() + " activate ability " + defendPlayer.getAbility().getAbilityType() + "\n" +
                           defendPlayer.getCharacterName() + " has now " + defendPlayer.getHealth() + "\n");

    }

    private static void showAttackPlayerLog(Player attackPlayer){
        System.out.println(attackPlayer.getCharacterName() + " activates ability " + attackPlayer.getAbility().getAbilityType());
    }

    private static void showNoAbilityActovLog(Player defendPlayer){
        System.out.println("No ability activated" + "\n" +
                           defendPlayer.getCharacterName() + " has now " + defendPlayer.getHealth() + "\n");
    }

    public static int getRoundCount(Player defendPlayer) {
        return roundCount;
    }

    public static void setRoundCount(int roundCount) {
        CombatLog.roundCount = roundCount;
    }
}
