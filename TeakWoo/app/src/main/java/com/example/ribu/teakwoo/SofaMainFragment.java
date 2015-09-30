package com.example.ribu.teakwoo;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by ribu on 10-Sep-15.
 */
public class SofaMainFragment extends Fragment{

    ListView list;
    String[] itemrs ={
            "1230",
            "2500",
            "1750",
            "1500",
            "4000"
    };

    String[] oldrs={
            "1700",
            "3000",
            "2450",
            "1850",
            "5500"
    };

    Integer[] imgid={
            R.drawable.sofa1,
            R.drawable.sofa2,
            R.drawable.sofa3,
            R.drawable.sofa4,
            R.drawable.sofa5

    };

    String[] desc={
            "Rio Grande Three Seater Sofa",
            "San Marino Three Seater Sofa",
            "Oritz Three Seater Sofa with Two Pillows",
            "L'Aquila Three Seater Sofa",
            "New Windsor Three Seater Sofa"
    };


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         View rootView = inflater.inflate(R.layout.sofa_main, container, false);
        CustomListAdapter adapter=new CustomListAdapter(getActivity(),desc, itemrs,oldrs, imgid);
        list=(ListView)rootView.findViewById(R.id.listsofamain);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                Fragment fragment=new SofaFragment();
                android.app.FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.frame_container, fragment).commit();

            }
        });
        return rootView;
    }
}
