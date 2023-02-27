package middleearth.units.middleearth;

import middleearth.army.AbstractUnit;
import middleearth.interfaces.middleearth.MiddleEarthUnit;
import middleearth.utils.RandomInt;

public class Elf extends AbstractUnit implements MiddleEarthUnit {

    public Elf(String name) {
        super(name);
        super.setPower(RandomInt.getRandom(4, 7));
    }
}
