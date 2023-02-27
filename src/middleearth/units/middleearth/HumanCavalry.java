package middleearth.units.middleearth;


import middleearth.army.AbstractCavalryUnit;
import middleearth.interfaces.middleearth.Human;
import middleearth.interfaces.middleearth.MiddleEarthUnit;
import middleearth.utils.RandomInt;

public class HumanCavalry extends AbstractCavalryUnit implements MiddleEarthUnit, Human {

    public HumanCavalry(String name) {
        super(name);
        super.setPower(RandomInt.getRandom(7, 8));
        setBeast(this.new Horse());
    }
}
