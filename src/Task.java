import java.util.Arrays;

public class Task {

    public int maxSpeed(){
        Planes boengSpeed = Planes.BOENG_001;
        Planes il90Speed = Planes.IL_90;
        Planes tu153Speed = Planes.TU_153;
        double[] arr = {boengSpeed.speed(), il90Speed.speed(), tu153Speed.speed()};
        Arrays.sort(arr);
        return (int) arr[2];
    }

    enum Planes{
        BOENG_001(8000,10),
        IL_90(5400,9),
        TU_153(14000,15);

        private final double distance;
        private final int time;

        Planes(int dist, int t) {
            distance = dist;
            time = t;
        }
        public double speed(){
            return distance/time;
        }
    }
}
