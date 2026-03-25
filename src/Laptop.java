public class Laptop extends Hardware {

    private Laptop(Builder builder) {
        super(builder);
    }

    @Override
    public String interpretSpec() {
        return SPEC + "GB RAM";
    }

    public static class Builder extends Hardware.Builder {

        @Override
        public Builder setId(int id) {
            super.setId(id);
            return this;
        }

        @Override
        public Builder setBrand(String brand) {
            super.setBrand(brand);
            return this;
        }

        @Override
        public Builder setSpec(int spec) {
            super.setSpec(spec);
            return this;
        }

        public Laptop build() {
            this.type = "Laptop";
            return new Laptop(this);
        }
    }
}