package de.der_nik.niksimagepicker;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import de.der_nik.niksimagepicker.data.models.Image;
import de.der_nik.niksimagepicker.ui.adapter.ImageAdapter;

/**
 * Created by nhenry on 27.12.2016.
 */

public class OverviewActivity extends AppCompatActivity {
	RecyclerView img;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_overview);
		img = (RecyclerView) findViewById(R.id.grid);
		showGallery();

	}
	public void showGallery()
	{
		int permissionCheck = ContextCompat.checkSelfPermission(this,
		                                                        Manifest.permission.READ_EXTERNAL_STORAGE);
		if(permissionCheck == PackageManager.PERMISSION_GRANTED)
		{
			Image[] imgs = stuff();
			Log.d("xxx", "Menge: "+ imgs.length);
			for (int i = 0; i < imgs.length; i++)
			{
				Log.d("xxx",imgs[i].getPath());
			}
			ImageAdapter adapter = new ImageAdapter(imgs,this);
			RecyclerView.LayoutManager layout = new GridLayoutManager(this, 3);
			img.setHasFixedSize(true);
			img.setItemViewCacheSize(20);
			img.setDrawingCacheEnabled(true);
			img.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
			img.setLayoutManager(layout);
			img.setAdapter(adapter);
		}
		else
		{
			Log.d("xxx","Keine Permission");
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setMessage("Permission fehlt")
			       .setTitle("No Permission")
			       .setPositiveButton("OK", new DialogInterface.OnClickListener() {
				       @Override
				       public void onClick(DialogInterface dialogInterface, int i) {
					       finish();
				       }
			       })
			       .create()
			.show();
		}

	}

	private Image[] stuff()
	{
		final String[] columns = { MediaStore.Images.Media.DATA, MediaStore.Images.Media._ID };
		final String orderBy = MediaStore.Images.Media._ID;
		Image[] images;
		//Stores all the paths from the gallery in Cursor
		Cursor cursor = getContentResolver().query(
				MediaStore.Images.Media.EXTERNAL_CONTENT_URI, columns, null,
				null, orderBy);
		//Total number of paths
		int count = cursor.getCount();

		//Create an array to store path to all the paths
		images = new Image[count];
		for (int i = 0; i < count; i++) {
			cursor.moveToPosition(i);
			int dataColumnIndex = cursor.getColumnIndex(MediaStore.Images.Media.DATA);
			//Store the path of the image
			images[i] = new Image();
			images[i].setPath(cursor.getString(dataColumnIndex));
		}
		return images;
	}
}
