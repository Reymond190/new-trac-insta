package com.reymond.trac_insta.installation;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.reymond.trac_insta.R;
import com.reymond.trac_insta.service.ServiceimageActivity;

import androidx.fragment.app.Fragment;

public class Photo_fragment extends Fragment {

    Button button;





    public Photo_fragment() {
// Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
// Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.photo_install, container, false);



        button = view.findViewById(R.id.PhotoButton);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), InstallPhotoActivity.class);
                startActivity(intent);

            }
        });
        return  view;
    }
}



