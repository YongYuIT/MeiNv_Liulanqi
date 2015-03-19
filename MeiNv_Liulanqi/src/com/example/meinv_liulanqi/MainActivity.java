package com.example.meinv_liulanqi;

import com.example.meinv_liulanqi.R;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 获取ActionBar实例
        ActionBar bar = this.getActionBar();
        // 设置ActionBar的导航方式为Tab方式
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        // 设置MeiNvFragment的img_ids参数
        MeiNvFragment.img_ids = new int[] { R.drawable.linzhiling,
                R.drawable.liuyan, R.drawable.yangmi };
        // 添加Tab项；设置Tab项的标签；设置Tab项的事件监听器，在事件监听器中新建Fragment并用此Fragment替代原本的布局。
        for (int i = 0; i < MeiNvFragment.img_ids.length; i++)
        {
            Tab t = bar.newTab();
            t.setText("第" + (i + 1) + "个美女");
            t.setTabListener(new MyTabListener());
            bar.addTab(t);
        }

    }

    class MyTabListener implements ActionBar.TabListener
    {

        public void onTabReselected(Tab arg0, FragmentTransaction arg1)
        {
            // TODO Auto-generated method stub

        }

        // 当指定Tab项被选中时激发该方法
        @Override
        public void onTabSelected(Tab arg0, FragmentTransaction arg1)
        {
            // TODO Auto-generated method stub
            MeiNvFragment f = new MeiNvFragment();
            // 向新建的MeiNvFragment传递参数
            Bundle b = new Bundle();
            b.putInt(MeiNvFragment.Fragment_Key, arg0.getPosition());
            f.setArguments(b);
            // 获取FragmentTransaction对象
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            // 使用fragment代替该Activity中的container组件
            ft.replace(R.id.container, f);
            // 提交事务
            ft.commit();
        }

        @Override
        public void onTabUnselected(Tab arg0, FragmentTransaction arg1)
        {
            // TODO Auto-generated method stub

        }

    }
}
