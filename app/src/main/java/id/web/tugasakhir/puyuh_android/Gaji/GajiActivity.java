package id.web.tugasakhir.puyuh_android.Gaji;

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


public class GajiActivity extends AppCompatActivity {
    private GajiAdapter adapter;
    private RecyclerView recyclerView;
    ProgressDialog progressDoalog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaji);

        progressDoalog = new ProgressDialog(GajiActivity.this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();

        /*Create handle for the RetrofitInstance interface*/
        GajiService gajiService = ApiClient.getRetrofitInstance().create(GajiService.class);
        Call<List<GajiData>> call = gajiService.getAllGaji();
        call.enqueue(new Callback<List<GajiData>>() {
            @Override
            public void onResponse(Call<List<GajiData>> call, Response<List<GajiData>> response) {
                progressDoalog.dismiss();
                generateDataList(response.body());

            }

            @Override
            public void onFailure(Call<List<GajiData>> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(GajiActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /*Method to generate List of data using RecyclerView with custom adapter*/
    private void generateDataList(List<GajiData> gajiDataList) {
        recyclerView = findViewById(R.id.gajiRecyclerView);
        adapter = new GajiAdapter(gajiDataList, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }
}
