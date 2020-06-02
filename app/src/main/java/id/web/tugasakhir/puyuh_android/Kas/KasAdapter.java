package id.web.tugasakhir.puyuh_android.Kas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import id.web.tugasakhir.puyuh_android.R;

public class KasAdapter extends RecyclerView.Adapter<KasAdapter.KasViewHolder> {
    private List<KasData> dataList;
    private Context context;

    public KasAdapter(List<KasData> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    class KasViewHolder extends RecyclerView.ViewHolder{
        public TextView mTextBulanKas, mTextTotalKas;

        KasViewHolder(View itemView) {
            super(itemView);
            mTextBulanKas = itemView.findViewById(R.id.textTanggalKas);
            mTextTotalKas = itemView.findViewById(R.id.textTotalKas);

        }
    }

    @Override
    public KasViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.kas_row, parent, false);
        return new KasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(KasViewHolder holder, int position) {
        holder.mTextBulanKas.setText("Bulan ="+ dataList.get(position).getTanggalKas() );
        holder.mTextTotalKas.setText("Total Kas ="+ dataList.get(position).getTotalKas());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}

