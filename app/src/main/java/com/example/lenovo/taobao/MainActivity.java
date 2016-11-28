package com.example.lenovo.taobao;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
    //记录标记时间
    private long exitTime = 0;
    //四个Fragment  ID
    private RelativeLayout r1;
    private RelativeLayout r2;
    private RelativeLayout r3;
    private RelativeLayout r4;

    //四个Img图片 底部Tab
    private ImageView img1;
    private ImageView img2;
    private ImageView img3;
    private ImageView img4;

    //初始化fragment
    private FirstFragment fragment1 = new FirstFragment();
    private SecondFragment fragment2 = new SecondFragment();
    private ThirdFragment fragment3 = new ThirdFragment();
    private FourthFragment fragment4 = new FourthFragment();
    //判断Fragment是否加载过
    private Fragment mTempFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exp);

        //开始界面第一个Fragment
        fragment1 = new FirstFragment();
        mTempFragment = fragment1;
        switchFragment(fragment1);


        getRelativeID();
        setListenerID();

        //首页的图片切换
        img1.setBackgroundResource(R.drawable.guide_tfaccount_on);

    }

    //实现四个界面显示
//    private void addFragment(Fragment fragment, String tag) {
//        FragmentManager manager = getSupportFragmentManager();
//        FragmentTransaction transaction = manager.beginTransaction();
//        transaction.add(R.id.content, fragment, tag);
//        transaction.commit();
//    }

    private void switchFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        if (fragment != mTempFragment) {
            if (!fragment.isAdded()) {
                transaction.hide(mTempFragment).add(R.id.content, fragment).commit();
            } else {
                transaction.hide(mTempFragment).show(fragment).commit();
            }
            mTempFragment = fragment;
        }
        else {
            if(!fragment.isAdded()){
                transaction.add(R.id.content, fragment);
                transaction.commit();
            }
        }
    }


    /**
     * 获取ID和设置监听器
     * **/
    public void getRelativeID(){
        r1 = (RelativeLayout)findViewById(R.id.first_layout);
        r2 = (RelativeLayout)findViewById(R.id.second_layout);
        r3 = (RelativeLayout)findViewById(R.id.third_layout);
        r4 = (RelativeLayout)findViewById(R.id.fourth_layout);

        img1 = (ImageView)findViewById(R.id.first_image);
        img2 = (ImageView)findViewById(R.id.second_image);
        img3 = (ImageView)findViewById(R.id.third_image);
        img4 = (ImageView)findViewById(R.id.fourth_image);
    }
    public void setListenerID(){
        r2.setOnClickListener(mylistener);
        r3.setOnClickListener(mylistener);
        r4.setOnClickListener(mylistener);
        r1.setOnClickListener(mylistener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    //四个界面的切换选择ID
    View.OnClickListener mylistener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.first_layout:
                    img1.setBackgroundResource(R.drawable.guide_tfaccount_on);
                    img2.setBackgroundResource(R.drawable.guide_discover_nm);
                    img3.setBackgroundResource(R.drawable.guide_cart_nm);
                    img4.setBackgroundResource(R.drawable.guide_account_nm);
                    switchFragment(fragment1);
                    break;
                case R.id.second_layout:
                    img1.setBackgroundResource(R.drawable.guide_tfaccount_nm);
                    img2.setBackgroundResource(R.drawable.guide_discover_on);
                    img3.setBackgroundResource(R.drawable.guide_cart_nm);
                    img4.setBackgroundResource(R.drawable.guide_account_nm);
                    switchFragment(fragment2);
                    break;
                case R.id.third_layout:
                    img1.setBackgroundResource(R.drawable.guide_tfaccount_nm);
                    img2.setBackgroundResource(R.drawable.guide_discover_nm);
                    img3.setBackgroundResource(R.drawable.guide_cart_on);
                    img4.setBackgroundResource(R.drawable.guide_account_nm);
                    switchFragment(fragment3);
                    break;
                case R.id.fourth_layout:
                    img1.setBackgroundResource(R.drawable.guide_tfaccount_nm);
                    img2.setBackgroundResource(R.drawable.guide_discover_nm);
                    img3.setBackgroundResource(R.drawable.guide_cart_nm);
                    img4.setBackgroundResource(R.drawable.guide_account_on);
                    switchFragment(fragment4);
                    break;
                default:
                    break;

            }
        }
    };

    //实现双击退出
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (KeyEvent.KEYCODE_BACK == keyCode) {
        // 判断是否在两秒之内连续点击返回键，是则退出，否则不退出
            if (System.currentTimeMillis() - exitTime > 2000) {
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                // 将系统当前的时间赋值给exitTime
                exitTime = System.currentTimeMillis();
            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}

