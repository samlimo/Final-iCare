package com.ftfl.limo.icare.emergency;

import android.app.Activity;
import android.os.Bundle;

import com.ftfl.limo.icare.R;

public class ShakeActivity extends Activity {

	/*private ShakeDetector mShakeDetector;
	private SensorManager mSensorManager;
	private Sensor mAccelerometer;

	static final String mPhoneNumner = "008801714103857";
	static final String mName = "Samiul Hoque Limo";*/

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shake);
	
		// ShakeDetector initialization
		/*mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		mAccelerometer = mSensorManager
				.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

		mShakeDetector = new ShakeDetector(new OnShakeListener() {
			@Override
			public void onShake() {
				// Do stuff!
				Intent callIntent = new Intent(Intent.ACTION_CALL,
						Uri.parse("Mobile:" + mPhoneNumner));
				startActivity(callIntent);
			}
		});
	}

	@Override
	protected void onResume() {
		super.onResume();
		mSensorManager.registerListener(mShakeDetector, mAccelerometer,
				SensorManager.SENSOR_DELAY_UI);
	}

	@Override
	protected void onPause() {
		mSensorManager.unregisterListener(mShakeDetector);
		super.onPause();
	}*/
	
	}
	}
