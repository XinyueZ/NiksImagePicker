package de.der_nik.niksimagepicker.data.models;

/**
 * Created by nhenry on 30.12.2016.
 */

public class Image
{
	private String path;
	private boolean picked;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean isPicked() {
		return picked;
	}

	public void setPicked(boolean picked) {
		this.picked = picked;
	}
}
