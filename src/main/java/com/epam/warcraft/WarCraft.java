package com.epam.warcraft;

import com.epam.warcraft.entity.Race;
import com.epam.warcraft.entity.Unit;
import com.epam.warcraft.entity.UnitComponent;
import com.epam.warcraft.entity.UnitComposite;

public class WarCraft {
    public static void main(String[] args) {
        UnitComponent human1=new Unit(10,5,101, Race.HUMAN);
        UnitComponent human2=new Unit(10,5,102,Race.HUMAN);
        UnitComponent nightElf1=new Unit(8,12,201,Race.NIGHT_ELF);
        UnitComponent nightElf2=new Unit(8,12,201,Race.NIGHT_ELF);
        UnitComponent orc1=new Unit(12,8,201,Race.ORC);
        UnitComponent orc2=new Unit(12,8,201,Race.ORC);
        UnitComponent undead1=new Unit(12,8,301,Race.UNDEAD);
        UnitComponent undead2=new Unit(12,8,301,Race.UNDEAD);
        UnitComponent anduinLotar=new Unit(20,15,110,Race.HUMAN);
        UnitComponent Thrall=new Unit(25,12,210,Race.ORC);

        UnitComposite groupHumans=new UnitComposite();
        UnitComposite groupOrcs=new UnitComposite();
        UnitComposite groupUndead=new UnitComposite();
        UnitComposite groupNightElf=new UnitComposite();
        UnitComposite alliance=new UnitComposite();
        UnitComposite scourge=new UnitComposite();
        groupUndead.add(undead1);
        groupUndead.add(undead2);
        groupHumans.add(human1);
        groupHumans.add(human2);
        groupOrcs.add(orc1);
        groupOrcs.add(orc2);
        groupNightElf.add(nightElf1);
        groupNightElf.add(nightElf2);
        alliance.add(groupHumans);
        alliance.add(groupNightElf);
        scourge.add(groupOrcs);
        scourge.add(groupUndead);
        scourge.add(Thrall);
        alliance.inflictDamage(scourge);
        System.out.println(scourge);



    }
}