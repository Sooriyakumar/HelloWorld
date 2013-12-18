package com.rand.rowlibrary;

import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Gallery;
import android.widget.GridView;
import android.widget.LinearLayout;

public class MoreGridView implements OnItemClickListener {
	private Activity activity;
	private GridView moregridview;
	@SuppressWarnings("deprecation")
	private Gallery gallery;
	private static LayoutInflater inflater = null;
	private MoreGridAdapter adapter;
	private View morelayout;
	private String[] packagenames = new String[15];
	private int[] resourceIds = new int[15];
	private String PackageName = "";
	private int galleryint = 2;
	private LinearLayout layout;
	private int type=1;
	public MoreGridView(Activity activity, LinearLayout layout,
			String PackageName) {
		try {
			this.PackageName = PackageName;
			this.layout = layout;
			this.activity = activity;
			inflater = (LayoutInflater) activity
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			adapter = new MoreGridAdapter(activity);
		} catch (Exception e) {
		} catch (Error er) {
		}
	}

	public void MoreViewType(int type, int selection) {
		this.type=type;
		switch (type) {
		case 1:
			GalleryLayout(selection);
			break;
		case 2:
			GridLayout();
			break;
		}
		new moreBackground().execute("");
	}

	private void GridLayout() {
		try {
			morelayout = inflater.inflate(R.layout.morelayout_gridview, null);
			moregridview = (GridView) morelayout
					.findViewById(R.id.more_gridview);
			moregridview.setOnItemClickListener(this);
			moregridview.setAdapter(adapter);
			layout.addView(morelayout);
		} catch (Exception e) {
		} catch (Error er) {
		}
	}

	private void GalleryLayout(int selection) {
		try {
			galleryint = selection;
			morelayout = inflater.inflate(R.layout.morelayout_gallery, null);
			gallery = (Gallery) morelayout.findViewById(R.id.more_galleryview);
			gallery.setOnItemClickListener(this);
			gallery.setAdapter(adapter);
			layout.addView(morelayout);
		} catch (Exception e) {
		} catch (Error er) {
		}
	}

	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		if (arg0 != null) {
			MoreAppsHelp.GoToMarket(packagenames[arg2], activity);
		}
	}

	class moreBackground extends AsyncTask<String, Integer, String> {
		protected String doInBackground(String... params) {
			LoadAllApps();
			return "";
		}

		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			TeskComplete();
		}
	}

	private void TeskComplete() {
		adapter.MoreAdapterDataSet(packagenames, resourceIds);
		if (type ==1) {
			if(galleryint==2){
				int localint=galleryint;
				try{
					do{
					 localint=new Random().nextInt(14);
					}while(localint<2 && localint>12);
					galleryint=localint;
				}catch(Exception e){
				}catch(Error er){
				}
			}
			gallery.setSelection(galleryint);
		}
	}

	private void LoadAllApps() {
		try {
			packagenames[0] = "com.rand.animalsphotopuzzle";
			resourceIds[0] = R.drawable.more_aniumalspuzzle;
			packagenames[1] = "com.rand.applocker";
			resourceIds[1] = R.drawable.more_applocker;
			packagenames[2] = "com.rand.appshare";
			resourceIds[2] = R.drawable.more_appshare;
			packagenames[3] = "com.rand.birdsphotopuzzle";
			resourceIds[3] = R.drawable.more_birdspuzzle;
			packagenames[4] = "com.rand.memory";
			resourceIds[4] = R.drawable.more_brainsharper;
			packagenames[5] = "com.rand.flashlight";
			resourceIds[5] = R.drawable.more_candle;
			packagenames[6] = "com.rand.drawingbook";
			resourceIds[6] = R.drawable.more_drawingbook;
			packagenames[7] = "com.rand.mobileinfo";
			resourceIds[7] = R.drawable.more_mobileinfo;
			packagenames[8] = "com.rand.petsphotopuzzle";
			resourceIds[8] = R.drawable.more_petspuzzle;
			packagenames[9] = "com.rand.photolocker";
			resourceIds[9] = R.drawable.more_photolocker;
			packagenames[10] = "com.rand.photopuzzle";
			resourceIds[10] = R.drawable.more_photopuzzle;
			packagenames[11] = "com.rand.qrcode";
			resourceIds[11] = R.drawable.more_qrcode;
			packagenames[12] = "com.rand.spycam";
			resourceIds[12] = R.drawable.more_spycamera;
			packagenames[13] = "com.rand.sudoku";
			resourceIds[13] = R.drawable.more_sudoku;
			packagenames[14] = "com.rand.taskmanager";
			resourceIds[14] = R.drawable.more_taskmanager;
			for (int i = 0; i < 15; i++) {
				if (PackageName.equals(packagenames[i])) {
					packagenames[i] = "com.rand.colorburst";
					resourceIds[i] = R.drawable.more_photomagic;
				}
			}
		} catch (Exception e) {
		} catch (Error er) {
		}
	}
}
