import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.foodapp.R;

public class MainActivity extends AppCompatActivity {
    private EditText emailEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private TextView statusTextView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);
        statusTextView = findViewById(R.id.statusTextView);
        
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                loginUser(email, password);
            }
        });
    }
    
    private void loginUser(String email, String password) {
        // This is a simplified login - in a real app, this would be handled by the ViewModel
        if (email.equals("admin@foodapp.com") && password.equals("admin123")) {
            statusTextView.setText("Login successful!\nRedirecting to main app...");
            new android.os.Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(MainActivity.this, HomeActivity.class));
                    finish();
                }
            }, 2000);
        } else {
            statusTextView.setText("Invalid credentials. Try: admin@foodapp.com / admin123");
        }
    }
}