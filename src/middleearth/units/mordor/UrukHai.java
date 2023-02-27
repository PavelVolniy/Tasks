package middleearth.units.mordor;

import middleearth.army.AbstractUnit;
import middleearth.interfaces.mordor.MordorUnit;
import middleearth.interfaces.mordor.Orc;
import middleearth.utils.RandomInt;

public class UrukHai<T extends OrcCavalry> extends AbstractUnit implements MordorUnit, Orc {

    public UrukHai(String name) {
        super(name);
        super.setPower(RandomInt.getRandom(10, 12));
    }
}
