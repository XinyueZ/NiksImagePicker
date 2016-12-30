package de.der_nik.niksimagepicker.ui.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import de.der_nik.niksimagepicker.R;
import de.der_nik.niksimagepicker.data.models.Image;
import de.der_nik.niksimagepicker.databinding.ItemGalleryImageBinding;
import de.der_nik.niksimagepicker.viewmodels.ImageViewModel;

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
		ItemGalleryImageBinding imageBinding = DataBindingUtil.inflate(
				LayoutInflater.from(parent.getContext()),
				R.layout.item_gallery_image,
		        parent,
		        false);
		return new BindingHolder(imageBinding);
	}

	@Override
	public void onBindViewHolder(BindingHolder holder, int position) {
		ItemGalleryImageBinding imageBinding = holder.binding;
		imageBinding.setViewModel(new ImageViewModel(context, images[position]));
//		Picasso.with(context).load(imageBinding.getViewModel().getImageFile()).noFade().resize(400, 400).centerCrop().into(holder.mImageView);
	}

	@Override
	public int getItemCount() {
		return images.length;
	}


	public static class BindingHolder extends RecyclerView.ViewHolder
	{
		private ItemGalleryImageBinding binding;
		private ImageView mImageView;

		public BindingHolder (ItemGalleryImageBinding binding)
		{
			super(binding.cardView);
			this.binding = binding;
			mImageView = binding.imageView;
		}
	}
}
