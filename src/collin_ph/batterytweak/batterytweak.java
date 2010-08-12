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
private String audio;{
	FileInputStream in = null;
	try {
		in = new FileInputStream("/system/etc/batt.conf");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	BufferedReader br = new BufferedReader(new InputStreamReader(in));
	final String[] battconf;
	battconf = new String[16];			
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
	if (battconf[0]!= "audio_fix=1"){
		audio = "Enable Audio Fix";
	}
	if (battconf[0] != "audio_fix=0"){
		audio = "Disable Audio Fix";
	}
}
private String lv_arr[]={"Revert to 768mhz defaults","Revert to 710mhz defaults","Customize Settings","Toggle Battery Tweak","Toggle CFS Tweaks","Toggle LED Fix","Toggle New Disk Boot",audio};
String[] battconf = new String[20];
private String strLine;
int batt;
private String battery;
private Object caramel;
private ArrayAdapter<String> lv1Adapter;
public void onCreate(Bundle icicle){

super.onCreate(icicle);
setContentView(R.layout.main);
lv1=(ListView)findViewById(R.id.ListView01);
lv1.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1 , lv_arr));
lv1Adapter = (new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1 , lv_arr));
lv1.setTextFilterEnabled(true);
lv1.setOnItemClickListener(new OnItemClickListener() {
private int cobbles;
public void onItemClick(AdapterView<?> a, View v, int position, long id) {
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
	Toast.makeText( getApplicationContext() , "Battery Tweak Disabled", 
	Toast.LENGTH_SHORT).show();
	battconf[3] = "enabled=0";
	cobbles = 1;
}
if (lv1.getItemAtPosition(position) == "Enable Battery Tweak" && cobbles == 0){
	Toast.makeText( getApplicationContext() , "Battery Tweak Enabled", 
	Toast.LENGTH_SHORT).show();
	battconf[3] = "enabled=1";
}
if (lv1.getItemAtPosition(position) == "Disable CFS Tweaks"){
	Toast.makeText( getApplicationContext() , "CFS Tweaks Diabled", 
	Toast.LENGTH_SHORT).show();
	battconf[1] = "CFStweaks=0";
	cobbles = 1;
}
if (lv1.getItemAtPosition(position) == "Enable CFS Tweaks" && cobbles == 0){
	Toast.makeText( getApplicationContext() , "CFS Tweaks Enabled", 
	Toast.LENGTH_SHORT).show();
	battconf[1] = "CFStweaks=1";
}
if (lv1.getItemAtPosition(position) == "Disable LED Fix"){
	Toast.makeText( getApplicationContext() , "LED Fix Diabled", 
	Toast.LENGTH_SHORT).show();
	battconf[4] = "LEDfix=0";
	cobbles = 1;
}
if (lv1.getItemAtPosition(position) == "Enable LED Fix" && cobbles == 0){
	Toast.makeText( getApplicationContext() , "LED Fix Enabled", 
	Toast.LENGTH_SHORT).show();
	battconf[4] = "LEDfix=1";
}
if (lv1.getItemAtPosition(position) == "Disable New Disk Boot"){
	Toast.makeText( getApplicationContext() , "New Disk Boot Diabled", 
	Toast.LENGTH_SHORT).show();
	battconf[2] = "MOUNToptions=0";
	cobbles = 1;
}
if (lv1.getItemAtPosition(position) == "Enable New Disk Boot" && cobbles == 0){
	Toast.makeText( getApplicationContext() , "New Disk Boot Enabled", 
	Toast.LENGTH_SHORT).show();
	battconf[2] = "MOUNToptions=1";
}
if (lv1.getItemAtPosition(position) == "Disable Audio Fix"){
	Toast.makeText( getApplicationContext() , "Audio Quality Fix Diabled", 
	Toast.LENGTH_SHORT).show();
	battconf[0] = "audio_fix=0";
	cobbles = 1;
}
if (lv1.getItemAtPosition(position) == "Enable Audio Fix" && cobbles == 0){
	Toast.makeText( getApplicationContext() , "Audio Quality Fix Enabled", 
	Toast.LENGTH_SHORT).show();
	battconf[0] = "audio_fix=1";
}
try {
	BufferedWriter out = new BufferedWriter(new FileWriter("/system/etc/batt2.conf"));
	out.write(battconf[0]);
	out.write(battconf[1]);
	out.write(battconf[2]);
	out.write(battconf[3]);
	out.write(battconf[4]);
	out.write(battconf[5]);
	out.write(battconf[6]);
	out.write(battconf[7]);
	out.write(battconf[8]);
	out.write(battconf[9]);
	out.write(battconf[10]);
	out.write(battconf[11]);
	out.write(battconf[12]);
	out.write(battconf[13]);
	out.write(battconf[14]);
	out.write(battconf[15]);
	out.write(battconf[16]);

	out.close();
	} catch (IOException e) {
	}
	
}
});
}
}
