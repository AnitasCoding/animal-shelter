package de.animalshelter.model;

import javax.persistence.*;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Date;

@Entity
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int nid;
    private String title;
    @Lob
    private String information;
    private Date date;
    @Lob
    private Blob image;
    private byte[] byteImage;

    public News(int nid, String title, String information, Date date, Blob image) {
        this.nid = nid;
        this.title = title;
        this.information = information;
        this.date = date;
        this.byteImage = makeByteImage(image);
    }

    public News() {

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
}
