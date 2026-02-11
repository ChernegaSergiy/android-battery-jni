package com.chernegasergiy.battery.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.chernegasergiy.battery.R;

public class AboutFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        TextView versionText = view.findViewById(R.id.about_version);
        try {
            PackageInfo pInfo = requireActivity().getPackageManager().getPackageInfo(
                    requireActivity().getPackageName(), 0);
            versionText.setText("Version " + pInfo.versionName);
        } catch (PackageManager.NameNotFoundException e) {
            versionText.setText("Version unknown");
        }

        return view;
    }
}
