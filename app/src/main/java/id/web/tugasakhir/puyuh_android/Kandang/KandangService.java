package id.web.tugasakhir.puyuh_android.Kandang;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface KandangService {
    @GET("kandang")
    Call<List<KandangData>> getAllKandang();

}