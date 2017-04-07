package id.sch.smktelkom_mlg.project2.xirpl32425263034.javoods;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project2.xirpl32425263034.javoods.adapter.MakananAdapter;
import id.sch.smktelkom_mlg.project2.xirpl32425263034.javoods.model.Makanan;

public class Makanan_Activity extends AppCompatActivity {

    ArrayList<Makanan> mList = new ArrayList<>();
    MakananAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makanan_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerViewMakanan);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new MakananAdapter(mList);
        recyclerView.setAdapter(mAdapter);

        filldata();

    }

    private void filldata() {
        Resources resources = getResources();
        String[] arJudul = resources.getStringArray(R.array.judulmakanan);
        TypedArray a = resources.obtainTypedArray(R.array.makanan_picture);
        Drawable[] arFoto = new Drawable[a.length()];
        for (int i = 0; i < arFoto.length; i++) {
            arFoto[i] = a.getDrawable(i);
        }
        a.recycle();
        for (int i = 0; i < arJudul.length; i++) {
            mList.add(new Makanan(arJudul[i], arFoto[i]));
        }
        mAdapter.notifyDataSetChanged();
    }

}
