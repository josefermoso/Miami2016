package joesoft.miami2016.model;

/**
 * Created by joe on 7/30/16.
 */
public class Picture {
    private String textPicture;
    private Integer idImage;

    public Picture(String textPicture, Integer idImage) {

        this.textPicture = textPicture;
        this.idImage = idImage;
    }
    public String getTextPicture() {
        return textPicture;
    }

    public void setTextPicture(String textPicture) {
        this.textPicture = textPicture;
    }

    public Integer getIdImage() {
        return idImage;
    }

    public void setIdImage(Integer idImage) {
        this.idImage = idImage;
    }
}
