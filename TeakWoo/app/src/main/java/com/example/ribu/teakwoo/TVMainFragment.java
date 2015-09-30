package com.example.ribu.teakwoo;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by ribu on 10-Sep-15.
 */
public class TVMainFragment extends Fragment {

    ListView listtv;

    String[] itemrstv ={
            "8500",
            "12500",
            "11750",
            "19500",
            "20000"
    };

    String[] oldrstv={
            "6500",
            "9500",
            "8300",
            "16500",
            "18500"
    };

    Integer[] imgidtv={
            R.drawable.tv1,
            R.drawable.tv2,
            R.drawable.tv3,
            R.drawable.tv4,
            R.drawable.tv5

    };

    String[] desctv={
            "Rio Grande Three Seater Sofa",
            "San Marino Three Seater Sofa",
            "Oritz Three Seater Sofa with Two Pillows",
            "L'Aquila Three Seater Sofa",
            "New Windsor Three Seater Sofa"
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tvstand_main, container, false);
        CustomListAdapter adaptertv=new CustomListAdapter(getActivity(),desctv, itemrstv,oldrstv, imgidtv);
        listtv=(ListView)rootView.findViewById(R.id.listtvstandmain);
        listtv.setAdapter(adaptertv);
        listtv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                Fragment fragment = new TvFragment();
                android.app.FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.frame_container, fragment).commit();

            }
        });
        return rootView;
    }
}
