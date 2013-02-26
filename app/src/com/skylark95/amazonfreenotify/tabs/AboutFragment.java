package com.skylark95.amazonfreenotify.tabs;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;
import com.skylark95.amazonfreenotify.R;
import com.skylark95.amazonfreenotify.util.ButtonMenuActions;
import com.skylark95.amazonfreenotify.util.HtmlUtil;
import com.skylark95.amazonfreenotify.util.Logger;

public class AboutFragment extends SherlockFragment {
	
	private static final String TAG = Logger.getTag(AboutFragment.class);

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		Log.v(TAG, "ENTER - onCreateView()");
		View view = inflater.inflate(R.layout.fragment_about, container, false);
		setVersionText(view);		
		setHtmlText(view);
		setupButtons(view);
		Log.v(TAG, "EXIT - onCreateView()");
		return view;
	}

	private void setupButtons(View view) {
		Button changelogButton = (Button) view.findViewById(R.id.changelog_button);
		changelogButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Log.v(TAG, "BUTTON - Changelog");
				ButtonMenuActions.showChangelog(getFragmentManager());
			}
		});
		
		Button ukUsersButton = (Button) view.findViewById(R.id.uk_users_button);
		ukUsersButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Log.v(TAG, "BUTTON - UK Users");
				ButtonMenuActions.showUkUsers(getFragmentManager());
			}
		});
		
	}

	private void setHtmlText(View view) {
		Log.v(TAG, "Creating about_html view");
		TextView aboutTextView = (TextView) view.findViewById(R.id.about_html);			
		HtmlUtil.createHtmlView(getSherlockActivity(), aboutTextView, getString(R.string.html_about));
	}

	private void setVersionText(View view) {
		TextView versionTextView = (TextView) view.findViewById(R.id.about_app_version);
		versionTextView.setText(getString(R.string.app_version_label) + " " + getVersion());
	}
	
	private String getVersion() {
		Log.v(TAG, "Getting application version");
		String result = "";
        try {
            PackageManager manager = getSherlockActivity().getPackageManager();
            PackageInfo info = manager.getPackageInfo(getSherlockActivity().getPackageName(), 0);

            result = info.versionName;
        } catch (NameNotFoundException e) {
            Log.w(TAG, "WARNING Unable to get application version: " + e.getMessage());
            result = "N/A";
        }

        return result;
    }

}
