package id.sch.smktelkom_mlg.project2.xirpl32425263034.javoods;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project2.xirpl32425263034.javoods.Detail.Detail_Makanan;
import id.sch.smktelkom_mlg.project2.xirpl32425263034.javoods.adapter.MakananAdapter;
import id.sch.smktelkom_mlg.project2.xirpl32425263034.javoods.model.Makanan;

public class Makanan_Activity extends AppCompatActivity implements MakananAdapter.IMakananAdapter {

    public static final String MAKANAN = "makanan";
    ArrayList<Makanan> mList = new ArrayList<>();
    MakananAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makanan_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerViewMakanan);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new MakananAdapter(this, mList);
        recyclerView.setAdapter(mAdapter);

        filldata();

    }

    private void filldata() {
        Resources resources = getResources();
        String[] arJudul = resources.getStringArray(R.array.judulmakanan);
        String[] arAlat = resources.getStringArray(R.array.bahanmakanan);
        String[] arStep = resources.getStringArray(R.array.stepmakanan);
        TypedArray a = resources.obtainTypedArray(R.array.makanan_picture);
        String[] arFoto = new String[a.length()];
        for (int i = 0; i < arFoto.length; i++) {
            int id = a.getResourceId(i, 0);
            arFoto[i] = ContentResolver.SCHEME_ANDROID_RESOURCE + "://"
                    + resources.getResourcePackageName(id) + '/'
                    + resources.getResourceTypeName(id) + '/'
                    + resources.getResourceEntryName(id);
        }
        a.recycle();
        for (int i = 0; i < arJudul.length; i++) {
            mList.add(new Makanan(arJudul[i], arAlat[i], arStep[i], arFoto[i]));
        }
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void doClick(int pos) {
        Intent intent = new Intent(this, Detail_Makanan.class);
        intent.putExtra(MAKANAN, mList.get(pos));
        startActivity(intent);
    }
}
