package com.example.lenovo.taobao;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * Created by Lenovo on 2016/10/25.
 */

public class FourthFragment extends Fragment{

    private TextView myTextView;
//    EditText pwdInput;
//    Button loginbutton;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg4, container, false);

//        //获取用户名文本框
//        myTextView = (TextView)view.findViewById(R.id.textView1);


//        //获取密码框
//        pwdInput = (EditText)view.findViewById(R.id.pwd);
//        //获取登陆按钮
//        loginbutton = (Button)view.findViewById(R.id.loginbutton);
//        //设置登陆按钮的点击事件
//        loginbutton.setOnClickListener(new View.OnClickListener() {
//            //这里是编写点击登陆的代码
//            @Override
//            public void onClick(View view) {
//                //获取用户名
//                String username = usernameInput.getText().toString();
//                //获取密码
//                String pwd = pwdInput.getText().toString();
//                //将用户名和密码放入Map中
//                Map<String,String> data = new HashMap<String,String>();
//                data.put("username",username);
//                data.put("pwd",pwd);
//                //定义发送给服务器的地址
//                String url = HttpUtil.BASE_URL+"login";
//                try{
//                    //将数据发给制定的服务器地址上
//                    String returndata = HttpUtil.postRequest(url,data);
//                    //将服务器返回数据转换成JSON格式
//                    JSONObject jsondata = new JSONObject(returndata);
//                    if (jsondata.getBoolean("flag")){
//                        Toast.makeText(getContext(),"登陆成功",Toast.LENGTH_LONG).show();
//                    }else{
//                        Toast.makeText(getContext(),"登陆失败",Toast.LENGTH_LONG).show();
//                    }
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//            }
//        });

        return view;
     }
}