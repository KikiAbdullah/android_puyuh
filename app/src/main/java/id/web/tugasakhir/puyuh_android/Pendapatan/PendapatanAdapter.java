package id.web.tugasakhir.puyuh_android.Pendapatan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import id.web.tugasakhir.puyuh_android.R;

public class PendapatanAdapter extends RecyclerView.Adapter<PendapatanAdapter.PendapatanViewHolder> {
    private List<PendapatanData> dataList;
    private Context context;

    public PendapatanAdapter(List<PendapatanData> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    class PendapatanViewHolder extends RecyclerView.ViewHolder{
        public TextView mTanggalPendapatan, mNamaPendapatan, mHargaPendapatan, mJumlahPendapatan, mTotalPendapatan;

        PendapatanViewHolder(View itemView) {
            super(itemView);
            mTanggalPendapatan = itemView.findViewById(R.id.textTanggalPendapatan);
            mNamaPendapatan = itemView.findViewById(R.id.textNamaPendapatan);
            mHargaPendapatan = itemView.findViewById(R.id.textHargaPendapatan);
            mJumlahPendapatan = itemView.findViewById(R.id.textJumlahPendapatan);
            mTotalPendapatan = itemView.findViewById(R.id.textTotalPendapatan);
        }
    }

    @Override
    public PendapatanViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.pendapatan_row, parent, false);
        return new PendapatanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PendapatanViewHolder holder, int position) {
        holder.mTanggalPendapatan.setText("Tanggal : " + dataList.get(position).getTanggal());
        holder.mNamaPendapatan.setText("Nama : "+dataList.get(position).getNamaPendapatan());
        holder.mHargaPendapatan.setText("Harga : "+dataList.get(position).getHargaPendapatan());
        holder.mJumlahPendapatan.setText("Jumlah : "+dataList.get(position).getJumlahPendapatan() + " " +  dataList.get(position).getSatuanPendapatan());
        holder.mTotalPendapatan.setText("Total : "+dataList.get(position).getTotalPendapatan());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
