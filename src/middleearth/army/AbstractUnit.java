package middleearth.army;


import middleearth.interfaces.Infantry;

public abstract class AbstractUnit implements Infantry {
    private Integer power;
    private String name;

    public AbstractUnit(String name) {
        if (name != null && name.length() > 1) this.name = name;
        else this.name = super.toString();
    }

    @Override
    public boolean isAlive() {
        if (this.power!= null && this.power != 0) return true;
        else return false;
    }

    public <T extends AbstractCavalryUnit> void strike(T item) {
        int thisPower = this.power;
        int res = item.getPower() + item.getPowerRidingAnimal();
        if (thisPower >= res) {
            item.setPowerRidingAnimal(0);
            item.setPower(0);
        } else {
            int a = thisPower - item.getPowerRidingAnimal();
            if (a >= 0) {
                item.setPowerRidingAnimal(0);
                item.setPower(item.getPower() - a);
            }
        }
    }

    public <T extends AbstractUnit> void strike(T item) {
        if (this.power >= item.getPower()) item.setPower(0);
        else item.setPower(item.getPower() - this.power);
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        if (this.power == null && power >= 0) this.power = power;
        else if (power >= 0 && this.power > power) this.power = power;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(this.getClass().getSimpleName())
                .append(" ")
                .append(this.name)
                .append(" has power ")
                .append(this.power)
                .toString();
    }
}
