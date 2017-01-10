package com.example.administrator.bottomenavigationbarapp.fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.bottomenavigationbarapp.R;
import com.example.administrator.bottomenavigationbarapp.adapter.MyPageAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/10.
 */

public class ProjectFragment extends Fragment {
    private static ProjectFragment fragment;

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TabLayout.Tab projectTab, newsTab, discoveryTab, userCenterTab;
    private List<String> titleLsit = new ArrayList<>();
    private List<View> viewList = new ArrayList<>();


    public static ProjectFragment newInstance() {
        if (fragment == null) {
            Bundle args = new Bundle();
            fragment = new ProjectFragment();
            fragment.setArguments(args);
        }
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.layout_project_fragment, container, false);
        initViews(view);
        initData();
        initListeners();
        Log.e("onCreateView","onCreateView");
        return view;
    }


    private void initViews(View view) {
        tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
    }

    private void initData() {
        initTitleData();
        initViewData();
        tabLayout.addTab(tabLayout.newTab().setText(titleLsit.get(0)));
        tabLayout.addTab(tabLayout.newTab().setText(titleLsit.get(1)));
        tabLayout.addTab(tabLayout.newTab().setText(titleLsit.get(2)));
        tabLayout.addTab(tabLayout.newTab().setText(titleLsit.get(3)));

        MyPageAdapter myPageAdapter = new MyPageAdapter(viewList, titleLsit);
        viewPager.setAdapter(myPageAdapter);
        tabLayout.setupWithViewPager(viewPager);//与viewPager使用同一个适配器，那么适配器数据变化时，tabLayout的数据也会跟着变化（如果注销掉，那么页面滑动时tabLayout的标题不会变），
        // 同样点击了tabLayout页会变动pagerAdapter的数据，那么ViewPager也会跟着变动；
        projectTab = tabLayout.getTabAt(0);
        newsTab = tabLayout.getTabAt(1);
        discoveryTab = tabLayout.getTabAt(2);
        userCenterTab = tabLayout.getTabAt(3);

    }

    private void initListeners() {
        viewPager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Log.e("ViewPager", "点击了");
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                Log.e("onPageScrolled", position + "滑动了");
            }

            @Override
            public void onPageSelected(int position) {
//                Log.e("onPageSelected", position + "选定了");
//                tabLayout.getTabAt(position).setText(Html.fromHtml("<font size=\"32px\">"+tabLayout.getTabAt(position).getText().toString()+"</font>"));
            }

            @Override
            public void onPageScrollStateChanged(int state) {
//                Log.e("ScrollStateChanged", "改变了");
            }
        });

        tabLayout.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
//                Log.e("onFocusChange", "焦点改变了");
            }
        });

    }

    ///////////////////////////////////////////
    private void initTitleData() {
        titleLsit.add("项目");
        titleLsit.add("资讯");
        titleLsit.add("发现");
        titleLsit.add("个人中心");
    }

    private void initViewData() {
        LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
        viewList.add(layoutInflater.inflate(R.layout.pager_item_layout, null));
        viewList.add(layoutInflater.inflate(R.layout.pager_item_layout2, null));
        viewList.add(layoutInflater.inflate(R.layout.pager_item_layout3, null));
        viewList.add(layoutInflater.inflate(R.layout.pager_item_layout4, null));
    }

    @Override
    public void onAttach(Context context) {
        Log.e("onAttach","onAttach");
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.e("onCreate","onCreate");
        super.onCreate(savedInstanceState);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Log.e("onActivityCreated","onActivityCreated");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.e("onStart","onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.e("onResume","onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.e("onPause","onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.e("onStop","onStop");
        super.onStop();
    }

    @Override
    public void onDestroy() {
        Log.e("onDestroy","onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        Log.e("onDestroyView","onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDetach() {
        Log.e("onDetach","onDetach");
        super.onDetach();
    }
}
