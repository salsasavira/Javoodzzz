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
import android.widget.Button;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project2.xirpl32425263034.javoods.Detail.Detail_Cemilan;
import id.sch.smktelkom_mlg.project2.xirpl32425263034.javoods.adapter.CemilanAdapter;
import id.sch.smktelkom_mlg.project2.xirpl32425263034.javoods.model.Cemilan;

public class Cemilan_Activity extends AppCompatActivity implements CemilanAdapter.ICemilanAdapter {
    public static final String CEMILAN = "cemilan";
    ArrayList<Cemilan> mList = new ArrayList<>();
    CemilanAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cemilan_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerViewCemilan);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new CemilanAdapter(this, mList);
        recyclerView.setAdapter(mAdapter);

        filldata();
    }

    private void filldata() {
        Resources resources = getResources();
        String[] arJudul = resources.getStringArray(R.array.judulcemilan);
        String[] arStep = resources.getStringArray(R.array.stepcemilan);
        String[] arAlat = resources.getStringArray(R.array.bahanCemilan);
        TypedArray a = resources.obtainTypedArray(R.array.cemilan_picture);
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
            mList.add(new Cemilan(arJudul[i], arStep[i], arAlat[i], arFoto[i]));
        }
        mAdapter.notifyDataSetChanged();

    }

    @Override
    public void doClick(int pos) {
        Intent intent = new Intent(this, Detail_Cemilan.class);
        intent.putExtra(CEMILAN, mList.get(pos));
        startActivity(intent);
    }
}
