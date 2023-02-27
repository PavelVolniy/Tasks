package middleearth.utils;

import java.util.Random;

public class RandomInt {

    public static int getRandom(int min, int max) {
        if (min == max) return max;
        else return new Random().nextInt((max - min)) + min;
    }
}
