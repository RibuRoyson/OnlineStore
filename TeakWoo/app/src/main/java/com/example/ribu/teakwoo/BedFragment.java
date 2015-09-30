package com.example.ribu.teakwoo;

import android.app.Fragment;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by ribu on 09-Sep-15.
 */
public class BedFragment extends Fragment {

    private FloatingActionButton floatingActionButton2;
    //the images to display
    Integer[] imageIDs = {
            R.drawable.bed1,
            R.drawable.bed2,
            R.drawable.bed3,
            R.drawable.bed4,
            R.drawable.bed5

    };

    public BedFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.bedlayout, container, false);
        Gallery gallery1 = (Gallery)rootView.findViewById(R.id.gallery2);
        gallery1.setAdapter(new ImageAdapter1(getActivity()));
        gallery1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                // display the images selected
                ImageView imageView = (ImageView) rootView.findViewById(R.id.imageview2);
                imageView.setImageResource(imageIDs[position]);
            }
        });
        floatingActionButton2=(FloatingActionButton)rootView.findViewById(R.id.btnFloatingAction2);
        floatingActionButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Added to cart!!", Toast.LENGTH_SHORT).show();
            }
        });
        return rootView;
    }

    public class ImageAdapter1 extends BaseAdapter {
        private Context context;
        private int itemBackground;
        public ImageAdapter1(Context c)
        {
            context = c;
            // sets a grey background; wraps around the images
            TypedArray a =getActivity().obtainStyledAttributes(R.styleable.MyGallery);
            itemBackground = a.getResourceId(R.styleable.MyGallery_android_galleryItemBackground, 0);
            a.recycle();
        }
        // returns the number of images
        public int getCount() {
            return imageIDs.length;
        }
        // returns the ID of an item
        public Object getItem(int position) {
            return position;
        }
        // returns the ID of an item
        public long getItemId(int position) {
            return position;
        }
        // returns an ImageView view
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(context);
            imageView.setImageResource(imageIDs[position]);
            imageView.setLayoutParams(new Gallery.LayoutParams(200, 200));
            imageView.setBackgroundResource(itemBackground);
            return imageView;
        }
    }
}



