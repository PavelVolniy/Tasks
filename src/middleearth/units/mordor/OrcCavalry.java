package middleearth.units.mordor;

import middleearth.army.AbstractCavalryUnit;
import middleearth.interfaces.mordor.MordorUnit;
import middleearth.interfaces.mordor.Orc;
import middleearth.utils.RandomInt;

public class OrcCavalry extends AbstractCavalryUnit implements MordorUnit, Orc {

    public OrcCavalry(String name) {
        super(name);
        super.setPower(RandomInt.getRandom(8, 10));
        setBeast(this.new Warg());
    }
}
