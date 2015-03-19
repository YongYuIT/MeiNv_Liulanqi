package com.example.meinv_liulanqi;

import android.app.Activity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewSwitcher;
import android.widget.ViewSwitcher.ViewFactory;

public class ViewSwitcherHuadongActivity extends Activity
{

    private int             screenNo = -1;
    private int             screenNum;
    public ViewSwitcher     switcher;
    public int[]            img_ids;
    private GestureDetector myDesDet;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_switcher_huadong);

        // GestureDetector用于从OnTouchListener的onTouch函数中接收数据由此判别手势，
        // 识别出手势后，由OnGestureListener响应。
        myOnGestureListener listener = new myOnGestureListener(this);
        myDesDet = new GestureDetector(listener);

        img_ids = new int[] { R.drawable.linzhiling, R.drawable.liuyan,
                R.drawable.yangmi };
        screenNum = img_ids.length;

        // 为ViewSwitcher提供视图工厂
        switcher = (ViewSwitcher) findViewById(R.id.viewSwitcher);
        myViewFactory factory = new myViewFactory(this.getLayoutInflater(),
                myDesDet);
        switcher.setFactory(factory);

        // 初始化
        getNext(switcher, img_ids);
    }

    public void getNext(ViewSwitcher _switcher, int[] _img_ids)
    {
        if (screenNo < screenNum - 1)
        {
            screenNo++;
            // 设置视图切换的动画效果
            _switcher.setInAnimation(ViewSwitcherHuadongActivity.this,
                    R.anim.slide_in_right);
            _switcher.setOutAnimation(ViewSwitcherHuadongActivity.this,
                    R.anim.slide_out_left);
            // 获取下一个视图的实例
            LinearLayout lil = (LinearLayout) _switcher.getNextView();
            ImageView img = (ImageView) lil.findViewById(R.id.img_meinv);
            img.setImageResource(_img_ids[screenNo]);
            // 切换视图
            _switcher.showNext();
        }
    }

    public void getPrev(ViewSwitcher _switcher, int[] _img_ids)
    {
        if (screenNo > 0)
        {
            screenNo--;
            // 设置视图切换的动画效果
            _switcher.setInAnimation(ViewSwitcherHuadongActivity.this,
                    R.anim.slide_in_lef);
            _switcher.setOutAnimation(ViewSwitcherHuadongActivity.this,
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
        private LayoutInflater  inflater;
        private GestureDetector desDet;

        public myViewFactory(LayoutInflater _inf, GestureDetector _desDet)
        {
            inflater = _inf;
            desDet = _desDet;
        }

        @Override
        public View makeView()
        {
            // 提供下一个视图的实例
            View v = inflater.inflate(R.layout.fragment_layout, null);
            ImageView img = (ImageView) v.findViewById(R.id.img_meinv);
            // 为图片注册触摸事件监听器
            img.setOnTouchListener(new myOnTouchListener(desDet));
            return v;
        }
    }

    // 扩展得到自己的触摸事件监听器
    class myOnTouchListener implements OnTouchListener
    {
        private GestureDetector desDet;

        public myOnTouchListener(GestureDetector _desDet)
        {
            desDet = _desDet;
        }

        @Override
        public boolean onTouch(View arg0, MotionEvent arg1)
        {
            // 将监听数据传到GestureDetector，GestureDetector可以从中判别手势
            return desDet.onTouchEvent(arg1);
        }

    }

}
