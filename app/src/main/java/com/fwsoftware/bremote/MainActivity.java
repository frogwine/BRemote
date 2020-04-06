package com.fwsoftware.bremote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener  {
    String socketIP = "192.168.1.103";
    String socketPort = "3131";
    String message = "";

    Button toLeftButton, toRightButton, toDownButton, toUpButton;
    EditText KeyBoardText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toLeftButton = findViewById(R.id.button10);
        toRightButton = findViewById(R.id.button11);
        toUpButton = findViewById(R.id.button14);
        toDownButton = findViewById(R.id.button19);
        KeyBoardText = findViewById(R.id.editText2);

        toLeftButton.setOnTouchListener(this);
        toRightButton.setOnTouchListener(this);
        toUpButton.setOnTouchListener(this);
        toDownButton.setOnTouchListener(this);

        KeyBoardText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && keyCode == KeyEvent.KEYCODE_ENTER)
                {
                    new SendMessage().execute(socketIP, socketPort, String.valueOf(KeyBoardText.getText()));
                    return true;
                }/*
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && keyCode == KeyEvent.KEYCODE_DEL)
                {
                    new SendMessage().execute(socketIP, socketPort, "DELETE");
                }*/
                return false;
            }
        });

    }



    public void onLeftClick(View view){

        message = "LEFT_CLICK";
        new SendMessage().execute(socketIP, socketPort, message);
    }
    public void onRightClick(View view)
    {
        message = "RIGHT_CLICK";
        new SendMessage().execute(socketIP, socketPort, message);
    }
    public void onScrollUp(View view)
    {
        message = "SCROLL_UP";
        new SendMessage().execute(socketIP, socketPort, message);
    }
    public void onScrollDown(View view)
    {
        message = "SCROLL_DOWN";
        new SendMessage().execute(socketIP, socketPort, message);
    }
    public void toLeft()
    {

            message = "GO_LEFT";
            new SendMessage().execute(socketIP, socketPort, message);

    }

    public void deleteRequest(View view)
    {
        message = "DELETE";
        new SendMessage().execute(socketIP,socketPort, message);
    }

    public void toRight()
    {
        message = "GO_RIGHT";
        new SendMessage().execute(socketIP, socketPort, message);
    }
    public void toUp()
    {
        message = "GO_UP";
        new SendMessage().execute(socketIP, socketPort, message);
    }
    public void toDown()
    {
        message = "GO_DOWN";
        new SendMessage().execute(socketIP, socketPort, message);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch(v.getId()){

            case R.id.button10:
                Log.d("sa", "as");
                toLeft();
                break;
            case R.id.button11:
                toRight();
                break;
            case R.id.button14:
                toUp();
                break;
            case R.id.button19:
                toDown();
                break;
        }
        return false;
    }
}
