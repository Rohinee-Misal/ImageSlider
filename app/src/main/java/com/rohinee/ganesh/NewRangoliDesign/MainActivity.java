package com.rohinee.ganesh.NewRangoliDesign;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static ViewPager mPager;
    private static int currentPage=0;
    private static final  Integer[] IMG={R.drawable.icon,R.drawable.r1,R.drawable.r2,R.drawable.r3,R.drawable.r4,R.drawable.r5,R.drawable.r6,R.drawable.r7,R.drawable.r8,R.drawable.r9,
            R.drawable.r9,R.drawable.r10,R.drawable.r11,R.drawable.r12,R.drawable.r13,R.drawable.r14};
    private ArrayList<Integer> IMGArray=new ArrayList<Integer>();
    private Button prev, next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        //setRequestedOrientation(1);
        getWindow().setFlags(1024,1024);
        setContentView(R.layout.activity_main);


        for(int i=0;i<IMG.length;i++){
            IMGArray.add(IMG[i]);
            mPager=(ViewPager) findViewById(R.id.viewPager);
            mPager.setAdapter(new MyPageAdapter(MainActivity.this,IMGArray));
        }

        prev=(Button)findViewById(R.id.button);

       prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mPager.getCurrentItem()==1) prev.setVisibility(View.INVISIBLE); if(mPager.getAdapter().getCount()>mPager.getCurrentItem()) next.setVisibility(View.VISIBLE);
                     mPager.setCurrentItem(mPager.getCurrentItem()-1,true);
            }
        });
        next=(Button)findViewById(R.id.button2);
         next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mPager.getAdapter().getCount()-1==mPager.getCurrentItem()) next.setVisibility(View.INVISIBLE); if(mPager.getCurrentItem()>=0) prev.setVisibility(View.VISIBLE);
                mPager.setCurrentItem(mPager.getCurrentItem()+1,true);
            }
        });
        
    }
}
