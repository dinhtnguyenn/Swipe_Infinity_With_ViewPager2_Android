package com.dinhnt.scrollinfinity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.dinhnt.scrollinfinity.adapter.ListLoadMoreAdapter;

import java.util.ArrayList;

public class LoadMoreActivity extends AppCompatActivity {
    ArrayList<Integer> list;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loadmore);

        ViewPager2 viewPager2 = findViewById(R.id.viewPager2);

        //tạo list ban đầu có 3 giá trị
        list = new ArrayList<>();
        for (; i < 3; i++) {
            list.add(i);
        }

        ListLoadMoreAdapter adapter = new ListLoadMoreAdapter(this, list);
        viewPager2.setAdapter(adapter);

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                //kiểm tra để screen vị trí cuối cùng load thêm 3 item mới
                if (position == (list.size() - 1)) {
                    int tong = list.size() + 3;
                    for (; i < tong; i++) {
                        list.add(i);
                    }
                    adapter.notifyItemChanged(i + 1);
                }
            }
        });
    }
}