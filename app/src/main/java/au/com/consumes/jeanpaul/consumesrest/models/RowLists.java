package au.com.consumes.jeanpaul.consumesrest.models;
/*******************************************************************************
 * Copyright (c) 2018 Ndisanze jean Paul.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v2.1
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 *
 * Contributors:
 *     Ndisanze jean Paul. - initial API and implementation
 ******************************************************************************/
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * class modeling list of Row
 */
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
