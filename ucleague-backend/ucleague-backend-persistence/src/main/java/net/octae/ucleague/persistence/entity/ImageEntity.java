package net.octae.ucleague.persistence.entity;

import javax.persistence.*;
import java.sql.Blob;

/**
 * The type Image entity.
 */
@Entity(name = "IMAGE")
public class ImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition="BLOB")
    @Lob
    private byte[] data;

    /**
     * Instantiates a new Image entity.
     */
    public ImageEntity() {
    }

    /**
     * Instantiates a new Image entity.
     *
     * @param data the data
     */
    public ImageEntity(byte[] data) {
        this.data = data;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get data byte [ ].
     *
     * @return the byte [ ]
     */
    public byte[] getData() {
        return data;
    }

    /**
     * Sets data.
     *
     * @param data the data
     */
    public void setData(byte[] data) {
        this.data = data;
    }
}
