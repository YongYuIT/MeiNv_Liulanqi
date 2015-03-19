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

        // ��ȡActionBarʵ��
        ActionBar bar = this.getActionBar();
        // ����ActionBar�ĵ�����ʽΪTab��ʽ
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        // ����MeiNvFragment��img_ids����
        MeiNvFragment.img_ids = new int[] { R.drawable.linzhiling,
                R.drawable.liuyan, R.drawable.yangmi };
        // ���Tab�����Tab��ı�ǩ������Tab����¼������������¼����������½�Fragment���ô�Fragment���ԭ���Ĳ��֡�
        for (int i = 0; i < MeiNvFragment.img_ids.length; i++)
        {
            Tab t = bar.newTab();
            t.setText("��" + (i + 1) + "����Ů");
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

        // ��ָ��Tab�ѡ��ʱ�����÷���
        @Override
        public void onTabSelected(Tab arg0, FragmentTransaction arg1)
        {
            // TODO Auto-generated method stub
            MeiNvFragment f = new MeiNvFragment();
            // ���½���MeiNvFragment���ݲ���
            Bundle b = new Bundle();
            b.putInt(MeiNvFragment.Fragment_Key, arg0.getPosition());
            f.setArguments(b);
            // ��ȡFragmentTransaction����
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            // ʹ��fragment�����Activity�е�container���
            ft.replace(R.id.container, f);
            // �ύ����
            ft.commit();
        }

        @Override
        public void onTabUnselected(Tab arg0, FragmentTransaction arg1)
        {
            // TODO Auto-generated method stub

        }

    }
}
