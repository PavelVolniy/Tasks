package middleearth.interfaces;

import middleearth.army.AbstractCavalryUnit;
import middleearth.army.AbstractUnit;

public interface Unit {

    public boolean isAlive();
    public <T extends AbstractCavalryUnit> void strike(T item);
    public <T extends AbstractUnit> void strike(T item);
    public int getPower();

}
