package middleearth.units.middleearth;

import middleearth.army.AbstractCavalryUnit;
import middleearth.interfaces.middleearth.Human;
import middleearth.interfaces.middleearth.MiddleEarthUnit;

public class Rohhirim<T extends HumanCavalry>  extends AbstractCavalryUnit implements MiddleEarthUnit, Human {

    public Rohhirim(String name) {
        super(name);
        setPower(8);
        setBeast(this.new Horse());
    }
}
