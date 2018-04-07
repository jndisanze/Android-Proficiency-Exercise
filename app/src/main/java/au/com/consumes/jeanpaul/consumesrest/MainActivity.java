package au.com.consumes.jeanpaul.consumesrest;
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
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import au.com.consumes.jeanpaul.consumesrest.Adapter.RowAdapter;
import au.com.consumes.jeanpaul.consumesrest.models.ApiService;
import au.com.consumes.jeanpaul.consumesrest.models.RetroClient;
import au.com.consumes.jeanpaul.consumesrest.models.Row;
import au.com.consumes.jeanpaul.consumesrest.models.RowLists;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * MainActivity class
 */
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
        pDialog.setMessage(getString(R.string.loading));
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();
        //Creating an object of our api interface
        RetroClient retroClient = new RetroClient(getString(R.string.root_url));
        ApiService api = retroClient.getApiService();
        /**
         * Calling JSON
         */
        Call<RowLists> call = api.getMyJSON();
        /**
         * Enqueue Callback will be call when get response...
         */
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

