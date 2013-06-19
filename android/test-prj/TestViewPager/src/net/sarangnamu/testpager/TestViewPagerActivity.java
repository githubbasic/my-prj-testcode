package net.sarangnamu.testpager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TestViewPagerActivity extends Activity {
    private ListView mList;
    private String[] mListItem = { "Pager Adapter", "FragmentPagerAdapter",
            "FragmentStatePagerAdapter", "ViewPager Other Function" };
    private Class<?>[] activitys = { PagerAdapterSampeActivity.class,
            FragmentPagerAdapterSampeActivity.class,
            FragmentStatePagerAdapterSampeActivity.class,
            OtherViewPagerSampeActivity.class };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        mList = (ListView) findViewById(R.id.list);
        mList.setAdapter(new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1, mListItem));
        mList.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> list, View v, int position,
                    long id) {
                startActivity(new Intent(getApplicationContext(),
                        activitys[position]));
            }
        });
    }
}