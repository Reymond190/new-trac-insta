package com.reymond.trac_insta.requirement;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.reymond.trac_insta.R;
import com.reymond.trac_insta.database.requirements;

import java.util.List;


public class installationListViewReq extends ArrayAdapter<requirements> {
    private Activity context;
    private List<requirements> installationListReq;

    public installationListViewReq(Activity context, List<requirements> installationList) {
        super(context, R.layout.installation_list_items_req, installationList);
        this.context = context;
        this.installationListReq = installationList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.installation_list_items_req, null, true);
        TextView No_of_device=  listViewItem.findViewById(R.id.textView2);
        TextView site_name = listViewItem.findViewById(R.id.textView3);
        TextView device_name = listViewItem.findViewById(R.id.textView9);
        TextView region = listViewItem.findViewById(R.id.textView10);
        requirements install = installationListReq.get(position);
        No_of_device.setText(install.getNoofdevice());
        site_name.setText(install.getDevicename());
        device_name.setText(install.getRegion());
        region.setText(install.getSitename());
        return listViewItem;
    }

}
