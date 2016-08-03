package joesoft.miami2016.view;


import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.flaviofaria.kenburnsview.KenBurnsView;

import java.util.List;

import joesoft.miami2016.R;
import joesoft.miami2016.controller.ImageController;
import joesoft.miami2016.controller.PictureController;
import joesoft.miami2016.model.Frace;
import joesoft.miami2016.model.ImageToShow;
import joesoft.miami2016.model.Picture;
import joesoft.miami2016.util.ResultListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class PictureFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View pictureView = inflater.inflate(R.layout.fragment_picture, container, false);
        final ImageView imageView = (ImageView) pictureView.findViewById(R.id.fragmentPictureImage);

        final TextView textView = (TextView) pictureView.findViewById(R.id.fragmentPictureText);

        Bundle unBundle = getArguments();
        final Integer positionPicture = unBundle.getInt("position");
        final PictureController pictureController = PictureController.getInstante();
        pictureController.getPictures(new ResultListener<List<Picture>>() {
            @Override
            public void finish(List<Picture> resultado) {
                Picture picture = resultado.get(positionPicture);
                textView.setText(picture.getTextPicture().getFrase());
                pictureController.getPictureURI(picture, new ResultListener<String>() {
                    @Override
                    public void finish(String resultado) {
                        Glide.with(PictureFragment.this).load(resultado).into(imageView);
                    }
                });
            }
        });
        return pictureView;
    }

    public static PictureFragment getNewPictureFragment(Integer picturePostion){
        PictureFragment pictureFragment = new PictureFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("position",picturePostion);
        pictureFragment.setArguments(bundle);
        return pictureFragment;
    }
}
