package dsa.eetac.upc.edu.examenminimo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import retrofit2.Call;

public class MainActivity extends AppCompatActivity {

    private APIRest myapirest;
    private Recycler recycler;
    private RecyclerView recyclerView;

    TextView textViewCodiPostal;
    TextView textViewNameTown;
    ImageView ImageURL;

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
        textViewNameTown=findViewById(R.id.citytext);
        ImageURL=findViewById(R.id.imageView);

        Intent intent = getIntent();

        myapirest = APIRest.createAPIRest();

        getIne();
    }

    private void getIne() {
       //Call<Element> elementCall = myapirest.getIne();
    }
}
