package de.der_nik.niksimagepicker.ui.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import de.der_nik.niksimagepicker.R;
import de.der_nik.niksimagepicker.data.models.Image;
import de.der_nik.niksimagepicker.databinding.ItemGalleryImageBinding;
import de.der_nik.niksimagepicker.viewmodels.GalleryImageViewModel;


/**
 * Created by nhenry on 30.12.2016.
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.BindingHolder>
{
	private Image[] images;
	private Context context;

	public ImageAdapter (Image[] images, Context context)
	{
		this.images = images;
		this.context = context;
	}

	@Override
	public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gallery_image, parent, false);
		return new BindingHolder(v);
	}

	@Override
	public void onBindViewHolder(BindingHolder holder, int position) {

		final GalleryImageViewModel image = new GalleryImageViewModel(context, images[position], holder.getBinding().imageView);
		holder.bindImage(image);
	}

	@Override
	public int getItemCount() {
		return images.length;
	}


	public static class BindingHolder extends RecyclerView.ViewHolder
	{
		private ItemGalleryImageBinding binding;

		public BindingHolder (View view)
		{
			super(view);
			this.binding = DataBindingUtil.bind(view);
		}
		public ItemGalleryImageBinding getBinding()
		{
			return binding;
		}

		public void bindImage(GalleryImageViewModel image)
		{
			binding.setGalleryImage(image);
		}
	}
}
