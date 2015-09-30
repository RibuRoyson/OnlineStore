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
public class BedMainFragment extends Fragment {

    ListView listbd;
    String[] itemrsbd ={
            "21230",
            "27500",
            "31750",
            "21500",
            "34000"
    };

    String[] oldrsbd={
            "19000",
            "26000",
            "30000",
            "20500",
            "33500"
    };

    Integer[] imgidbd={
            R.drawable.bed1,
            R.drawable.bed2,
            R.drawable.bed3,
            R.drawable.bed4,
            R.drawable.bed5

    };

    String[] descbd={
            "Rio Grande Three Seater Sofa",
            "San Marino Three Seater Sofa",
            "Oritz Three Seater Sofa with Two Pillows",
            "L'Aquila Three Seater Sofa",
            "New Windsor Three Seater Sofa"
    };


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.bed_main, container, false);
        CustomListAdapter adaptertv=new CustomListAdapter(getActivity(),descbd, itemrsbd,oldrsbd, imgidbd);
        listbd=(ListView)rootView.findViewById(R.id.listbedmain);
        listbd.setAdapter(adaptertv);
        listbd.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                Fragment fragment = new BedFragment();
                android.app.FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.frame_container, fragment).commit();

            }
        });
        return rootView;
    }
}
