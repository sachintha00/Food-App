package com.smd.foodmaster.ui.slideshow;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import com.blogspot.atifsoftwares.circularimageview.CircularImageView;
import com.smd.foodmaster.Classes.StringFormatter;
import com.smd.foodmaster.Database.DBhandler;
import com.smd.foodmaster.R;
import com.smd.foodmaster.UserAthunEdit;
import com.smd.foodmaster.UserPrivacyEdit;
import com.smd.foodmaster.databinding.FragmentSlideshowBinding;
import com.smd.foodmaster.userMainActivity;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.util.List;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;
    private FragmentSlideshowBinding binding;

    private CircularImageView profileDp;
    RelativeLayout privacyEdit,authenticationEdit;
    TextView name;

    private static final int CAMERA_REQUEST_CODE = 100;
    private static final int STORAGE_REQUEST_CODE = 101;

    private static final int IMAGE_PICK_CAMERA = 102;
    private static final int IMAGE_PICK_GALLERY = 103;

//    permission array
    private String[] cameraPermission; //camera and storage permission
    private String[] storagePermission; //only storage permission

    private Uri imageUri;

    Runnable mTicker;

    @SuppressLint("SetTextI18n")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

//        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
//        View root = binding.getRoot();

        DBhandler db = new DBhandler(getActivity());
        List<String> userInfo = db.readUser(userMainActivity.passRollId);

        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        profileDp = (CircularImageView) root.findViewById(R.id.profile_dp);
        privacyEdit = (RelativeLayout) root.findViewById(R.id.privacy_details);
        authenticationEdit = (RelativeLayout) root.findViewById(R.id.authentication_details);
        name = (TextView) root.findViewById(R.id.name);

//        name.setText(userInfo.get(0)+" "+userInfo.get(1));
//        final Handler mHandler = new Handler();
//        mTicker = new Runnable() {
//            @Override
//            public void run() {
//
//                name.setText(StringFormatter.capitalizeWord(userInfo.get(0))+" "+StringFormatter.capitalizeWord(userInfo.get(1)));
//                mHandler.postDelayed(mTicker, 10);
//
//            }
//        };
//
//        mHandler.postDelayed(mTicker, 10);
        name.setText(StringFormatter.capitalizeWord(userInfo.get(0))+" "+StringFormatter.capitalizeWord(userInfo.get(1)));

        cameraPermission = new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};
        storagePermission = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE};

        profileDp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imagePickDialog();
            }
        });
        privacyEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent userPrivacy = new Intent(getActivity(), UserPrivacyEdit.class);
                startActivity(userPrivacy);
            }
        });
        authenticationEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent userAuth = new Intent(getActivity(), UserAthunEdit.class);
                startActivity(userAuth);
            }
        });

        return root;
    }

    private void imagePickDialog(){
        String[] options = {"Camera","Gallery"};
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Pick a image");

        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(i==0){
                    if(!checkCameraPermission()){
                        requestCameraPermission();
                    }
                    else{
                        pickFromCamera();
                    }
                }else if(i==1){
                    if(!checkStoragePermission()){
                        requestStoragePermission();
                    }
                    else{
                        pickFromGallery();
                    }
                }
            }
        });

        builder.create().show();
    }

    private void pickFromCamera(){
        ContentValues contentValues = new ContentValues();
        contentValues.put(MediaStore.Images.Media.TITLE,"Image Title");
        contentValues.put(MediaStore.Images.Media.DESCRIPTION,"Image Description");

        imageUri =  getActivity().getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,contentValues);

        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
        startActivityForResult(cameraIntent,IMAGE_PICK_CAMERA);
    }
    private void pickFromGallery(){
        Intent galleryIntent = new Intent(Intent.ACTION_PICK);
        galleryIntent.setType("image/*");
        startActivityForResult(galleryIntent,IMAGE_PICK_GALLERY);
    }

    private boolean checkStoragePermission(){
        boolean result = ContextCompat.checkSelfPermission(getActivity(),Manifest.permission.WRITE_EXTERNAL_STORAGE) == (PackageManager.PERMISSION_GRANTED);
        return result;
    }

    private void requestStoragePermission(){
        ActivityCompat.requestPermissions(getActivity(),storagePermission,STORAGE_REQUEST_CODE);
    }

    private boolean checkCameraPermission(){
        boolean result = ContextCompat.checkSelfPermission(getActivity(),Manifest.permission.CAMERA) == (PackageManager.PERMISSION_GRANTED);
        boolean result1 = ContextCompat.checkSelfPermission(getActivity(),Manifest.permission.WRITE_EXTERNAL_STORAGE) == (PackageManager.PERMISSION_GRANTED);
        return result && result1;
    }

    private void requestCameraPermission(){
        ActivityCompat.requestPermissions(getActivity(),cameraPermission,CAMERA_REQUEST_CODE);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        
        switch(requestCode){
            case CAMERA_REQUEST_CODE:{
                if(grantResults.length>0){
                    boolean cameraAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    boolean storageAccepted = grantResults[1] == PackageManager.PERMISSION_GRANTED;

                    if(cameraAccepted && storageAccepted){
                        pickFromCamera();
                    }
                    else{
                        Toast.makeText(getActivity(), "Camera & Storage permission are required", Toast.LENGTH_SHORT).show();
                    }
                }
            }
            break;
            case STORAGE_REQUEST_CODE:{
                if(grantResults.length>0){
                    boolean storageAccepted = grantResults[0]== PackageManager.PERMISSION_GRANTED;
                    if(storageAccepted){
                        pickFromGallery();
                    }
                    else{
                        Toast.makeText(getActivity(), "Storage permission is required...", Toast.LENGTH_SHORT).show();
                    }
                }
            }
            break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if(resultCode == Activity.RESULT_OK){

            if(requestCode == IMAGE_PICK_GALLERY){

                Toast.makeText(getActivity(), "in crop image", Toast.LENGTH_SHORT).show();

                CropImage.activity(data.getData())
                .setGuidelines(CropImageView.Guidelines.ON)
                .setAspectRatio(1,1)
                .start(getActivity());
            }
            else if(requestCode == IMAGE_PICK_CAMERA){

                CropImage.activity(imageUri)
                        .setGuidelines(CropImageView.Guidelines.ON)
                        .setAspectRatio(1,1)
                        .start(getActivity());
            }
            else if(requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE){
                Toast.makeText(getActivity(), "in crop image", Toast.LENGTH_SHORT).show();
                CropImage.ActivityResult result = CropImage.getActivityResult(data);
                if(resultCode == Activity.RESULT_OK){
                    Toast.makeText(getActivity(), "uri", Toast.LENGTH_SHORT).show();
                    Uri resultUri = result.getUri();
                    imageUri = resultUri;
                    profileDp.setImageURI(resultUri);
                }
                else if(resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE){
                    Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}