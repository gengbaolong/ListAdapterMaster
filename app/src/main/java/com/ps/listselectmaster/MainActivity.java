package com.ps.listselectmaster;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ps.listselectmaster.apapter.DividerItemDecoration;
import com.ps.listselectmaster.apapter.RecyclerAdapter;
import com.ps.listselectmaster.bean.UserInfo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerAdapter.OnItemClickListener{

    private RecyclerView mRecyclerView;
    private List<UserInfo> mList = new ArrayList<>();
    private RecyclerAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        initData();
        initRecycler();
    }

    private void initData() {
        for (int i = 0; i < 100; i++) {
            UserInfo userInfo = new UserInfo();
            userInfo.setName("seven"+i);
            userInfo.setNumber("number"+i);
            mList.add(userInfo);
        }
    }

    private void initRecycler() {
        recyclerAdapter = new RecyclerAdapter(MainActivity.this, mList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        DividerItemDecoration decoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST);
        mRecyclerView.addItemDecoration(decoration);
        mRecyclerView.setAdapter(recyclerAdapter);
        recyclerAdapter.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(int position) {
        //条目点击
        boolean isSelectFlag = mList.get(position).isSelectFlag();
//        //单选
//        if(!isSelectFlag){
//            for (int i=0; i<mList.size(); i++){
//                if(position == i){
//                    mList.get(position).setSelectFlag(!isSelectFlag);//true
//                }else{
//                    mList.get(i).setSelectFlag(isSelectFlag);//false
//                }
//            }
//            recyclerAdapter.notifyDataSetChanged();
//        }

        //多选
        mList.get(position).setSelectFlag(!isSelectFlag);
        recyclerAdapter.notifyDataSetChanged();
    }
}
