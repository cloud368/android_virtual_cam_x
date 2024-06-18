package com.example.android_virtual_cam.service;

import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.Nullable;

import com.example.android_virtual_cam.R;
import com.example.android_virtual_cam.databinding.LayoutFloatingBinding;

public class FloatingService extends Service implements View.OnTouchListener, View.OnClickListener {
    private LayoutFloatingBinding binding;
    private WindowManager windowManager;
    private int initialX;
    private int initialY;
    private float initialTouchX;
    private float initialTouchY;
    private final WindowManager.LayoutParams params = new WindowManager.LayoutParams(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
            WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL,
            PixelFormat.TRANSLUCENT);

    @Override
    public void onCreate() {
        super.onCreate();
        if (Settings.canDrawOverlays(this)) {
            initFloating();
        } else {
            Log.d("没有悬浮窗权限", "s");
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // 可以在这里处理启动服务时的逻辑
        return START_STICKY;
    }


    private void initFloating() {
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.layout_floating, null, false);
        binding = LayoutFloatingBinding.bind(view);
        params.gravity = Gravity.TOP | Gravity.END;
        params.x = WindowManager.LayoutParams.WRAP_CONTENT;
        params.y = WindowManager.LayoutParams.WRAP_CONTENT;
        windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        windowManager.addView(view, params);
        binding.image.setOnClickListener(this);
        binding.visibility.setOnClickListener(this);
        binding.getRoot().setOnTouchListener(this);
        binding.play.setOnClickListener(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        windowManager.removeView(binding.getRoot());
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // 记录初始位置和触摸点坐标
                initialX = params.x;
                initialY = params.y;
                initialTouchX = event.getRawX();
                initialTouchY = event.getRawY();
                return true;
            case MotionEvent.ACTION_MOVE:
                // 根据触摸移动的距离更新悬浮窗位置
                params.x = initialX + (int) (event.getRawX() - initialTouchX);
                params.y = initialY + (int) (event.getRawY() - initialTouchY);
                windowManager.updateViewLayout(binding.getRoot(), params);
                return true;
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.visibility || v.getId() == R.id.image) {
            boolean is = binding.image.getVisibility() == View.VISIBLE;
            binding.image.setVisibility(is ? View.GONE : View.VISIBLE);
            binding.l.setVisibility(is ? View.VISIBLE : View.GONE);
        } else if (v.getId() == R.id.play) {
            String mp4 = binding.edit.getText().toString();
            Intent intent = new Intent("action_gorgon");
            intent.putExtra("mp4", mp4);
            sendBroadcast(intent);
        }
    }
}
