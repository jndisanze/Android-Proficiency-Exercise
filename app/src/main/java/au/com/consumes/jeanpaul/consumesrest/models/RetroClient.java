package au.com.consumes.jeanpaul.consumesrest.models;

import android.content.Context;

import au.com.consumes.jeanpaul.consumesrest.R;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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