package pricecheck;

public class Receipt {

    public static void printReceipt(ProductInfo[] products) {
        Transaction transaction = new Transaction();
        if (products != null && products.length > 0) {
            for (ProductInfo item : products) { // заполняем данными транзакцию
                if (item != null) transaction.new TransactionItem(item.name, item.price)
                        .printInfo(); // печать нименований и цены
            }
        }
        printTransactionInfo(transaction.new TransactionItem());
    }

    public static void printTransactionInfo(Transaction.TransactionItem transactionItem) {
        if (transactionItem != null) System.out.printf("Order %8.2f:USD\nTotal %8.2f:USD",
                transactionItem.getTransaction().getPrice(),
                transactionItem.getTransaction().dealPrice());
        ;
    }
}
