package id.web.tugasakhir.puyuh_android.Keuangan;

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


public class KeuanganActivity extends AppCompatActivity {
    private KeuanganAdapter adapter;
    private RecyclerView recyclerView;
    ProgressDialog progressDoalog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keuangan);

        progressDoalog = new ProgressDialog(KeuanganActivity.this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();

        /*Create handle for the RetrofitInstance interface*/
        KeuanganService keuanganService = ApiClient.getRetrofitInstance().create(KeuanganService.class);
        Call<List<KeuanganData>> call = keuanganService.getAllKeuangan();
        call.enqueue(new Callback<List<KeuanganData>>() {
            @Override
            public void onResponse(Call<List<KeuanganData>> call, Response<List<KeuanganData>> response) {
                progressDoalog.dismiss();
                generateDataList(response.body());

            }

            @Override
            public void onFailure(Call<List<KeuanganData>> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(KeuanganActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /*Method to generate List of data using RecyclerView with custom adapter*/
    private void generateDataList(List<KeuanganData> keuanganDataList) {
        recyclerView = findViewById(R.id.keuanganRecyclerView);
        adapter = new KeuanganAdapter(keuanganDataList, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
