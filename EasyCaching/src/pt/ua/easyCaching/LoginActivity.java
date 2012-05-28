package pt.ua.easyCaching;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class LoginActivity extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        
        Button userButton = (Button) findViewById(R.id.login_user);
        Button juriButton = (Button) findViewById(R.id.login_juri);
        
        userButton.setOnClickListener(this);
        juriButton.setOnClickListener(this);
    }
    
    public void onClick(View v) {
    	
    	if(v.getId() == R.id.login_user)
    		startActivity(new Intent(LoginActivity.this, MenuUserActivity.class));
    	
    	else if(v.getId() == R.id.login_juri)
    		startActivity(new Intent(LoginActivity.this, MenuJuriActivity.class));
    	
    }
    
}