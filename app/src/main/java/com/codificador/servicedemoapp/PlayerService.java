package com.codificador.servicedemoapp;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class PlayerService extends Service {

    MediaPlayer mediaPlayer;

    public PlayerService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        switch (intent.getIntExtra(MainActivity.SERVICE_EXTRA,-1)){
            case MainActivity.PLAY_CODE:
                play();
                break;
            case MainActivity.PAUSE_CODE:
                pause();
                break;
            case MainActivity.STOP_CODE:
                stop();
                break;
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void play(){
        if(mediaPlayer != null)
//            if(!mediaPlayer.isPlaying())
            mediaPlayer.start();
        else{
            mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.audio);
            mediaPlayer.start();
        }
    }

    private void pause(){
        if(mediaPlayer != null)
            mediaPlayer.pause();
    }

    private void stop(){
        if(mediaPlayer != null){
            mediaPlayer.stop();
            mediaPlayer = null;
        }
    }
}
