package randommoney;

import java.util.Random;

public class RandomMoney {

    private double price;

    public double getPrice() {
        return price;
    }

    public void sale(int quantity, int time) {
        price = 5 * Math.sin(0.5 * time);

        double result = Math.round(quantity * price);

        if (result > 0) System.out.printf("The company has earned USD %8.2f", result);
        else if (result == 0) System.out.print("The company did not earn anything and did not lose on the sale");
        else if (result < 0) System.out.printf("The company has lost USD %8.2f", result);
    }

    public void testSale() {
        for (int i = 0; i < 3; i++) {
            sale(new Random().nextInt(10), new Random().nextInt(50));
        }
    }
}
