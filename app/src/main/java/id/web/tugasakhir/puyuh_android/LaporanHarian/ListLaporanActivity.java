package id.web.tugasakhir.puyuh_android.LaporanHarian;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

public class ListLaporanActivity extends AppCompatActivity {

    private LaporanAdapter adapter;
    private RecyclerView recyclerView;
    Button btnAdd;
    ProgressDialog progressDoalog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laporan);

        //toPendapatan
        btnAdd = findViewById(R.id.btn_addLaporan);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toAdd = new Intent(ListLaporanActivity.this, LaporanActivity.class);
                startActivity(toAdd);
            }
        });

        progressDoalog = new ProgressDialog(ListLaporanActivity.this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();

        /*Create handle for the RetrofitInstance interface*/
        LaporanService pendapatanService = ApiClient.getRetrofitInstance().create(LaporanService.class);
        retrofit2.Call<List<LaporanData>> call = pendapatanService.getAllLaporan();
        call.enqueue(new Callback<List<LaporanData>>() {
            @Override
            public void onResponse(retrofit2.Call<List<LaporanData>> call, Response<List<LaporanData>> response) {
                progressDoalog.dismiss();
                generateDataList(response.body());

            }

            @Override
            public void onFailure(Call<List<LaporanData>> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(ListLaporanActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /*Method to generate List of data using RecyclerView with custom adapter*/
    private void generateDataList(List<LaporanData> pendapatanDataList) {
        recyclerView = findViewById(R.id.laporanRecyclerView);
        adapter = new LaporanAdapter(pendapatanDataList, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
