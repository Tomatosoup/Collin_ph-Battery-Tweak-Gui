package collin_ph.batterytweak;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
public class customize extends Activity
{	
private ListView lv1;
private String[] battconf;
{
	FileInputStream in = null;
	battconf = new String[16];	
	try {
		in = new FileInputStream("/data/data/collin_ph.batterytweak/batt.conf");
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	BufferedReader br = new BufferedReader(new InputStreamReader(in));
	try {
		for (int j = 0; j < battconf.length; j++){
		battconf[j] = br.readLine();
		}
	} catch (IOException e) {
		e.printStackTrace();
	}
	try {
		in.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
	}

private String lv_arr[]={"Change CPU limiting method","Min CPU on Battery","Max CPU on Battery","Min CPU on USB","Max CPU on USB","Min CPU on Power","Max CPU on Power","Polling Interval on Battery","Polling Interval on USB","Polling Interval on Power","Max CPU Reduction"};
int batt;
private ArrayAdapter<String> lv1Adapter;
public void onCreate(Bundle icicle){
	Process process;
	try {
		process = Runtime.getRuntime().exec("su");
DataOutputStream os = new DataOutputStream(process.getOutputStream());
   os.writeBytes("killall -9 batt.sh\n");
   os.flush();
	} catch (IOException e1) {
	}
	try {
		process = Runtime.getRuntime().exec("su");
DataOutputStream os = new DataOutputStream(process.getOutputStream());
   os.writeBytes("nohup /system/bin/batt.sh 2>/dev/nul &\n");
   os.flush();
	} catch (IOException e1) {
	}
super.onCreate(icicle);
setContentView(R.layout.main);
lv1=(ListView)findViewById(R.id.ListView01);
lv1Adapter=(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1 , lv_arr));
lv1.setAdapter(lv1Adapter);
lv1.setTextFilterEnabled(true);
lv1.setOnItemClickListener(new OnItemClickListener() {
private int cobbles;
private String[] curr;
private String min;
private String max;
public void onItemClick(AdapterView<?> a, View v, int position, long id) {
lv1Adapter.notifyDataSetChanged();
Process process;
	try {
		process = Runtime.getRuntime().exec("su");
DataOutputStream os = new DataOutputStream(process.getOutputStream());
   os.writeBytes("killall -9 batt.sh\n");
   os.flush();
	} catch (IOException e1) {
	}
	try {
		process = Runtime.getRuntime().exec("su");
DataOutputStream os = new DataOutputStream(process.getOutputStream());
   os.writeBytes("nohup /system/bin/batt.sh 2>/dev/nul &\n");
   os.flush();
	} catch (IOException e1) {
	}

	
cobbles = 0;
if (lv1.getItemAtPosition(position) == "Change CPU limiting method"){
	if (battconf[5].equals("cpu_limiting_method=1")==true){
	 Toast.makeText( getApplicationContext() , "Limiting method set to Powersave Bias", 
	 Toast.LENGTH_SHORT).show();
	 battconf[5] = "cpu_limiting_method=2";
	 cobbles = 1;
	}
	if (battconf[5].equals("cpu_limiting_method=2")==true && cobbles == 0){
		 Toast.makeText( getApplicationContext() , "Limiting method set to Underclock", 
		 Toast.LENGTH_SHORT).show();
		 battconf[5] = "cpu_limiting_method=1";
		}
	
}
min= "245000";
max= "748800";
if (lv1.getItemAtPosition(position) == "Min CPU on Battery"){
	curr= new String[1];
	curr = battconf[6].split("=");
}



try{ process = Runtime.getRuntime().exec("su");
DataOutputStream os = new DataOutputStream(process.getOutputStream());
   os.writeBytes("touch /data/data/collin_ph.batterytweak/batt.conf\n");
   os.flush();
	} catch (IOException e1) {
	}
PrintStream out;
	try {
		out = new PrintStream("/data/data/collin_ph.batterytweak/batt.conf");
		for (int i = 0; i < battconf.length;) {
		    out.println(battconf[i]);
		    if (++i < battconf.length) {
		        out.print("");
		    }	
		}
	} catch (FileNotFoundException e) {
		Toast.makeText( getApplicationContext() , "Press it again if you don't want to break everything", 
		Toast.LENGTH_SHORT).show();
		try{ process = Runtime.getRuntime().exec("su");
		DataOutputStream os = new DataOutputStream(process.getOutputStream());
		   os.writeBytes("touch /data/data/collin_ph.batterytweak/batt.conf\n");
		   os.flush();
			} catch (IOException e1) {
			}
	}
}
});
}
}
