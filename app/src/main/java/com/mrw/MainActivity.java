package com.mrw;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.TextView;

import com.mrw.wzmrecyclerview.Divider.BaseItemDecoration;
import com.mrw.wzmrecyclerview.Divider.DividerItemDecoration;
import com.mrw.wzmrecyclerview.PullToLoad.OnLoadListener;
import com.mrw.wzmrecyclerview.PullToLoad.PullToLoadRecyclerView;
import com.mrw.wzmrecyclerview.PullToRefresh.OnRefreshListener;
import com.mrw.wzmrecyclerview.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private PullToLoadRecyclerView rcv;
    private TestAdapter testAdapter;
    private ArrayList<String> imgs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcv = (PullToLoadRecyclerView) findViewById(R.id.rcv);

        imgs.add("http://seopic.699pic.com/photo/50004/2199.jpg_wh1200.jpg");
        imgs.add("http://seopic.699pic.com/photo/50000/2811.jpg_wh1200.jpg");
        imgs.add("http://seopic.699pic.com/photo/50007/7034.jpg_wh1200.jpg");
        imgs.add("http://seopic.699pic.com/photo/50006/0945.jpg_wh1200.jpg");
        imgs.add("http://seopic.699pic.com/photo/00040/2066.jpg_wh1200.jpg");
        imgs.add("http://seopic.699pic.com/photo/00010/8940.jpg_wh1200.jpg");
        imgs.add("http://seopic.699pic.com/photo/00041/5575.jpg_wh1200.jpg");
        imgs.add("http://seopic.699pic.com/photo/50007/1912.jpg_wh1200.jpg");
        imgs.add("http://seopic.699pic.com/photo/50004/2199.jpg_wh1200.jpg");
        imgs.add("http://seopic.699pic.com/photo/50000/2811.jpg_wh1200.jpg");
        imgs.add("http://seopic.699pic.com/photo/50007/7034.jpg_wh1200.jpg");
        imgs.add("http://seopic.699pic.com/photo/50006/0945.jpg_wh1200.jpg");
        imgs.add("http://seopic.699pic.com/photo/00040/2066.jpg_wh1200.jpg");
        imgs.add("http://seopic.699pic.com/photo/00010/8940.jpg_wh1200.jpg");
        imgs.add("http://seopic.699pic.com/photo/00041/5575.jpg_wh1200.jpg");
        imgs.add("http://seopic.699pic.com/photo/50007/1912.jpg_wh1200.jpg");
        imgs.add("http://seopic.699pic.com/photo/50004/2199.jpg_wh1200.jpg");
        imgs.add("http://seopic.699pic.com/photo/50000/2811.jpg_wh1200.jpg");
        imgs.add("http://seopic.699pic.com/photo/50007/7034.jpg_wh1200.jpg");
        imgs.add("http://seopic.699pic.com/photo/50006/0945.jpg_wh1200.jpg");
        imgs.add("http://seopic.699pic.com/photo/00040/2066.jpg_wh1200.jpg");
        imgs.add("http://seopic.699pic.com/photo/00010/8940.jpg_wh1200.jpg");
        imgs.add("http://seopic.699pic.com/photo/00041/5575.jpg_wh1200.jpg");
        imgs.add("http://seopic.699pic.com/photo/50007/1912.jpg_wh1200.jpg");
        imgs.add("http://seopic.699pic.com/photo/50004/2199.jpg_wh1200.jpg");
        imgs.add("http://seopic.699pic.com/photo/50000/2811.jpg_wh1200.jpg");
        imgs.add("http://seopic.699pic.com/photo/50007/7034.jpg_wh1200.jpg");
        imgs.add("http://seopic.699pic.com/photo/50006/0945.jpg_wh1200.jpg");
        imgs.add("http://seopic.699pic.com/photo/00040/2066.jpg_wh1200.jpg");
        imgs.add("http://seopic.699pic.com/photo/00010/8940.jpg_wh1200.jpg");
        imgs.add("http://seopic.699pic.com/photo/00041/5575.jpg_wh1200.jpg");
        imgs.add("http://seopic.699pic.com/photo/50007/1912.jpg_wh1200.jpg");

        testAdapter = new TestAdapter(imgs,this);
//        rcv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        rcv.setLayoutManager(new GridLayoutManager(this,2));
//        rcv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        rcv.setRefreshView(R.layout.layout_header_ptr_recyclerview);
        rcv.setLoadView(R.layout.layout_header_ptr_recyclerview);
        rcv.setAdapter(testAdapter);
        rcv.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onStartRefreshing() {
//                imgs.addAll(0,imgs);
//                testAdapter.notifyDataSetChanged();
//                rcv.completeRefresh();
            }
        });
        rcv.setOnLoadListener(new OnLoadListener() {
            @Override
            public void onStartLoading() {
//                imgs.addAll(imgs);
//                testAdapter.notifyDataSetChanged();
//                rcv.completeLoad();
            }
        });
        rcv.addItemDecoration(new BaseItemDecoration(this, R.color.colorAccent));

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_header:
                rcv.addHeaderView(getHeaderView());
                break;
            case R.id.btn_footer:
                rcv.addFooterView(getFooterView());
                break;
            case R.id.btn_remove_header:
                if (headerViews.size()==0) return;
                rcv.removeHeaderView(headerViews.get(headerViews.size()-1));
                headerViews.remove(headerViews.size()-1);
                break;
            case R.id.btn_remove_footer:
                if (footerViews.size()==0) return;
                rcv.removeFooterView(footerViews.get(footerViews.size() - 1));
                footerViews.remove(footerViews.size() - 1);
                break;
            case R.id.btn_finish_refreshing:
                rcv.completeRefresh();
                break;
            case R.id.btn_finish_loading:
                rcv.completeLoad();
                break;
        }
    }

    private ArrayList<View> headerViews = new ArrayList<>();
    private ArrayList<View> footerViews = new ArrayList<>();

    private View getHeaderView() {
        View view = getLayoutInflater().inflate(R.layout.item_header,rcv,false);
        ((TextView) view.findViewById(R.id.tv)).setText("Header"+headerViews.size());
        headerViews.add(view);
        return view;
    }

    private View getFooterView() {
        View view = getLayoutInflater().inflate(R.layout.item_footer,rcv,false);
        footerViews.add(view);
        return view;
    }

}
