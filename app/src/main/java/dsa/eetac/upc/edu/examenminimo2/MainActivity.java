package dsa.eetac.upc.edu.examenminimo2;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private APIRest myapirest;
    private Recycler recycler;
    private RecyclerView recyclerView;

    TextView textViewCodiPostal;
    TextView textViewNameTown;
    ImageView ImageURL;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.Recycler_View);
        recycler = new Recycler(this);
        recyclerView.setAdapter(recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        textViewCodiPostal = findViewById(R.id.codipostaltext);
        textViewNameTown = findViewById(R.id.citytext);
        ImageURL = findViewById(R.id.imageView);

        Intent intent = getIntent();

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Loading...");
        progressDialog.setMessage("Waiting...");
        progressDialog.setCancelable(false);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.show();

        myapirest = APIRest.createAPIRest();

        getData();
    }

    private void getData() {
        Call<Cities> elementCall = myapirest.getData();

        elementCall.enqueue(new Callback<Cities>() {
            @Override
            public void onResponse(Call<Cities> call, Response<Cities> response) {
                if(response.isSuccessful()){
                    Cities cities = response.body();

                    List<Element> elementList = cities.getElements();

                    for(int i = 0; i<elementList.size(); i++){
                        Log.i("Name city: " + elementList.get(i).getMunicipiNom(), response.message());
                    }

                    if(elementList.size() != 0){
                        recycler.addElements(elementList);
                    }

                    progressDialog.hide();
                } else {
                    Log.e("GITHUB", String.valueOf(response.errorBody()));

                    progressDialog.hide();

                    //Show the alert dialog
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);

                    alertDialogBuilder
                            .setTitle("Error")
                            .setMessage(response.message())
                            .setCancelable(false)
                            .setPositiveButton("De acuerdo", (dialog, which) -> finish());

                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
                }
            }

            @Override
            public void onFailure(Call<Cities> call, Throwable t) {
                Log.e("GITHUB", t.getMessage());

                progressDialog.hide();

                //Show the alert dialog
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);

                alertDialogBuilder
                        .setTitle("Error")
                        .setMessage(t.getMessage())
                        .setCancelable(false)
                        .setPositiveButton("De acuerdo", (dialog, which) -> finish());

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });
    }


}
