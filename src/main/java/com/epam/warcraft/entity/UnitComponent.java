package com.epam.warcraft.entity;

public interface UnitComponent {
    int attack();
    int healthPoint();
    int count();
    UnitComponent inflictDamage(UnitComponent unit);
    void setHealthUnit(int healthPoint);
    void dead();




