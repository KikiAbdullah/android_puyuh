package id.web.tugasakhir.puyuh_android.Gaji;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class GajiData {
    @SerializedName("id")
    @Expose
    private Integer idGaji;

    @SerializedName("jumlah_gaji")
    @Expose
    private Integer jumlahGaji;

    @SerializedName("tanggal")
    @Expose
    private Integer tanggalGaji;

    public GajiData(Integer idGaji, Integer jumlahGaji, Integer tanggalGaji) {
        this.idGaji = idGaji;
        this.jumlahGaji = jumlahGaji;
        this.tanggalGaji = tanggalGaji;
    }

    public Integer getIdGaji() {
        return idGaji;
    }

    public void setIdGaji(Integer idGaji) {
        this.idGaji = idGaji;
    }

    public Integer getJumlahGaji() {
        return jumlahGaji;
    }

    public void setJumlahGaji(Integer jumlahGaji) {
        this.jumlahGaji = jumlahGaji;
    }

    public Integer getTanggalGaji() {
        return tanggalGaji;
    }

    public void setTanggalGaji(Integer tanggalGaji) {
        this.tanggalGaji = tanggalGaji;
    }
}
