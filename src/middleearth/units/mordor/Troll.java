package middleearth.units.mordor;

import middleearth.army.AbstractUnit;
import middleearth.interfaces.mordor.MordorUnit;
import middleearth.utils.RandomInt;

public class Troll extends AbstractUnit implements MordorUnit {

    public Troll(String name) {
        super(name);
        super.setPower(RandomInt.getRandom(11, 15));
    }
}
