package com.reymond.trac_insta.installation;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.reymond.trac_insta.R;
import com.reymond.trac_insta.database.installation;

import java.util.List;


public class installationListView extends ArrayAdapter<installation> {
    private Activity context;
    private List<installation> installationList;

    public installationListView(Activity context, List<installation> installationList) {
        super(context, R.layout.installation_list_items, installationList);
        this.context = context;
        this.installationList = installationList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.installation_list_items, null, true);
        TextView textViewNo=  listViewItem.findViewById(R.id.textView2);
        TextView vehicleName = listViewItem.findViewById(R.id.textView3);
        TextView location = listViewItem.findViewById(R.id.textView9);
        TextView date = listViewItem.findViewById(R.id.textView10);
        installation install = installationList.get(position);
        textViewNo.setText(install.getVehicle_no());
        vehicleName.setText(install.getVehicle_type());
        location.setText(install.getLocation());
        date.setText(install.getAuthorised_person());
        return listViewItem;
    }

}