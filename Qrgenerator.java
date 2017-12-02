package com.example.saravanan.qrcodegenerator;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class MainActivity extends AppCompatActivity {
EditText edit;
Button button;
ImageView imageView;
String texttoqr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit=findViewById(R.id.text1);
        button=findViewById(R.id.bt);
        imageView=findViewById(R.id.image);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MultiFormatWriter multiFormatWriter=new MultiFormatWriter();
                try
                {

                    texttoqr=edit.getText().toString().trim();
                    BitMatrix bitMatrix=multiFormatWriter.encode(texttoqr, BarcodeFormat.QR_CODE,2000,2000);
                    BarcodeEncoder barcodeEncoder=new BarcodeEncoder();
                    Bitmap bitmap=barcodeEncoder.createBitmap(bitMatrix);
                    imageView.setImageBitmap(bitmap);
                }
                catch (WriterException e)
                {
                e.printStackTrace();
                }
            }
        });
    }
}
