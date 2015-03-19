package com.example.meinv_liulanqi;

import java.util.Date;
import android.view.MotionEvent;
import android.view.GestureDetector.OnGestureListener;

public class myOnGestureListener implements OnGestureListener
{
    private ViewSwitcherHuadongActivity act;
    private static Date                 lastTime = null;

    public myOnGestureListener(ViewSwitcherHuadongActivity a)
    {
        act = a;
    }

    @Override
    // �����������ǣ�����������ˮƽ�����ϵ�λ����
    // ���ĸ������ǣ����������ڴ�ֱ�����ϵ�λ����
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
            float distanceY)
    {
        // ��ȡ��ǰʱ��
        Date curDate = new Date(System.currentTimeMillis());
        float shijiancha = 1000;
        if (lastTime != null)
        {
            shijiancha = curDate.getTime() - lastTime.getTime();
        }
        // �Ա����λ�������֮���ʱ������
        // ���ڶ���Ļ��һ�λ������ܻᱻGestureDetectorʶ�𵽺ü������ƣ�������Ҫ���˵�ʱ����̫�̵����ơ�
        if (shijiancha > 500)
        {
            if (distanceX > 10)
            {
                act.getNext(act.switcher, act.img_ids);
            }
            if (distanceX < -10)
            {
                act.getPrev(act.switcher, act.img_ids);
            }
        }
        lastTime = curDate;
        return true;
    }

    @Override
    public boolean onDown(MotionEvent arg0)
    {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean onFling(MotionEvent arg0, MotionEvent arg1, float arg2,
            float arg3)
    {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public void onLongPress(MotionEvent arg0)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void onShowPress(MotionEvent arg0)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean onSingleTapUp(MotionEvent arg0)
    {
        // TODO Auto-generated method stub
        return true;
    }

}