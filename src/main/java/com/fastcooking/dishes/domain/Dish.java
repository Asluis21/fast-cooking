package com.fastcooking.dishes.domain;

import java.time.Duration;

public class Dish {
    
    private final Long id;
    private final String name;
    private final String description;
    private final Region region;
    private final Duration prepationTime;

    private Dish(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
        this.region = builder.region;
        this.prepationTime = builder.prepationTime;
    }

    public static class Builder {

        private final Long id;
        private final String name;
        private String description = "";
        private Region region = null;
        private Duration prepationTime = Duration.ZERO;

        public Builder (Long id, String name){
            this.id = id;
            this.name = name;
        }

        public Builder description(String description){
            this.description = description;

            return this;
        }

        public Builder region(Region region){
            this.region = region;

            return this;
        }

        public Builder prepationTime(Duration prepationTime){
            this.prepationTime = prepationTime;

            return this;
        }

        public Dish dish(){
            return new Dish(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Region getRegion() {
        return region;
    }

    public Duration getPrepationTime() {
        return prepationTime;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Dish other = (Dish) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
 
    
}
