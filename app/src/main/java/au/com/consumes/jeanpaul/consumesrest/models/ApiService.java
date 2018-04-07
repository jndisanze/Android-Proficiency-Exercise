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
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * This interface defines possible endpoint URLs and their respective HTTP methods.
 * It describe Api web service available
 * here only GET
 */
public interface ApiService {
    @GET("facts.json")
    Call<RowLists> getMyJSON();

}


