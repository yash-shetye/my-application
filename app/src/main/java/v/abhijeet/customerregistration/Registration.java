package v.abhijeet.customerregistration;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Registration extends AppCompatActivity {

    EditText editTextUsername, editTextEmail, editTextPassword, editTextCnfPassword,editTextMobile,editTextName;
    Button buttonRegister;
    TextView textViewLogin;
    private UserDao userDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextCnfPassword = findViewById(R.id.editTextCnfPassword);
        buttonRegister = findViewById(R.id.buttonRegister);
        editTextMobile = findViewById(R.id.editTextMobile);
        editTextName = findViewById(R.id.editTextName);



        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = editTextUsername.getText().toString().trim();
                String email = editTextEmail.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();
                String passwordConf = editTextCnfPassword.getText().toString().trim();
                String name = editTextName.getText().toString().trim();
                String mobile = editTextMobile.getText().toString().trim();




                if (userName.isEmpty()&&email.isEmpty()&&name.isEmpty()&&mobile.isEmpty()&&password.isEmpty()) {
                    editTextUsername.setError("Field cannot be empty");
                    editTextEmail.setError("Feild cannot be empty");
                    editTextName.setError("Field cannot be empty");
                    editTextMobile.setError("Feild cannot be empty");
                    editTextPassword.setError("Feild cannot be empty");


                }
                else if (password.equals(passwordConf)) {
                    User user = new User(userName,password,email);
                    userDao.insert(user);
                    Intent moveToLogin = new Intent(Registration.this, MainActivity.class);
                    startActivity(moveToLogin);
                    Toast.makeText(Registration.this, "Login Sucessfull", Toast.LENGTH_SHORT).show();

                }
                else {
                    Toast.makeText(Registration.this, "Password is not matching", Toast.LENGTH_SHORT).show();

                }


            }
        });
        userDao = Room.databaseBuilder(this, UserDataBase.class, "mi-database.db").allowMainThreadQueries()
                .build().getUserDao();
        textViewLogin = findViewById(R.id.textViewLogin);
        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Registration.this, MainActivity.class));
            }
        });

    }
}