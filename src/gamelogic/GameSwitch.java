package gamelogic;

import ability.Ability;
import entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameSwitch {


    private Random random;
    private String characterAttacking;

    private GameLogic gameLogic;


    private List<Player> players = new ArrayList<>();

    public GameSwitch() {
        random = new Random();
        gameLogic = new GameLogic();
    }

    public void game(Player attackPlayer, Player defendPlayer, List<Ability> abilities ){

        players.add(attackPlayer);
        players.add(defendPlayer);
        characterAttacking = players.get(random.nextInt(players.size())).getCharacterName(); //aleg random ce carter sa atace primul

        while(true){

            switch (characterAttacking) {

                case "Character 1" -> fight(gameLogic, attackPlayer, defendPlayer, abilities);

                case "Character 2" -> fight(gameLogic, defendPlayer, attackPlayer, abilities);
            }


                if(attackPlayer.getHealth() <= 0 || defendPlayer.getHealth() <=0 ){

                    players.stream()
                            .filter( player -> player.getHealth() > 0)
                            .forEach( player-> System.out.println(player.getCharacterName() + " won"));

                    System.out.println("End");

                    break;
                }
        }
    }



    private void fight(GameLogic gameLogic, Player attackPlayer, Player defendPlayer, List<Ability> abilities){
        gameLogic.playerVSplayer(attackPlayer, defendPlayer, abilities);

        characterAttacking = defendPlayer.getCharacterName();
    }

}
