package com.rohinee.ganesh.NewRangoliDesign;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

public class MyPageAdapter extends PagerAdapter {


    private ArrayList<Integer> images;
    private LayoutInflater inflater;
    private Context context;
    public MyPageAdapter(Context context,ArrayList<Integer> images){
        this.context=context;
        this.images=images;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {

        return view.equals(o);
    }
    @Override
    public Object instantiateItem(ViewGroup view,int position){
        View myImageLayout=inflater.inflate(R.layout.slide,view,false);
        ImageView myimage= (ImageView) myImageLayout.findViewById(R.id.imageView);
        myimage.setImageResource(images.get(position));
        view.addView(myImageLayout,0);
        return myImageLayout;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
