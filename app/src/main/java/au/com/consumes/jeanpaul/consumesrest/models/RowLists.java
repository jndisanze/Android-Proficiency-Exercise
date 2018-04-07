package au.com.consumes.jeanpaul.consumesrest.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class RowLists {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("rows")
    @Expose
    private ArrayList<Row> rows = null;

    /**
     * this method return title of album description
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method set title of album description
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * This method return array of description
     * @return array of description
     */
    public ArrayList<Row> getRows() {
        return rows;
    }

    /**
     * This method return array of description
     * @param rows
     */
    public void setRows(ArrayList<Row> rows) {
        this.rows = rows;
    }


}
