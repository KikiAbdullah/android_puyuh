package id.web.tugasakhir.puyuh_android.Kas;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import id.web.tugasakhir.puyuh_android.R;
import id.web.tugasakhir.puyuh_android.RestAPI.ApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class KasActivity extends AppCompatActivity {
    private KasAdapter adapter;
    private RecyclerView recyclerView;
    ProgressDialog progressDoalog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kas);

        progressDoalog = new ProgressDialog(KasActivity.this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();

        /*Create handle for the RetrofitInstance interface*/
        KasService kasService = ApiClient.getRetrofitInstance().create(KasService.class);
        Call<List<KasData>> call = kasService.getAllKas();
        call.enqueue(new Callback<List<KasData>>() {
            @Override
            public void onResponse(Call<List<KasData>> call, Response<List<KasData>> response) {
                progressDoalog.dismiss();
                generateDataList(response.body());

            }

            @Override
            public void onFailure(Call<List<KasData>> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(KasActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /*Method to generate List of data using RecyclerView with custom adapter*/
    private void generateDataList(List<KasData> kasDataList) {
        recyclerView = findViewById(R.id.kasRecyclerView);
        adapter = new KasAdapter(kasDataList, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
