package com.example.netback.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.example.netback.interfaces.IBasePersenter;
import com.example.netback.interfaces.IBaseView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 基础Fragment
 *  * MVP框架中BaseFragment类应该具备如下特征：
 *  * 1.应该包含用来处理网络数据逻辑的P层
 *  * 2.应该具备界面初始化的方法initView
 *  * 3.应该具备数据初始化的方法initData
 *  * 4.获取当前应该显示的xml布局页面
 *  * 5.生命周期结束的时候解绑p层的关联
 */
public abstract class BaseFragment<P extends IBasePersenter> extends Fragment implements IBaseView {
    protected P persenter;
    protected Context context;
    protected Activity activity;
    Unbinder unbinder;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(getLayout(), null);
        return inflate;
    }

    protected abstract int getLayout();

    @Override
    public void showMes(String s) {
        Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
         context = getContext();
         activity = getActivity();
         unbinder = ButterKnife.bind(this,view);
         persenter  = createPersenter();
        if(persenter != null) persenter.attachView(this);
        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract P createPersenter();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(persenter != null){
            persenter.detachView();
        }
        if(unbinder != null){
            unbinder.unbind();
        }
    }
}
