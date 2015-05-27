/**
 * @author Fred Liu <liuxiaokun0410@qq.com>
 * @version 1.7
 * @since  2015-5-26
 */
package com.example.pulltorefreshtest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.pulltorefreshtest.RefreshableView.PullToRefreshListener;

public class MainActivity extends Activity {

    private RefreshableView refreshableView;
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private String[] items = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
            "L" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        refreshableView = (RefreshableView) findViewById(R.id.refreshable_view);
        listView = (ListView) findViewById(R.id.list_view);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);
        refreshableView.setOnRefreshListener(new PullToRefreshListener() {
            @Override
            public void onRefresh() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                refreshableView.finishRefreshing();
            }
        }, 0);
    }

}
