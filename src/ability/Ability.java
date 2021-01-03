package ability;
import java.util.Random;

public abstract class Ability {

    private String abilityName;
    private final int chance = 1;
    private final int twentyFivePercentChance = 4;
    private int abilityType;
    private Random random;



    public Ability(String abilityName, int abilityType) {
        this.abilityName = abilityName;
        this.abilityType = abilityType;
        this.random = new Random();


    }

    public abstract boolean activBuff();


    public String getAbilityName() {
        return abilityName;
    }

    public void setAbilityName(String abilityName) {
        this.abilityName = abilityName;
    }

    public int getChance() {
        return chance;
    }

    public int getTwentyFivePercentChance() {
        return twentyFivePercentChance;
    }

    public Random getRandom() {
        return random;
    }

    public int getAbilityType() {
        return abilityType;
    }

    public void setAbilityType(int abilityType) {
        this.abilityType = abilityType;
    }

    @Override
    public String toString() {
        return abilityName;
    }
}
