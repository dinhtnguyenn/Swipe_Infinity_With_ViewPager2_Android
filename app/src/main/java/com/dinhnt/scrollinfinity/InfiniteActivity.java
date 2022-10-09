package com.dinhnt.scrollinfinity;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.dinhnt.scrollinfinity.adapter.ListInfiniteAdapter;
import com.dinhnt.scrollinfinity.models.Sample;

import java.util.ArrayList;

public class InfiniteActivity extends AppCompatActivity {
    ArrayList<Sample> list;
    ViewPager2 viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infinite);

        viewPager2 = findViewById(R.id.viewPager2);

        //tạo list ban đầu có 3 giá trị
        list = new ArrayList<>();
        list.add(new Sample(1, Color.RED));
        list.add(new Sample(2, Color.BLUE));
        list.add(new Sample(3, Color.GREEN));
        list.add(new Sample(4, Color.YELLOW));
        list.add(new Sample(5, Color.GRAY));

        ListInfiniteAdapter adapter = new ListInfiniteAdapter(this, list);
        viewPager2.setAdapter(adapter);

        viewPager2.setCurrentItem(1);
        infiniteList(list.size() + 2);

    }

    private void infiniteList(int size) {
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
                if (state == ViewPager2.SCROLL_STATE_IDLE) {
                    if (viewPager2.getCurrentItem() == size - 1) {
                        viewPager2.setCurrentItem(1, false);
                    }
                    if (viewPager2.getCurrentItem() == 0) {
                        viewPager2.setCurrentItem(size - 2, false);
                    }
                }
            }
        });
    }
}