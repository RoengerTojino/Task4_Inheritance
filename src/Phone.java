class Phone extends Hardware {

    private Phone(Builder builder) {
        super(builder);
    }

    @Override
    public String interpretSpec() {
        return SPEC + "MP";
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

        public Phone build() {
            this.type = "Phone";
            return new Phone(this);
        }
    }
}
