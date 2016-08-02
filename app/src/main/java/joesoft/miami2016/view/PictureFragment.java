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


import com.flaviofaria.kenburnsview.KenBurnsView;

import joesoft.miami2016.R;
import joesoft.miami2016.model.Picture;

/**
 * A simple {@link Fragment} subclass.
 */
public class PictureFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View pictureView = inflater.inflate(R.layout.fragment_picture, container, false);
        ImageView imageView = (ImageView) pictureView.findViewById(R.id.fragmentPictureImage);

        TextView textView = (TextView) pictureView.findViewById(R.id.fragmentPictureText);

        Bundle unBundle = getArguments();
        textView.setText(unBundle.getString("text"));
        imageView.setImageResource(unBundle.getInt("image"));

        return pictureView;
    }

    public static PictureFragment getNewPicture(Picture picture){
        PictureFragment pictureFragment = new PictureFragment();
        Bundle bundle = new Bundle();
        bundle.putString("text",picture.getTextPicture());
        bundle.putInt("image",picture.getIdImage());
        pictureFragment.setArguments(bundle);
        return pictureFragment;
    }
}
