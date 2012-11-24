package br.com.kots.mob.complex.preferences.example;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import br.com.kots.mob.complex.preferences.ComplexPreferences;

public class ScreenActivity1 extends Activity {

	Button button;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_screen_activity1);
		
		button = (Button) findViewById(R.id.button1);
		
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				User user = new User();
				user.setName("Felipe");
				user.setAge(22);
				user.setActive(true);
				
				User user1 = new User();
				user1.setName("Adriano");
				user1.setAge(25);
				user1.setActive(false);
				
				User user2 = new User();
				user2.setName("Marcos");
				user2.setAge(23);
				user2.setActive(true);
				
				List<User> users = new ArrayList<User>();
				users.add(user);
				users.add(user1);
				users.add(user2);
								
				ListUserComplexPref complexObject = new ListUserComplexPref();
				complexObject.users = users;

				ComplexPreferences complexPrefenreces = ComplexPreferences.getComplexPreferences(getBaseContext(), "myPrefs", MODE_PRIVATE);
				complexPrefenreces.putObject("user", user);
				complexPrefenreces.putObject("list", complexObject);
				complexPrefenreces.commit();
				
				startActivity(new Intent(getBaseContext(),ScreenActivity2.class));
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_screen_activity1, menu);
		return true;
	}

}
