package com.lanou3g.hua.mvptry.p;

import com.lanou3g.hua.mvptry.bean.MyBean;

/**
 * Created by dllo on 16/11/8.
 */
public interface IPresent {

    void onSuccess(MyBean bean);

    void onFailure(String errMsg);

    void  onStart(String url);
}
