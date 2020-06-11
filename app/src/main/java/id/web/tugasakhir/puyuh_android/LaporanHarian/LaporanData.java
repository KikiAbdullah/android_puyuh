package id.web.tugasakhir.puyuh_android.LaporanHarian;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LaporanData {
    @SerializedName("id")
    @Expose
    private Integer idLaporan;

    @SerializedName("id_user")
    @Expose
    private Integer idUserLaporan;

    @SerializedName("id_kandang")
    @Expose
    private Integer idKandangLaporan;

    @SerializedName("tanggal")
    @Expose
    private String tanggalLaporan;

    @SerializedName("jumlah_telur")
    @Expose
    private Integer jumlahTelur;

    @SerializedName("jumlah_kematian")
    @Expose
    private Integer jumlahKematian;

    public LaporanData(Integer idLaporan, Integer idUserLaporan, Integer idKandangLaporan, String tanggalLaporan, Integer jumlahTelur, Integer jumlahKematian) {
        this.idLaporan = idLaporan;
        this.idUserLaporan = idUserLaporan;
        this.idKandangLaporan = idKandangLaporan;
        this.tanggalLaporan = tanggalLaporan;
        this.jumlahTelur = jumlahTelur;
        this.jumlahKematian = jumlahKematian;
    }

    public Integer getIdLaporan() {
        return idLaporan;
    }

    public void setIdLaporan(Integer idLaporan) {
        this.idLaporan = idLaporan;
    }

    public Integer getIdUserLaporan() {
        return idUserLaporan;
    }

    public void setIdUserLaporan(Integer idUserLaporan) {
        this.idUserLaporan = idUserLaporan;
    }

    public Integer getIdKandangLaporan() {
        return idKandangLaporan;
    }

    public void setIdKandangLaporan(Integer idKandangLaporan) {
        this.idKandangLaporan = idKandangLaporan;
    }

    public String getTanggalLaporan() {
        return tanggalLaporan;
    }

    public void setTanggalLaporan(String tanggalLaporan) {
        this.tanggalLaporan = tanggalLaporan;
    }

    public Integer getJumlahTelur() {
        return jumlahTelur;
    }

    public void setJumlahTelur(Integer jumlahTelur) {
        this.jumlahTelur = jumlahTelur;
    }

    public Integer getJumlahKematian() {
        return jumlahKematian;
    }

    public void setJumlahKematian(Integer jumlahKematian) {
        this.jumlahKematian = jumlahKematian;
    }
}
