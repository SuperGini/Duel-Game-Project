package gamelogic;

import ability.Ability;
import ability.HalfDamage;
import ability.MoreAttackPower;
import ability.PlusFiveHp;
import entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AssembleGame {

    private GameInitialUI gameInitialUI;
    private GameSwitch gameSwitch;
    private Player player1;
    private Player player2;
    private Random random;
    private List<Ability> abilities = new ArrayList<>();


    public AssembleGame() {
        this.gameInitialUI = new GameInitialUI();
        this.gameSwitch = new GameSwitch();
        this.random = new Random();
        createPlayers();
        addAbilities();
    }

    public void createPlayers(){
         player1 = new Player.Builder()
                .withCharacterName("Character 1")
                .withDefensePower(random.nextInt(6) + 10)
                .withAttackPower(random.nextInt(6) + 15)
                .build();

         player2 = new Player.Builder()
                .withCharacterName("Character 2")
                .withDefensePower(random.nextInt(6) + 10)
                .withAttackPower(random.nextInt(6) + 15)
                .build();
    }

    public void addAbilities(){
        abilities.add(new HalfDamage("50% less damage", 1));
        abilities.add(new MoreAttackPower("50% more attack power", 2));
        abilities.add(new PlusFiveHp("+5 hp if hp drops under 30", 3));
    }

    public void andPlay(){
        gameInitialUI.sowDialog(player1, player2, abilities);
        gameSwitch.game(player1, player2, abilities);
    }


}
