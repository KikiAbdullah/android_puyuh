package id.web.tugasakhir.puyuh_android.Gaji;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GajiService {
    @GET("gaji")
    Call<List<GajiData>> getAllGaji();
}