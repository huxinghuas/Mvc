package com.lanou3g.hua.mvptry;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.lanou3g.hua.mvptry.bean.MyBean;
import com.lanou3g.hua.mvptry.p.IPresent;
import com.lanou3g.hua.mvptry.p.Present;
import com.lanou3g.hua.mvptry.v.IView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IView {

     private IPresent iPresent;
     private TextView showTv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showTv = (TextView) findViewById(R.id.show_tv);
        iPresent = new Present(this);
        iPresent.onStart("http://c.m.163.com/nc/article/list/T1348648517839/0-20.html");

      }




    @Override
    public void onSucccessful(MyBean bean) {
        String datas = bean.getT1348648517839().get(0).getAds().get(0).getTitle();
        showTv.setText(datas);
        Log.d("aaaa", datas);
    }

    @Override
    public void onFaild(String errMsg) {

    }

    @Override
    public void onshowProgress() {

    }

    @Override
    public void onHideProgresss() {

    }
}
