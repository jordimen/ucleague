package net.octae.ucleague.persistence.entity;

import javax.persistence.*;
import java.sql.Blob;

@Entity(name = "IMAGE")
public class ImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition="BLOB")
    @Lob
    private byte[] data;

    public ImageEntity() {
    }

    public ImageEntity(byte[] data) {
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
