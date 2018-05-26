package com.example.saifulalam.androidviewpager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomPageAdapter extends PagerAdapter {


    private Context context;
    private List<DataObject> dataObjectList;
    private LayoutInflater layoutInflater;

    public CustomPageAdapter(Context context, List<DataObject> dataObjectList){
        this.context = context;
        this.layoutInflater = (LayoutInflater)this.context.getSystemService(this.context.LAYOUT_INFLATER_SERVICE);
        this.dataObjectList = dataObjectList;
    }
    @Override
    public int getCount() {
        return dataObjectList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == ((View)object);
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = this.layoutInflater.inflate(R.layout.pager_list_items, container, false);
        ImageView displayImage = (ImageView)view.findViewById(R.id.large_image);
        TextView imageText = (TextView)view.findViewById(R.id.image_name);
        displayImage.setImageResource(this.dataObjectList.get(position).getImageId());
        imageText.setText(this.dataObjectList.get(position).getImageName());
        container.addView(view);
        return view;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
