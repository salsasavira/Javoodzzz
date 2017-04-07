package id.sch.smktelkom_mlg.project2.xirpl32425263034.javoods.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project2.xirpl32425263034.javoods.R;
import id.sch.smktelkom_mlg.project2.xirpl32425263034.javoods.model.Cemilan;

/**
 * Created by Prasetya on 7/4/2017.
 */

public class CemilanAdapter extends RecyclerView.Adapter<CemilanAdapter.ViewHolder> {

    ArrayList<Cemilan> cemilanList;
    ICemilanAdapter mICemilanAdapter;

    public CemilanAdapter(Context context, ArrayList<Cemilan> cemilanList) {
        this.cemilanList = cemilanList;
        mICemilanAdapter = (ICemilanAdapter) context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_cemilan, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Cemilan cemilan = cemilanList.get(position);
        holder.tvJudul.setText(cemilan.nama);
        holder.ivFoto.setImageURI(Uri.parse(cemilan.foto));
    }

    @Override
    public int getItemCount() {
        if (cemilanList != null)
            return cemilanList.size();
        return 0;
    }

    public interface ICemilanAdapter {
        void doClick(int pos);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivFoto;
        TextView tvJudul;

        public ViewHolder(View itemView) {
            super(itemView);
            ivFoto = (ImageView) itemView.findViewById(R.id.imageViewCemilan);
            tvJudul = (TextView) itemView.findViewById(R.id.textViewJudulCemilan);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mICemilanAdapter.doClick(getAdapterPosition());
                }
            });
        }
    }
}
