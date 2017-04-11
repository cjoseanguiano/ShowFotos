package com.devix.www.showfotos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

import droidninja.filepicker.FilePickerBuilder;
import ly.kite.photopicker.DeviceFolderActivity;
import ly.kite.photopicker.Photo;
import ly.kite.photopicker.PhotoPicker;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_PHOTO_PICKER = 99;

    ArrayList<String> fileLocalPath = new ArrayList<String>();
    GridView gridView;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupToolbar();

        gridView = (GridView) findViewById(R.id.gv);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                fileLocalPath.clear();
//                FilePickerBuilder.getInstance().setMaxCount(5).
//                        setSelectedFiles(fileLocalPath).
//                        setActivityTheme(R.style.AppTheme).
//                        pickPhoto(MainActivity.this);

                PhotoPicker.startPhotoPickerForResult(MainActivity.this, REQUEST_CODE_PHOTO_PICKER);

             }
        });
    }

    private void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.show();
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_PHOTO_PICKER) {
            if (resultCode == Activity.RESULT_OK) {
                Photo[] photos = PhotoPicker.getResultPhotos(data);
                Toast.makeText(this, "User selected " + photos.length + " photos", Toast.LENGTH_SHORT).show();
                for (Photo photo : photos) {
                    Log.i("dbotha", "URI: " + photo.getUri());
                }
            } else if (resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(this, "Photo Picking Cancelled", Toast.LENGTH_SHORT).show();
            } else {
                Log.i("dbotha", "Unknown result code: " + resultCode);
            }
        }
    }
}
