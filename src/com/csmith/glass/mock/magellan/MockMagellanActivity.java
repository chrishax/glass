

package com.csmith.glass.mock.magellan;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * An activity that displays a mock Magellan Message 
 * and speak the current
 * alarm.
 */
public class MockMagellanActivity extends Activity
    implements  TextToSpeech.OnInitListener {

  private TextToSpeech mSpeech;
  private String messageText;
  private ImageView imgAlarm;
  private TextView txtPrompt, txtAlarm;
  
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.layout_message_wait);
    
    imgAlarm = (ImageView)findViewById(R.id.imageView1);
    txtPrompt = (TextView)findViewById(R.id.textViewPrompt);
    txtAlarm = (TextView)findViewById(R.id.textViewAlarm);
    
    mSpeech = new TextToSpeech(this, this);
    
  }

  @Override
  protected void onResume() {
    super.onResume();
  }

  @Override
  protected void onPause() {
    super.onPause();
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    mSpeech.shutdown();
  }
  

  @Override
  public boolean onKeyDown(int keyCode, KeyEvent event) {
    switch (keyCode) {
    // Handle tap events on the touchpad.
    case KeyEvent.KEYCODE_DPAD_CENTER:
    case KeyEvent.KEYCODE_ENTER:
    	receiveMessage();
      return true;
    default:
      return super.onKeyDown(keyCode, event);
    }
  }

  public boolean receiveMessage(){
	  
	  messageText = "Bed 313   Oximeter Alarm";
	  mSpeech.speak(messageText, TextToSpeech.QUEUE_FLUSH, null);
	    
	  txtPrompt.setText("");
	  txtAlarm.setVisibility(1);
	  imgAlarm.setVisibility(1);
	  return true;
  }

  
  @Override
  public void onInit(int status) {
    // Called when the text-to-speech engine is initialized; we don't need
    // to do anything here.
  }
 
@Override
public void onBackPressed(){
	super.finish();
}
  
  
}
