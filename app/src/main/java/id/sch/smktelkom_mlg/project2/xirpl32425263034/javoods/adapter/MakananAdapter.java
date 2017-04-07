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
import id.sch.smktelkom_mlg.project2.xirpl32425263034.javoods.model.Makanan;

/**
 * Created by Prasetya on 7/4/2017.
 */

public class MakananAdapter extends RecyclerView.Adapter<MakananAdapter.ViewHolder> {

    ArrayList<Makanan> makanList;
    IMakananAdapter mIMakananAdapter;

    public MakananAdapter(Context context, ArrayList<Makanan> makanList) {
        this.makanList = makanList;
        mIMakananAdapter = (IMakananAdapter) context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_makanan, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Makanan makanan = makanList.get(position);
        holder.tvJudul.setText(makanan.nama);
        holder.ivFoto.setImageURI(Uri.parse(makanan.foto));
    }

    @Override
    public int getItemCount() {
        if (makanList != null)
            return makanList.size();
        return 0;
    }

    public interface IMakananAdapter {
        void doClick(int pos);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivFoto;
        TextView tvJudul;

        public ViewHolder(View itemView) {
            super(itemView);
            ivFoto = (ImageView) itemView.findViewById(R.id.imageViewMakanan);
            tvJudul = (TextView) itemView.findViewById(R.id.textViewJudulMakanan);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mIMakananAdapter.doClick(getAdapterPosition());
                }
            });

        }
    }
}
