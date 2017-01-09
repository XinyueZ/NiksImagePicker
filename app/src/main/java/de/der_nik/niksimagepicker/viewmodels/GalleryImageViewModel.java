package de.der_nik.niksimagepicker.viewmodels;

import android.content.Context;
import android.databinding.BaseObservable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.File;

import de.der_nik.niksimagepicker.data.models.Image;

/**
 * Created by nhenry on 30.12.2016.
 */

public class GalleryImageViewModel extends BaseObservable {
	private final String TAG = "ImageViewModel";
	private Context context;
	private Image image;
	private ImageView view;

	public GalleryImageViewModel(Context context, Image image, ImageView view)
	{
		this.context = context;
		this.image = image;
		this.view = view;
		showImage();
	}

	private void showImage()
	{
		Picasso.with(context).load(getImageFile()).noFade().resize(400, 400).centerCrop().into(view);
	}

	public File getImageFile()
	{
		File f = new File(image.getPath());
		return f;
	}

	public View.OnClickListener onClickImage()
	{
		return new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Log.d(TAG, "Click received");
				//Toggle Picked()
			}
		};
	}

	private void togglePicked()
	{

	}

}
