package id.sch.smktelkom_mlg.project2.xirpl32425263034.javood_3.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import id.sch.smktelkom_mlg.project2.xirpl32425263034.javood_3.R;

/**
 * Created by Prasetya on 7/4/2017.
 */

public class MinumanAdapter extends RecyclerView.Adapter<MinumanAdapter.ViewHolder> {
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_minuman, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivFoto;
        TextView tvJudul, tvDesk;

        public ViewHolder(View itemView) {
            super(itemView);
            ivFoto = (ImageView) itemView.findViewById(R.id.imageViewMinuman);
            tvJudul = (TextView) itemView.findViewById(R.id.textViewJudulMinuman);
            tvDesk = (TextView) itemView.findViewById(R.id.textViewDeskripsiMinuman);
        }
    }
}
