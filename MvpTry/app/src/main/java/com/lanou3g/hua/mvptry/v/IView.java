package com.lanou3g.hua.mvptry.v;

import com.lanou3g.hua.mvptry.bean.MyBean;

/**
 * Created by dllo on 16/11/8.
 */
public interface IView {


    void  onSucccessful(MyBean bean);
    void  onFaild(String errMsg);

    void  onshowProgress();

    void onHideProgresss();
}
