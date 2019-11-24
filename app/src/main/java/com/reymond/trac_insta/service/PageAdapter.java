package com.reymond.trac_insta.service;

/**
 * Created by welcome on 9/19/2019.
 */

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PageAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PageAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                FirstSerFragment tab1 = new FirstSerFragment();
                return tab1;
            case 1:
                SecondSerFragment tab2 = new SecondSerFragment();
                return tab2;
            case 2:
                ThirdSerFragment tab3 = new ThirdSerFragment();
                return tab3;
            default:
                return null;
        }
    }


    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
