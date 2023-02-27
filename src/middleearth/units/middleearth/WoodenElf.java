package middleearth.units.middleearth;

import middleearth.army.AbstractUnit;
import middleearth.interfaces.middleearth.MiddleEarthUnit;

public class WoodenElf extends AbstractUnit implements MiddleEarthUnit {

    public WoodenElf(String name) {
        super(name);
        super.setPower(6);
    }

}
