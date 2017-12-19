package com.routineapp.aristaik.mydssapp14;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by AR Istaik on 12/8/2017.
 */

public class myService extends Service {

   // private  static BroadcastReceiver sBroadcastReceiver ;



    @Override

    public void onCreate() {
        super.onCreate();
        Log.d("arif","service oncreate ");
        Toast.makeText(this,"service started",Toast.LENGTH_LONG).show();

        OutgoingCallReceiver outgoingCallReceiver = new OutgoingCallReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_NEW_OUTGOING_CALL);
        this.registerReceiver(outgoingCallReceiver,filter);



      //  startReciver();
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


       return  Service.START_STICKY ;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("arif","service destroyed ");
        Toast.makeText(this,"service destroyed",Toast.LENGTH_LONG).show();
    }


    @Override
    public IBinder onBind(Intent intent) {
        return null ;
    }



    public static  class OutgoingCallReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d(com.routineapp.aristaik.mydssapp14.OutgoingCallReceiver.class.getSimpleName(), intent.toString());
            Toast.makeText(context, "Outgoing call catched!", Toast.LENGTH_LONG).show();


            if (intent.getAction().equals("android.intent.action.NEW_OUTGOING_CALL")) {
                Toast.makeText(context,"dialed",Toast.LENGTH_LONG).show();
                String number=intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
                Log.e("Number=",number);
                if(number.equals("1994")) {
                    Intent i = new Intent(context,MainActivity.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(i);
                    Toast.makeText(context, "welcome ", Toast.LENGTH_LONG).show();
                }
            }
            //TODO: Handle outgoing call event here
        }
    }


}
