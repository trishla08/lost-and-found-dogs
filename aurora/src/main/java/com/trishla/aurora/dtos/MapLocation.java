package com.trishla.aurora.dtos;

import lombok.Getter;

@Getter
public class MapLocation {
    final double latitude;
    final double longitude;
    
    private MapLocation(Builder builder) {
        this.latitude = builder.latitude;
        this.longitude = builder.longitude;
    }

    public static class Builder {
        double latitude;
        double longitude;
        
        public Builder latitude(double latitude) {
            this.latitude = latitude;
            return this;
        }
        
        public Builder longitude(double longitude) {
            this.longitude = longitude;
            return this;
        }

        public MapLocation build() {
            return new MapLocation(this);
        }
    }
}
