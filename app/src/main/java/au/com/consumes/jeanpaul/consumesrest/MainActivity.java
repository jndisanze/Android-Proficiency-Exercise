package au.com.consumes.jeanpaul.consumesrest;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import au.com.consumes.jeanpaul.consumesrest.Adapter.RowAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Row> rowList;
    private ProgressDialog pDialog;
    private RecyclerView recyclerView;
    private RowAdapter eAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pDialog = new ProgressDialog(MainActivity.this);
        pDialog.setMessage("JeanP Sys Loading Data.. Please wait...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();

        ApiService api = RetroClient.getApiService();
        Call<RowLists> call = api.getMyJSON();
        call.enqueue(new Callback<RowLists>() {
            @Override
            public void onResponse(Call<RowLists> call, Response<RowLists> response) {
                //Dismiss Dialog
                pDialog.dismiss();

                if (response.isSuccessful()) {
                    /**
                     * Got Successfully
                     */
                    rowList = response.body().getRows();
                    recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
                    eAdapter = new RowAdapter(rowList,getBaseContext());
                    RecyclerView.LayoutManager eLayoutManager = new LinearLayoutManager(getApplicationContext());
                    recyclerView.setLayoutManager(eLayoutManager);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter(eAdapter);
                }
            }

            @Override
            public void onFailure(Call<RowLists> call, Throwable t) {
                pDialog.dismiss();
            }
        });
    }
}

