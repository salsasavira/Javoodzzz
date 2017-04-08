package id.sch.smktelkom_mlg.project2.xirpl32425263034.javoods;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView ivMakan, ivMinum, ivCemilan, ivAboutUs;

    public static int calculateInSampleSize(BitmapFactory.Options options,
                                            int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;
        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and
            // keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }
        return inSampleSize;
    }

    public static Bitmap decodeSampledBitmapFromResource(String strPath, int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(strPath, options);
        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth,
                reqHeight);
        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(strPath, options);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ivMakan = (ImageView) findViewById(R.id.ivMakanan);
        ivMinum = (ImageView) findViewById(R.id.ivMinuman);
        ivCemilan = (ImageView) findViewById(R.id.ivCemilan);
        ivAboutUs = (ImageView) findViewById(R.id.ivAboutUs);

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

        ivAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
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
