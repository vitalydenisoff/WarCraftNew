package com.epam.warcraft.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class UnitComposite implements UnitComponent {

    private List<UnitComponent> unitComponents = new ArrayList<>();

    public void add(UnitComponent unit) {
        unitComponents.add(unit);
    }

    public List<UnitComponent> getUnitComponents() {
        return unitComponents;
    }

    @Override
    public int attack() {
        int resAttack = 0;
        for (UnitComponent unit : unitComponents) {
            resAttack += unit.attack();
        }
        return resAttack;
    }

    @Override
    public int healthPoint() {
        int resHealthPoint = 0;
        for (UnitComponent unit : unitComponents) {
            resHealthPoint += unit.healthPoint();
        }
        return resHealthPoint;
    }


    @Override
    public void setHealthUnit(int healthPoint) {
        for (UnitComponent unit : unitComponents) {
            unit.setHealthUnit(healthPoint);
        }

    }

    @Override
    public void dead() {
        for (UnitComponent unit : unitComponents) {
            unit.dead();
        }
    }

    @Override
    public int count() {
        int resCount = 0;
        for (UnitComponent unit : unitComponents) {
            resCount += unit.count();
        }
        return resCount;
    }

    @Override
    public UnitComponent inflictDamage(UnitComponent unit) {
        if (this.attack() > unit.healthPoint()) {
            for (UnitComponent currentUnit : unitComponents) {
                unit.setHealthUnit(0);
                unit.dead();
            }
        } else {
            unit.setHealthUnit(unit.healthPoint() / unit.count() - this.attack() / this.count());
        }
        return unit;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", "[", "]")
                .add("unitComponents=" + unitComponents)
                .toString();
    }
}
