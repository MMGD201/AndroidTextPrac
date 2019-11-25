package com.example.myapplication;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class PmTask extends AsyncTask<String,Void,String> {

    private Activity activity;
    private ListView listView;
    private ArrayList<PmItem> list;

    public PmTask(Activity activity1, ListView listView1){
        activity=activity1;
        listView=listView1;
    }

    @Override
    protected String doInBackground(String... strings) {
        StringBuilder sb=new StringBuilder();
        try{
            URL url=new URL(strings[0]);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            final InputStream is = conn.getInputStream();
            BufferedReader br = new BufferedReader( new InputStreamReader(is) );
            String str=null;
            while( (str=br.readLine())!=null ){
                sb.append(str);
            }
            br.close();
        }catch (Exception e){

        }
        return sb.toString();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        parseJson(s);
    }

    private void parseJson(String data){
        Toast.makeText(activity,data,Toast.LENGTH_SHORT).show();
        list=new ArrayList<>();
        PmItem pm=null;
        try{
            JSONArray array=new JSONArray(data);
            for(int i=0;i<array.length();i++){
                pm=new PmItem();
                JSONObject object=array.getJSONObject(i);
                pm.setCounty( object.optString("county") );
                pm.setSite( object.optString("Site") );
                pm.setPm( object.optString("PM25") );
                list.add(pm);
            }
            listView.setAdapter( new PmAdapter(activity,list) );
        }catch(Exception e){

        }
    }


}
