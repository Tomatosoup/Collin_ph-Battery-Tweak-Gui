package collin_ph.batterytweak;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
public class Main extends Activity
{
	private String lv_arr[]={"Profile","Battery","Performance","Other Tweaks/Fixes","Diagnostics","Save","Exit (Without Saving)"};
	int batt;
	private ArrayAdapter<String> lv1Adapter;
	private ListView lv1;
	private Button b1;
	private Button b2;
public void onCreate(Bundle icicle)
{
	Process process;
			try 
			{
				new FileInputStream("/data/data/collin_ph.batterytweak/lib/batt.sh");
			}
			catch (FileNotFoundException e)
			{
					try
					{
						process = Runtime.getRuntime().exec("su");
						DataOutputStream os = new DataOutputStream(process.getOutputStream());
						os.writeBytes("mv /data/data/collin_ph.batterytweak/lib/libshell.so /data/data/collin_ph.batterytweak/lib/batt.sh\n");
						os.flush();
					}
					catch (IOException e1)
					{
						Toast.makeText( getApplicationContext() , "Error writing file", 
						Toast.LENGTH_SHORT).show();
					}
			}
super.onCreate(icicle);
try 
{
	FileInputStream fis = openFileInput("First_Run");
}
catch (FileNotFoundException e1)
{
    final Dialog dialog = new Dialog(Main.this, R.style.FullHeightDialog);
    dialog.setContentView(R.layout.disclaimer);
    dialog.setTitle("Warning:");
    dialog.setCancelable(false);
    dialog.show();
    b1=(Button) dialog.findViewById(R.id.Button01);
    b2=(Button) dialog.findViewById(R.id.Button02);
	b2.setOnClickListener(new OnClickListener()
	{
		public void onClick(View arg0)
		{
			finish();				
		}
	});
	b1.setOnClickListener(new OnClickListener()
	{
		public void onClick(View arg0)
		{
			FileOutputStream fos;
			try 
			{
				fos = openFileOutput("First_Run", Context.MODE_PRIVATE);
				fos.write(1);
				fos.close();
			}
			catch (FileNotFoundException e)
			{	
			}
			catch (IOException e)
			{
			}
			dialog.dismiss();
		}
	});
}
setContentView(R.layout.main);
lv1=(ListView)findViewById(R.id.ListView01);
lv1Adapter=(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1 , lv_arr));
lv1.setAdapter(lv1Adapter);
lv1.setTextFilterEnabled(true);
lv1.setOnItemClickListener(new OnItemClickListener()
{
	Intent Battery = new Intent(Main.this, Battery.class);
	Intent Diagnostics = new Intent(Main.this, Diagnostics.class);
	Intent Fixes = new Intent(Main.this, Fixes.class);
	Intent Performance = new Intent(Main.this, Performance.class);
	Intent Profile = new Intent(Main.this, Profile.class);
public void onItemClick(AdapterView<?> a, View v, int position, long id)
{
	if (lv1.getItemAtPosition(position) == "Profile")
	{
		Main.this.startActivity(Profile);
	}
	if (lv1.getItemAtPosition(position) == "Battery")
	{
		try 
		{
			openFileInput("Phone");
			Main.this.startActivity(Battery);
		}
		catch (FileNotFoundException e1)
		{
			Toast.makeText( getApplicationContext() , "Please select a profile first!", 
			Toast.LENGTH_SHORT).show();
			Main.this.startActivity(Profile);
		}
	}
	if (lv1.getItemAtPosition(position) == "Performance")
	{
		Main.this.startActivity(Performance);
	}
	if (lv1.getItemAtPosition(position) == "Other Tweaks/Fixes")
	{
		Main.this.startActivity(Fixes);
	}
	if (lv1.getItemAtPosition(position) == "Diagnostics")
	{
		Main.this.startActivity(Diagnostics);
	}
	if (lv1.getItemAtPosition(position) == "Save")
	{
		Toast.makeText( getApplicationContext() , "Eventually make this save", 
		Toast.LENGTH_SHORT).show();	
	}
	if (lv1.getItemAtPosition(position) == "Exit (Without Saving)")
	{
		finish();
	}
};});}}