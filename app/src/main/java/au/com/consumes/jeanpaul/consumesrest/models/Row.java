package au.com.consumes.jeanpaul.consumesrest.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Row {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("imageHref")
    @Expose
    private String imageHref;

    /**
     * This method return array of description
     *
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     * This set return array of description
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * This method return the description
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method return the description
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * This method return url/ref of image
     *
     * @return
     */
    public String getImageHref() {
        return imageHref;
    }

    /**
     * This method set url/ref of image
     */
    public void setImageHref() {
        setImageHref();
    }

    /**
     * This method set url/ref of image
     *
     * @param imageHref
     */
    public void setImageHref(String imageHref) {
        this.imageHref = imageHref;
    }
}