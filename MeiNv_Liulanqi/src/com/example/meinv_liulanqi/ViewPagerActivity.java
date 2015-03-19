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
// ����FragmentPagerAdapterֻ��android.support.v4�ж���
// ��android.support.v4.app.FragmentActivity��ʵ������Ҫ����android.support.v4.app.FragmentManager��
// ��������FragmentManagerֻ��ͨ��FragmentActivity��getSupportFragmentManager�����õ���
// ����ViewPagerActivity����̳�android.support.v4.app.FragmentActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        MeiNvFragment_V4.img_ids = new int[] { R.drawable.linzhiling,
                R.drawable.liuyan, R.drawable.yangmi };

        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        // ΪViewPager���FragmentPagerAdapter
        myFragmentPagerAdapter adapter = new myFragmentPagerAdapter(
                getSupportFragmentManager());
        pager.setAdapter(adapter);
        // ΪViewPager����¼�������
        mySimpleOnPageChangeListener listener = new mySimpleOnPageChangeListener(
                pager);
        pager.setOnPageChangeListener(listener);

    }

    // ��չ�õ��Լ���FragmentPagerAdapter
    class myFragmentPagerAdapter extends FragmentPagerAdapter
    {

        public myFragmentPagerAdapter(FragmentManager fm)
        {
            super(fm);
            // TODO Auto-generated constructor stub
        }

        // ��ȡָ��λ�õ�Fragment
        @Override
        public Fragment getItem(int arg0)
        {
            Fragment f = new MeiNvFragment_V4();
            Bundle b = new Bundle();
            b.putInt(MeiNvFragment.Fragment_Key, arg0);
            f.setArguments(b);
            return f;
        }

        // ָ����Adapter����Fragment����Ŀ
        @Override
        public int getCount()
        {
            // TODO Auto-generated method stub
            return MeiNvFragment_V4.img_ids.length;
        }

        @Override
        public CharSequence getPageTitle(int position)
        {
            return "��" + (position + 1) + "����Ů";
        }
    }

    // ��չ�õ��Լ���SimpleOnPageChangeListener
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
