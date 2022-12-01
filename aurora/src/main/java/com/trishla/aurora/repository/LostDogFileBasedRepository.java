package com.trishla.aurora.repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.trishla.aurora.dtos.LostDog;

public class LostDogFileBasedRepository implements LostDogRepository {

    private final String fileName = "lostDog.dat";

    private static File f = new File("lostDog.dat");

    @Override
    public void create(LostDog obj) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName, true);

            // write object to file
            Object lostObj = (Object) obj;
            if (f.length() == 0) {
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(lostObj);
                oos.close();
            } else {
                CustomObjectOutputStream oos = null;
                oos = new CustomObjectOutputStream(fos);
                oos.writeObject(lostObj);
                oos.close();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public LostDog read(String uid) {
        LostDog dogObject = null;
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);

            // read object from file
            Object obj = null;
            while (fis.available() != 0) {
                obj = ois.readObject();
                dogObject = (LostDog) obj;
                if (dogObject.getUid().equals(uid)) {
                    ois.close();
                    return dogObject;
                }
            }

            // close reader
            ois.close();
            // return list;

        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return dogObject;
    }

    @Override
    public List<LostDog> readAll() {
        List<LostDog> list = new ArrayList<LostDog>();
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);

            // read object from file
            Object obj = null;
            while (fis.available() != 0) {
                obj = ois.readObject();
                LostDog item = (LostDog) obj;
                list.add(item);
            }

            // close reader
            ois.close();
            return list;

        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
            return list;
        }
    }

    @Override
    public void update(LostDog obj) {
        try {
            List<LostDog> list = readAll();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getUid().equals(obj.getUid())) {
                    list.set(i, obj);
                }
            }
            PrintWriter pw = new PrintWriter(fileName);
            pw.close();
            for (int i = 0; i < list.size(); i++) {
                create(list.get(i));
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public LostDog delete(String uid) {
        LostDog deletedObject = null;
        try {
            List<LostDog> list = readAll();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getUid().equals(uid)) {
                    deletedObject = list.get(i);
                    list.remove(i);
                }
            }
            PrintWriter pw = new PrintWriter(fileName);
            pw.close();
            for (int i = 0; i < list.size(); i++) {
                create(list.get(i));
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return deletedObject;
    }

}
