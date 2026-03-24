public class Laptop extends Hardware {

    private Laptop(Builder builder) {
        super(builder.id, builder.brand, builder.spec);
    }


    public String interpretSpec() {
        return spec + "GB RAM";
    }


    public static class Builder {
        private int id;
        private String brand;
        private int spec;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public Builder setSpec(int spec) {
            this.spec = spec;
            return this;
        }

        public Laptop build() {
            return new Laptop(this);
        }
    }
}