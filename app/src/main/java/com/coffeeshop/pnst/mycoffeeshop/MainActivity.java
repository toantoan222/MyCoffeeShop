package com.coffeeshop.pnst.mycoffeeshop;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button LoginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        ControlButton();
    }
    public void ControlButton(){
        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog=new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.login);
                Button loginbuttondialog=(Button)dialog.findViewById(R.id.loginbuttondialog);
                final EditText UNdialog=(EditText)dialog.findViewById(R.id.UNdialog);
                final EditText PWdialog=(EditText)dialog.findViewById(R.id.PWdialog);
                loginbuttondialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(UNdialog.getText().toString().length()!=0&&PWdialog.getText().toString().length()!=0) {
                            if (UNdialog.getText().toString().equals("admin") && PWdialog.getText().toString().equals("admin")) {
                                Toast.makeText(MainActivity.this, "Access granted", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(MainActivity.this, EditForm.class);
                                startActivity(i);
                            } else {
                                Toast.makeText(MainActivity.this, "Access failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else if(UNdialog.getText().toString().length()==0&&PWdialog.getText().toString().length()==0){
                            Toast.makeText(MainActivity.this,"Please input your Username and Password",Toast.LENGTH_SHORT).show();
                        }else if(UNdialog.getText().toString().length()!=0&&PWdialog.getText().toString().length()==0) {
                            Toast.makeText(MainActivity.this, "Please input your Password", Toast.LENGTH_SHORT).show();
                        }else if(UNdialog.getText().toString().length()==0&&PWdialog.getText().toString().length()!=0) {
                            Toast.makeText(MainActivity.this, "Please input your Username", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                dialog.show();
            }
        });
    }


    public void anhxa() {
        LoginButton = (Button) findViewById(R.id.LoginButton);
    }
}
