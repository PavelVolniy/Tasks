package middleearth.units.middleearth;

import middleearth.army.AbstractCavalryUnit;
import middleearth.interfaces.middleearth.MiddleEarthUnit;

public class Wizard extends AbstractCavalryUnit implements MiddleEarthUnit {
    private Horse horse;

    public Wizard(String name) {
        super(name);
        super.setPower(20);
        setBeast(this.new Horse());
    }
}
