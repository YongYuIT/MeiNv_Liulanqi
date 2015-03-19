package com.example.meinv_liulanqi;

import com.example.meinv_liulanqi.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MeiNvFragment extends Fragment
{
    public static int[]  img_ids;
    public static String Fragment_Key = "Fragment_Key";

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_layout, null);
        ImageView img_meinv = (ImageView) v.findViewById(R.id.img_meinv);
        // 获取创建该Fragment时传入的参数Bundle
        Bundle args = getArguments();
        img_meinv.setImageResource(img_ids[args.getInt(Fragment_Key)]);
        return v;
    }
}
