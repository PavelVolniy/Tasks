package arraylist;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CashCustomer extends Customer {

    public CashCustomer(String name, String documentNumber, int purchaseCount) {
        super(name, purchaseCount);
        super.setPurchaseCount(purchaseCount);
        if (documentNumber != null) {
            documentNumber.trim();
            Pattern pattern = Pattern.compile("\\d{4} \\d{6}");
            Matcher matcher = pattern.matcher(documentNumber);
            if (matcher.find()) super.setDocumentNumber(documentNumber);
            else super.setDocumentNumber("0000 000000");
        }
    }

    @Override
    public void customerInfo() {
        System.out.printf("Customer %s (card: %s) has a discount %s %%\n",
                super.getName(),
                super.getDocumentNumber(),
                super.getDiscountSize() * 100);

    }
}
