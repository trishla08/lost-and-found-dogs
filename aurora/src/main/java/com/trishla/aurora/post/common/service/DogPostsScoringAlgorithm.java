package com.trishla.aurora.post.common.service;

import java.time.Duration;
import java.time.Instant;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import com.trishla.aurora.post.common.dto.Colour;
import com.trishla.aurora.post.common.dto.DogPhysicalAttributes;
import com.trishla.aurora.post.common.dto.Gender;
import com.trishla.aurora.post.common.dto.Location;
import com.trishla.aurora.post.foundDog.dto.FoundDog;
import com.trishla.aurora.post.foundDog.dto.FoundDogPost;
import com.trishla.aurora.post.lostDog.dto.LostDog;
import com.trishla.aurora.post.lostDog.dto.LostDogPost;

public class DogPostsScoringAlgorithm {
    public int findScoreForPair(LostDogPost lostDogPost, FoundDogPost foundDogPost) {
        LostDog lostDog = lostDogPost.getLostDog();
        FoundDog foundDog = foundDogPost.getFoundDog();

        int score = 0;

        // Breed
        
        if (lostDog.getBreed() != "" && foundDog.getBreed() != "") {
            String breed1 = lostDog.getBreed();
            String breed2 = foundDog.getBreed();

            if (breed1 == breed2) {
                score += 2;
            } else if (hasCommonSubstringOfLength(breed1, breed2, 4)) {
                score += 1;
            } else {
                score -= 1;
            }
        }

        // Gender

        if (lostDog.getGender() != null && foundDog.getGender() != null) {
            Gender gender1 = lostDog.getGender();
            Gender gender2 = foundDog.getGender();

            if (gender1 == gender2) {
                score += 2;
            } else {
                score -= 2;
            }
        }

        // Location

        Location lostLocation = lostDog.getLastKnownLocation();
        Location foundLocation = foundDog.getLocationFoundAt();

        if (lostLocation != null && foundLocation != null) {
            // Calculate the distance between the two locations
            double distance = calculateDistance(lostLocation.getLatitude(), lostLocation.getLongitude(),
                    foundLocation.getLatitude(), foundLocation.getLongitude());

            // Compare the distance and assign the score accordingly
            if (distance <= 2) {
                score += 4;
            } else if (distance <= 5) {
                score += 3;
            } else if (distance <= 10) {
                score += 2;
            } else if (distance <= 15) {
                score += 1;
            } else if (distance > 50) {
                score -= 2;
            }
        }

        if (lostDog.getDateLost() != null && foundDog.getDateFound() != null) {
            Instant instantLost = lostDog.getDateLost();
            Instant instantFound = foundDog.getDateFound();

            if (instantFound.isBefore(instantLost)) {
                score -= 2;
            } else {

                Duration duration = Duration.between(instantLost, instantFound);
                long weeks = duration.toDays() / 7;

                if (weeks <= 1) {
                    score += 2;
                } else {
                    score += 1;
                }
            }
        }

        DogPhysicalAttributes lostDistinctiveFeatures = lostDog.getDistinctiveFeatures();
        DogPhysicalAttributes foundDistinctiveFeatures = foundDog.getDistinctiveFeatures();

        if (lostDistinctiveFeatures != null && !lostDistinctiveFeatures.getColours().isEmpty()
                && foundDistinctiveFeatures != null
                && !foundDistinctiveFeatures.getColours().isEmpty()) {
            List<Colour> lostColors = lostDistinctiveFeatures.getColours();
            List<Colour> foundColors = foundDistinctiveFeatures.getColours();

            if (lostColors.containsAll(foundColors) && foundColors.containsAll(lostColors)) {
                score += 2; // Every color matches
            } else if (!Collections.disjoint(lostColors, foundColors)) {
                score += 1; // At least one color matches
            } else {
                score -= 2; // No color matches
            }
        }

        if (lostDistinctiveFeatures != null && foundDistinctiveFeatures != null) {
            // Size
            if (lostDistinctiveFeatures.getSize() != null && foundDistinctiveFeatures.getSize() != null) {
                if (lostDistinctiveFeatures.getSize() == foundDistinctiveFeatures.getSize()) {
                    score += 1;
                } else {
                    score -= 1;
                }
            }

            // Furry
            if (lostDistinctiveFeatures.getFurry() != null && foundDistinctiveFeatures.getFurry() != null) {
                if (lostDistinctiveFeatures.getFurry() == foundDistinctiveFeatures.getFurry()) {
                    score += 1;
                } else {
                    score -= 1;
                }
            }

            // Weight
            if (lostDistinctiveFeatures.getWeight() != null && foundDistinctiveFeatures.getWeight() != null) {
                if (lostDistinctiveFeatures.getWeight() == foundDistinctiveFeatures.getWeight()) {
                    score += 1;
                } else {
                    score -= 1;
                }
            }

            // Coat
            if (lostDistinctiveFeatures.getCoat() != null && foundDistinctiveFeatures.getCoat() != null) {
                if (lostDistinctiveFeatures.getCoat() == foundDistinctiveFeatures.getCoat()) {
                    score += 1;
                }
            }

            // Collar
            if (lostDistinctiveFeatures.getCollar() != null && foundDistinctiveFeatures.getCollar() != null) {
                if (lostDistinctiveFeatures.getCollar() == foundDistinctiveFeatures.getCollar()) {
                    score += 1;
                }
            }

            // Wounded
            if (lostDistinctiveFeatures.getWounded() != null && foundDistinctiveFeatures.getWounded() != null) {
                if (lostDistinctiveFeatures.getWounded() == foundDistinctiveFeatures.getWounded()) {
                    score += 1;
                }
            }

            // Limping
            if (lostDistinctiveFeatures.getLimping() != null && foundDistinctiveFeatures.getLimping() != null) {
                if (lostDistinctiveFeatures.getLimping() == foundDistinctiveFeatures.getLimping()) {
                    score += 1;
                }
            }

            // Sterilised
            if (lostDistinctiveFeatures.getSterilised() != null && foundDistinctiveFeatures.getSterilised() != null) {
                if (lostDistinctiveFeatures.getSterilised() == foundDistinctiveFeatures.getSterilised()) {
                    score += 2;
                } else {
                    score -= 2;
                }
            }
        }

        return score;
    }

    private boolean hasCommonSubstringOfLength(String str1, String str2, Integer length) {
        HashSet<String> substrings = new HashSet<>();

        for (int i = 0; i <= str1.length() - length; i++) {
            substrings.add(str1.substring(i, i + length));
        }

        for (int i = 0; i <= str2.length() - length; i++) {
            String substring = str2.substring(i, i + length);
            if (substrings.contains(substring)) {
                return true;
            }
        }

        return false;
    }

    public static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        // Radius of the Earth in kilometers
        double earthRadius = 6371;
    
        // Convert latitude and longitude values to radians
        double lat1Rad = Math.toRadians(lat1);
        double lon1Rad = Math.toRadians(lon1);
        double lat2Rad = Math.toRadians(lat2);
        double lon2Rad = Math.toRadians(lon2);
    
        // Calculate the differences in latitude and longitude
        double deltaLat = lat2Rad - lat1Rad;
        double deltaLon = lon2Rad - lon1Rad;
    
        // Calculate the square of half the chord length between the latitude points
        double a = Math.sin(deltaLat / 2) * Math.sin(deltaLat / 2)
                + Math.cos(lat1Rad) * Math.cos(lat2Rad)
                * Math.sin(deltaLon / 2) * Math.sin(deltaLon / 2);
    
        // Calculate the angular distance in radians
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    
        // Calculate the distance in kilometers
        double distance = earthRadius * c;
    
        return distance;
    }
    

}
