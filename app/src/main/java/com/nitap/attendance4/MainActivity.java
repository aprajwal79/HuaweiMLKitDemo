package com.nitap.attendance4;

import android.Manifest;
import android.graphics.Rect;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.huawei.hms.mlsdk.livenessdetection.MLLivenessCapture;
import com.huawei.hms.mlsdk.livenessdetection.MLLivenessCaptureResult;
import com.huawei.hms.mlsdk.livenessdetection.MLLivenessDetectView;
import com.huawei.hms.mlsdk.livenessdetection.OnMLLivenessDetectCallback;

public class MainActivity extends AppCompatActivity {

    MLLivenessCapture.Callback callback;
    MLLivenessCapture.Callback callback2;
    MLLivenessCapture capture,capture2 ;

    MLLivenessDetectView mlLivenessDetectView;
    FrameLayout mPreviewContainer;
    ImageView img_back;
    Bundle savedInstanceStateGlobal = null;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        savedInstanceStateGlobal = savedInstanceState;

        //getWindow().setWindowAnimations();
        requestPermissions(new String[]{Manifest.permission_group.CAMERA,Manifest.permission_group.STORAGE},0);
       // capture = MLLivenessCapture.getInstance();
       // capture2 = MLLivenessCapture.getInstance();

        //CUSTOM 2
        mPreviewContainer = findViewById(R.id.surface_layout);
        img_back=findViewById(R.id.img_back);
        img_back.setOnClickListener(v -> finish());
        // Obtain MLLivenessDetectView
        mlLivenessDetectView = new MLLivenessDetectView.Builder()
                .setContext(this)
                //.setOptions(MLLivenessDetectView.DETECT_MASK) // set Rect of face frame relative to surface in layout
                .setFaceFrameRect(new Rect(0, 0,0 , 200))
                .setDetectCallback(new OnMLLivenessDetectCallback() {
                                       @Override
                                       public void onCompleted(MLLivenessCaptureResult mlLivenessCaptureResult) {
                                           Toast.makeText(MainActivity.this, mlLivenessCaptureResult.toString(), Toast.LENGTH_SHORT).show();
                                           refresh();
                                           // finish();
                                       }

                                       @Override
                                       public void onError(int i) {
                                           Toast.makeText(MainActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
                                       }

                                       @Override
                                       public void onStateChange(int i, Bundle bundle) {

                                       }

                                       @Override
                                       public void onInfo(int i, Bundle bundle) {

                                       }
                                   }


                ).build();
        mPreviewContainer.removeAllViews();
        mPreviewContainer.addView(mlLivenessDetectView);
        mlLivenessDetectView.onCreate(savedInstanceState);



/*
          callback = new MLLivenessCapture.Callback() {
            @Override
            public void onSuccess(MLLivenessCaptureResult result) {
                // Processing logic when the verification is successful. The verification result indicates whether the face is of a real person.
                //capture2.startDetect(MainActivity.this,callback2);
               // startActivity(new Intent(MainActivity.this,MainActivity.class));
                capture.startDetect(MainActivity.this,(MLLivenessCapture.Callback) this);
                 Toast.makeText(MainActivity.this, "LIVE?: " + result.isLive() + ", " +  (int)result.getScore(), Toast.LENGTH_SHORT).show();
                ImageView img = findViewById(R.id.img);
                img.setImageBitmap(result.getBitmap());
            }

            @Override
            public void onFailure(int errorCode) {
                // Processing logic when the verification fails. For example, the camera is abnormal (CAMERA_ERROR).
                Toast.makeText(getApplicationContext(),"ERR: "+errorCode,Toast.LENGTH_SHORT).show();
            }
        };
*/
        //  capture = MLLivenessCapture.getInstance();



       /*  callback2 = new MLLivenessCapture.Callback() {
            @Override
            public void onSuccess(MLLivenessCaptureResult result) {
                // Processing logic when the verification is successful. The verification result indicates whether the face is of a real person.
                capture.startDetect(MainActivity.this,callback);

                /* Toast.makeText(MainActivity.this, "LIVE?: " + result.isLive() + ", " + result.toString(), Toast.LENGTH_SHORT).show();
                ImageView img = findViewById(R.id.img);
                img.setImageBitmap(result.getBitmap());
            }

            // @Ov erride
            public void onFailure(int errorCode) {
                // Processing logic when the verification fails. For example, the camera is abnormal (CAMERA_ERROR).
                Toast.makeText(getApplicationContext(),"ERR: "+errorCode,Toast.LENGTH_SHORT).show();
            }
        };*/

        //CUSTOM

        /**
         *i. Bind the camera preview screen to the remote view and set the liveness detection area.
         * In the camera preview stream, the static biometric verification service determines whether a face is in the middle of the image. To improve the pass rate, you are advised to place the face frame in the middle of the screen and set the verification area to be slightly larger than the face frame.
         *ii. Set whether to detect the mask.
         *ii. Set the result callback.
         *iii. Load the MLLivenessDetectView to the activity. The sample code is as follows:
         */

           // mPreviewContainer = findViewById(R.id.surface_layout);
            //ObtainLLivenessDetectView

           /* mlLivenessDetectView = new MLLivenessDetectView.Builder()
                    .setContext(this)
                    // Set whether to perform mask detection.
                    .setOptions(MLLivenessDetectView.DETECT_MASK)
                    // Set the rectangle of the face frame relative to MLLivenessDetectView.
                    .setFaceFrameRect(new Rect(0, 0, 0, 200))
                    // Set the result callback.
                    .setDetectCallback(new OnMLLivenessDetectCallback() {
                        @Override
                        public void onCompleted(MLLivenessCaptureResult result) {
                            // Callback when the verification is complete.
                            Toast.makeText(MainActivity.this, result.toString() , Toast.LENGTH_SHORT).show();

                        }

                        @Override
                        public void onError(int error) {
                            // Callback when an error occurs during verification.
                            Toast.makeText(MainActivity.this, "ERR: "+ error, Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onInfo(int infoCode, Bundle bundle) {
                            // Callback when the verification prompt message is received.
                            // if(infoCode==MLLivenessDetectInfo.NO_FACE_WAS_DETECTED){
                            // No face is detected.
                            // }
                            // ...
                        }

                        @Override
                        public void onStateChange(int state, Bundle bundle) {
                            // Callback when the verification status changes.
                            // if(state==MLLivenessDetectStates.START_DETECT_FACE){
                            // Start face detection.
                            // }
                            // ...
                        }
                    }).build();

            */
            //mPreviewContainer.addView(mlLivenessDetectView);
            //mlLivenessDetectView.onCreate(savedInstanceState);
            //mlLivenessDetectView.onResume();

        }

    public void refresh() {
       // mlLivenessDetectView.onDestroy();
        mlLivenessDetectView = new MLLivenessDetectView.Builder()
                .setContext(this)
                //.setOptions(MLLivenessDetectView.DETECT_MASK) // set Rect of face frame relative to surface in layout
                .setFaceFrameRect(new Rect(0, 0,0 , 200))
                .setDetectCallback(new OnMLLivenessDetectCallback() {
                                       @Override
                                       public void onCompleted(MLLivenessCaptureResult mlLivenessCaptureResult) {
                                           Toast.makeText(MainActivity.this, mlLivenessCaptureResult.toString(), Toast.LENGTH_SHORT).show();
                                           refresh();
                                           // finish();
                                       }

                                       @Override
                                       public void onError(int i) {
                                           Toast.makeText(MainActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
                                       }

                                       @Override
                                       public void onStateChange(int i, Bundle bundle) {

                                       }

                                       @Override
                                       public void onInfo(int i, Bundle bundle) {

                                       }
                                   }


                ).build();
        //mPreviewContainer.removeAllViews();
        mPreviewContainer.addView(mlLivenessDetectView);
        mlLivenessDetectView.onCreate(savedInstanceStateGlobal);
        mlLivenessDetectView.onStart();
        mlLivenessDetectView.onResume();
    }


    public void call() {
        capture.startDetect(this,callback);
    }

    @Override
    protected void onResume() {
        super.onResume();
//        capture.startDetect(MainActivity.this,callback);
        mlLivenessDetectView.onResume();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mlLivenessDetectView.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mlLivenessDetectView.onPause();
    }



    @Override
    protected void onStart() {
        super.onStart();
        mlLivenessDetectView.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mlLivenessDetectView.onStop();
    }


}