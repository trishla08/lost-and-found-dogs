package com.trishla.aurora.dtos;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

import com.google.common.collect.ImmutableMap;

import ch.hsr.geohash.GeoHash;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;

@Getter
@Setter
@NoArgsConstructor
@Builder(setterPrefix = "set")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Data
public class Geohash {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String uid;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "point_id", referencedColumnName = "ID")
    private Point point;

    @Singular private ImmutableMap<Integer, String> geoHashes;

    private static final int minPrecision = 3;
    private static final int maxPrecision = 6;

    public Geohash(String uid, Point point) {
        this.uid = uid;
        this.point = point;
        this.geoHashes = ImmutableMap.copyOf(getGeohashesForPoint(point));
    }

    private Map<Integer, String> getGeohashesForPoint(Point p) {
        HashMap<Integer, String> map = new HashMap<Integer, String>(); 
        for (int precision = minPrecision; precision <= maxPrecision; precision++) {
            map.put(precision,
                    GeoHash.geoHashStringWithCharacterPrecision(p.getLatitude(), p.getLongitude(), precision));
        }
        return map;
    }
}
