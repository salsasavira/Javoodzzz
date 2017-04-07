package id.sch.smktelkom_mlg.project2.xirpl32425263034.javoods.Detail;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import id.sch.smktelkom_mlg.project2.xirpl32425263034.javoods.Minuman_Activity;
import id.sch.smktelkom_mlg.project2.xirpl32425263034.javoods.R;
import id.sch.smktelkom_mlg.project2.xirpl32425263034.javoods.model.Minuman;

public class Detail_Minuman extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail__minuman);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Minuman minuman = (Minuman) getIntent().getSerializableExtra(Minuman_Activity.MINUMAN);
        setTitle(minuman.nama);
        ImageView ivFoto = (ImageView) findViewById(R.id.imageFotoMinuman);
        ivFoto.setImageURI(Uri.parse(minuman.foto));
        TextView tvAlat = (TextView) findViewById(R.id.alat);
        tvAlat.setText(minuman.alat);
        TextView tvStep = (TextView) findViewById(R.id.step);
        tvStep.setText(minuman.step);

    }
}
