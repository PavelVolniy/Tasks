package middleearth.army;


import middleearth.interfaces.Cavalry;
import middleearth.interfaces.Infantry;
import middleearth.interfaces.Unit;

import java.util.ArrayList;
import java.util.Random;

public class Army<T extends Unit> {

    private ArrayList<Cavalry> cavalry = new ArrayList<>(); //список воинов
    private ArrayList<Infantry> infantry = new ArrayList<>(); //список воинов

    //добавление воина
    public boolean recruit(T warrior) {
        if (warrior.getClass().getSuperclass() == AbstractCavalryUnit.class) {
            cavalry.add((Cavalry) warrior);
            return true;
        } else if (warrior.getClass().getSuperclass() == AbstractUnit.class) {
            infantry.add((Infantry) warrior);
            return true;
        } else return false;
    }

    public void print() {
        if (cavalry != null && !cavalry.isEmpty())
            for (Cavalry item : cavalry) if (item != null) System.out.println(item);
        if (infantry != null && !infantry.isEmpty())
            for (Infantry item : infantry) if (item != null) System.out.println(item);
    }

    public ArrayList<Cavalry> getCavalry() {
        return cavalry;
    }

    public ArrayList<Infantry> getInfantry() {
        return infantry;
    }

    //удаление воина
    public boolean release(T warrior) {
        if (warrior.getClass().getSuperclass() == AbstractCavalryUnit.class && cavalry.contains(warrior)) {
            cavalry.remove(warrior);
            return true;
        } else if (warrior.getClass().getSuperclass() == AbstractUnit.class && infantry.contains(warrior)) {
            infantry.remove(warrior);
            return true;
        } else return false;
    }

    //вернуть случайного воина
    public T getRandomUnit() {
        ArrayList<T> arr = new ArrayList<>();
        if (cavalry != null) for (Cavalry item : cavalry) arr.add((T) item);
        if (infantry != null) for (Infantry item : infantry) arr.add((T) item);
        if (!arr.isEmpty()) return arr.get(new Random().nextInt(arr.size()));
        else return null;
    }

    //вернуть случайного воина указанного типа
    public Unit getRandomUnit(T item) {
        if (item.getClass() == Cavalry.class) {
            if (!cavalry.isEmpty()) return cavalry.get(new Random().nextInt(cavalry.size()));
        } else if (item.getClass() == Infantry.class) {
            if (!infantry.isEmpty()) return infantry.get(new Random().nextInt(infantry.size()));
        }
        return null;
    }

    public ArrayList<T> getArmy() {
        ArrayList<T> arr = new ArrayList<>();
        if (!cavalry.isEmpty()) for (Cavalry item : cavalry) arr.add((T) item);
        if (!infantry.isEmpty()) for (Infantry item : infantry) arr.add((T) item);
        return arr;
    }
}
