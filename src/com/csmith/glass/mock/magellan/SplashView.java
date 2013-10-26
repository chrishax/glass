

package com.csmith.glass.mock.magellan;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Implementation for {@link SplashScreen}
 * @author csmith
 *
 */
public class SplashView extends Activity {

	   private static String TAG = SplashView.class.getName();
	   
	   /**
	    * Set the amount of time that the splash screen is displayed
	    */
	   private static long SLEEP_TIME = 3; 
	   ImageView image;
	 
	   @Override
	   protected void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);
	 
	      this.requestWindowFeature(Window.FEATURE_NO_TITLE);    // Removes title bar
	      this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);    // Removes notification bar
	 
	      setContentView(R.layout.layout_splash);
	      image = (ImageView)findViewById(R.id.imageView1);
	      
	       Animation animationFadeIn = AnimationUtils.loadAnimation(this, R.anim.fadein);
	       image.startAnimation(animationFadeIn);
	      // Start timer and launch main activity
	      IntentLauncher launcher = new IntentLauncher();
	      launcher.start();
	   }
	 
	   @Override
	   public void onBackPressed(){
		   return;
	   }
	   
	   private class IntentLauncher extends Thread {
	      @Override
	      /**
	       * Sleep for some time and than start new activity.
	       */
	      public void run() {
	         try {
	            // Sleeping
	            Thread.sleep(SLEEP_TIME*1000);
	         } catch (Exception e) {
	            Log.e(TAG, e.getMessage());
	         }

	         // Start main activity
	         Intent loadIntent = new Intent(SplashView.this, MockMagellanActivity.class);

	         startActivity(loadIntent);

	         SplashView.this.finish();

	      }
	   }

}
