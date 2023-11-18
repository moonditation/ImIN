package com.example.ssainfeproject2;

import android.location.LocationRequest;

import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;

public class GoogleMapGetMyLocation {
    private FusedLocationProviderClient mFusedLocationClient;
    private LocationRequest locationRequest;
    private int locationRequestCode = 1000;
    private double wayLatitude = 0.0, wayLongitude = 0.0;
    private boolean isContinue = false;
    public static final int DEFAULT_LOCATION_REQUEST_PRIORITY = LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY;
    public static final long DEFAULT_LOCATION_REQUEST_INTERVAL = 20000L;      //20초 사이
    public static final long DEFAULT_LOCATION_REQUEST_FAST_INTERVAL = 10000L; //10초에서

    mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this); //위치 정보를 제공하는 클라이언트 객체

    private void getLocation() {
// LocationRequest를 빌더 패턴으로 생성
        LocationRequest locationRequest = new LocationRequest.Builder()
                .setPriority(LocationRequest.QUALITY_HIGH_ACCURACY) // 위치 정밀도 설정
                .setInterval(DEFAULT_LOCATION_REQUEST_INTERVAL) // 위치 업데이트 시간 간격을 밀리초 단위로 설정
                .setFastestInterval(DEFAULT_LOCATION_REQUEST_FAST_INTERVAL) // 가장 빠른 위치 업데이트 시간 간격 설정
                .build(); // LocationRequest 객체 생성

        //앱에 위치 권한이 있는 없는 경우
        if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
                    locationRequestCode);//위치권한 요청

        } else {    //이미 앱에 위치 권한이 있는 경우
            if (isContinue) {
                mFusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, null); //Request객체를 전달하고 그 결과를 콜백함수에서 전달 받는다
            } else {
                mFusedLocationClient.getLastLocation().addOnSuccessListener(MainActivity.this, location -> {
                    if (location != null) {
                        wayLatitude = location.getLatitude();
                        wayLongitude = location.getLongitude();
                    } else {
                        mFusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, null);
                    }
                });
            }
        }
    }
}
