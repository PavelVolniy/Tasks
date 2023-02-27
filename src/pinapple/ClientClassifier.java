package pinapple;

import java.util.Random;

public class ClientClassifier {

    public static void main(String[] args) {
        String[] arr = {
                "institution",
                "individual",
                "institution"};
        Client[] arrClients = new Client[50];
//        Client[] arrClients = {};

        for (int i = 0; i < 50; i++) {
            arrClients[i] = new Client(156, arr[new Random().nextInt(2)], null, 0);
            arrClients[i] = new Client(156, "arr[new Random().nextInt(2)]", null, 0);
        }
//        for (Client i : arrClients) {
//            System.out.println(i);
//        }
//        Client[] result = new Client[10];
        Client[] result = {};

        getClientsByType(arrClients, arr[0], result);
        printClients(arrClients);
//        System.out.println("-------------");
//        for (Client item : result) {
//            System.out.println(item);
//        }

    }

    public static void getClientsByType(Client[] clients, String type, Client[] result) {
        if (clients == null || clients.length == 0) System.out.println("Clients array is null or empty");
        else if (result == null || result.length == 0) System.out.println("Result array is null or empty");
        else {
            for (int i = 0, index = 0; i < clients.length; i++) {
                if (index < result.length) {
                    if (clients[i] != null) {
                        if (clients[i].getType() == type) {
                            result[index] = clients[i];
                            index++;
                        }
                    } else System.out.println("Item is null index " + i);
                } else {
                    System.out.println("Result array length exceeded");
                    i = clients.length;
                }
            }
        }
    }

    public static void printClients(Client[] clients) {
        if (clients != null || clients.length > 0) {
            for (Client item : clients) {
                System.out.println(item);
            }
        }
    }
}
