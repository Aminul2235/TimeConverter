package listviewjson.learn2crack.com.time;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import java.util.ArrayList;



class TimeConverterAdapter extends BaseAdapter{

    ArrayList<GetZones> arrayLists=new ArrayList<>();
    Context context;

    public TimeConverterAdapter(ArrayList<GetZones> arrayLists, Context context) {
        this.arrayLists = arrayLists;
        this.context = context;
    }

    public TimeConverterAdapter() {
    }

    @Override
    public int getCount() {
        return arrayLists.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.timezone_custom_row,null);
        GetZones getZones;
        getZones=arrayLists.get(position);
        TextView CountryName;


        CountryName=convertView.findViewById(R.id.CountryName);

        CountryName.setText(getZones.getCountryName()+" ("+getZones.getCountryCode()+")\n"+getZones.getzoneName());

        return convertView;
    }
}
