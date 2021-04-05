package com.softartch.example;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;

import java.util.List;


/**
 * Created by Astrit Veliu on 09,September,2019
 */
public class ExPagerAdapter extends PagerAdapter {

    private Context mContext;
    private List<String> feedItemList;

    public ExPagerAdapter(List<String> feedItemList, Context mContext) {
        this.mContext = mContext;
        this.feedItemList = feedItemList;
    }

    @Override
    public int getCount() {
        return feedItemList.size();
    }

    @Override
    public View instantiateItem(ViewGroup container, int position) {
        final String item = feedItemList.get(position);

        LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.list_item, container, false);

        TextView tvItemName = (TextView) view.findViewById(R.id.tvItemName);

        tvItemName.setText(item);

        container.addView(view);
        return view;
    }


    @Override
    public void destroyItem (ViewGroup container, int position, Object object){
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject (View view, Object object){
        return view.equals(object);
    }
}