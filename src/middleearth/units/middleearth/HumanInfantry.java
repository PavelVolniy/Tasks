package middleearth.units.middleearth;

import middleearth.army.AbstractUnit;
import middleearth.interfaces.middleearth.Human;
import middleearth.interfaces.middleearth.MiddleEarthUnit;
import middleearth.utils.RandomInt;

public class HumanInfantry extends AbstractUnit implements MiddleEarthUnit, Human {

    public HumanInfantry(String name) {
        super(name);
        super.setPower(RandomInt.getRandom(7, 8));
    }

    @Override
    public boolean isAlive() {
        if (super.getPower() != 0) return true;
        else return false;
    }
}
