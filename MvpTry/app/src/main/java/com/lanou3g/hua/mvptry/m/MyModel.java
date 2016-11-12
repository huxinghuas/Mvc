package com.lanou3g.hua.mvptry.m;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.lanou3g.hua.mvptry.MyApp;
import com.lanou3g.hua.mvptry.bean.MyBean;
import com.lanou3g.hua.mvptry.p.IPresent;

/**
 * Created by dllo on 16/11/8.
 */
public class MyModel implements IModel {

    private IPresent iPresent;

    public MyModel(IPresent iPresent) {
        this.iPresent = iPresent;
    }

    @Override
    public void onStartRequest(String url) {
        RequestQueue queue = Volley.newRequestQueue(MyApp.getContext());
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                MyBean bean = gson.fromJson(response,MyBean.class);
                iPresent.onSuccess(bean);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                iPresent.onFailure("网络加载失败");
            }
        });
        queue.add(request);
    }
}
