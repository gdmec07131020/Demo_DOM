package cn.edu.gdmec.s07131020.demo_dom;

import java.io.IOException;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
	try {
		List<User> users=DOMXMLParser.parse(getAssets().open("users.xml"));
		for(User user : users){
		Log.i("info",user.toString());
		
		}
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	}



}
