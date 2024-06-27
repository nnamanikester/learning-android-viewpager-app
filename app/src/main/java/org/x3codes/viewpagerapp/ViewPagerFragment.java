package org.x3codes.viewpagerapp;

import androidx.fragment.app.Fragment;

public class ViewPagerFragment extends Fragment {
    String title = "";

    public ViewPagerFragment(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    };
}
