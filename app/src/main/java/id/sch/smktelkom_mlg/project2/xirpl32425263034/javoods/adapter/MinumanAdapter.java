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
import id.sch.smktelkom_mlg.project2.xirpl32425263034.javoods.model.Minuman;

/**
 * Created by Prasetya on 7/4/2017.
 */

public class MinumanAdapter extends RecyclerView.Adapter<MinumanAdapter.ViewHolder> {

    ArrayList<Minuman> minumanList;
    IMinumanAdapter mIMinumanAdapter;

    public MinumanAdapter(Context context, ArrayList<Minuman> minumanList) {
        this.minumanList = minumanList;
        mIMinumanAdapter = (IMinumanAdapter) context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_minuman, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Minuman minuman = minumanList.get(position);
        holder.tvJudul.setText(minuman.nama);
        holder.ivFoto.setImageURI(Uri.parse(minuman.foto));
    }

    @Override
    public int getItemCount() {
        if (minumanList != null)
            return minumanList.size();
        return 0;
    }

    public interface IMinumanAdapter {
        void doClick(int pos);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivFoto;
        TextView tvJudul;

        public ViewHolder(View itemView) {
            super(itemView);
            ivFoto = (ImageView) itemView.findViewById(R.id.imageViewMinuman);
            tvJudul = (TextView) itemView.findViewById(R.id.textViewJudulMinuman);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mIMinumanAdapter.doClick(getAdapterPosition());
                }
            });
        }
    }
}
