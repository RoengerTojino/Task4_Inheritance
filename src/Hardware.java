public class Hardware {
    protected int id;
    protected String brand;
    protected int spec;

    public Hardware(int id, String brand, int spec) {
        this.id = id;
        this.brand = brand;
        this.spec = spec;
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public int getSpec() {
        return spec;
    }


    public String interpretSpec() {
        return spec + " units";
    }
}
