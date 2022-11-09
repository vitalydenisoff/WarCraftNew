package com.epam.warcraft.entity;

import java.util.StringJoiner;

public class Unit implements UnitComponent {

    private int health;
    private int damage;
    private int id;
    private Condition condition;
    private Race race;

    public Unit(int health, int damage, int id, Race race) {
        this.health = health;
        this.damage = damage;
        this.id = id;
        this.condition = Condition.ALIVE;
        this.race = race;
    }


    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }


    public void setCondition(Condition condition) {
        this.condition = condition;
    }


    @Override
    public int attack() {
        return damage;
    }

    @Override
    public int healthPoint() {
        return health;
    }

    @Override
    public int count() {
        return 1;
    }

    @Override
    public UnitComponent inflictDamage(UnitComponent unit) {
        if (getDamage() > unit.healthPoint()) {
            unit.setHealthUnit(0);
            unit.dead();
        } else {
            unit.setHealthUnit(unit.healthPoint() - getDamage());
        }
        return unit;
    }

    @Override
    public void setHealthUnit(int healthPoint) {
        setHealth(healthPoint);
    }

    @Override
    public void dead() {
        setCondition(Condition.DEAD);
    }


    @Override
    public String toString() {
        return new StringJoiner(", ", "[", "]")
                .add("race=" + race)
                .add("health=" + health)
                .add("damage=" + damage)
                .add("id=" + id)
                .add("condition=" + condition)
                .toString();
    }

}