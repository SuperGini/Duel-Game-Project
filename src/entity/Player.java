package entity;

import ability.Ability;

import java.util.Objects;

public class Player {

    private String characterName;
    private double health = 100;
    private double defensePower;
    private double attackPower;
    private Ability ability;
    private boolean abilitySelectedRandom;




    private double attackAbility;
    private double defenceAbility;
    private int plusFiveHealth;

    public Player() {
    }

    public static class Builder {
        private Player player = new Player();


        public Builder withCharacterName(String characterName) {
            player.characterName = characterName;
            return this;
        }

        public Builder withDefensePower(int defensePower) {
            player.defensePower = defensePower;
            return this;
        }

        public Builder withAttackPower(int attackPower) {
            player.attackPower = attackPower;
            return this;
        }


        public Player build() {
            return player;

        }

    }


    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getDefensePower() {
        return defensePower;
    }

    public void setDefensePower(double defensePower) {
        this.defensePower = defensePower;
    }

    public double getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(double attackPower) {
        this.attackPower = attackPower;
    }


    public double getAttackAbility() {
        return attackAbility;
    }

    public void setAttackAbility(double attackAbility) {
        this.attackAbility = attackAbility;
    }

    public double getDefenceAbility() {
        return defenceAbility;
    }

    public void setDefenceAbility(double defenceAbility) {
        this.defenceAbility = defenceAbility;
    }

    public int getPlusFiveHealth() {
        return plusFiveHealth;
    }

    public void setPlusFiveHealth(int plusFiveHealth) {
        this.plusFiveHealth = plusFiveHealth;
    }

    public Ability getAbility() {
        return ability;
    }

    public void setAbility(Ability ability) {
        this.ability = ability;
    }

    public boolean isAbilitySelectedRandom() {
        return abilitySelectedRandom;
    }

    public void setAbilitySelectedRandom(boolean abilitySelectedRandom) {
        this.abilitySelectedRandom = abilitySelectedRandom;
    }

    @Override
    public String toString() {
        return characterName + ": " + " power = " + attackPower + " defense = " + defensePower;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(characterName, player.characterName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(characterName);
    }


}
