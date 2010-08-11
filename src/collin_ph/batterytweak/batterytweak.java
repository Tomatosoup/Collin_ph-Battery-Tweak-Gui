package collin_ph.batterytweak;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class batterytweak extends Activity
{
private ListView lv1;
private String lv_arr[]={"Revert to 768mhz defaults","Revert to 710mhz defaults","Customize Settings","Toggle Battery Tweak","Toggle CFS Tweaks","Toggle LED Fix","Toggle New Disk Boot","Toggle Audio Quality Fix"};
private int battweak;
private int cfs;
private int led;
private int disk;
private int audio;
public void onCreate(Bundle icicle){
battweak = 1;
cfs = 1;
led = 1;
disk = 1;
audio = 1;
super.onCreate(icicle);
setContentView(R.layout.main);
lv1=(ListView)findViewById(R.id.ListView01);
lv1.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1 , lv_arr));
lv1.setTextFilterEnabled(true);
lv1.setOnItemClickListener(new OnItemClickListener() {
private int cobbles;
private int cfs;
private String commands;
private String single;

public void onItemClick(AdapterView<?> a, View v, int position, long id) {
cobbles = 0;
if (lv1.getItemAtPosition(position) == "Revert to 768mhz defaults"){
	Process process = null;
	try {
		process = Runtime.getRuntime().exec("su");
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	DataOutputStream os = new DataOutputStream(process.getOutputStream());
	DataInputStream osRes = new DataInputStream(process.getInputStream());
	{
	try {
		os.writeBytes("commands go here" + "\n");
		os.writeBytes("and here" + "\n");
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	   try {
		os.flush();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	   ArrayAdapter<String> res = null;
	}
	try {
		os.writeBytes("exit\n");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		os.flush();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		process.waitFor();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Toast.makeText( getApplicationContext() , "Reverted to 768mhz defaults", 
	Toast.LENGTH_SHORT).show();

}
if (lv1.getItemAtPosition(position) == "Revert to 710mhz defaults"){
	Toast.makeText( getApplicationContext() , "Reverted to 710mhz defaults", 
	Toast.LENGTH_SHORT).show();
}
if (lv1.getItemAtPosition(position) == "Customize Settings"){
	Toast.makeText( getApplicationContext() , "Fill this space later", 
	Toast.LENGTH_SHORT).show();
}
if (lv1.getItemAtPosition(position) == "Toggle Battery Tweak" && battweak == 1){
	Toast.makeText( getApplicationContext() , "Battery Tweak Diabled", 
	Toast.LENGTH_SHORT).show();
	battweak = 0;
	cobbles = 1;
}
if (lv1.getItemAtPosition(position) == "Toggle Battery Tweak" && battweak == 0 && cobbles == 0){
	Toast.makeText( getApplicationContext() , "Battery Tweak Enabled", 
	Toast.LENGTH_SHORT).show();
	battweak = 1;
}
if (lv1.getItemAtPosition(position) == "Toggle CFS Tweaks" && cfs == 1){
	Toast.makeText( getApplicationContext() , "CFS Tweaks Diabled", 
	Toast.LENGTH_SHORT).show();
	cfs = 0;
	cobbles = 1;
}
if (lv1.getItemAtPosition(position) == "Toggle CFS Tweaks" && cfs == 0 && cobbles == 0){
	Toast.makeText( getApplicationContext() , "CFS Tweaks Enabled", 
	Toast.LENGTH_SHORT).show();
	cfs = 1;
}
if (lv1.getItemAtPosition(position) == "Toggle LED Fix" && led == 1){
	Toast.makeText( getApplicationContext() , "LED Fix Diabled", 
	Toast.LENGTH_SHORT).show();
	led = 0;
	cobbles = 1;
}
if (lv1.getItemAtPosition(position) == "Toggle LED Fix" && led == 0 && cobbles == 0){
	Toast.makeText( getApplicationContext() , "LED Fix Enabled", 
	Toast.LENGTH_SHORT).show();
	led = 1;
}
if (lv1.getItemAtPosition(position) == "Toggle New Disk Boot" && disk == 1){
	Toast.makeText( getApplicationContext() , "New Disk Boot Diabled", 
	Toast.LENGTH_SHORT).show();
	disk = 0;
	cobbles = 1;
}
if (lv1.getItemAtPosition(position) == "Toggle New Disk Boot" && disk == 0 && cobbles == 0){
	Toast.makeText( getApplicationContext() , "New Disk Boot Enabled", 
	Toast.LENGTH_SHORT).show();
	disk = 1;
}
if (lv1.getItemAtPosition(position) == "Toggle Audio Quality Fix" && audio == 1){
	Toast.makeText( getApplicationContext() , "Audio Quality Fix Diabled", 
	Toast.LENGTH_SHORT).show();
	audio = 0;
	cobbles = 1;
}
if (lv1.getItemAtPosition(position) == "Toggle Audio Quality Fix" && audio == 0 && cobbles == 0){
	Toast.makeText( getApplicationContext() , "Audio Quality Fix Enabled", 
	Toast.LENGTH_SHORT).show();
	audio = 1;
}
}
});
}
}
