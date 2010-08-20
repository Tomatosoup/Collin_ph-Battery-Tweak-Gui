package collin_ph.batterytweak;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
public class Fixes extends Activity
{
	private String lv_arr[]={"Enable Audio Fix","Zipalign All Applications"};
	int batt;
	private ArrayAdapter<String> lv1Adapter;
	private ListView lv1;
public void onCreate(Bundle icicle)
{
setTitle("Other Tweaks/Fixes");
super.onCreate(icicle);
setContentView(R.layout.main);
lv1=(ListView)findViewById(R.id.ListView01);
lv1Adapter=(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1 , lv_arr));
lv1.setAdapter(lv1Adapter);
lv1.setTextFilterEnabled(true);
lv1.setOnItemClickListener(new OnItemClickListener()
{
private int cobbles;

public void onItemClick(AdapterView<?> a, View v, int position, long id)
{
	cobbles=0;
	if (lv1.getItemAtPosition(position) == "Enable Audio Fix")
	{
		lv_arr[0] = "Disable Audio Fix";
		lv1Adapter.notifyDataSetChanged();
		cobbles=1;
	}
	if (lv1.getItemAtPosition(position) == "Disable Audio Fix" && cobbles==0)
	{
		lv_arr[0] = "Enable Audio Fix";
		lv1Adapter.notifyDataSetChanged();
	}
	if (lv1.getItemAtPosition(position) == "Zipalign All Applications")
	{
		//insert zipalign stuff here
	}
};});}}