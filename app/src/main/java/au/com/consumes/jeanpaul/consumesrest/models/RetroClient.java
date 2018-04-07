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
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
/**
 * Creating Retrofit Client
 * we instantiate Retrofit.Builder using the domain URL
 * */
public class RetroClient {
    private static  String ROOT_URL;
    public RetroClient(String urlRoot){
        this.ROOT_URL = urlRoot;
    }
    /**
     * Thi Get Retrofit Instance
     * @return
     */
    private static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /**
     * Get API Service
     * @return API Service
     */
    public static ApiService getApiService() {
        return getRetrofitInstance().create(ApiService.class);
    }
}