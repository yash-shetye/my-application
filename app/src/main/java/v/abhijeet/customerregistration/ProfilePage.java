package v.abhijeet.customerregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ProfilePage extends AppCompatActivity {
    private TextView tvUser,info;

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
        user = (User) getIntent().getSerializableExtra("User");

        tvUser = findViewById(R.id.tvUser);
        info = findViewById(R.id.info);

        if (user != null) {
            tvUser.setText(user.getEmail());
            info.setText  (user.getUserName());
        }
    }
}