package creditbank;

import java.util.Scanner;

public class CreditCalculator {
    private String lastName = null;
    private String firstName = null;
    private String secondName = null;
    private Integer loanMaturity = null;
    private Double sum = null;
    private Double interestRate = null;
    private String[] nameFields = { //массив наименований параметров
            "Lastname",
            "Firstname",
            "Secondname",
            "Interest rate",
            "Credit amount",
            "Loan maturity"
    };
    private Object[] typeOfFields = new Object[]{ // массив типов класса
            String.class,
            String.class,
            String.class,
            double.class,
            double.class,
            int.class
    };
    private Object[] fieldsValue = new Object[]{ //массив значений полей
            lastName,
            firstName,
            secondName,
            interestRate,
            sum,
            loanMaturity
    };

    public CreditCalculator() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < nameFields.length; ) {
            System.out.println(nameFields[i]); //печать названия параметра ввода

            if (typeOfFields[i] == String.class) {
                if (scanner.hasNextLine()) {
                    String a = scanner.nextLine();
                    if (a.length() > 0) fieldsValue[i] = a; //проверка корректности ввода строковых данных
                } else System.out.println(nameFields[i] + " is incorrect. It must be not empty string");
            }

            if (typeOfFields[i] == double.class) {
                if (scanner.hasNextDouble()) fieldsValue[i] = scanner.nextDouble();
                else System.out.println(nameFields[i] + " is incorrect. It must be strictly positive number");
                scanner.nextLine();
            }

            if (typeOfFields[i] == int.class) {
                if (scanner.hasNextInt()) fieldsValue[i] = scanner.nextInt();
                else System.out.println(nameFields[i] + " is incorrect. It must be strictly positive number");
                scanner.nextLine();
            }

            if (fieldsValue[i] != null) i++;
        }
        saveFieldsData(fieldsValue);
    }

    //сохраняем данные
    private void saveFieldsData(Object[] fieldsValue) {
        this.lastName = (String) fieldsValue[0];
        this.firstName = (String) fieldsValue[1];
        this.secondName = (String) fieldsValue[2];
        this.interestRate = (Double) fieldsValue[3];
        this.sum = (Double) fieldsValue[4];
        this.loanMaturity = (Integer) fieldsValue[5];
    }

    //расчет по формуле, вывод форматированных данных
    public void printCreditAgreement() {
        double pl = (this.sum * (this.interestRate / (12 * 100))) / (1 - Math.pow((1 + (this.interestRate / (12 * 100))), -this.loanMaturity));
        System.out.printf("Ежемесячный платеж составляет %8.2f", pl);
    }
}
