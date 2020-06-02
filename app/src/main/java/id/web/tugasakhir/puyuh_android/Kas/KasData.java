package id.web.tugasakhir.puyuh_android.Kas;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class KasData {
    @SerializedName("id")
    @Expose
    private Integer idKas;

    @SerializedName("kas_perbulan")
    @Expose
    private Integer kasPerbulan;

    @SerializedName("total_periode")
    @Expose
    private Integer totalPeriode;

    @SerializedName("total_kas")
    @Expose
    private Integer totalKas;

    @SerializedName("tanggal")
    @Expose
    private Date tanggalKas;

    public KasData(Integer idKas, Integer kasPerbulan, Integer totalPeriode, Integer totalKas, Date tanggalKas) {
        this.idKas = idKas;
        this.kasPerbulan = kasPerbulan;
        this.totalPeriode = totalPeriode;
        this.totalKas = totalKas;
        this.tanggalKas = tanggalKas;
    }

    public Integer getIdKas() {
        return idKas;
    }

    public void setIdKas(Integer idKas) {
        this.idKas = idKas;
    }

    public Integer getKasPerbulan() {
        return kasPerbulan;
    }

    public void setKasPerbulan(Integer kasPerbulan) {
        this.kasPerbulan = kasPerbulan;
    }

    public Integer getTotalPeriode() {
        return totalPeriode;
    }

    public void setTotalPeriode(Integer totalPeriode) {
        this.totalPeriode = totalPeriode;
    }

    public Integer getTotalKas() {
        return totalKas;
    }

    public void setTotalKas(Integer totalKas) {
        this.totalKas = totalKas;
    }

    public Date getTanggalKas() {
        return tanggalKas;
    }

    public void setTanggalKas(Date tanggalKas) {
        this.tanggalKas = tanggalKas;
    }
}
