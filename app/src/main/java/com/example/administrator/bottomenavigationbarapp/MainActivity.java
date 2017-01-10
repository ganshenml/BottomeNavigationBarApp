package com.example.administrator.bottomenavigationbarapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.administrator.bottomenavigationbarapp.fragments.ProjectFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {
    private BottomNavigationBar bottomTab;
    private ProjectFragment projectFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomTab = (BottomNavigationBar) findViewById(R.id.bottomTab);
        bottomTab.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE);
        bottomTab.setActiveColor(R.color.green)
                .setInActiveColor("#FFFFFF")
                .setBarBackgroundColor("#ECECEC");
        bottomTab.addItem(new BottomNavigationItem(R.drawable.home, "Home"))
                .addItem(new BottomNavigationItem(R.drawable.books, "Books"))
                .addItem(new BottomNavigationItem(R.drawable.music, "Music"))
                .addItem(new BottomNavigationItem(R.drawable.movie, "Movies & TV"))
                .addItem(new BottomNavigationItem(R.drawable.games, "Games"))
                .initialise();
        setDefaultFragment();
    }

    /**
     * 设置默认的
     */
    private void setDefaultFragment() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        projectFragment = ProjectFragment.newInstance();
        transaction.replace(R.id.backFl, projectFragment);
        transaction.commit();
    }

    @Override
    public void onTabSelected(int position) {

    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
