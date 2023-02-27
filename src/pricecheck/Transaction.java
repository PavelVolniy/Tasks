package pricecheck;

class Transaction {

    private double price;
    private double tax = 1.2;

    public double getPrice() {
        return price;
    }

    public double dealPrice() {
        return price * tax;
    }

    private void printCheck(double price) {
        System.out.printf("Order: %8.2f: USD\n", (price > 0) ? price : 0);
    }

    public void printCheck() {
        printCheck(price);
        System.out.printf("Total %8.2f: USD", dealPrice());
    }

    public class TransactionItem extends ProductInfo {

        private double price;
        private String name;

        public TransactionItem(){}

        //валидация данных и сохранение
        public TransactionItem(String name, Double price) {
            if (name == null || name.length() == 0) this.name = "default";
            else {
                name.trim();
                if (name.length() == 0) this.name = "default";
                else this.name = name;
            }
            if (price == null || price < 0) this.price = 0;
            else {
                this.price = price;
                Transaction.this.price += this.price; //увеличиваем значение внешнего класса
            }
        }

        void printInfo() {
            System.out.printf("Item: %s,  ", name);
            printCheck(this.price);
        }

        public Transaction getTransaction() {
            return Transaction.this;
        }
    }
}
