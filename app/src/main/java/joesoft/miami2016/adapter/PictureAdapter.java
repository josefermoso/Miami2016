package joesoft.miami2016.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import joesoft.miami2016.model.Picture;
import joesoft.miami2016.view.PictureFragment;

/**
 * Created by joe on 7/30/16.
 */
public class PictureAdapter extends FragmentStatePagerAdapter {



    private List<PictureFragment> pictureList;

    public PictureAdapter(FragmentManager fm, List<Picture> pictures ) {
        super(fm);

        pictureList = new ArrayList<>();

        for (Picture picture : pictures){
               pictureList.add(PictureFragment.getNewPicture(picture));
        }
    }

    @Override
    public Fragment getItem(int position) {
        return pictureList.get(position);
    }

    @Override
    public int getCount() {
        return pictureList.size();
    }
}
