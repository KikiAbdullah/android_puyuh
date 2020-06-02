package id.web.tugasakhir.puyuh_android.Gaji;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import id.web.tugasakhir.puyuh_android.R;

public class GajiAdapter extends RecyclerView.Adapter<GajiAdapter.GajiViewHolder> {
    private List<GajiData> dataList;
    private Context context;

    public GajiAdapter(List<GajiData> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    class GajiViewHolder extends RecyclerView.ViewHolder{
        public TextView mTextTanggalGaji, mTextJumlahGaji;

        GajiViewHolder(View itemView) {
            super(itemView);
            mTextTanggalGaji = itemView.findViewById(R.id.textTanggalGaji);
            mTextJumlahGaji = itemView.findViewById(R.id.textJumlahGaji);

        }
    }

    @Override
    public GajiViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.gaji_row, parent, false);
        return new GajiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GajiViewHolder holder, int position) {
        holder.mTextTanggalGaji.setText("Bulan ="+ dataList.get(position).getTanggalGaji() );
        holder.mTextJumlahGaji.setText("Total Gaji ="+ dataList.get(position).getJumlahGaji());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}

