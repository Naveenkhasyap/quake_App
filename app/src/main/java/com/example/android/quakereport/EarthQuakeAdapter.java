package com.example.android.quakereport;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by msi on 2/23/2017.
 */

public class EarthQuakeAdapter extends ArrayAdapter<EarthQuake>{


    public EarthQuakeAdapter(Activity context, ArrayList<EarthQuake> earthQuakes) {
        super(context, 0,earthQuakes);
    }

    @Override
    public View getView(int position, View ConvertView, ViewGroup parent){
        View listItemView = ConvertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_layout,parent,false);
        }

        EarthQuake currentdata = getItem(position);
        DecimalFormat formatter = new DecimalFormat("0.00");
        String mag = formatMagnitude(currentdata.getmMagnitude());
        TextView magTv =(TextView) listItemView.findViewById(R.id.magnitude);

        magTv.setText(mag);
        GradientDrawable magniCircle =  (GradientDrawable) magTv.getBackground();
        int magColor = getMagnitudeColor(currentdata.getmMagnitude());

        magniCircle.setColor(magColor);

        String loc = currentdata.getlocation();
        String part1;
        String part2;
        if(loc.contains("of")){
            String [] parts =  loc.split("of");
            part1 = parts[0]+"of";
            part2 = parts[1];
        }else{
            part1 = "Near by";
            part2 = loc;
        }

        TextView locTv =(TextView) listItemView.findViewById(R.id.loc1);

        locTv.setText(part1);
        TextView locTv2 =(TextView) listItemView.findViewById(R.id.loc2);

        locTv2.setText(part2);

        Date dateObject = new Date(currentdata.getTimeInMilliseconds ());

        TextView dateTv =(TextView) listItemView.findViewById(R.id.date);
        String formatedDate = formatDate(dateObject);
        dateTv.setText(formatedDate);

        TextView timeTV =(TextView) listItemView.findViewById(R.id.time);
        String formattedTime = formatTime(dateObject);
        timeTV.setText(formattedTime);
        return listItemView;
    }

    // Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
    //
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    /**
     * Return the formatted magnitude string showing 1 decimal place (i.e. "3.2")
     * from a decimal magnitude value.
     */
    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}
