package gamelogic;

import ability.Ability;
import entity.Player;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameInitialUI {

    private int count;
    private String line1;
    private String line2;
    private Random random;
    private List<Player> players;
    private boolean isSelectedAbilityPlayer1;
    private boolean isSelectedAbilityPlayer2;

    private final InputStreamReader isr;
    private final BufferedReader br;

    public GameInitialUI() {
        this.random = new Random();
        isr = new InputStreamReader(System.in);
        br = new BufferedReader(isr);


    }


    public boolean selectAbilityForPlayer1(String line){
        boolean flag1 = true;

        while(flag1){

            try {
                line = br.readLine().toLowerCase().trim();
                switch (line) {

                    case "y" -> {flag1 = false;
                                  return true;}

                    case "n" -> {flag1 = false;
                                  return false;}

                    default -> System.out.println("Enter Y/N");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }


        }
        return true;
    }

    public boolean selectAbilityForPlayer2(String line){
        boolean flag1 = true;

        while(flag1){

            try {
                line = br.readLine().toLowerCase().trim();
                switch (line) {

                    case "y" -> {flag1 = false;

                        return true;}

                    case "n" -> {flag1 = false;
                        return false;}

                    default -> System.out.println("Enter Y/N");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }



    public void sowDialog(Player player1, Player player2, List<Ability> abilities){

        players = new ArrayList<>();
        players.add(player1);
        players.add(player2);


        try(isr; br){  //inchidem resursele

            System.out.println("Game Started: \n");
            System.out.println("The abilities of the characters are: \n");

            abilities.forEach( this::showAbilities);



                            //Character 1 selection
            System.out.println("*************************************************************");
            System.out.println("Do you want to select a random ability for " + player1.getCharacterName() + "? Y/N");


            if(isSelectedAbilityPlayer1 = selectAbilityForPlayer1(line1)){

                int randomAbility1 =random.nextInt(abilities.size());
                player1.setAbility(abilities.get(randomAbility1));
                player1.setAbilitySelectedRandom(false);

                System.out.println("Ability: " + player1.getAbility().getAbilityName() + " -> was selected for" + player1.getCharacterName());
                System.out.println("*************************************************************");
            }else{
                System.out.println("A random ability will be selected each round for " + player1.getCharacterName());
                System.out.println("*************************************************************");
                player1.setAbilitySelectedRandom(true);
            }




                            //Character 2 selection
            System.out.println("Do you want to select a random ability for" + player2.getCharacterName() + "? Y/N");
            if(isSelectedAbilityPlayer2 = selectAbilityForPlayer2(line2)){

                int randomAbility2 = random.nextInt(abilities.size());
                player2.setAbility(abilities.get(randomAbility2));
                player2.setAbilitySelectedRandom(false);

                System.out.println("Ability: " + player2.getAbility().getAbilityName() + " -> was selected");
                System.out.println("*************************************************************");
            } else{
                System.out.println("A random ability will be selected each round for " + player2.getCharacterName());
                System.out.println("*************************************************************");
                player2.setAbilitySelectedRandom(true);
            }



            System.out.println(player1);
            System.out.println(player2);
            System.out.println("*************************************************************");

        }catch (IOException e){
            e.printStackTrace();
        }
    }


    private void showAbilities(Ability ability){
        count++;
        System.out.println(count + "." + ability.toString());
    }
}








