package id.web.tugasakhir.puyuh_android;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import id.web.tugasakhir.puyuh_android.Kandang.KandangActivity;
import id.web.tugasakhir.puyuh_android.Kas.KasActivity;
import id.web.tugasakhir.puyuh_android.Keuangan.KeuanganAdapter;
import id.web.tugasakhir.puyuh_android.Keuangan.KeuanganData;
import id.web.tugasakhir.puyuh_android.Keuangan.KeuanganService;
import id.web.tugasakhir.puyuh_android.RestAPI.ApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MenuActivity extends AppCompatActivity {
    Button btnLaporan, btnPendapatan, btnData, btnKas, btnKeuangan;
    TextView dateNow;

    private KeuanganAdapter adapter;
    private RecyclerView recyclerView;
    ProgressDialog progressDoalog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        progressDoalog = new ProgressDialog(MenuActivity.this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();

        /*Create handle for the RetrofitInstance interface*/
        KeuanganService KeuanganService = ApiClient.getRetrofitInstance().create(id.web.tugasakhir.puyuh_android.Keuangan.KeuanganService.class);
        Call<List<KeuanganData>> call = KeuanganService.getAllKeuangan();
        call.enqueue(new Callback<List<KeuanganData>>() {
            @Override
            public void onResponse(Call<List<KeuanganData>> call, Response<List<KeuanganData>> response) {
                progressDoalog.dismiss();
                generateDataList(response.body());

            }

            @Override
            public void onFailure(Call<List<KeuanganData>> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(MenuActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });



//dateNow
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        dateNow = findViewById(R.id.textHariIni);
        dateNow.setText(formatter.format(date));

        //toLaporan
        btnLaporan = findViewById(R.id.btn_laporan);
        btnLaporan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toLaporan = new Intent(MenuActivity.this, LaporanActivity.class);
                startActivity(toLaporan);
            }
        });

        //toPendapatan
        btnPendapatan = findViewById(R.id.btn_pendapatan);
        btnPendapatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toPendapatan = new Intent(MenuActivity.this, PendapatanActivity.class);
                startActivity(toPendapatan);
            }
        });
//toData
        btnData = findViewById(R.id.btn_data);
        btnData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toData = new Intent(MenuActivity.this, KandangActivity.class);
                startActivity(toData);
            }
        });

        //toKas
        btnKas = findViewById(R.id.btn_kas);
        btnKas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toKas = new Intent(MenuActivity.this, KasActivity.class);
                startActivity(toKas);
            }
        });

//        //toKas
//        btnKeuangan = findViewById(R.id.btn_keuangan);
//        btnKeuangan.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent toKeuangan = new Intent(MenuActivity.this, KeuanganActivity.class);
//                startActivity(toKeuangan);
//            }
//        });
    }

    /*Method to generate List of data using RecyclerView with custom adapter*/
    private void generateDataList(List<KeuanganData> KeuanganDataList) {
        recyclerView = findViewById(R.id.keuanganRecyclerView);
        adapter = new KeuanganAdapter(KeuanganDataList, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

}
