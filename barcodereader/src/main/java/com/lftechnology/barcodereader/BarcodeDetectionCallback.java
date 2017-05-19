package com.lftechnology.barcodereader;

import com.google.android.gms.vision.barcode.Barcode;

public interface BarcodeDetectionCallback {
    void onDetected(Barcode barcode);
}
