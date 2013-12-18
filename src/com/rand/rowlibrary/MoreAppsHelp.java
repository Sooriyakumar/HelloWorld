package com.rand.rowlibrary;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

public class MoreAppsHelp {
	public MoreAppsHelp(){
		
	}
	public static void GoToMarket(String packagename,Activity activity) {
		try {
			try {
				activity.startActivity(new Intent(Intent.ACTION_VIEW,
						Uri.parse("market://details?id=" + packagename)));
			} catch (Exception e) {
				activity.startActivity(new Intent(
						Intent.ACTION_VIEW,
						Uri.parse("https://play.google.com/store/apps/details?id="
								+ packagename)));
			} catch (Error er) {
				activity.startActivity(new Intent(
						Intent.ACTION_VIEW,
						Uri.parse("https://play.google.com/store/apps/details?id="
								+ packagename)));
			}
		} catch (Exception e) {
		} catch (Error er) {
		}
	}
	public static void GoToMarket(Activity activity) {
		try {
			try {
				activity.startActivity(new Intent(Intent.ACTION_VIEW,
						Uri.parse("market://developer?id=Rupees+%26+Dollars")));
			} catch (Exception e) {
				activity.startActivity(new Intent(
						Intent.ACTION_VIEW,
						Uri.parse("https://play.google.com/store/apps/developer?id=Rupees+%26+Dollars")));
			} catch (Error er) {
				activity.startActivity(new Intent(
						Intent.ACTION_VIEW,
						Uri.parse("https://play.google.com/store/apps/developer?id=Rupees+%26+Dollars")));
			}
		} catch (Exception e) {
		} catch (Error er) {
		}
	}
}
