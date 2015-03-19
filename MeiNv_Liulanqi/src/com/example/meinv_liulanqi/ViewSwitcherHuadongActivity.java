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

        // GestureDetector���ڴ�OnTouchListener��onTouch�����н��������ɴ��б����ƣ�
        // ʶ������ƺ���OnGestureListener��Ӧ��
        myOnGestureListener listener = new myOnGestureListener(this);
        myDesDet = new GestureDetector(listener);

        img_ids = new int[] { R.drawable.linzhiling, R.drawable.liuyan,
                R.drawable.yangmi };
        screenNum = img_ids.length;

        // ΪViewSwitcher�ṩ��ͼ����
        switcher = (ViewSwitcher) findViewById(R.id.viewSwitcher);
        myViewFactory factory = new myViewFactory(this.getLayoutInflater(),
                myDesDet);
        switcher.setFactory(factory);

        // ��ʼ��
        getNext(switcher, img_ids);
    }

    public void getNext(ViewSwitcher _switcher, int[] _img_ids)
    {
        if (screenNo < screenNum - 1)
        {
            screenNo++;
            // ������ͼ�л��Ķ���Ч��
            _switcher.setInAnimation(ViewSwitcherHuadongActivity.this,
                    R.anim.slide_in_right);
            _switcher.setOutAnimation(ViewSwitcherHuadongActivity.this,
                    R.anim.slide_out_left);
            // ��ȡ��һ����ͼ��ʵ��
            LinearLayout lil = (LinearLayout) _switcher.getNextView();
            ImageView img = (ImageView) lil.findViewById(R.id.img_meinv);
            img.setImageResource(_img_ids[screenNo]);
            // �л���ͼ
            _switcher.showNext();
        }
    }

    public void getPrev(ViewSwitcher _switcher, int[] _img_ids)
    {
        if (screenNo > 0)
        {
            screenNo--;
            // ������ͼ�л��Ķ���Ч��
            _switcher.setInAnimation(ViewSwitcherHuadongActivity.this,
                    R.anim.slide_in_lef);
            _switcher.setOutAnimation(ViewSwitcherHuadongActivity.this,
                    R.anim.slide_out_right);
            // ��ȡ��һ����ͼ��ʵ��
            LinearLayout lil = (LinearLayout) _switcher.getNextView();
            ImageView img = (ImageView) lil.findViewById(R.id.img_meinv);
            img.setImageResource(_img_ids[screenNo]);
            // �л���ͼ
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
            // �ṩ��һ����ͼ��ʵ��
            View v = inflater.inflate(R.layout.fragment_layout, null);
            ImageView img = (ImageView) v.findViewById(R.id.img_meinv);
            // ΪͼƬע�ᴥ���¼�������
            img.setOnTouchListener(new myOnTouchListener(desDet));
            return v;
        }
    }

    // ��չ�õ��Լ��Ĵ����¼�������
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
            // ���������ݴ���GestureDetector��GestureDetector���Դ����б�����
            return desDet.onTouchEvent(arg1);
        }

    }

}
