package com.reymond.trac_insta.requirement;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
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
import com.reymond.trac_insta.database.requirements;
import com.reymond.trac_insta.installation.installationListView;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;
import java.util.Objects;


public class FourthReqFragment extends Fragment {
    private String id,s1,s2,s3,s4,s5,s6,s7,s8,s9;
    private ListView installationListReq;
    private installationListViewReq Adapter1;
    private TextView no_of_device,type_of_device,region,device_name,site_name,email,mobile_no,address,pincode;
    private DatabaseReference installation_db1;
    private List<requirements> arrayList = new ArrayList<requirements>();


    public FourthReqFragment() {

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
        progressBar.setMessage("Loading Data");
        installation_db1 = FirebaseDatabase.getInstance().getReference("requirements");
        View view = inflater.inflate(R.layout.fragment_fourth_req, container, false);
        installationListReq = view.findViewById(R.id.listViewreq);
        installationListReq.setDivider(null);
        progressBar.show();


        installation_db1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //clearing the previous artist list
                arrayList.clear();
                //iterating through all the nodes
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //getting artist
                    requirements install = postSnapshot.getValue(requirements.class);
                    arrayList.add(install);
                }

                if (getActivity()!=null) {
                    //creating adapter
                    Collections.reverse(arrayList);
                    Adapter1 = new installationListViewReq(getActivity(), arrayList);
                    //attaching adapter to the listview
                    installationListReq.setAdapter(Adapter1);
                    Adapter1.notifyDataSetChanged();
                }
                progressBar.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getActivity(), "db error", Toast.LENGTH_SHORT).show();
            }
        });

        installationListReq.setOnItemClickListener(new AdapterView.OnItemClickListener() {



            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //getting the selected artist
                requirements artist = arrayList.get(i);

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(Objects.requireNonNull(getActivity()));
                LayoutInflater inflater = getLayoutInflater();
                View view1 = inflater.inflate(R.layout.customreq, null);
                no_of_device = view1.findViewById(R.id.text);
                type_of_device = view1.findViewById(R.id.text1);
                region=view1.findViewById(R.id.text12);
                device_name = view1.findViewById(R.id.text2);
                site_name = view1.findViewById(R.id.text3);
                email = view1.findViewById(R.id.text4);
                mobile_no = view1.findViewById(R.id.text5);
                address= view1.findViewById(R.id.text6);
                pincode = view1.findViewById(R.id.text7);




                no_of_device.setText(artist.getNoofdevice());
                type_of_device.setText(artist.getTypeofdevice());
                region.setText(artist.getRegion());
                device_name.setText(artist.getDevicename());
                site_name.setText(artist.getSitename());
                email.setText(artist.getEmail());
                mobile_no.setText(artist.getMobileno());
                address.setText(artist.getAddress());
                pincode.setText(artist.getPincode());
                alertDialog.setView(view1);
                alertDialog.setPositiveButton("OK", null);
                alertDialog.setView(view1);
                // create and show the alert dialog
                AlertDialog dialog = alertDialog.create();
                // Initialize a new window manager layout parameters
                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();


                // Copy the alert dialog window attributes to new layout parameter instance
                layoutParams.copyFrom(dialog.getWindow().getAttributes());

                // Set the width and height for the layout parameters
                // This will bet the width and height of alert dialog
                layoutParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
                layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;

                // Apply the newly created layout parameters to the alert dialog window
                dialog.getWindow().setAttributes(layoutParams);
                alertDialog.show();
            }
        });

        installationListReq.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {


                String s="";
                s = ((global_vars) Objects.requireNonNull(getActivity()).getApplication()).getSomeVariable();
                SharedPreferences sp = Objects.requireNonNull(getActivity()).getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                s = sp.getString("key", null);


                if(s == null)
                {
                    Toast.makeText(getActivity(), "You are not admin to edit the details please go to Settings -> admin -> verify", Toast.LENGTH_SHORT).show();
                }
                else if (s.equals("admin")){
                EditText no_of_device, type_of_device, region, device_name, site_name, email, mobile_no, address, pincode;
                requirements artist = arrayList.get(i);
                id = artist.getInstallationId();
                showUpdateDeleteDialog(artist, artist.getInstallationId(), artist.getNoofdevice());
            }
                return true;
            }
        });
        return view;
    }

    private void showUpdateDeleteDialog(requirements artist, final String artistId, String artistName) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(Objects.requireNonNull(getActivity()));
        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.update_dialog_require, null);

        no_of_device = dialogView.findViewById(R.id.text);
        type_of_device = dialogView.findViewById(R.id.text1);
        region=dialogView.findViewById(R.id.text12);
        device_name = dialogView.findViewById(R.id.text2);
        site_name = dialogView.findViewById(R.id.text3);
        email = dialogView.findViewById(R.id.text4);
        mobile_no = dialogView.findViewById(R.id.text5);
        address= dialogView.findViewById(R.id.text6);
        pincode = dialogView.findViewById(R.id.text7);


        no_of_device.setText(artist.getNoofdevice());
        type_of_device.setText(artist.getTypeofdevice());
        region.setText(artist.getRegion());
        device_name.setText(artist.getDevicename());
        site_name.setText(artist.getSitename());
        email.setText(artist.getEmail());
        mobile_no.setText(artist.getMobileno());
        address.setText(artist.getAddress());
        pincode.setText(artist.getPincode());

        dialogBuilder.setView(dialogView);
        final Button buttonUpdate = (Button) dialogView.findViewById(R.id.buttonUpdateArtist);
        final Button buttonDelete = (Button) dialogView.findViewById(R.id.buttonDeleteArtist);
        final AlertDialog b = dialogBuilder.create();
        b.show();




        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1 = ""+ no_of_device.getText();
                s2 = ""+ type_of_device.getText();
                s3 = ""+ region.getText();
                s4 = ""+ device_name.getText();
                s5 = ""+ site_name.getText();
                s6 = ""+ email.getText();
                s7 = ""+ mobile_no.getText();
                s8 = ""+ address.getText();
                s9 = ""+ pincode.getText();
                updateArtist(id,s1,s2,s3,s4,s5,s6,s7,s8,s9);
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
                b.dismiss();
            }
        });
    }

    private boolean deleteArtist(String id) {
        //getting the specified artist reference
        DatabaseReference dR = FirebaseDatabase.getInstance().getReference("requirements").child(id);
        //removing artist
        dR.removeValue();

        Toast.makeText(getActivity(), "vehicle Deleted", Toast.LENGTH_LONG).show();
        return true;
    }

    private void updateArtist(String id, String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, String s9) {
        //getting the specified artist reference
        DatabaseReference dR = FirebaseDatabase.getInstance().getReference("requirements").child(id);
        //updating artist
        requirements artist = new requirements(id,s1,s2,s3,s4,s5,s6,s7,s8,s9);
        dR.setValue(artist);
        if(getActivity()!=null) {
            Adapter1 = new installationListViewReq(getActivity(), arrayList);
            installationListReq.setAdapter(Adapter1);
        }else{
            Toast.makeText(getActivity(), "Error SF: could not process your request", Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(getActivity(), "Data Updated", Toast.LENGTH_LONG).show();
    }


}

