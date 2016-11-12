package com.lanou3g.hua.mvptry.p;

import com.lanou3g.hua.mvptry.bean.MyBean;
import com.lanou3g.hua.mvptry.m.IModel;
import com.lanou3g.hua.mvptry.m.MyModel;
import com.lanou3g.hua.mvptry.v.IView;

/**
 * Created by dllo on 16/11/8.
 */
public class Present implements  IPresent{

    private IView iView;
    private IModel iModel;


    public Present(IView iView) {
        this.iView = iView;
        iModel = new MyModel(this);
    }

    @Override
    public void onSuccess(MyBean bean) {
        iView.onHideProgresss();
        iView.onSucccessful(bean);

    }

    @Override
    public void onFailure(String errMsg) {
        iView.onHideProgresss();
        iView.onFaild(errMsg);
    }

    @Override
    public void onStart(String url) {
        iView.onshowProgress();
        iModel.onStartRequest(url);
    }


}
