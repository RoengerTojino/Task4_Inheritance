public class Phone extends Hardware {

    private Phone(Builder builder) {
        super(builder.id, builder.brand, builder.spec);
    }


    public String interpretSpec() {
        return spec + "MP";
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

        public Phone build() {
            return new Phone(this);
        }
    }
}