package middleearth.units.mordor;

import middleearth.army.AbstractUnit;
import middleearth.interfaces.mordor.MordorUnit;
import middleearth.utils.RandomInt;

public class Goblin extends AbstractUnit implements MordorUnit {

    public Goblin(String name) {
        super(name);
        super.setPower(RandomInt.getRandom(2, 5));
    }
}
