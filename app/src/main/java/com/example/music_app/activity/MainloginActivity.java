package com.example.music_app.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.music_app.R;

public class MainloginActivity extends AppCompatActivity {
    EditText edtuser, edtpassword;
    Button btndangky, btndangnhap, btnthoat;
    String ten, mk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_login);
        Anhxa();
        ControlButton();
    }
    private void ControlButton() {
        btnthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainloginActivity.this,android.R.style.Theme_DeviceDefault_Light_Dialog);
                builder.setTitle("Bạn muốn thoát khỏi app?");
                builder.setMessage("Hãy lựa chọn bên dưới để xác nhận");
                builder.setIcon(android.R.drawable.ic_dialog_alert);
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        onBackPressed();
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();

            }
        });
        btndangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(MainloginActivity.this);
                dialog.setTitle("Hộp thoại xử lí");
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.customdialog);
                EditText edttk = (EditText)dialog.findViewById(R.id.edttk);
                EditText edtmk = (EditText)dialog.findViewById(R.id.edtmk);
                Button btnhuy = (Button)dialog.findViewById(R.id.buttonhuy);
                Button btnok = (Button)dialog.findViewById(R.id.buttonok);
                btnok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ten = edttk.getText().toString().trim();
                        mk = edtmk.getText().toString().trim();

                        edtuser.setText(ten);
                        edtpassword.setText(mk);

                        dialog.cancel();

                    }
                });
                btnhuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.cancel();
                    }
                });
                dialog.show();
            }
        });
        btndangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtuser.getText().length() !=0 && edtpassword.getText().length() !=0) {
                    if (edtuser.getText().toString().equals(ten) && edtpassword.getText().toString().equals(mk)) {
                        Toast.makeText(MainloginActivity.this, "Bạn đã đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainloginActivity.this, MainActivity.class);
                        startActivity(intent);
                    } else if (edtuser.getText().toString().equals("thao") && edtpassword.getText().toString().equals("123")){
                        Toast.makeText(MainloginActivity.this, "Bạn đã đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainloginActivity.this, MainActivity.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(MainloginActivity.this, "Bạn đã đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(MainloginActivity.this, "Mời bạn nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                }



            }
        });
    }

    private void Anhxa() {
        edtuser = (EditText)findViewById(R.id.edittextuser);
        edtpassword = (EditText)findViewById(R.id.edittextpassword);
        btndangnhap = (Button)findViewById(R.id.buttondangnhap);
        btndangky = (Button)findViewById(R.id.buttondangky);
        btnthoat = (Button)findViewById(R.id.buttonthoat);
    }
}