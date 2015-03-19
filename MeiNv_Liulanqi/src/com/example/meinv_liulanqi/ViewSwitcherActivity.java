package com.example.meinv_liulanqi;

import com.example.meinv_liulanqi.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewSwitcher;
import android.widget.ViewSwitcher.ViewFactory;

public class ViewSwitcherActivity extends Activity
{
    private int          screenNo = -1;
    private int          screenNum;
    private ViewSwitcher switcher;
    private int[]        img_ids;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_switcher);

        img_ids = new int[] { R.drawable.linzhiling, R.drawable.liuyan,
                R.drawable.yangmi };
        screenNum = img_ids.length;
        // 为ViewSwitcher提供视图工厂
        switcher = (ViewSwitcher) findViewById(R.id.viewSwitcher);
        myViewFactory factory = new myViewFactory(this.getLayoutInflater());
        switcher.setFactory(factory);
        // 初始化
        getNext(switcher, img_ids);
        // 进行切换
        Button btn_next = (Button) findViewById(R.id.button_next);
        btn_next.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
                getNext(switcher, img_ids);
            }
        });
        Button btn_prev = (Button) findViewById(R.id.button_prev);
        btn_prev.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
                getPrev(switcher, img_ids);
            }
        });
    }

    private void getNext(ViewSwitcher _switcher, int[] _img_ids)
    {
        if (screenNo < screenNum - 1)
        {
            screenNo++;
            // 设置视图切换的动画效果
            _switcher.setInAnimation(ViewSwitcherActivity.this,
                    R.anim.slide_in_right);
            _switcher.setOutAnimation(ViewSwitcherActivity.this,
                    R.anim.slide_out_left);
            // 获取下一个视图的实例
            LinearLayout lil = (LinearLayout) _switcher.getNextView();
            ImageView img = (ImageView) lil.findViewById(R.id.img_meinv);
            img.setImageResource(_img_ids[screenNo]);
            // 切换视图
            _switcher.showNext();
        }
    }

    private void getPrev(ViewSwitcher _switcher, int[] _img_ids)
    {
        if (screenNo > 0)
        {
            screenNo--;
            // 设置视图切换的动画效果
            _switcher.setInAnimation(ViewSwitcherActivity.this,
                    R.anim.slide_in_lef);
            _switcher.setOutAnimation(ViewSwitcherActivity.this,
                    R.anim.slide_out_right);
            // 获取下一个视图的实例
            LinearLayout lil = (LinearLayout) _switcher.getNextView();
            ImageView img = (ImageView) lil.findViewById(R.id.img_meinv);
            img.setImageResource(_img_ids[screenNo]);
            // 切换视图
            _switcher.showPrevious();
        }
    }

    class myViewFactory implements ViewFactory
    {
        private LayoutInflater inflater;

        public myViewFactory(LayoutInflater inf)
        {
            inflater = inf;
        }

        @Override
        public View makeView()
        {
            // 提供下一个视图的实例
            return inflater.inflate(R.layout.fragment_layout, null);
        }

    }
}
