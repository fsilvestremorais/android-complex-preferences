package br.com.kots.mob.complex.preferences.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import br.com.kots.mob.complex.preferences.ComplexPreferences;

public class ScreenActivity2 extends Activity {

	TextView textView;
	ListView listView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_screen_activity2);
		
		textView = (TextView) findViewById(R.id.textView1);
		listView = (ListView) findViewById(R.id.listView1);
		
		ComplexPreferences complexPreferences = ComplexPreferences.getComplexPreferences(this, "myPrefs", MODE_PRIVATE);
		User user = complexPreferences.getObject("user", User.class);
		
		ListUserComplexPref complexObject = complexPreferences.getObject("list", ListUserComplexPref.class);
		
		String[] arrayUsers = new String[complexObject.users.size()];
		
		int i = 0;
		for(User item : complexObject.users){
			arrayUsers[i] = item.getName();
			i++;
		}
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayUsers);
		listView.setAdapter(adapter);
		
		textView.setText(""+user);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_screen_activity1, menu);
		return true;
	}

}
