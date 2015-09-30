package com.example.ribu.teakwoo;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by ribu on 09-Sep-15.
 */
public class HomeFragment extends Fragment {
    ImageView img1,img2,img3;

    public HomeFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        img1=(ImageView)rootView.findViewById(R.id.image1);
        img2=(ImageView)rootView.findViewById(R.id.image2);
        img3=(ImageView)rootView.findViewById(R.id.image3);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image1();
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image2();
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image3();
            }
        });
        return rootView;
    }
   public void image1()
   {
       Fragment fragment=new SofaMainFragment();
       android.app.FragmentManager fragmentManager = getFragmentManager();
       fragmentManager.beginTransaction()
               .replace(R.id.frame_container, fragment).commit();
   }
    public void image2()
    {
        Fragment fragment=new BedMainFragment();
        android.app.FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.frame_container, fragment).commit();
    }
    public void image3()
    {
        Fragment fragment=new TVMainFragment();
        android.app.FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.frame_container, fragment).commit();
    }

}
