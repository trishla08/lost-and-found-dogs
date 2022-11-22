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

import com.trishla.aurora.dtos.FoundDog;

public class FoundDogFileBasedRepository implements FoundDogRepository {

    private final String fileName = "foundDog.dat";

    private static File f = new File("foundDog.dat");

    @Override
    public void create(FoundDog obj) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName, true);

            ObjectOutputStream oos = null;
            if (f.length() == 0)
                oos = new ObjectOutputStream(fos);
            else
                oos = new CustomObjectOutputStream(fos);

            oos.writeObject(obj);
            oos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public FoundDog read(String uid) {
        FoundDog dogObject = null;
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);

            // read object from file
            Object obj = null;
            while (fis.available() != 0) {
                obj = ois.readObject();
                dogObject = (FoundDog) obj;

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
    public List<FoundDog> readAll() {
        List<FoundDog> list = new ArrayList<FoundDog>();
        ;
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);

            // read object from file
            Object obj = null;
            while (fis.available() != 0) {
                obj = ois.readObject();
                FoundDog item = (FoundDog) obj;
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
    public void update(FoundDog obj) {
        try {
            List<FoundDog> list = readAll();
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
    public void delete(String uid) {
        try {
            List<FoundDog> list = readAll();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getUid().equals(uid)) {
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
    }

}
