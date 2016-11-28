package com.example.lenovo.taobao;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2016/10/28.
 */

public class ThirdAdapter extends BaseAdapter{
    private Context context;
    private List<Book> lbook = new ArrayList<>();

    public ThirdAdapter(Context c, List<Book> ls) {
        context = c;
        lbook = ls;
    }

    @Override
    public int getCount() {
        return lbook.size();
    }

    @Override
    public Object getItem(int i) {
        return lbook.get(i);
    }

    @Override
    public long getItemId(int i) {
        return lbook.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (null == view){
            view = LayoutInflater.from(context).inflate(R.layout.fg3_listview,null);
        }
        ImageView Img = (ImageView)view.findViewById(R.id.fg3_list_shangjia);
        Img.setImageResource(lbook.get(i).getImg());

        ImageView Img2 = (ImageView)view.findViewById(R.id.fg3_list_shangpin);
        Img2.setImageResource(lbook.get(i).getImg());

        return view;
    }
}
