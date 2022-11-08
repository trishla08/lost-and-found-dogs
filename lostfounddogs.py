import pickle
import numpy as np
from haversine import haversine
from PIL import Image
import os

lostIndex = 1
foundIndex = 1

class lostDog:
         
    # The init method or constructor
    def __init__(self,uid,name,age,sex,breed,location,city,photo,message,ownerName,ownerEmail,ownerNumber,physicalAttributes,status="lost"):
             
        # Instance Variable
        self.uid = uid
        self.name = name    
        self.age = age
        self.sex = sex   
        self.breed = breed    
        self.location = location
        self.city = city
        self.photo = photo    
        self.message = message
        self.ownerName = ownerName   
        self.ownerEmail = ownerEmail    
        self.ownerNumber = ownerNumber
        self.status = status
        self.physicalAttributes = physicalAttributes

    def getName(self):
        return self.name

    def getUID(self):
        return self.uid
             

class foundDog:  
         
    # The init method or constructor
    def __init__(self,uid,sex,breed,location,city,photo,message,finderName,finderEmail,finderNumber, physicalAttributes):
             
        # Instance Variables
        self.uid = uid
        self.sex = sex   
        self.breed = breed    
        self.location = location
        self.city = city
        self.photo = photo    
        self.message = message
        self.finderName = finderName   
        self.finderEmail = finderEmail    
        self.finderNumber = finderNumber
        self.physicalAttributes = physicalAttributes

    def getName(self):
        return self.name
    def getSex(self):
        return self.sex
    def getBreed(self):
        return self.breed
    def getUID(self):
        return self.uid


def create(dogObj, fileName):
    dbfile = open(fileName, 'ab')
    pickle.dump(dogObj, dbfile)   
    dbfile.close()

def read(uid, fileName):
    with (open(fileName, "rb")) as openfile:
        while True:
            try:
                obj = pickle.load(openfile)
                if obj.getUID() == uid:
                    return obj
            except EOFError:
                break

def readAll(fileName):
    objects = []
    with (open(fileName, "rb")) as openfile:
        while True:
            try:
                objects.append(pickle.load(openfile))
            except EOFError:
                break
    return objects

def update(uid, newDogObj, fileName):
    f1 = open(fileName, "rb+")
    objList = []
     
    while True:
        try:
            obj = pickle.load(f1)
            if obj.getUID() == uid:
                objList.append(newDogObj)
            else:
                objList.append(obj)
        except EOFError:
            break
             
    f1.seek(0)
    f1.truncate()
     
    for i in range(len(objList)):
        pickle.dump(objList[i], f1)
    else:
        f1.close()


def delete(uid, fileName):
    f1 = open(fileName, "rb+")
    objList = []
     
    while True:
        try:
            obj = pickle.load(f1)
            if obj.getUID() != uid:
                objList.append(obj)
        except EOFError:
            break
             
    f1.seek(0)
    f1.truncate()
     
    for i in range(len(objList)):
        pickle.dump(objList[i], f1)
    else:
        f1.close()

def reportMissing(name,age,sex,breed,location,city,photo,message,ownerName,ownerEmail,ownerNumber):
    lostDogObj = lostDog(lostIndex, name,age,sex,breed,location,city,photo,message,ownerName,ownerEmail,ownerNumber, "lost")
    lostIndex = lostIndex + 1
    create(lostDogObj, 'lostDogs')

def reportFound(sex,breed,location,city,photo,message,finderName,finderEmail,finderNumber):
    foundDogObj = foundDog(foundIndex, sex,breed,location,city,photo,message,finderName,finderEmail,finderNumber)
    foundIndex = foundIndex + 1
    create(foundDogObj, 'foundDogs')


def browseDogs(sex,breed,location,city,radius,lostOrFound):
    objects = []
    if lostOrFound == "lost":
        fileName = "lostDogs"
    else:
        fileName = "foundDogs"

    objects = read(fileName)

    filteredList = []
    
    for obj in objects:
        a = False
        b = False
        c = False
        d = False
        if sex == '' or sex == obj.sex:
            a = True
        if breed == '' or breed == obj.breed:
            b = True
        if city == '' or city == obj.city:
            c = True
        if radius == 0 or isNearby(location,obj.location, radius):
            d = True
        
        if (a and b and c and d):
            filteredList.append(obj.getUID())

    return filteredList

def getDogDetails(uid, lostOrFound):
    if lostOrFound == "lost":
        fileName = "lostDogs"
    else:
        fileName = "foundDogs"

    read(uid, fileName)

def updateDogDetails(uid, lostOrFound, newDogObj):
    if lostOrFound == "lost":
        fileName = "lostDogs"
    else:
        fileName = "foundDogs"

    update(uid, newDogObj, fileName)

def deleteDogDetails(uid, lostOrFound):
    if lostOrFound == "lost":
        fileName = "lostDogs"
    else:
        fileName = "foundDogs"

    delete(uid, fileName)

def dogReunited(uid):
    deleteDogDetails(uid,"lost")


def isNearby(location1, location2, radius):
    print(haversine(location1,location2))
    return haversine(location1,location2) <= radius

if __name__ == "__main__":
    if os.path.exists("lostDogs"):
        os.remove("lostDogs")
    if os.path.exists("foundDogs"):
        os.remove("foundDogs")

    img = Image.open('download.jpeg')
    reportMissing("brownie", 4, 'Male', 'Indie', [20,50], 'Delhi', img, 'Pls help!', "Trish", "trish@10star.com", "12345")
    reportMissing("coco", 3, 'Male', 'Indie', [20.01,50], 'Pune', img, 'Pls help!', "Trish", "trish@10star.com", "12345")
    reportMissing("jupiter", 4, 'Female', 'Indie', [30,60], 'Delhi', img, 'Pls help!', "Trish", "trish@10star.com", "12345")
    reportMissing("luna", 1, 'Female', 'Indie', [31,60], 'Mumbai', img, 'Pls help!', "Trish", "trish@10star.com", "12345")
    reportMissing("alpha", 4, 'Male', 'Mixed', [40,50], 'Delhi', img, 'Pls help!', "Trish", "trish@10star.com", "12345")

    reportFound('Male', 'Indie', [21,50], 'Delhi', img, "Found", "trishla", "trishla@10star.com", "45678")
    reportFound('Male', 'Mixed', [40,50], 'Delhi', img, "Found", "trishla", "trishla@10star.com", "45678")
    reportFound('Female', 'Indie', [41,50], 'Delhi', img, "Found", "trishla", "trishla@10star.com", "45678")

    print(browseDogs('', '', [20,50], 'Delhi', 5, 'lost'))
