package com.example.netback.interfaces.maintitle;


import com.example.netback.interfaces.IBasePersenter;
import com.example.netback.interfaces.IBaseView;
import com.example.netback.model.bean.maintitle.MainTitleBean;

public interface MainTitleConstract {
    interface View extends IBaseView {
        void getMainTitleDataReturn(MainTitleBean mainTitleBean);
    }
    interface Presenter extends IBasePersenter<View> {
        void getMainTitleData(int page, int size);
    }
}
