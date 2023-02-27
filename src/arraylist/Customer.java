package arraylist;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Customer {
    private int purchaseCount;
    private double discountSize;
    private String documentNumber = "0000 000000";
    private String numberCard = "0000000000000000";
    private String name;

    public Customer(String name, int purchaseCount) {
        if (name != null) {
            Pattern pattern = Pattern.compile("\\w+.?\\w+?");
            Matcher matcher = pattern.matcher(name);
            if (matcher.find()) this.name = name;
            else this.name = "No-name";
        } else this.name = "No-name";
        setPurchaseCount(purchaseCount);
    }

    public String getDocumentNumber() {
        return this.documentNumber;
    }

    protected void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public int getPurchaseCount() {
        return purchaseCount;
    }

    public void setPurchaseCount(int purchaseCount) {
        if (purchaseCount >= 0) this.purchaseCount = purchaseCount;
        //вычисление и установка скидки
        if (this.purchaseCount < 10 && this.purchaseCount > 4) this.discountSize = 0.05;
        else if (this.purchaseCount > 9 && this.purchaseCount < 15) this.discountSize = 0.1;
        else if (this.purchaseCount >= 15) this.discountSize = 0.2;
        else if (this.purchaseCount <= 4) this.discountSize = 0;

    }

    protected void setNumberCard(String numberCard) {
        this.numberCard = numberCard;
    }

    public String getNumberCard() {
        return numberCard;
    }

    public double getDiscountSize() {
        return discountSize;
    }

    public String getName() {
        return name;
    }

    public abstract void customerInfo();
}
