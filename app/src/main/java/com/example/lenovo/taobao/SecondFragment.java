package com.example.lenovo.taobao;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Lenovo on 2016/10/25.
 */

public class SecondFragment extends Fragment {

    //两个图片点击设置
    private ImageView imageView_1;
    private ImageView imageView_2;

    private List<SecondList> books = new ArrayList<SecondList>();
    private SecondAdapter adapter;
    private ListView lv;

    //获得网络list数据
    private List<Map<String, String>> slist;
    private SecondData secondData;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg2, container, false);

        //给Book类添加数据
        gId(view);
        setListener();

        final Handler handler = new Handler() {
            public void handleMessage(android.os.Message msg) {
                switch (msg.what) {
                    case 0:
                        gEt(slist);
                        adapter = new SecondAdapter(getContext(),books);
                        lv.setAdapter(adapter);
                        break;
                    default:
                        break;
                }
            }
        };

        //获取网络资源
        final String path = "http://10.7.88.85/product/json";
        new Thread() {//创建子线程进行网络访问的操作
            public void run() {
                try {
                    slist = secondData.getJSONObject(path);
                    handler.sendEmptyMessage(0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();


        return view;
    }
    public void gEt (List<Map<String, String>> list){
        for (int i = 0;i < list.size();i++){
            books.add(new SecondList(i+1,list.get(i).get("name"),list.get(i).get("image"),list.get(i).get("logo")));
        }
    }
    public void gId(View view){
        imageView_1 = (ImageView)view.findViewById(R.id.fg2_title_img);
        imageView_1 = (ImageView)view.findViewById(R.id.fg2_content);
        lv = (ListView)view.findViewById(R.id.fg2_list);
    }
    public void setListener(){

    }

}
