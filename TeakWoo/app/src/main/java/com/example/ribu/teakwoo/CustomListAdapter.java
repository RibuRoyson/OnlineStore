package com.example.ribu.teakwoo;

import android.app.Activity;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ribu on 10-Sep-15.
 */
public class CustomListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] itemname;
    private final String[] oldrs;
    private final Integer[] imgid;
    private final String[] desc;

    public CustomListAdapter(Activity context,String[] desc, String[] itemname,String[]oldrs, Integer[] imgid) {
        super(context, R.layout.mylist, itemname);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.itemname=itemname;
        this.oldrs=oldrs;
        this.desc=desc;
        this.imgid=imgid;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.mylist, null, true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        TextView extratxt = (TextView) rowView.findViewById(R.id.textView1);
        TextView descrip = (TextView) rowView.findViewById(R.id.name);
        extratxt.setPaintFlags(extratxt.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
        txtTitle.setText("\u20B9" + "."+itemname[position]);
        imageView.setImageResource(imgid[position]);
        extratxt.setText("\u20B9" + "."+oldrs[position]);
        descrip.setText(desc[position]);
        return rowView;

    };
}