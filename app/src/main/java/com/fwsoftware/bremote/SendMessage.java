package com.fwsoftware.bremote;

import android.os.AsyncTask;
import android.util.Log;

import java.io.DataOutputStream;
import java.net.Socket;

public class SendMessage extends AsyncTask<String, Void, Void> {

    @Override
    protected Void doInBackground(String... strings) {
        String Destination = strings[0];
        int port = Integer.parseInt(strings[1]);
        String message = strings[2];
        Log.d("LOG", strings[0] + strings[1] + strings[2]);
        try {
            Socket s = new Socket(Destination, port);
            DataOutputStream dOut = new DataOutputStream(s.getOutputStream());
            dOut.writeChars(message);
            dOut.writeByte(1);
            dOut.flush();
            dOut.close();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
}

