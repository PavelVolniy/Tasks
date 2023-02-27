package middleearth.army;
import middleearth.interfaces.Cavalry;
import middleearth.utils.RandomInt;

public abstract class AbstractCavalryUnit implements Cavalry {
    private Integer power = null;
    private Integer powerRidingAnimal = null;
    private String name;


    public AbstractCavalryUnit(String name) {
        if (name != null && name.length() > 1) this.name = name;
        else this.name = super.toString();
    }


    public boolean isAlive() {
        if (this.power != null && this.power != 0) return true;
        else return false;
    }

    public <T extends Horse> void setBeast(T horse) {
        setPowerRidingAnimal(horse.getPower());
    }

    public <T extends Warg> void setBeast(T warg) {
        setPowerRidingAnimal(warg.getPower());
    }
    public <T extends AbstractCavalryUnit> void strike(T item) {
        if (item != null) {
            int thisPower = this.power + this.powerRidingAnimal;
            int res = item.getPowerRidingAnimal() + item.getPower();
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
    }

    public <T extends AbstractUnit> void strike(T item) {
        if (item != null) {
            int thisPower = this.power + this.powerRidingAnimal;
            int res = item.getPower();
            if (thisPower >= res) {
                item.setPower(0);
            } else {
                item.setPower(res - thisPower);
            }
        }
    }

    public int getPower() {
        return power;
    }

    public int getPowerRidingAnimal() {
        return powerRidingAnimal;
    }

    protected void setPowerRidingAnimal(int powerRidingAnimal) {
        if (this.powerRidingAnimal == null && powerRidingAnimal >= 0) this.powerRidingAnimal = powerRidingAnimal;
        else if (powerRidingAnimal >= 0 && powerRidingAnimal < this.powerRidingAnimal)
            this.powerRidingAnimal = powerRidingAnimal;
    }

    protected void setPower(int power) {
        if (this.power == null && power >= 0) this.power = power;
        else if (power >= 0 && power < this.power) this.power = power;
    }

    @Override
    public String toString() {
        int currentPower = 0;
        if (this.powerRidingAnimal != null) currentPower = this.powerRidingAnimal + this.power;
        else currentPower = this.power;
        return new StringBuilder()
                .append(this.getClass().getSimpleName())
                .append(" ")
                .append(this.name)
                .append(" has power ")
                .append(currentPower)
                .toString();
    }

    public class Horse {
        private Integer power;

        public Horse() {
            power = RandomInt.getRandom(4, 5);
        }

        public void setPower(int power) {
            if (this.power != null && power >= 0 && this.power > power) this.power = power;
        }

        public int getPower() {
            return power;
        }
    }

    public class Warg {
        private Integer power;

        public Warg() {
            power = RandomInt.getRandom(4, 7);
        }

        public int getPower() {
            return power;
        }

        public void setPower(int power) {
            if (this.power != null && power >= 0 && this.power > power) this.power = power;
        }
    }
}
