package com.reymond.trac_insta.installation;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;



import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.reymond.trac_insta.R;
import com.reymond.trac_insta.admin.global_vars;
import com.reymond.trac_insta.database.installation;

import java.util.ArrayList;
import java.util.Collections;




import java.util.Objects;


public class SecondFragment extends Fragment {
    private String id,s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,date;
    private ListView installationList;
    private TextView dateandtime,vehicle_type,vehicle_no, device_name, device_imei_no, sim_name, sim_imei_no, sim_no, location, service_time, service_engineer_name, site_incharge_name, authorised_person;

    ListViewAdapter adapter;
    DatabaseReference installation_db;
    ArrayList<installation> arrayList = new ArrayList<installation>();
    public static final String ARTIST_NAME = "net.simplifiedcoding.firebasedatabaseexample.artistname";
    public static final String ARTIST_ID = "net.simplifiedcoding.firebasedatabaseexample.artistid";





    public SecondFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final ProgressDialog progressBar = new ProgressDialog(getActivity());
        progressBar.setCancelable(true);//you can cancel it by pressing back button
        progressBar.setMessage("Loading");
        installation_db = FirebaseDatabase.getInstance().getReference("installation");



        View view = inflater.inflate(R.layout.fragment_second, container, false);
        installationList = (ListView) view.findViewById(R.id.listView);
        installationList.setDivider(null);
        progressBar.show();
        if(!isNetworkConnected()){
            Toast.makeText(getActivity(), "Not connected, please connect to internet!", Toast.LENGTH_SHORT).show();
            progressBar.dismiss();
        }



        installation_db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //clearing the previous artist list
                arrayList.clear();
                //iterating through all the nodes
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //getting artist
                    installation install = postSnapshot.getValue(installation.class);
                    arrayList.add(install);
                }
                //creating adapter
                if (getActivity()!=null) {
                    Collections.reverse(arrayList);
                    installationListView Adapter = new installationListView(getActivity(), arrayList);
                    //attaching adapter to the listview
                    installationList.setAdapter(Adapter);
                    Adapter.notifyDataSetChanged();
                }

                progressBar.dismiss();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getActivity(), "db error", Toast.LENGTH_SHORT).show();
            }
        });

//        if(arrayList.isEmpty()){
//            Toast.makeText(getActivity(), "List is empty, add details to veiw here", Toast.LENGTH_SHORT).show();
//        }

        installationList.setOnItemClickListener(new AdapterView.OnItemClickListener() {



            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //getting the selected artist
                installation artist = arrayList.get(i);


                AlertDialog.Builder alertDialog = new AlertDialog.Builder(Objects.requireNonNull(getActivity()));
                LayoutInflater inflater = getLayoutInflater();
                View view1 = inflater.inflate(R.layout.custom, null);
                vehicle_type = view1.findViewById(R.id.text);
                vehicle_no = view1.findViewById(R.id.text1);
                device_name = view1.findViewById(R.id.text2);
                device_imei_no = view1.findViewById(R.id.text3);
                sim_name = view1.findViewById(R.id.text4);
                sim_imei_no = view1.findViewById(R.id.text5);
                sim_no = view1.findViewById(R.id.text6);
                location = view1.findViewById(R.id.text7);
                service_time = view1.findViewById(R.id.text8);
                service_engineer_name = view1.findViewById(R.id.text9);
                site_incharge_name = view1.findViewById(R.id.text10);
                authorised_person = view1.findViewById(R.id.text11);
                dateandtime = view1.findViewById(R.id.text12);


                vehicle_type.setText(artist.getVehicle_type());
                vehicle_no.setText(artist.getVehicle_no());
                device_name.setText(artist.getDevice_name());
                device_imei_no.setText(artist.getDevice_imei_no());
                sim_name.setText(artist.getSim_name());
                sim_imei_no.setText(artist.getSim_imei_no());
                sim_no.setText(artist.getSim_no());
                location.setText(artist.getLocation());
                service_time.setText(artist.getService_time());
                service_engineer_name.setText(artist.getService_engineer_name());
                site_incharge_name.setText(artist.getSite_incharge_name());
                authorised_person.setText(artist.getAuthorised_person());
                dateandtime.setText(artist.getDatetime());
                Toast.makeText(getActivity(), ""+artist.getDatetime(), Toast.LENGTH_SHORT).show();
                alertDialog.setView(view1);
                alertDialog.setPositiveButton("OK", null);
                alertDialog.setView(view1);
                // create and show the alert dialog
                AlertDialog dialog = alertDialog.create();
                // Initialize a new window manager layout parameters
                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();


                // Copy the alert dialog window attributes to new layout parameter instance
                layoutParams.copyFrom(Objects.requireNonNull(dialog.getWindow()).getAttributes());

                // Set the width and height for the layout parameters
                // This will bet the width and height of alert dialog
                layoutParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
                layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;

                // Apply the newly created layout parameters to the alert dialog window
                dialog.getWindow().setAttributes(layoutParams);
                alertDialog.show();


            }
        });

        installationList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                //REMOVE COMMENTS HERE DURING DEPLOYMENT

                String s="";
                s = ((global_vars) Objects.requireNonNull(getActivity()).getApplication()).getSomeVariable();

                SharedPreferences sp = Objects.requireNonNull(getActivity()).getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                s= sp.getString("key", null);

                if(s == null)
                {
                    Toast.makeText(getActivity(), "You are not admin to edit the details please go to Settings -> admin -> verify", Toast.LENGTH_SHORT).show();
                }
                else if (s.equals("admin")){
                    EditText installationId, vehicle_type, vehicle_no, device_name, device_imei_no, sim_name, sim_imei_no, sim_no, location, service_time, service_engineer_name, site_incharge_name, authorised_person;
                    installation artist = arrayList.get(i);
                    id = artist.getInstallationId();
                    showUpdateDeleteDialog(artist, artist.getInstallationId(), artist.getVehicle_no());
                }
                return true;
            }
        });
        return view;
    }

    private void showUpdateDeleteDialog(final installation artist, final String artistId, String artistName) {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(Objects.requireNonNull(getActivity()));
        LayoutInflater inflater = getLayoutInflater();
        @SuppressLint("InflateParams") final View view1 = inflater.inflate(R.layout.update_dialog, null);

        vehicle_type = view1.findViewById(R.id.text);
        vehicle_no = view1.findViewById(R.id.text1);
        device_name = view1.findViewById(R.id.text2);
        device_imei_no = view1.findViewById(R.id.text3);
        sim_name = view1.findViewById(R.id.text4);
        sim_imei_no = view1.findViewById(R.id.text5);
        sim_no = view1.findViewById(R.id.text6);
        location = view1.findViewById(R.id.text7);
        service_time = view1.findViewById(R.id.text8);
        service_engineer_name = view1.findViewById(R.id.text9);
        site_incharge_name = view1.findViewById(R.id.text10);
        authorised_person = view1.findViewById(R.id.text11);

        vehicle_type.setText(artist.getVehicle_type());
        vehicle_no.setText(artist.getVehicle_no());
        device_name.setText(artist.getDevice_name());
        device_imei_no.setText(artist.getDevice_imei_no());
        sim_name.setText(artist.getSim_name());
        sim_imei_no.setText(artist.getSim_imei_no());
        sim_no.setText(artist.getSim_no());
        location.setText(artist.getLocation());
        service_time.setText(artist.getService_time());
        service_engineer_name.setText(artist.getService_engineer_name());
        site_incharge_name.setText(artist.getSite_incharge_name());
        authorised_person.setText(artist.getAuthorised_person());



        s1 = artist.getVehicle_type();
        s2 = artist.getVehicle_no();
        s3 = artist.getDevice_name();
        s4 = artist.getDevice_imei_no();
        s5 = artist.getSim_name();
        s6 = artist.getSim_imei_no();
        s7 = artist.getSim_no();
        s8 = artist.getLocation();
        s9 = artist.getService_time();
        s10 = artist.getService_engineer_name();
        s11 = artist.getSite_incharge_name();
        s12 = artist.getAuthorised_person();

        dialogBuilder.setView(view1);
        final Button buttonUpdate =  view1.findViewById(R.id.buttonUpdateArtist);
        final Button buttonDelete = view1.findViewById(R.id.buttonDeleteArtist);
        final AlertDialog b = dialogBuilder.create();
        b.show();

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                date = artist.getDatetime();
                s1 = ""+ vehicle_type.getText();
                s2 = ""+ vehicle_no.getText();
                s3 = ""+ device_name.getText();
                s4 = ""+ device_imei_no.getText();
                s5 = ""+ sim_name.getText();
                s6 = ""+ sim_imei_no.getText();
                s7 = ""+ sim_no.getText();
                s8 = ""+ location.getText();
                s9 = ""+ service_time.getText();
                s10 = ""+ service_engineer_name.getText();
                s11 = ""+ site_incharge_name.getText();
                s12 = ""+ authorised_person.getText();

                    updateArtist(id,s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12);
                Toast.makeText(getActivity(), "updated", Toast.LENGTH_SHORT).show();
                b.dismiss();
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Objects.requireNonNull(getActivity()));
                builder.setMessage("Are you sure you want to delete?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                deleteArtist(artistId);
                                b.dismiss();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();



            }
        });
    }

    private void deleteArtist(String id) {
        //getting the specified artist reference
        DatabaseReference dR = FirebaseDatabase.getInstance().getReference("installation").child(id);
        //removing artist
        dR.removeValue();
        Toast.makeText(getActivity(), "vehicle Deleted", Toast.LENGTH_LONG).show();
    }

    private void updateArtist(String id, String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, String s9, String s10, String s11, String s12) {
        //getting the specified artist reference
        DatabaseReference dR = FirebaseDatabase.getInstance().getReference("installation").child(id);
        //updating artist
        installation artist = new installation(id,date,s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12);
        dR.setValue(artist);
        if(getActivity()!=null) {
            installationListView Adapter = new installationListView(getActivity(), arrayList);
            installationList.setAdapter(Adapter);
        }else{
            Toast.makeText(getActivity(), "Error SF: could not process your request", Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(getActivity(), "Data Updated", Toast.LENGTH_LONG).show();
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) Objects.requireNonNull(getActivity()).getSystemService(Context.CONNECTIVITY_SERVICE);
        assert cm != null;
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();

    }
}

