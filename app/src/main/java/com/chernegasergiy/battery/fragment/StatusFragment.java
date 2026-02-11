package com.chernegasergiy.battery.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.chernegasergiy.battery.R;

public class StatusFragment extends Fragment {
    private TextView statusText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_status, container, false);
        statusText = view.findViewById(R.id.status_text);
        statusText.setText("Listening for broadcasts.\nBattery data will be available\nwhen PHP extension connects.");
        return view;
    }

    public void updateStatus(String status) {
        if (statusText != null) {
            statusText.setText(status);
        }
    }
}
