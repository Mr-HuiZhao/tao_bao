package com.example.lenovo.taobao;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 软件-侯会召-15633047075 on 2016/9/20.
 */

public class BookAdapter extends BaseAdapter {
    private LoadPicture Lp;
    private Bitmap bm;
    private Context context;
    private List<FirstList> lbook = new ArrayList<>();

    public BookAdapter(Context c, List<FirstList> ls) {
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
    public View getView(final int i, View view, ViewGroup viewGroup) {
        if (null == view){
            view = LayoutInflater.from(context).inflate(R.layout.book_view,null);
        }
        final ImageView Img = (ImageView)view.findViewById(R.id.Iv);

        final Handler handler = new Handler() {
            public void handleMessage(android.os.Message msg) {
                switch (msg.what) {
                    case 0:
                        Img.setImageBitmap(bm);
                        break;
                    default:
                        break;
                }
            }
        };

        new Thread(){
            public void run(){
                try{
                    bm = Lp.getBitmap(lbook.get(i).getImg());
                    handler.sendEmptyMessage(0);
                }catch (IOException e){
                    e.getMessage();
                }
            }
        }.start();



        TextView TvName = (TextView) view.findViewById(R.id.Tv);
        TvName.setText(lbook.get(i).getName());

        return view;
    }
}
