class Hardware {
    protected final int ID;
    protected final String BRAND;
    protected final int SPEC;
    protected final String TYPE;

    protected Hardware(Builder builder) {
        this.ID = builder.id;
        this.BRAND = builder.brand;
        this.SPEC = builder.spec;
        this.TYPE = builder.type;
    }

    public int getId() {
        return ID;
    }

    public String getBrand() {
        return BRAND;
    }

    public int getSpec() {
        return SPEC;
    }

    public String getType() {
        return TYPE;
    }

    public String interpretSpec() {
        return SPEC + " units";
    }

    // BUILDER
    public static class Builder {
        protected int id;
        protected String brand;
        protected int spec;
        protected String type;

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

        public Builder setType(String type) {
            this.type = type;
            return this;
        }

        public Hardware build() {
            return new Hardware(this);
        }
    }
}