package au.com.consumes.jeanpaul.consumesrest.models;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * This interface describe Api wab service available
 * here only GET
 */
public interface ApiService {
    @GET("facts.json")
    Call<RowLists> getMyJSON();

}


