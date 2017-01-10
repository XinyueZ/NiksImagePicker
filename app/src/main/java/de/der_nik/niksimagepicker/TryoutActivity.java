package de.der_nik.niksimagepicker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class TryoutActivity extends AppCompatActivity {

	RecyclerView img;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.actitvity_tryout);
		img = (RecyclerView) findViewById(R.id.grid);

	}
	public void buttonClick(View view)
	{
		Intent intent = new Intent(this, OverviewActivity.class);
		startActivity(intent);

//		Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
//		photoPickerIntent.setType("image/*");
//		startActivityForResult(photoPickerIntent, 1);

	}


}
