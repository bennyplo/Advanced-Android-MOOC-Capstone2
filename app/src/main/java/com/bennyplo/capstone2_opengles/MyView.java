package com.bennyplo.capstone2_opengles;

import android.content.Context;
import android.opengl.GLSurfaceView;

import java.util.Timer;
import java.util.TimerTask;

public class MyView extends GLSurfaceView {
    private final MyRenderer mRenderer;
    public MyView(Context context) {
        super(context);
        setEGLContextClientVersion(2);// Create an OpenGL ES 2.0 context.
        mRenderer = new MyRenderer();// Set the Renderer for drawing on the GLSurfaceView
        setRenderer(mRenderer);
        // Render the view only when there is a change in the drawing data
        setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);


        Timer timer=new Timer();
        final MyView thisview=this;
        TimerTask task= new TimerTask() {
            double pangle=0;
            @Override
            public void run() {
                thisview.invalidate();
                pangle+=10;
            }
        };
        timer.scheduleAtFixedRate(task,1000,100);
    }
}
