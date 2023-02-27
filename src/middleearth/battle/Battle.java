package middleearth.battle;

import middleearth.army.AbstractCavalryUnit;
import middleearth.army.AbstractUnit;
import middleearth.army.Army;
import middleearth.interfaces.Unit;
import middleearth.interfaces.middleearth.MiddleEarthUnit;
import middleearth.interfaces.mordor.MordorUnit;
import middleearth.units.middleearth.*;
import middleearth.units.mordor.*;
import middleearth.utils.RandomInt;

import java.util.ArrayList;
import java.util.Random;

public class Battle {
    private static Army<MordorUnit> mordorUnitArmy;
    private static Army<MiddleEarthUnit> middleEarthUnitArmy;

    public Battle() {
        mordorUnitArmy = new Army<>();
        middleEarthUnitArmy = new Army<>();
        fight();
    }

    private static void createArmy(int size) {
        if (size >= 1) {
            int percent;
            if (size >= 6) percent = (size * 20) / 100;
            else percent = 0;
            int sizeArmyMordor = RandomInt.getRandom(size - percent, size + percent);
            int sizeArmyMiddleEarth = RandomInt.getRandom(size - percent, size + percent);
            for (int i = 0; i < sizeArmyMordor; i++) {
                int a = RandomInt.getRandom(0, 3);
                mordorUnitArmy.recruit((MordorUnit) getMordorUnit(a));
            }
            for (int i = 0; i < sizeArmyMiddleEarth; i++) {
                int b = RandomInt.getRandom(0, 3);
                middleEarthUnitArmy.recruit((MiddleEarthUnit) getMiddleEarthUnit(b));
            }
            if (new Random().nextBoolean()) middleEarthUnitArmy.recruit(new Rohhirim("Rohhirim"));

        }
    }

    private static Unit getMiddleEarthUnit(int num) {
        switch (num) {
            case 0:
                return new Elf("middle");
            case 1: {
                if (new Random().nextBoolean()) {
                    return new HumanCavalry("middle");
                } else {
                    return new HumanInfantry("middle");
                }
            }
            case 2:
                return new Wizard("middle");
            case 3:
                return new WoodenElf("middle");
            default:
                return null;
        }
    }

    private static <T extends MordorUnit> Unit getMordorUnit(int num) {
        switch (num) {
            case 0: {
                if (new Random().nextBoolean()) return new OrcCavalry("mordor");
                else return new OrcInfantry("mordor");
            }
            case 1:
                return new Goblin("mordor");
            case 2:
                return new Troll("mordor");
            case 3:
                return new UrukHai("mordor");
            default:
                return null;
        }
    }

    private static void printArmy(Army army) {
        System.out.printf("Army of %s consist of:\n", army.getRandomUnit().getClass().getInterfaces());
        army.print();
    }


    public static <T extends AbstractCavalryUnit & Unit,
            T1 extends AbstractUnit & Unit> void fight() {
        createArmy(10);
        printArmy(middleEarthUnitArmy);
        printArmy(mordorUnitArmy);

        System.out.println("Phase N1");
        while (mordorUnitArmy.getCavalry().size() != 0 && middleEarthUnitArmy.getCavalry().size() != 0) {
            T a = (T) middleEarthUnitArmy.getCavalry().get(0);
            T b = (T) mordorUnitArmy.getCavalry().get(0);
            System.out.printf("middle %s ---------- mordor %s\n", a, b);
            while (a.isAlive() && b.isAlive()) {
                System.out.printf("%s vs %s", a, b);
                a.strike(b);
                resultOfRound(b.isAlive());
                b.strike(a);
                resultOfRound(a.isAlive());
                System.out.printf("%s -- %s", a, b);
            }
            if (a.isAlive()) {
                System.out.printf("%s is win\n", a);
                mordorUnitArmy.release(b);
            } else if (b.isAlive()) {
                System.out.printf("%s is win\n", b);
                middleEarthUnitArmy.release(a);
            }
        }


        while (mordorUnitArmy.getInfantry().size() != 0 && middleEarthUnitArmy.getInfantry().size() != 0) {
            T1 a1 = (T1) middleEarthUnitArmy.getInfantry().get(0);
            T1 b1 = (T1) mordorUnitArmy.getInfantry().get(0);
            System.out.printf("middle %s ---------- mordor %s\n", a1, b1);
            while (a1.isAlive() && b1.isAlive()) {
                System.out.printf("%s vs %s\n", a1, b1);
                a1.strike(b1);
                resultOfRound(b1.isAlive());
                b1.strike(a1);
                resultOfRound(a1.isAlive());
                System.out.printf("%s --  %s\n", a1, b1);
            }
            if (a1.isAlive()) {
                System.out.printf("%s is win\n", a1);
                mordorUnitArmy.release(b1);
            } else if (b1.isAlive()) {
                System.out.printf("%s is win\n", b1);
                middleEarthUnitArmy.release(a1);
            }
        }


        if (!mordorUnitArmy.getArmy().isEmpty() && !middleEarthUnitArmy.getArmy().isEmpty()) {
            ArrayList<MordorUnit> mordorList = mordorUnitArmy.getArmy();
            ArrayList<MiddleEarthUnit> middleList = middleEarthUnitArmy.getArmy();
            System.out.println("stage 3");
            while (!mordorList.isEmpty() == !middleList.isEmpty()) {
                break;
            }

        }
        System.out.println("----------------------");
        mordorUnitArmy.print();
        System.out.println("======================");
        middleEarthUnitArmy.print();
    }

    private static void resultOfRound(Boolean result) {
        if (result) System.out.println(" kills him");
        else System.out.println(" does not kill him");
    }

    public static <T extends Unit> void fight(ArrayList<? extends T> armyMordor, ArrayList<? extends T> armyMiddleEarth) {


    }
}
