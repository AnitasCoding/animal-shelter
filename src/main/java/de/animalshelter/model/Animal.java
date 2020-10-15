package de.animalshelter.model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;

/**
 * This class produces the table animal inside the h2-database.
 * It saves data from animal.
 */
@Entity
public class Animal {

    //Colums in the database
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aid;
    private String name;
    private int age;
    private boolean lost;
    private boolean found;
    @Lob
    private Blob image;

    //File for Display
    @Transient
    private File displayImage;

    //Parameters for employee.html and addAnimal
    @Transient
    private MultipartFile multipartFile;
    @Transient
    private String status;


    public Animal() {
    }

    public Animal(int aid, String name, int age, Blob image) {
        this.aid = aid;
        this.name = name;
        this.age = age;
        this.image = image;
        this.lost = false;
        this.found = false;
        setDisplayImage();
    }

    public Animal(int aid, String name, int age, Blob image, boolean lost, boolean found) {
        this.aid = aid;
        this.name = name;
        this.age = age;
        this.image = image;
        this.lost = lost;
        this.found = found;
        setDisplayImage();
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

    public File getDisplayImage() {
        return displayImage;
    }

    public void setDisplayImage(File displayImage) {
        this.displayImage = displayImage;
    }

    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }

    /**
     * This function saves the image in a folder, that can be found by Thymeleaf.
     */
    public void setDisplayImage() {
        try {
            InputStream in = this.image.getBinaryStream();
            OutputStream out = new FileOutputStream("../animal-shelter/src/main/resources/static/images/aid_" + this.aid + "_image.jpg");
            byte[] buff = this.image.getBytes(1, (int) this.image.length());
            out.write(buff);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.displayImage = new File("../images/aid_" + this.aid + "_image.jpg");
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
