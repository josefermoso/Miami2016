package joesoft.miami2016.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import joesoft.miami2016.controller.PictureController;
import joesoft.miami2016.model.Frace;
import joesoft.miami2016.model.ImageToShow;
import joesoft.miami2016.model.Picture;
import joesoft.miami2016.view.PictureFragment;

/**
 * Created by joe on 7/30/16.
 */
public class PictureAdapter extends FragmentStatePagerAdapter {



    private List<Picture> pictureList;
    private List<PictureFragment>pictureFragments;

    public PictureAdapter(FragmentManager fm) {
        super(fm);

        pictureList = new ArrayList<>();
        pictureFragments = new ArrayList<>();
    }

    @Override
    public Fragment getItem(int position) {
        return  pictureFragments.get(position);
    }

    @Override
    public int getCount() {
        return pictureFragments.size();
    }

    public List<Picture> getPictureList() {
        return pictureList;
    }

    public void setPictureList(List<Picture> pictureList) {
        this.pictureList = pictureList;

        for (int i = 0; i<pictureList.size();i++){
            pictureFragments.add(PictureFragment.getNewPictureFragment(i));
        }
    }
}
