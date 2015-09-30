package com.example.ribu.teakwoo;

import android.app.Fragment;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;

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
public class SofaFragment extends Fragment {

    private FloatingActionButton floatingActionButton;
    //the images to display
    Integer[] imageIDs = {
            R.drawable.sofa1,
            R.drawable.sofa2,
            R.drawable.sofa3,
            R.drawable.sofa4,
            R.drawable.sofa5
    };

    public SofaFragment(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootview=inflater.inflate(R.layout.sofalayout,container,false);
        Gallery gallery = (Gallery)rootview.findViewById(R.id.gallery1);
        floatingActionButton=(FloatingActionButton)rootview.findViewById(R.id.btnFloatingAction);
        gallery.setAdapter(new ImageAdapter(getActivity()));
        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                // display the images selected
                ImageView imageView = (ImageView) rootview.findViewById(R.id.imageview1);
                imageView.setImageResource(imageIDs[position]);
            }
        });
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"Added to cart!!",Toast.LENGTH_SHORT).show();
            }
        });
        return rootview;
    }

    public class ImageAdapter extends BaseAdapter {
        private Context context;
        private int itemBackground;
        public ImageAdapter(Context c)
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
