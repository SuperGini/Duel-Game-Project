package ability;


public class HalfDamage extends Ability{


    public HalfDamage(String abilityName, int abilityType) {
        super(abilityName, abilityType);
    }

    @Override
    public boolean activBuff() {
        return getChance() == getRandom().nextInt(getTwentyFivePercentChance());
    }


}
