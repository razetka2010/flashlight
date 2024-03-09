package ru.da.myapplication;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;

public class FlachClass {
    private final Context context;
    private boolean isOn = false;


    public FlachClass(Context context){
        this.context = context;
    }

    public void flashOn (){
        CameraManager cm = (CameraManager) context.getSystemService(Context.CAMERA_SERVICE);
        try {
            String cameraid = cm.getCameraIdList()[0];
            cm.setTorchMode(cameraid, true);
            isOn = true;
        } catch (CameraAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public  void flashOff() {
        CameraManager cm = (CameraManager) context.getSystemService(Context.CAMERA_SERVICE);
        try {
            String cameraid = cm.getCameraIdList()[0];
            cm.setTorchMode(cameraid, false);
            isOn = false;
        } catch (CameraAccessException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean status() {
        return isOn;
    }
}



