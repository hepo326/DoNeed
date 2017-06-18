package com.doneed.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.doneed.MapsFragment;
import com.doneed.R;
import com.doneed.adapter.MyPagerAdapter;

public class MapTabs extends Fragment {

    private TabLayout tabs;
    private ViewPager viewPager;
    private MyPagerAdapter pagerAdapter;


    @Override
    public void onStart() {
        super.onStart();



    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return(inflater.inflate(R.layout.home_fragment, container, false));
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager = (ViewPager) view.findViewById(R.id.pager);
        pagerAdapter = new MyPagerAdapter(getActivity().getSupportFragmentManager());
        pagerAdapter.addFrag(new MapsFragment(), getString(R.string.first_tab_title));
        pagerAdapter.addFrag(new MapsFragment(), getString(R.string.second_tab_title));
        pagerAdapter.addFrag(new MapsFragment(), getString(R.string.third_tab_title));
        pagerAdapter.addFrag(new MapsFragment(), getString(R.string.fourth_tab_title));

        viewPager.setAdapter(pagerAdapter);


        tabs = (TabLayout) view.findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        setupTabIcons();
    }
    private void setupTabIcons() {
        TextView tabOne = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.custom_tab, null);
        tabOne.setText(getString(R.string.first_tab_title));
        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_food_24dp, 0, 0);
        tabs.getTabAt(0).setCustomView(tabOne);

        TextView tabTwo = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.custom_tab, null);
        tabTwo.setText(getString(R.string.second_tab_title));
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_shirt_24dp, 0, 0);
        tabs.getTabAt(1).setCustomView(tabTwo);

        TextView tabThree = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.custom_tab, null);
        tabThree.setText(getString(R.string.third_tab_title));
        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_dollar_24dp, 0, 0);
        tabs.getTabAt(2).setCustomView(tabThree);

        TextView tabFour = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.custom_tab, null);
        tabFour.setText(getString(R.string.fourth_tab_title));
        tabFour.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_others_24dp, 0, 0);
        tabs.getTabAt(3).setCustomView(tabFour);


    }

}
