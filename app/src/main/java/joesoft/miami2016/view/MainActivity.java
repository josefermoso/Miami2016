package joesoft.miami2016.view;

import android.app.ActionBar;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import joesoft.miami2016.DAO.FraceDAO;
import joesoft.miami2016.R;
import joesoft.miami2016.adapter.PictureAdapter;
import joesoft.miami2016.controller.FraceController;
import joesoft.miami2016.controller.ImageController;
import joesoft.miami2016.controller.PictureController;
import joesoft.miami2016.model.Frace;
import joesoft.miami2016.model.ImageToShow;
import joesoft.miami2016.model.Picture;
import joesoft.miami2016.util.ResultListener;

public class MainActivity extends AppCompatActivity {

    PictureAdapter pictureAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager) findViewById(R.id.mainActivityPictureviewPager);

        List<Picture> pictureList = new ArrayList<>();

        pictureAdapter = new PictureAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pictureAdapter);

        viewPager.setPageTransformer(false, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(View page, float position) {
                int pageWidth = page.getWidth();

                if (position < -1) { // [-Infinity,-1)
                    // This page is way off-screen to the left.
                    page.setAlpha(1);

                } else if (position <= 1) { // [-1,1]
                    ImageView imageView = (ImageView) page.findViewById(R.id.fragmentPictureImage);
                    imageView.setTranslationX(-position * (pageWidth / 2)); //Half the normal speed

                } else { // (1,+Infinity]
                    // This page is way off-screen to the right.
                    page.setAlpha(1);
                }
            }
        });

        final PictureController pictureController = PictureController.getInstante();
        pictureController.getPictures(new ResultListener<List<Picture>>() {
            @Override
            public void finish(List<Picture> resultado) {
                pictureAdapter.setPictureList(resultado);
                pictureAdapter.notifyDataSetChanged();
            }
        });
    }

}

