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

import id.sch.smktelkom_mlg.project2.xirpl32425263034.javoods.Detail.Detail_Minuman;
import id.sch.smktelkom_mlg.project2.xirpl32425263034.javoods.adapter.MinumanAdapter;
import id.sch.smktelkom_mlg.project2.xirpl32425263034.javoods.model.Minuman;

public class Minuman_Activity extends AppCompatActivity implements MinumanAdapter.IMinumanAdapter {

    public static final String MINUMAN = "minuman";
    ArrayList<Minuman> mList = new ArrayList<>();
    MinumanAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minuman_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerViewMinuman);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new MinumanAdapter(this, mList);
        recyclerView.setAdapter(mAdapter);

        filldata();

    }

    private void filldata() {
        Resources resources = getResources();
        String[] arJudul = resources.getStringArray(R.array.judulminuman);
        String[] arAlat = resources.getStringArray(R.array.bahanminuman);
        String[] arStep = resources.getStringArray(R.array.stepminuman);
        TypedArray a = resources.obtainTypedArray(R.array.minuman_picture);
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
            mList.add(new Minuman(arJudul[i], arAlat[i], arStep[i], arFoto[i]));
        }
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void doClick(int pos) {
        Intent intent = new Intent(this, Detail_Minuman.class);
        intent.putExtra(MINUMAN, mList.get(pos));
        startActivity(intent);
    }
}
