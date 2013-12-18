package com.rand.rowlibrary;

import android.app.Activity;
import android.content.Context;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;

public class MoreGridAdapter extends BaseAdapter {
	private String[] packages;
	private int[] resouce;
	private LayoutInflater infalter;
	private Display display;
	private int screen_width = 60;
	private LayoutParams params;
	private int padding=3;
	
	public MoreGridAdapter(Activity activity) {
		infalter = (LayoutInflater) activity
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		try {
			display = activity.getWindowManager().getDefaultDisplay();
			screen_width = (int) (display.getHeight() /10.5);
			padding=screen_width/20;
		} catch (Exception e) {
		} catch (Error er) {
		}
		params = new LayoutParams(screen_width, screen_width);
		
	}

	public void MoreAdapterDataSet(String[] packages, int[] resouce) {
		this.packages = packages;
		this.resouce = resouce;
		notifyDataSetChanged();
	}

	public int getCount() {
		int count=0;
		try{
			count= resouce.length;
		}catch(Exception e){
			count=0;
		}catch(Error er){
			count=0;
		}
		return count;
	}

	public Object getItem(int position) {
		return position;
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		try {
			if (convertView == null) {
				convertView = infalter.inflate(R.layout.morelayout2, null);
				holder = new ViewHolder();
				holder.photo_1 = (ImageView) convertView
						.findViewById(R.id.more_appitem);
				holder.photo_1.setLayoutParams(params);
				holder.photo_1.setPadding(padding, padding, padding, padding);
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			holder.photo_1.setImageResource(resouce[position]);
		} catch (Exception e) {
		} catch (Error er) {
		}
		return convertView;
	}

	public class ViewHolder {
		ImageView photo_1;
	}
}
