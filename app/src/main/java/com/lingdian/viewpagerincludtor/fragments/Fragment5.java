package com.lingdian.viewpagerincludtor.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lingdian.viewpagerincludtor.R;

/**
 * Created by lingdian on 2018/1/31.
 */

public class Fragment5 extends Fragment {

    private View rootView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        rootView=inflater.inflate(R.layout.fragment_one,container,false);
        TextView text_tag=rootView.findViewById(R.id.text_tag);
        text_tag.setText("Five");
        return rootView;
    }
}
