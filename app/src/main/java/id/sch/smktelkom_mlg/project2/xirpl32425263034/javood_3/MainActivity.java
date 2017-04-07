package id.sch.smktelkom_mlg.project2.xirpl32425263034.javood_3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView ivMakan, ivMinum, ivCemilan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ivMakan = (ImageView) findViewById(R.id.imageView);
        ivMinum = (ImageView) findViewById(R.id.imageView2);
        ivCemilan = (ImageView) findViewById(R.id.imageView3);

        ivMakan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Makanan_Activity.class);
                startActivity(intent);
            }
        });

        ivMinum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Minuman_Activity.class);
                startActivity(intent);
            }
        });

        ivCemilan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Cemilan_Activity.class);
                startActivity(intent);
            }
        });

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                SharedPreferences getProfs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                boolean isFirstStart = getProfs.getBoolean("firstStart", true);
                if (isFirstStart) {
                    startActivity(new Intent(MainActivity.this, MyIntro.class));
                    SharedPreferences.Editor e = getProfs.edit();
                    e.putBoolean("firstStart", false);
                    e.apply();
                }
            }
        });

        thread.start();
    }
}
