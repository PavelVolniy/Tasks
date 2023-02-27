package middleearth.units.mordor;

import middleearth.army.AbstractUnit;
import middleearth.interfaces.mordor.MordorUnit;
import middleearth.interfaces.mordor.Orc;
import middleearth.utils.RandomInt;

public class OrcInfantry extends AbstractUnit implements MordorUnit, Orc {

    public OrcInfantry(String name) {
        super(name);
        super.setPower(RandomInt.getRandom(8, 10));
    }
}
