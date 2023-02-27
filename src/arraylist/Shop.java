package arraylist;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Shop {
    private static ArrayList<Customer> shopCustomers = new ArrayList<>();

    public void printShopSummary() {
        if (shopCustomers != null && !shopCustomers.isEmpty()) {
            for (Customer item : shopCustomers) item.customerInfo();
        }
    }

    private void addCustomer(Customer customer) {
        if (customer != null) shopCustomers.add(customer);
    }

    // выбор типа покупателя
    public static Shop createShopInfo() {
        Shop shop = new Shop();
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Shop data:");
        boolean work = true;
        while (work) {
            String line = null;
            if (scanner.hasNextLine()) {
                line = scanner.nextLine();
                if (line != null && line.toUpperCase().equals("EXIT")) work = false;
                String[] split = line.split(",");
                Integer type = null;
                Integer purchaseCount = null;
                try {
                    type = Integer.parseInt(split[0], 10);
                    purchaseCount = Integer.parseInt(split[2]);
                } catch (Exception e) {
                    System.out.println("type or purchaseCount isn't Integer");
                }

                if (type != null && purchaseCount != null && split.length >= 4) {
                    if (type == 2) {
                        if (!split[4].isEmpty()) {
                            shop.addCustomer(new CardCustomer(split[1], split[4], purchaseCount));
                            System.out.println("Customer is added");
                        }
                    } else if (type == 1) {
                        if (!split[3].isEmpty()) {
                            shop.addCustomer(new CashCustomer(split[1], split[3], purchaseCount));
                            System.out.println("Customer is added");
                        }
                    } else System.out.println("Unknown type Customer");
                }
            }
        }
        return shop;
    }

    public static Shop createShopWithParsing() {
        Shop shop = new Shop();
        Scanner scanner = new Scanner(System.in);
        System.out.println("start work");
        String name = " (\\w+\\D+.?\\w+?\\D+?) ";
        String type = "\\d ";
        String purchaseCountPattern = " (.?\\d+) ";
        String documentPattern = " (\\d{4} \\d{6}) ";
        String cardNumberPattern = "\\d{16}";
        boolean work = true;
        while (work) {
            String line = null;

            if (scanner.hasNextLine()) line = scanner.nextLine();
            line = line.replace(',', ' ');
            if (line.toUpperCase().equals("EXIT")) work = false;
            Integer typeCustom = 5;
            if (work) typeCustom = Integer.parseInt(getString(type, line));
            if (typeCustom == 1) {
                shop.addCustomer(new CashCustomer(getString(name, line),
                        getString(documentPattern, line),
                        Integer.parseInt(getString(purchaseCountPattern, line))));
            } else if (typeCustom == 2) {
                shop.addCustomer(new CashCustomer(getString(name, line),
                        getString(cardNumberPattern, line),
                        Integer.parseInt(getString(purchaseCountPattern, line))));
            } else System.out.println("Unknown typ customer");
        }
        return shop;
    }

    private static String getString(String patternCustom, String str) {
        Pattern pattern = Pattern.compile(patternCustom);
        Matcher matcher = pattern.matcher(str);
        matcher.find();
        String result = null;
        try {
            result = matcher.group().trim();
        } catch (Exception e) {
            System.out.println("not found");
        }
        return null;
    }

}
