package de.animalshelter.model;

import javax.persistence.*;
import java.sql.Blob;
import java.sql.SQLException;

@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int aid;
    private String name;
    private int age;
    @Lob
    private Blob image;
    private byte[] byteImage;
    private boolean lost;
    private boolean found;

    public Animal() {
    }

    public Animal(int aid, String name, int age, Blob image) {
        this.aid = aid;
        this.name = name;
        this.age = age;
        this.image = image;
        this.lost = false;
        this.found = false;
        this.byteImage = makeByteImage(image);
    }

    public Animal(int aid, String name, int age, Blob image, boolean lost, boolean found) {
        this.aid = aid;
        this.name = name;
        this.age = age;
        this.image = image;
        this.lost = lost;
        this.found = found;
        this.byteImage = makeByteImage(image);
    }

    private byte[] makeByteImage(Blob blob) {
        byte[] byteImage = null;
        try {
            byteImage = blob.getBytes(1, (int) blob.length());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return byteImage;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public boolean isLost() {
        return lost;
    }

    public void setLost(boolean lost) {
        this.lost = lost;
    }

    public boolean isFound() {
        return found;
    }

    public void setFound(boolean found) {
        this.found = found;
    }

    public byte[] getByteImage() {
        return byteImage;
    }

    public void setByteImage(byte[] byteImage) {
        this.byteImage = byteImage;
    }
}
