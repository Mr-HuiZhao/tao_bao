package com.example.lenovo.taobao;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class FirstFragment extends ListFragment implements View.OnClickListener{
    //菜单
    private ImageView imageView;

    private List<FirstList> books = new ArrayList<FirstList>();
    private Button button,button1;
    private BookAdapter adapter;
    private ListView lv;
    //获得网络list数据
    private List<Map<String, String>> slist;
    private FirstData firstData;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg1, container, false);
        imageView = (ImageView) view.findViewById(R.id.title_imv);
        imageView.setOnClickListener(new OnClickListener());
        lv = (ListView)view.findViewById(android.R.id.list);

        final Handler handler = new Handler() {
            public void handleMessage(android.os.Message msg) {
                switch (msg.what) {
                    case 0:
                        gEt(slist);
                        adapter = new BookAdapter(getContext(),books);
                        lv.setAdapter(adapter);
                        break;
                    default:
                        break;
                }
            }
        };

        //获取网络资源
        final String path = "http://10.7.88.85/business/json";
        new Thread() {//创建子线程进行网络访问的操作
            public void run() {
                try {
                    slist = firstData.getJSONObject(path);
                    handler.sendEmptyMessage(0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();

        return view;

    }

    @Override
     public void onClick(View view) {
        //刷新数据
        // adapter.notifyDataSetChanged();
    }

    private final class OnClickListener implements android.view.View.OnClickListener{

        @Override
        public void onClick(View view) {
                // View当前PopupMenu显示的相对View的位置
                PopupMenu popupMenu = new PopupMenu(getContext(), view);
                // menu布局
                popupMenu.getMenuInflater().inflate(R.menu.main, popupMenu.getMenu());

                // menu的item点击事件
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        //Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
                        return false;
                    }
                });

                // PopupMenu关闭事件
                popupMenu.setOnDismissListener(new PopupMenu.OnDismissListener() {
                    @Override
                    public void onDismiss(PopupMenu menu) {
                        //Toast.makeText(getApplicationContext(), "关闭PopupMenu", Toast.LENGTH_SHORT).show();
                    }
                });
                popupMenu.show();
        }

    }

    public void gEt (List<Map<String, String>> list){
        for (int i = 0;i < list.size();i++){
            books.add(new FirstList(list.get(i).get("name"), list.get(i).get("image"),i+1));
        }
    }
}
