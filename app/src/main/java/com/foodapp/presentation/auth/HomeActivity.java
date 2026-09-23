import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.foodapp.R;

public class HomeActivity extends AppCompatActivity {
    private TextView welcomeTextView;
    private Button investorButton;
    private Button productButton;
    private Button cartButton;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        
        welcomeTextView = findViewById(R.id.welcomeTextView);
        investorButton = findViewById(R.id.investorButton);
        productButton = findViewById(R.id.productButton);
        cartButton = findViewById(R.id.cartButton);
        
        investorButton.setOnClickListener(v -> startActivity(new android.content.Intent(this, com.foodapp.presentation.investor.InvestorActivity.class)));
        productButton.setOnClickListener(v -> startActivity(new android.content.Intent(this, com.foodapp.presentation.product.ProductActivity.class)));
        cartButton.setOnClickListener(v -> startActivity(new android.content.Intent(this, com.foodapp.presentation.user.CartActivity.class)));
    }
}