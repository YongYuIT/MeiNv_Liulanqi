package com.example.meinv_liulanqi;

import com.example.meinv_liulanqi.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;

public class ViewPagerActivity extends FragmentActivity
// 由于FragmentPagerAdapter只在android.support.v4中定义
// 而android.support.v4.app.FragmentActivity的实例化需要传入android.support.v4.app.FragmentManager，
// 这个特殊的FragmentManager只能通过FragmentActivity的getSupportFragmentManager方法得到，
// 所以ViewPagerActivity必须继承android.support.v4.app.FragmentActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        MeiNvFragment_V4.img_ids = new int[] { R.drawable.linzhiling,
                R.drawable.liuyan, R.drawable.yangmi };

        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        // 为ViewPager添加FragmentPagerAdapter
        myFragmentPagerAdapter adapter = new myFragmentPagerAdapter(
                getSupportFragmentManager());
        pager.setAdapter(adapter);
        // 为ViewPager添加事件监听器
        mySimpleOnPageChangeListener listener = new mySimpleOnPageChangeListener(
                pager);
        pager.setOnPageChangeListener(listener);

    }

    // 扩展得到自己的FragmentPagerAdapter
    class myFragmentPagerAdapter extends FragmentPagerAdapter
    {

        public myFragmentPagerAdapter(FragmentManager fm)
        {
            super(fm);
            // TODO Auto-generated constructor stub
        }

        // 获取指定位置的Fragment
        @Override
        public Fragment getItem(int arg0)
        {
            Fragment f = new MeiNvFragment_V4();
            Bundle b = new Bundle();
            b.putInt(MeiNvFragment.Fragment_Key, arg0);
            f.setArguments(b);
            return f;
        }

        // 指出该Adapter包含Fragment的数目
        @Override
        public int getCount()
        {
            // TODO Auto-generated method stub
            return MeiNvFragment_V4.img_ids.length;
        }

        @Override
        public CharSequence getPageTitle(int position)
        {
            return "第" + (position + 1) + "个美女";
        }
    }

    // 扩展得到自己的SimpleOnPageChangeListener
    class mySimpleOnPageChangeListener extends SimpleOnPageChangeListener
    {
        private ViewPager pager;

        public mySimpleOnPageChangeListener(ViewPager p)
        {
            pager = p;
        }

        public void onPageSelected(int position)
        {
            pager.setCurrentItem(position);
        }

    }
}
