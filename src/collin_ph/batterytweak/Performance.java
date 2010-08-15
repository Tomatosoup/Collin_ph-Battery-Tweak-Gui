package collin_ph.batterytweak;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
public class Performance extends Activity
{
	private String lv_arr[]={"This","is","a","temporary","placeholder","!"};
	int batt;
	private ArrayAdapter<String> lv1Adapter;
	private ListView lv1;
public void onCreate(Bundle icicle)
{
setTitle("Performance");
super.onCreate(icicle);
setContentView(R.layout.main);
lv1=(ListView)findViewById(R.id.ListView01);
lv1Adapter=(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1 , lv_arr));
lv1.setAdapter(lv1Adapter);
lv1.setTextFilterEnabled(true);
lv1.setOnItemClickListener(new OnItemClickListener()
{
public void onItemClick(AdapterView<?> a, View v, int position, long id)
{
	if (lv1.getItemAtPosition(position) == "Profile")
	{
	}
	if (lv1.getItemAtPosition(position) == "Battery")
	{
	}
	if (lv1.getItemAtPosition(position) == "Performance")
	{
	}
	if (lv1.getItemAtPosition(position) == "Other Tweaks/Fixes")
	{
	}
	if (lv1.getItemAtPosition(position) == "Diagnostics")
	{
	}
	if (lv1.getItemAtPosition(position) == "Save")
	{
	}
};});}}