package com.example.android_virtual_cam;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.OutputConfiguration;
import android.hardware.camera2.params.SessionConfiguration;
import android.media.MediaPlayer;
import android.view.Surface;
import android.view.SurfaceHolder;

import androidx.media3.exoplayer.ExoPlayer;

public class Storage {
    public Surface c2_preview_Surfcae;
    public Surface c2_preview_Surfcae_1;
    public Surface c2_reader_Surfcae;
    public Surface c2_reader_Surfcae_1;
    public ExoPlayer c2_player;
    public ExoPlayer c2_player_1;
    public Surface c2_virtual_surface;
    public SurfaceTexture c2_virtual_surfaceTexture;
    public boolean need_recreate;
    public CameraDevice.StateCallback c2_state_cb;
    public CaptureRequest.Builder c2_builder;
    public Context toast_content;
    public String mp4;
    public volatile byte[] data_buffer = {0};

    public Surface mSurface;
    public SurfaceTexture mSurfacetexture;
    public MediaPlayer mMediaPlayer;
    public SurfaceTexture fake_SurfaceTexture;
    public Camera origin_preview_camera;

    public Camera camera_onPreviewFrame;
    public Camera start_preview_camera;
    public byte[] input;
    public int mhight;
    public int mwidth;
    public boolean is_someone_playing;
    public boolean is_hooked;
    public VideoToFrames hw_decode_obj;
    public VideoToFrames c2_hw_decode_obj;
    public VideoToFrames c2_hw_decode_obj_1;
    public SurfaceTexture c1_fake_texture;
    public Surface c1_fake_surface;
    public SurfaceHolder ori_holder;
    public MediaPlayer mplayer1;
    public Camera mcamera1;
    public int imageReaderFormat = 0;
    public boolean is_first_hook_build = true;

    public int onemhight;
    public int onemwidth;
    public Class camera_callback_calss;

    public SessionConfiguration fake_sessionConfiguration;
    public SessionConfiguration sessionConfiguration;
    public OutputConfiguration outputConfiguration;
    public boolean need_to_show_toast = true;

    public int c2_ori_width = 1280;
    public int c2_ori_height = 720;

    public Class c2_state_callback;


    public static Storage getInstance() {
        return My.getStorage();
    }

    public Surface getC2_preview_Surfcae() {
        return c2_preview_Surfcae;
    }

    public Surface getC2_preview_Surfcae_1() {
        return c2_preview_Surfcae_1;
    }

    public Surface getC2_reader_Surfcae() {
        return c2_reader_Surfcae;
    }

    public Surface getC2_reader_Surfcae_1() {
        return c2_reader_Surfcae_1;
    }

    public ExoPlayer getC2_player() {
        return c2_player;
    }

    public ExoPlayer getC2_player_1() {
        return c2_player_1;
    }

    public Surface getC2_virtual_surface() {
        return c2_virtual_surface;
    }

    public SurfaceTexture getC2_virtual_surfaceTexture() {
        return c2_virtual_surfaceTexture;
    }

    public boolean isNeed_recreate() {
        return need_recreate;
    }

    public CameraDevice.StateCallback getC2_state_cb() {
        return c2_state_cb;
    }

    public CaptureRequest.Builder getC2_builder() {
        return c2_builder;
    }

    public Context getToast_content() {
        return toast_content;
    }

    public String getMp4() {
        return mp4;
    }

    public Storage setC2_preview_Surfcae(Surface c2_preview_Surfcae) {
        this.c2_preview_Surfcae = c2_preview_Surfcae;
        return this;
    }

    public Storage setC2_preview_Surfcae_1(Surface c2_preview_Surfcae_1) {
        this.c2_preview_Surfcae_1 = c2_preview_Surfcae_1;
        return this;
    }

    public Storage setC2_reader_Surfcae(Surface c2_reader_Surfcae) {
        this.c2_reader_Surfcae = c2_reader_Surfcae;
        return this;
    }

    public Storage setC2_reader_Surfcae_1(Surface c2_reader_Surfcae_1) {
        this.c2_reader_Surfcae_1 = c2_reader_Surfcae_1;
        return this;
    }

    public Storage setC2_player(ExoPlayer c2_player) {
        this.c2_player = c2_player;
        return this;
    }

    public Storage setC2_player_1(ExoPlayer c2_player_1) {
        this.c2_player_1 = c2_player_1;
        return this;
    }

    public Storage setC2_virtual_surface(Surface c2_virtual_surface) {
        this.c2_virtual_surface = c2_virtual_surface;
        return this;
    }

    public Storage setC2_virtual_surfaceTexture(SurfaceTexture c2_virtual_surfaceTexture) {
        this.c2_virtual_surfaceTexture = c2_virtual_surfaceTexture;
        return this;
    }

    public Storage setNeed_recreate(boolean need_recreate) {
        this.need_recreate = need_recreate;
        return this;
    }

    public Storage setC2_state_cb(CameraDevice.StateCallback c2_state_cb) {
        this.c2_state_cb = c2_state_cb;
        return this;
    }

    public Storage setC2_builder(CaptureRequest.Builder c2_builder) {
        this.c2_builder = c2_builder;
        return this;
    }

    public Storage setToast_content(Context toast_content) {
        this.toast_content = toast_content;
        return this;
    }

    public Storage setMp4(String mp4) {
        this.mp4 = mp4;
        return this;
    }

    private static class My {
        public static Storage storage;

        public static Storage getStorage() {
            if (storage == null) {
                storage = new Storage();
            }
            return storage;
        }
    }
}
