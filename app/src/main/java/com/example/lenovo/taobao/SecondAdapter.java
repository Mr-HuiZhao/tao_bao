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
 * Created by Lenovo on 2016/10/28.
 */

public class SecondAdapter extends BaseAdapter {
    private LoadPicture Lp;
    private Bitmap bm,bm2;
    private Context context;
    private List<SecondList> lbook = new ArrayList<>();

    public SecondAdapter(Context c, List<SecondList> ls) {
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
            view = LayoutInflater.from(context).inflate(R.layout.fg2_list,null);
        }
        final ImageView Img = (ImageView)view.findViewById(R.id.fg2_title_img);

        final ImageView Img2 = (ImageView)view.findViewById(R.id.fg2_content);

        final Handler handler = new Handler() {
            public void handleMessage(android.os.Message msg) {
                switch (msg.what) {
                    case 0:
                        Img2.setImageBitmap(bm2);
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
                    bm2 = Lp.getBitmap(lbook.get(i).getImg());
                    bm = Lp.getBitmap(lbook.get(i).getLogo());
                    handler.sendEmptyMessage(0);
                }catch (IOException e){
                    e.getMessage();
                }
            }
        }.start();


        TextView TvName = (TextView) view.findViewById(R.id.fg2_title);
        TvName.setText(lbook.get(i).getName());

        return view;
    }
}
