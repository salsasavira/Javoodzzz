package id.sch.smktelkom_mlg.project2.xirpl32425263034.javood_3;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;

public class MyIntro extends AppIntro {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addSlide(AppIntroFragment.newInstance("1",
                "Siapapun bisa memasak seperti koki!",
                R.drawable.chef,
                Color.parseColor("#ffbf00")));

        addSlide(AppIntroFragment.newInstance("2",
                "Berisi berbagai resep Masakan Jawa terpopuler",
                R.drawable.rice,
                Color.parseColor("#e6ac00")));

        addSlide(AppIntroFragment.newInstance("3",
                "Berisi berbagai resep Minuman Jawa terpopuler",
                R.drawable.icecream,
                Color.parseColor("#cc9900")));

        addSlide(AppIntroFragment.newInstance("4",
                "Mudah dan fleksibel, dapat dilihat di HP dan bisa dibawa kemana saja",
                R.drawable.app,
                Color.parseColor("#997300")));

        showStatusBar(false);
        setBarColor(Color.parseColor("#00ffffff"));
        setSeparatorColor(Color.parseColor("#00ffffff"));
    }

    @Override
    public void onDonePressed() {
        startActivity(new Intent(MyIntro.this, MainActivity.class));
        finish();
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        startActivity(new Intent(MyIntro.this, MainActivity.class));
        Toast.makeText(MyIntro.this, "On Skip Clicked", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void onSlideChanged() {
        Toast.makeText(MyIntro.this, "On Slide Clicked", Toast.LENGTH_SHORT).show();

    }
}
