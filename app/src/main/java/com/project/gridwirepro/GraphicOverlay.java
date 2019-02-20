package com.project.gridwirepro;

import android.hardware.camera2.CameraCharacteristics;
import android.view.View;

import java.util.HashSet;
import java.util.Set;

public class GraphicOverlay  {
    private final Object lock = new Object();
    private int previewWidth;
    private float widthScaleFactor = 1.0f;
    private int previewHeight;
    private float heightScaleFactor = 1.0f;
    private int facing = CameraCharacteristics.LENS_FACING_BACK;
    private Set<Graphic> graphics = new HashSet<>();

    public abstract static class Graphic
    {
        public GraphicOverlay overlay;

        public Graphic(GraphicOverlay overlay) {
            this.overlay = overlay;
        }


    }
    public void clear() {
        synchronized (lock) {
            graphics.clear();
        }
        //postInvalidate();
    }
        public void add(Graphic graphic) {
            synchronized (lock) {
                graphics.add(graphic);
            }
            //postInvalidate();
        }
}
