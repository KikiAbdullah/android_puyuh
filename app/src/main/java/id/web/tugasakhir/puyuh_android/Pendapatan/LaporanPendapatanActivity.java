package id.web.tugasakhir.puyuh_android.Pendapatan;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import id.web.tugasakhir.puyuh_android.R;
import id.web.tugasakhir.puyuh_android.RestAPI.ApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LaporanPendapatanActivity extends AppCompatActivity {
    private EditText editTelur, editHarga;
    private TextView textTotal, textDate;
    private Button btnSubmitPendapatan;
    private String nama;
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date date = new Date();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pendapatan);
        Date today = new Date();
        editTelur = findViewById(R.id.edit_telur);
        editHarga = findViewById(R.id.edit_harga);
        textDate = findViewById(R.id.textDate);
        textTotal = findViewById(R.id.textTotal);
        textDate.setText(today + "");
        btnSubmitPendapatan = findViewById(R.id.btn_submitPendapatan);

        btnSubmitPendapatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData();
            }
        });
    }

    private void sendData() {
        String tanggal = dateFormat.format(date);
        String jmlTelur = editTelur.getText().toString().trim();
        String jmlHarga = editHarga.getText().toString().trim();
        String totalHarga = Integer.parseInt(jmlTelur) * Integer.parseInt(jmlHarga) + "";
        textTotal.setText(totalHarga);

        String idUser = "1";
        String nama = "Jual Telur";
        String satuan = "kg";

        PendapatanService pendapatanService = ApiClient.getRetrofitInstance().create(PendapatanService.class);
        Call<PendapatanData> call = pendapatanService.addPendapatan(
                idUser,
                tanggal,
                nama,
                jmlHarga,
                jmlTelur,
                satuan,
                totalHarga
        );
        call.enqueue(new Callback<PendapatanData>() {
            @Override
            public void onResponse(Call<PendapatanData> call, Response<PendapatanData> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(LaporanPendapatanActivity.this, "berhasil ditambahkan", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<PendapatanData> call, Throwable t) {
                Toast.makeText(LaporanPendapatanActivity.this, "Gagal ditambahkan", Toast.LENGTH_SHORT).show();
            }
        });

    }
}