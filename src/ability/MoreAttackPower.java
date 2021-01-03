package ability;

public class MoreAttackPower extends Ability {


    public MoreAttackPower(String abilityName, int abilityType) {
        super(abilityName, abilityType);
    }

    @Override
    public boolean activBuff() {
        return getChance() == getRandom().nextInt(getTwentyFivePercentChance());
    }
}
