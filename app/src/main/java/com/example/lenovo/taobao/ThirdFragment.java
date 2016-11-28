package com.example.lenovo.taobao;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2016/10/25.
 */

public class ThirdFragment extends Fragment{

        private List<Book> books = new ArrayList<Book>();
        private ThirdAdapter adapter;
        private ListView lv;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg3, container, false);

        gEt();

        lv = (ListView)view.findViewById(R.id.fg3_list);
        adapter = new ThirdAdapter(getContext(),books);
        lv.setAdapter(adapter);

        return view;
    }

    public void gEt (){
        books.add(new Book("名字",R.drawable.s,1));
        books.add(new Book("名字",R.drawable.s_s,2));
        books.add(new Book("名字",R.drawable.s,1));
        books.add(new Book("名字",R.drawable.s_s,2));

    }
}
