package com.ftfl.limo.icare.fragment;

import com.ftfl.limo.icare.R;
import com.ftfl.limo.icare.doctor.DoctorList;
import com.ftfl.limo.icare.notes.NoteList;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DoctorFragment extends Fragment {
	
	public DoctorFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_doctor, container, false);
        Intent intent = new Intent(getActivity(),DoctorList.class);
    	startActivity(intent);
        return rootView;
    }
}
