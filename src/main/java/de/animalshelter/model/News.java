package de.animalshelter.model;


import javax.persistence.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.util.Date;

/**
 * This class produces the table news inside the h2-database.
 * It saves data from news.
 */
@Entity
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int nid;
    private String title;
    @Lob
    private String information;
    private Date date;
    @Lob
    private Blob image;
    @Transient
    private File displayImage;

    public News(int nid, String title, String information, Date date, Blob image) {
        this.nid = nid;
        this.title = title;
        this.information = information;
        this.date = date;
        this.image = image;
        setDisplayImage();
    }

    public News() {

    }

    public int getNid() {
        return nid;
    }

    public void setNid(int nid) {
        this.nid = nid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public File getDisplayImage() {
        return displayImage;
    }

    public void setDisplayImage(File displayImage) {
        this.displayImage = displayImage;
    }


    /**
     * This function saves the image in a folder, that can be found by Thymeleaf.
     */
    public void setDisplayImage() {
        try {
            OutputStream out = new FileOutputStream("../animal-shelter/src/main/resources/static/images/nid_" + this.nid + "_image.jpg");
            byte[] buff = this.image.getBytes(1, (int) this.image.length());
            out.write(buff);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.displayImage = new File("../images/nid_" + this.nid + "_image.jpg");
    }
}
