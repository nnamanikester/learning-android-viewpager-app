package org.x3codes.viewpagerapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ViewPager2 viewPager;
    TabLayout tabLayout;

    ViewPagerAdapter adapter;

    ArrayList<ViewPagerFragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        viewPager = findViewById(R.id.viewPager2);
        tabLayout = findViewById(R.id.tabLayout);

        fragments = new ArrayList<>();
        fragments.add(new FragmentOne("Home"));
        fragments.add(new FragmentTwo("About"));
        fragments.add(new FragmentThree("Settings"));


        adapter = new ViewPagerAdapter(getSupportFragmentManager(), getLifecycle(), fragments);

        viewPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);

        viewPager.setAdapter(adapter);

        new TabLayoutMediator(
                tabLayout,
                viewPager,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        ViewPagerFragment fragment = fragments.get(position);
                        String title = fragment.getTitle();
                        tab.setText(title);
                    }
                }
        ).attach();
    }
}