class LostDog {
    Double uid;
    String name;
    Integer age;
    String sex;
    String breed;
    Pair<Double, Double> location;
    String city;
    String photo;
    String message;
    String ownerName;
    String ownerEmail;
    String ownerNumber;
    Map<String, String> physicalAttributes;

    enum Status {
        Lost,
        Found
    }

    Status currentStatus;

    public LostDog(Double uid, String name, Integer age, String sex, String breed, Pair<Double, Double> location,
            String city, String photo, String message, String ownerName, String ownerEmail, String ownerNumber,
            Map<String, String> physicalAttributes, LostDog.Status currentStatus) {
        this.uid = uid;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.breed = breed;
        this.location = location;
        this.city = city;
        this.photo = photo;
        this.message = message;
        this.ownerName = ownerName;
        this.ownerEmail = ownerEmail;
        this.ownerNumber = ownerNumber;
        this.physicalAttributes = physicalAttributes;
        this.currentStatus = currentStatus;
    }

    public Double getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
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

    public String getOwnerName() {
        return ownerName;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public String getOwnerNumber() {
        return ownerNumber;
    }

    public Map<String, String> getPhysicalAttributes() {
        return physicalAttributes;
    }

    public Status getCurrentStatus() {
        return currentStatus;
    }

}