package id.web.tugasakhir.puyuh_android.Kas;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface KasService {
    @GET("kas")
    Call<List<KasData>> getAllKas();
}