class FoundDog {
    Double uid;
    String sex;
    String breed;
    Pair<Double,Double> location;
    String city;
    String photo;
    String message;
    String finderName;
    String finderEmail;
    String finderNumber;
    Map<String,String> physicalAttributes;

    public FoundDog(Double uid, String sex, String breed, Pair<Double, Double> location, String city, String photo,
            String message, String finderName, String finderEmail, String finderNumber,
            Map<String, String> physicalAttributes) {
        this.uid = uid;
        this.sex = sex;
        this.breed = breed;
        this.location = location;
        this.city = city;
        this.photo = photo;
        this.message = message;
        this.finderName = finderName;
        this.finderEmail = finderEmail;
        this.finderNumber = finderNumber;
        this.physicalAttributes = physicalAttributes;
    }

    public Double getUid() {
        return uid;
    }

    public String getSex() {
        return sex;
    }

    public String getBreed() {
        return breed;
    }

    public Pair<Double, Double> getLocation() {
        return location;
    }

    public String getCity() {
        return city;
    }

    public String getPhoto() {
        return photo;
    }

    public String getMessage() {
        return message;
    }

    public String getFinderName() {
        return finderName;
    }

    public String getFinderEmail() {
        return finderEmail;
    }

    public String getFinderNumber() {
        return finderNumber;
    }

    public Map<String, String> getPhysicalAttributes() {
        return physicalAttributes;
    }

    

}