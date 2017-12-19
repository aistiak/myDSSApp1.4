package com.routineapp.aristaik.mydssapp14;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int MY_PERMISSION_REQUEST = 0;
    private Button Startbutton ;
    private Button StopButton ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Startbutton =  (Button) findViewById(R.id.start_button);
        StopButton = (Button) findViewById(R.id.stop_button);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode,String[] permissions,int[] grantResults) {
         switch (requestCode) {
             case MY_PERMISSION_REQUEST: {
                  if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                      // permission was granted
                      Toast.makeText(this,"pemission was granted",Toast.LENGTH_LONG).show();
                      Log.d("arif","permission was granted for  out going calls ");
                      Intent i = new Intent(this,myService.class);
                      startService(i);
                  }else{

                      Log.d("arif","permission was not granted for out going calls ") ;
                  }
             }

         }
    }

    public void StartMethod(View v){


        if(ContextCompat.checkSelfPermission(this, Manifest.permission.PROCESS_OUTGOING_CALLS)!= PackageManager.PERMISSION_GRANTED)
        {
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.PROCESS_OUTGOING_CALLS)){

            }else {

                ActivityCompat.requestPermissions(this,new String[] {Manifest.permission.PROCESS_OUTGOING_CALLS},MY_PERMISSION_REQUEST);




            }
        }
   /*     Intent i = new Intent(this,myService.class);
        startService(i);*/


    }
    public void StopMethod(View v){
        Intent i = new Intent(this,myService.class);
        stopService(i);
    }
}
