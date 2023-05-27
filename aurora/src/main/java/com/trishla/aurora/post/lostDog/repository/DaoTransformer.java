package com.trishla.aurora.post.lostDog.repository;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.trishla.aurora.post.common.dao.DogPhysicalAttributesDao;
import com.trishla.aurora.post.common.dao.LocationDao;
import com.trishla.aurora.post.common.dto.DogPhysicalAttributes;
import com.trishla.aurora.post.common.dto.Location;
import com.trishla.aurora.post.lostDog.dao.LostDogDao;
import com.trishla.aurora.post.lostDog.dao.LostDogPostDao;
import com.trishla.aurora.post.lostDog.dto.LostDog;
import com.trishla.aurora.post.lostDog.dto.LostDogPost;

@Service
public class DaoTransformer {
    public LostDogPostDao convertToDao(LostDogPost lostDogPost) {
        LostDogPostDao.LostDogPostDaoBuilder lostDogPostDao = LostDogPostDao.builder();
        return lostDogPostDao.UID(lostDogPost.getUID())
                .lostDog(convertLostDogToDao(lostDogPost.getLostDog()))
                .postCreationTimestamp(lostDogPost.getPostCreationTimestamp())
                .postStatus(lostDogPost.getPostStatus())
                .title(lostDogPost.getTitle())
                .userID(lostDogPost.getUserID()).build();
    }

    private LostDogDao convertLostDogToDao(LostDog lostDog) {
        if (lostDog == null)
            return null;

        LostDogDao.LostDogDaoBuilder lostDogDaoBuilder = LostDogDao.builder();
        return lostDogDaoBuilder.name(lostDog.getName()).age(lostDog.getAge()).breed(lostDog.getBreed())
                .dateLost(lostDog.getDateLost())
                .distinctiveFeatures(convertDogPhysicalAttributesToDao(lostDog.getDistinctiveFeatures()))
                .gender(lostDog.getGender())
                .lastKnownLocation(convertLocationToDao(lostDog.getLastKnownLocation()))
                .message(lostDog.getMessage())
                .ownerEmail(lostDog.getOwnerEmail())
                .ownerName(lostDog.getOwnerName())
                .ownerPhone(lostDog.getOwnerPhone())
                .photo(lostDog.getPhoto())
                .build();
    }

    public LostDogPost convertToDtoOptional(Optional<LostDogPostDao> lostDogPost) {
        if (lostDogPost.isPresent()) {
            return convertToDto(lostDogPost.get());
        } else
            return null;
    }

    public LostDogPost convertToDto(LostDogPostDao lostDogPost) {
        LostDogPost.LostDogPostBuilder lostDogPostDaoBuilder = LostDogPost.builder();
        return lostDogPostDaoBuilder.UID(lostDogPost.getUID())
                .lostDog(convertLostDogToDto(lostDogPost.getLostDog()))
                .postCreationTimestamp(lostDogPost.getPostCreationTimestamp())
                .postStatus(lostDogPost.getPostStatus())
                .title(lostDogPost.getTitle())
                .userID(lostDogPost.getUserID()).build();
    }

    private LostDog convertLostDogToDto(LostDogDao lostDog) {
        if (lostDog == null)
            return null;

        LostDog.LostDogBuilder lostDogBuilder = LostDog.builder();
        return lostDogBuilder.name(lostDog.getName()).age(lostDog.getAge()).breed(lostDog.getBreed())
                .dateLost(lostDog.getDateLost())
                .distinctiveFeatures(convertDogPhysicalAttributesToDTO(lostDog.getDistinctiveFeatures()))
                .gender(lostDog.getGender())
                .lastKnownLocation(convertLocationToDto(lostDog.getLastKnownLocation()))
                .message(lostDog.getMessage())
                .ownerEmail(lostDog.getOwnerEmail())
                .ownerName(lostDog.getOwnerName())
                .ownerPhone(lostDog.getOwnerPhone())
                .photo(lostDog.getPhoto())
                .build();
    }

    private DogPhysicalAttributesDao convertDogPhysicalAttributesToDao(DogPhysicalAttributes attributesDto) {
        if (attributesDto == null)
            return null;

        DogPhysicalAttributesDao.DogPhysicalAttributesDaoBuilder builder = DogPhysicalAttributesDao.builder();
        return builder.colours(attributesDto.getColours())
                .size(attributesDto.getSize())
                .collar(attributesDto.isCollar())
                .coat(attributesDto.isCoat())
                .wounded(attributesDto.isWounded())
                .furry(attributesDto.isFurry())
                .limping(attributesDto.isLimping())
                .weight(attributesDto.getWeight())
                .sterilised(attributesDto.isSterilised()).build();
    }

    private DogPhysicalAttributes convertDogPhysicalAttributesToDTO(DogPhysicalAttributesDao attributesDao) {
        if (attributesDao == null)
            return null;

        DogPhysicalAttributes.DogPhysicalAttributesBuilder builder = DogPhysicalAttributes.builder();
        return builder.colours(attributesDao.getColours())
                .size(attributesDao.getSize())
                .collar(attributesDao.isCollar())
                .coat(attributesDao.isCoat())
                .wounded(attributesDao.isWounded())
                .furry(attributesDao.isFurry())
                .limping(attributesDao.isLimping())
                .weight(attributesDao.getWeight())
                .sterilised(attributesDao.isSterilised()).build();
    }

    private LocationDao convertLocationToDao(Location location) {
        if (location == null)
            return null;

        LocationDao.LocationDaoBuilder builder = LocationDao.builder();
        return builder.latitude(location.getLatitude()).longitude(location.getLongitude()).build();
    }

    private Location convertLocationToDto(LocationDao location) {
        if (location == null)
            return null;

        Location.LocationBuilder builder = Location.builder();
        return builder.latitude(location.getLatitude()).longitude(location.getLongitude()).build();
    }
}
