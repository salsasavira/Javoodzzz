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

import id.sch.smktelkom_mlg.project2.xirpl32425263034.javoods.Makanan_Activity;
import id.sch.smktelkom_mlg.project2.xirpl32425263034.javoods.R;
import id.sch.smktelkom_mlg.project2.xirpl32425263034.javoods.model.Makanan;

public class Detail_Makanan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail__makanan);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });



        Makanan makanan = (Makanan) getIntent().getSerializableExtra(Makanan_Activity.MAKANAN);
        setTitle(makanan.nama);
        ImageView ivFoto = (ImageView) findViewById(R.id.imageFotoMakanan);
        ivFoto.setImageURI(Uri.parse(makanan.foto));
        TextView tvAlat = (TextView) findViewById(R.id.alat);
        tvAlat.setText(makanan.alat);
        TextView tvStep = (TextView) findViewById(R.id.step);
        tvStep.setText(makanan.step);

    }
}
