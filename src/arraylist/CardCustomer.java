package arraylist;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CardCustomer extends Customer {

    public CardCustomer(String name, String numberCard, int purchaseCount) {
        super(name, purchaseCount);
        if (numberCard != null) {
            Pattern pattern = Pattern.compile("\\d{16}");
            Matcher matcher = pattern.matcher(numberCard);
            if (matcher.find()) super.setNumberCard(numberCard);
            else super.setNumberCard("0000000000000000");
        }
    }

    @Override
    public void customerInfo() {
        System.out.printf("Customer %s (card: %s) has a discount %s %%\n",
                super.getName(),
                super.getNumberCard(),
                super.getDiscountSize() * 100);
    }
}
