package com.project.gridwirepro;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Paint;

import com.google.firebase.ml.vision.document.FirebaseVisionDocumentText;
import java.util.List;

class CloudTextGraphic {
    private static final int TEXT_COLOR = Color.GREEN;
    private static final float TEXT_SIZE = 60.0f;
    private static final float STROKE_WIDTH = 5.0f;

    private final Paint rectPaint;
    private final Paint textPaint;
    private final FirebaseVisionDocumentText.Word word;
    private final GraphicOverlay overlay;

    CloudTextGraphic(GraphicOverlay overlay , FirebaseVisionDocumentText.Word word) {
       // super(overlay);

        this.word = word;
        this.overlay = overlay;

        rectPaint = new Paint();
        rectPaint.setColor(TEXT_COLOR);
        rectPaint.setStyle(Paint.Style.STROKE);
        rectPaint.setStrokeWidth(STROKE_WIDTH);

        textPaint = new Paint();
        textPaint.setColor(TEXT_COLOR);
        textPaint.setTextSize(TEXT_SIZE);
        // Redraw the overlay, as this graphic has been added.

    }
}
