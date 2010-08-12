package collin_ph.batterytweak;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Reader;
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
private String audio;
private String disk;
private String cfs;
private String led;
private String batts;
private String[] battconf;;	
{
	FileInputStream in = null;
	battconf = new String[16];	
	try {
		in = new FileInputStream("/system/etc/batt.conf");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	BufferedReader br = new BufferedReader(new InputStreamReader(in));
	try {
		for (int j = 0; j < battconf.length; j++){
		battconf[j] = br.readLine();
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		in.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	if (battconf[0].equals("audio_fix=0")==true){
		audio = "Enable Audio Fix";
	}
	if (battconf[0].equals("audio_fix=1")==true){
		audio = "Disable Audio Fix";
	}
	if (battconf[1].equals("CFStweaks=0")==true){
		cfs = "Enable CFS Tweaks";
	}
	if (battconf[1].equals("CFStweaks=1")==true){
		cfs = "Disable CFS Tweaks";
	}
	if (battconf[2].equals("MOUNToptions=0")==true){
		disk = "Enable New Disk Boot";
	}
	if (battconf[2].equals("MOUNToptions=1")==true){
		disk = "Disable New Disk Boot";
	}
	if (battconf[3].equals("enabled=0")==true){
		batts = "Enable Battery Tweak";
	}
	if (battconf[3].equals("enabled=1")==true){
		batts = "Disable Battery Tweak";
	}
	if (battconf[4].equals("LEDfix=0")==true){
		led = "Enable LED Fix";
	}
	if (battconf[4].equals("LEDfix=1")==true){
		led = "Disable LED Fix";
	}
}
private String lv_arr[]={"Revert to 768mhz defaults","Revert to 710mhz defaults","Customize Settings",batts,cfs,led,disk,audio};
private String strLine;
int batt;
private String battery;
private Object caramel;
private ArrayAdapter<String> lv1Adapter;
public void onCreate(Bundle icicle){

super.onCreate(icicle);
setContentView(R.layout.main);
lv1=(ListView)findViewById(R.id.ListView01);
lv1Adapter=(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1 , lv_arr));
lv1.setAdapter(lv1Adapter);
lv1.setTextFilterEnabled(true);
lv1.setOnItemClickListener(new OnItemClickListener() {
private int cobbles;
public void onItemClick(AdapterView<?> a, View v, int position, long id) {
lv1Adapter.notifyDataSetChanged();

cobbles = 0;
if (lv1.getItemAtPosition(position) == "Revert to 768mhz defaults"){
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
if (lv1.getItemAtPosition(position) == "Disable Battery Tweak"){
	//Toast.makeText( getApplicationContext() , "Battery Tweak Disabled", 
	//Toast.LENGTH_SHORT).show();
	battconf[3] = "enabled=0";
	lv_arr[3] = "Enable Battery Tweak";
	cobbles = 1;
}
if (lv1.getItemAtPosition(position) == "Enable Battery Tweak" && cobbles == 0){
	//Toast.makeText( getApplicationContext() , "Battery Tweak Enabled", 
	//Toast.LENGTH_SHORT).show();
	battconf[3] = "enabled=1";
	lv_arr[3] = "Disable Battery Tweak";
}
if (lv1.getItemAtPosition(position) == "Disable CFS Tweaks"){
	//Toast.makeText( getApplicationContext() , "CFS Tweaks Diabled", 
	//Toast.LENGTH_SHORT).show();
	battconf[4] = "CFStweaks=0";
	cobbles = 1;
	lv_arr[4] = "Enable CFS Tweaks";
}
if (lv1.getItemAtPosition(position) == "Enable CFS Tweaks" && cobbles == 0){
	//Toast.makeText( getApplicationContext() , "CFS Tweaks Enabled", 
	//Toast.LENGTH_SHORT).show();
	battconf[4] = "CFStweaks=1";
	lv_arr[4] = "Disable CFS Tweaks";
}
if (lv1.getItemAtPosition(position) == "Disable LED Fix"){
	//Toast.makeText( getApplicationContext() , "LED Fix Diabled", 
	//Toast.LENGTH_SHORT).show();
	battconf[4] = "LEDfix=0";
	cobbles = 1;
	lv_arr[5] = "Enable LED Fix";
}
if (lv1.getItemAtPosition(position) == "Enable LED Fix" && cobbles == 0){
	//Toast.makeText( getApplicationContext() , "LED Fix Enabled", 
	//Toast.LENGTH_SHORT).show();
	battconf[4] = "LEDfix=1";
	lv_arr[5] = "Enable LED Fix";
}
if (lv1.getItemAtPosition(position) == "Disable New Disk Boot"){
	//Toast.makeText( getApplicationContext() , "New Disk Boot Diabled", 
	//Toast.LENGTH_SHORT).show();
	battconf[2] = "MOUNToptions=0";
	cobbles = 1;
	lv_arr[6] = "Enable New Disk Boot";
}
if (lv1.getItemAtPosition(position) == "Enable New Disk Boot" && cobbles == 0){
	//Toast.makeText( getApplicationContext() , "New Disk Boot Enabled", 
	//Toast.LENGTH_SHORT).show();
	battconf[2] = "MOUNToptions=1";
	lv_arr[6] = "Disable New Disk Boot";
}
if (lv1.getItemAtPosition(position) == "Disable Audio Fix"){
	//Toast.makeText( getApplicationContext() , "Audio Quality Fix Diabled", 
	//Toast.LENGTH_SHORT).show();
	battconf[0] = "audio_fix=0";
	cobbles = 1;
	lv_arr[7] = "Enable Audio Fix";
}
if (lv1.getItemAtPosition(position) == "Enable Audio Fix" && cobbles == 0){
	//Toast.makeText( getApplicationContext() , "Audio Quality Fix Enabled", 
	//Toast.LENGTH_SHORT).show();
	battconf[0] = "audio_fix=1";
	lv_arr[7] = "Disable Audio Fix";
}
PrintStream out;
	try {
		out = new PrintStream("/sdcard/batt.conf");
		for (int i = 0; i < battconf.length;) {
		    out.println(battconf[i]);
		    if (++i < battconf.length) {
		        out.print("");
		    }	
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
});
}}
