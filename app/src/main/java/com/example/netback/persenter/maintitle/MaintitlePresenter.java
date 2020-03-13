package com.example.netback.persenter.maintitle;


import com.example.netback.base.BasePersenter;
import com.example.netback.common.CommonSubscriber;
import com.example.netback.interfaces.maintitle.MainTitleConstract;
import com.example.netback.model.HttpManager;
import com.example.netback.model.bean.maintitle.MainTitleBean;
import com.example.netback.utils.RxUtils;

public class MaintitlePresenter extends BasePersenter<MainTitleConstract.View> implements MainTitleConstract.Presenter {
    @Override
    public void getMainTitleData(int page, int size) {
        addSubScribe(HttpManager.getInstance().getShopApi().getMainTitleData(page,size)
        .compose(RxUtils.<MainTitleBean>rxScheduler())
        .subscribeWith(new CommonSubscriber<MainTitleBean>(mView) {
            @Override
            public void onNext(MainTitleBean mainTitleBean) {
                mView.getMainTitleDataReturn(mainTitleBean);
            }
        }));
    }
}
