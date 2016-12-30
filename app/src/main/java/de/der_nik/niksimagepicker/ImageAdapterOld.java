package de.der_nik.niksimagepicker;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.File;

/**
 * Created by nhenry on 28.12.2016.
 */

public class ImageAdapterOld extends RecyclerView.Adapter<ImageAdapterOld.MyViewHolder> {
	String[] paths;
	Bitmap[] images;
	Context context;

	public ImageAdapterOld(String[] paths, Context context)
	{

		this.paths = paths;
		this.images = new Bitmap[paths.length];
		this. context = context;
//		asd();
	}

	@Override
	public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_item, parent, false);
		return new MyViewHolder(itemView);
	}

	@Override
	public void onBindViewHolder(MyViewHolder holder, int position) {
		Log.d("xxx", "allegedly loading: "+paths[position]);
		File f = new File(paths[position]);
		Picasso.with(context).load(f).noFade().resize(400, 400).centerCrop().into(holder.item);
//		holder.item.setImageBitmap(images[position]);
	}

	@Override
	public int getItemCount() {
		return paths.length;
	}

	public class MyViewHolder extends RecyclerView.ViewHolder {

		ImageView item;
		public MyViewHolder(View itemView) {
			super(itemView);
			item = (ImageView) itemView.findViewById(R.id.img_item);
		}
	}

	private Bitmap[] asd ()
	{
		for (int i = 0; i < paths.length; i++)
		{
			images[i]= createThumbnail(paths[i]);
		}
		return images;
	}

	private Bitmap createThumbnail(String photoPath)
	{
		BitmapFactory.Options options = new BitmapFactory.Options();
		options.inPreferredConfig = Bitmap.Config.ARGB_8888;
		Bitmap bitmap = BitmapFactory.decodeFile(photoPath, options);
		Bitmap thumbnail = ThumbnailUtils.extractThumbnail(bitmap, 400, 400);
		return thumbnail;
	}
}
