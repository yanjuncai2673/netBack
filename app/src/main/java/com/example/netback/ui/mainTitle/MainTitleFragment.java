package com.example.netback.ui.mainTitle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.netback.R;
import com.example.netback.base.BaseFragment;
import com.example.netback.interfaces.maintitle.MainTitleConstract;
import com.example.netback.model.bean.maintitle.MainTitleBean;
import com.example.netback.persenter.maintitle.MaintitlePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainTitleFragment extends BaseFragment<MainTitleConstract.Presenter> implements MainTitleConstract.View {


    @BindView(R.id.rv_maintitle)
    RecyclerView rvMaintitle;
    List<MainTitleBean.DataBeanX.DataBean> dataBeans;
    MainTitleAdapter titleAdapter;

    @Override
    protected int getLayout() {
        return R.layout.fragment_maintitle;
    }

    @Override
    protected void initData() {
        persenter.getMainTitleData(1, 20);
    }

    @Override
    protected void initView() {
        rvMaintitle.setLayoutManager(new LinearLayoutManager(getActivity()));

        dataBeans = new ArrayList<>();
        titleAdapter = new MainTitleAdapter(dataBeans, getActivity());
        rvMaintitle.setAdapter(titleAdapter);
    }

    @Override
    protected MainTitleConstract.Presenter createPersenter() {
        return new MaintitlePresenter();
    }

    @Override
    public void getMainTitleDataReturn(MainTitleBean mainTitleBean) {

        titleAdapter.updata(mainTitleBean.getData().getData());
    }
}