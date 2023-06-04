package com.trishla.aurora.post.foundDog.repository;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.trishla.aurora.post.common.dao.DogPhysicalAttributesDao;
import com.trishla.aurora.post.common.dao.LocationDao;
import com.trishla.aurora.post.common.dto.DogPhysicalAttributes;
import com.trishla.aurora.post.common.dto.Location;
import com.trishla.aurora.post.foundDog.dao.FoundDogDao;
import com.trishla.aurora.post.foundDog.dao.FoundDogPostDao;
import com.trishla.aurora.post.foundDog.dto.FoundDog;
import com.trishla.aurora.post.foundDog.dto.FoundDogPost;
import com.trishla.aurora.user.repository.UserDaoTransformer;

@Service
public class FoundDogDaoTransformer {

    public FoundDogPostDao convertToDao(FoundDogPost foundDogPost) {
        FoundDogPostDao.FoundDogPostDaoBuilder foundDogPostDao = FoundDogPostDao.builder();
        return foundDogPostDao.UID(foundDogPost.getUID())
                .foundDog(convertFoundDogToDao(foundDogPost.getFoundDog()))
                .postCreationTimestamp(foundDogPost.getPostCreationTimestamp())
                .postStatus(foundDogPost.getPostStatus())
                .title(foundDogPost.getTitle()).build();
    }

    private FoundDogDao convertFoundDogToDao(FoundDog foundDog) {
        if (foundDog == null)
            return null;

        FoundDogDao.FoundDogDaoBuilder foundDogDaoBuilder = FoundDogDao.builder();
        return foundDogDaoBuilder.breed(foundDog.getBreed())
                .dateFound(foundDog.getDateFound())
                .distinctiveFeatures(convertDogPhysicalAttributesToDao(foundDog.getDistinctiveFeatures()))
                .gender(foundDog.getGender())
                .locationFoundAt(convertLocationToDao(foundDog.getLocationFoundAt()))
                .message(foundDog.getMessage())
                .finderEmail(foundDog.getFinderEmail())
                .finderName(foundDog.getFinderName())
                .finderPhone(foundDog.getFinderPhone())
                .photo(foundDog.getPhoto())
                .build();
    }

    public FoundDogPost convertToDtoOptional(Optional<FoundDogPostDao> foundDogPost) {
        return null;
    }

    public FoundDogPost convertToDto(FoundDogPostDao foundDogPostDao) {
        FoundDogPost.FoundDogPostBuilder foundDogPostBuilder = FoundDogPost.builder();
        return foundDogPostBuilder.UID(foundDogPostDao.getUID())
                .foundDog(convertFoundDogToDto(foundDogPostDao.getFoundDog()))
                .postCreationTimestamp(foundDogPostDao.getPostCreationTimestamp())
                .postStatus(foundDogPostDao.getPostStatus())
                .title(foundDogPostDao.getTitle()).build();
    }

    private FoundDog convertFoundDogToDto(FoundDogDao foundDogDao) {
        if (foundDogDao == null)
            return null;

        FoundDog.FoundDogBuilder foundDogBuilder = FoundDog.builder();
        return foundDogBuilder.breed(foundDogDao.getBreed())
                .dateFound(foundDogDao.getDateFound())
                .distinctiveFeatures(convertDogPhysicalAttributesToDTO(foundDogDao.getDistinctiveFeatures()))
                .gender(foundDogDao.getGender())
                .locationFoundAt(convertLocationToDto(foundDogDao.getLocationFoundAt()))
                .message(foundDogDao.getMessage())
                .finderEmail(foundDogDao.getFinderEmail())
                .finderName(foundDogDao.getFinderName())
                .finderPhone(foundDogDao.getFinderPhone())
                .photo(foundDogDao.getPhoto())
                .build();
    }

    private DogPhysicalAttributesDao convertDogPhysicalAttributesToDao(DogPhysicalAttributes attributesDto) {
        if (attributesDto == null)
            return null;

        DogPhysicalAttributesDao.DogPhysicalAttributesDaoBuilder builder = DogPhysicalAttributesDao.builder();
        return builder.colours(attributesDto.getColours())
                .size(attributesDto.getSize())
                .collar(attributesDto.getCollar())
                .coat(attributesDto.getCoat())
                .wounded(attributesDto.getWounded())
                .furry(attributesDto.getFurry())
                .limping(attributesDto.getLimping())
                .weight(attributesDto.getWeight())
                .sterilised(attributesDto.getSterilised()).build();
    }

    private DogPhysicalAttributes convertDogPhysicalAttributesToDTO(DogPhysicalAttributesDao attributesDao) {
        if (attributesDao == null)
            return null;

        DogPhysicalAttributes.DogPhysicalAttributesBuilder builder = DogPhysicalAttributes.builder();
        return builder.colours(attributesDao.getColours())
                .size(attributesDao.getSize())
                .collar(attributesDao.getCollar())
                .coat(attributesDao.getCoat())
                .wounded(attributesDao.getWounded())
                .furry(attributesDao.getFurry())
                .limping(attributesDao.getLimping())
                .weight(attributesDao.getWeight())
                .sterilised(attributesDao.getSterilised()).build();
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
