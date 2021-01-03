package ability;

public class PlusFiveHp extends Ability {

    public PlusFiveHp(String abilityName, int abilityType) {
        super(abilityName, abilityType);
    }

    @Override
    public boolean activBuff() {
        return getChance() == getRandom().nextInt(getTwentyFivePercentChance());
    }
}
