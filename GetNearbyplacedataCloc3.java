package com.sandbox.mobilemech;

import android.os.AsyncTask;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class GetNearbyplacedataCloc3 extends AsyncTask<Object,String,String> {

    String googlePlaceData;
    GoogleMap googleMap;
    String url;
    @Override
    protected String doInBackground(Object... objects) {
        googleMap=(GoogleMap) objects[0];
        url=(String) objects[1];

        DownloadURLCloc2 downloadURLCloc2 =new DownloadURLCloc2();
        try {
            googlePlaceData= downloadURLCloc2.readUrl(url);
        }catch (IOException e){
            e.printStackTrace();
        }
        return googlePlaceData;
    }

    @Override
    protected void onPostExecute(String s) {

        try {
            JSONObject parentObject = new JSONObject(s);
            JSONArray resultArray=parentObject.getJSONArray("results");
            for (int i=0; i < resultArray.length() ;i++){
                JSONObject jsonObject =resultArray.getJSONObject(i);
                JSONObject locationObj=jsonObject.getJSONObject("geometry").getJSONObject("location");

                String lattitude =locationObj.getString("lat");
                String longitude =locationObj.getString("lng");

                JSONObject nameObject = resultArray.getJSONObject(i);

                String name=nameObject.getString("name");

                LatLng latLng=new LatLng(Double.parseDouble(lattitude),Double.parseDouble(longitude));


                MarkerOptions markerOptions=new MarkerOptions();
                markerOptions.title(name);
                markerOptions.position(latLng);

                googleMap.addMarker(markerOptions);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
