package pinapple;

public class Client {
    private long id;
    private String type;
    private String name = "Default";
    private double sum = 0;

    public Client(long id, String type, String name, double sum) {
        if (id < 100_000_000_000L) this.id = 100_000_000_000L;
        if (!type.equals("institution") && !type.equals("individual")) this.type = "institution";
        else this.type = type;
        if (name != null) this.name = name;
        if (sum > 0) this.sum = sum;
    }

    @Override
    public String toString() {
        return "{"
                + this.id + "};{"
                + this.name + "};{"
                + this.type + "};{"
                + this.sum + "}";
    }

    public String getType() {
        return type;
    }
}
