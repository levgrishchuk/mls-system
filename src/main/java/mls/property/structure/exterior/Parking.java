package mls.property.structure.exterior;

import mls.property.structure.exterior.Exterior;

public class Parking extends Exterior {
    private String type;
    private int carSpace;

    public Parking(Builder builder) {
        super(builder);
        this.type = type;
        this.carSpace = carSpace;
    }
    public static class Builder extends Exterior.Builder<Backyard.Builder>{
        private String type;
        private int carSpace;

        public Builder setType(String type){
            this.type = type;
            return this;
        }

        public Builder setCarSpace(int carSpace){
            this.carSpace = carSpace;
            return this;
        }

        /**
         * Build method
         * @return Parking instance
         * @throws RuntimeException
         */
        public Parking build(){
            if(this.carSpace <= 0){
                throw new RuntimeException("Car space must be positive");
            }
            return new Parking(this);
        }
    }
}
