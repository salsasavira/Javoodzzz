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

import id.sch.smktelkom_mlg.project2.xirpl32425263034.javoods.Cemilan_Activity;
import id.sch.smktelkom_mlg.project2.xirpl32425263034.javoods.R;
import id.sch.smktelkom_mlg.project2.xirpl32425263034.javoods.model.Cemilan;

public class Detail_Cemilan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail__cemilan);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        Cemilan cemilan = (Cemilan) getIntent().getSerializableExtra(Cemilan_Activity.CEMILAN);
        setTitle(cemilan.nama);
        ImageView ivFoto = (ImageView) findViewById(R.id.imageFotoCemilan);
        ivFoto.setImageURI(Uri.parse(cemilan.foto));
        TextView tvAlat = (TextView) findViewById(R.id.alat);
        tvAlat.setText(cemilan.alat);
        TextView tvStep = (TextView) findViewById(R.id.step);
        tvStep.setText(cemilan.step);
    }
}
