package collin_ph.batterytweak;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.RadioGroup.OnCheckedChangeListener;
public class Battery extends Activity
{
private String Minu;
private String Maxb;
private String Pollb;
private String Minb;
private String Pollp;
private String Pollu;
private String Minp;
private String Maxu;
private String Maxp;
private String CPUred;
private Button b1;
private Button b2;
private ListView lv1;
private ArrayAdapter<String> lv1Adapter;
private int check;
private Button b3;
private Button b4;

public void onCreate(Bundle icicle)
{
setTitle("Battery");
Minp = "245000";
Minu = "245000";
Minb = "245000";
Maxp = "710000";
Maxu = "710000";
Maxb = "710000";
Pollp = "15 sec";
Pollu = "15 sec";
Pollb = "1 min";
CPUred = "33";
super.onCreate(icicle);
phoneset();
setContentView(R.layout.battery);
b1=(Button)findViewById(R.id.widgeta);
b2=(Button)findViewById(R.id.widgetb);
b1.setOnClickListener(new OnClickListener()
{
	public void onClick(View arg0)
	{
		//Put code for saving here
		finish();		
	}
});
b2.setOnClickListener(new OnClickListener()
{
	public void onClick(View arg0)
	{
		finish();				
	}
});
Spinner s = (Spinner) findViewById(R.id.widget43);
ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.cpu_methods, android.R.layout.simple_spinner_item);
adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
s.setAdapter(adapter);
lv1=(ListView)findViewById(R.id.widget55);
final String lv_arr[]={"Min CPU Power:" + Minp + " MHz","Min CPU USB:" + Minu + " MHz","Min CPU Battery:" + Minb + " MHz","Max CPU Power:" + Maxp + " MHz","Max CPU USB:" + Maxu + " MHz","Max CPU Battery:" + Maxb + " MHz", "Polling Interval Power:" + Pollp,"Polling Interval USB:" + Pollu,"Polling Interval Battery:" + Pollb,"Max CPU Reduction:" + CPUred + "%"};
lv1Adapter=(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, lv_arr));
lv1.setAdapter(lv1Adapter);
lv1.setTextFilterEnabled(true);
lv1.setOnItemClickListener(new OnItemClickListener() {
	private Button b3;
	private Button b4;
	private String Pollq;
	public void onItemClick(AdapterView<?> a, View v, final int position, long id) {
		lv1Adapter.notifyDataSetChanged();
		if (lv1.getItemIdAtPosition(position) == 0){
	        final Dialog dialog = new Dialog(Battery.this);
	        dialog.setContentView(R.layout.sliderdialog);
	        dialog.setTitle("Min CPU Power:" + Minp  + " MHz");
	        dialog.setCancelable(true);
	        dialog.show();
	        b3=(Button) dialog.findViewById(R.id.Button02);
	        b4=(Button) dialog.findViewById(R.id.Button01);
	        final SeekBar seekBar = (SeekBar) dialog.findViewById(R.id.Seekbar01);
	        seekBar.setProgress((Integer.parseInt(Minp)-245000)/200);
		    final int progress = (seekBar.getProgress()*200)+245000;
	        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
				public void onProgressChanged(SeekBar seekBar, int progress, boolean fromTouch) {		
				dialog.setTitle(("Min CPU Power:" + String.valueOf((progress*200)+245000)) + " MHz");
				Minp = Integer.toString((progress*200)+245000);
				}
				public void onStartTrackingTouch(SeekBar seekBar) {
				}
				public void onStopTrackingTouch(SeekBar seekBar) {		
				}
	        });
	        b3.setOnClickListener(new OnClickListener()
	        {
	        	public void onClick(View arg0)
	        	{
	        		lv_arr[0] = "Min CPU Power:" + Minp + " MHz";
	        		lv1Adapter.notifyDataSetChanged();
	        		dialog.dismiss();
	        	}
	        });
	        b4.setOnClickListener(new OnClickListener()
	        {
	        	public void onClick(View arg0)
	        	{
	        		Minp = Integer.toString(progress);
	        		lv_arr[0] = "Min CPU Power:" + Minp + " MHz";
	        		lv1Adapter.notifyDataSetChanged();
	        		dialog.dismiss();		
	        	}
	        });
		}
		if (lv1.getItemIdAtPosition(position) == 1){
	        final Dialog dialog = new Dialog(Battery.this);
	        dialog.setContentView(R.layout.sliderdialog);
	        dialog.setTitle("Min CPU USB:" + Minu  + " MHz");
	        dialog.setCancelable(true);
	        dialog.show();
	        b3=(Button) dialog.findViewById(R.id.Button02);
	        b4=(Button) dialog.findViewById(R.id.Button01);
	        final SeekBar seekBar = (SeekBar) dialog.findViewById(R.id.Seekbar01);
	        seekBar.setProgress((Integer.parseInt(Minu)-245000)/200);
		    final int progress = (seekBar.getProgress()*200)+245000;
	        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
				public void onProgressChanged(SeekBar seekBar, int progress, boolean fromTouch) {		
				dialog.setTitle(("Min CPU USB:" + String.valueOf((progress*200)+245000))  + " MHz");
				Minu = Integer.toString((progress*200)+245000);
				}
				public void onStartTrackingTouch(SeekBar seekBar) {
				}
				public void onStopTrackingTouch(SeekBar seekBar) {		
				}
	        });
	        b3.setOnClickListener(new OnClickListener()
	        {
	        	public void onClick(View arg0)
	        	{
	        		lv_arr[1] = "Min CPU USB:" + Minu + " MHz";
	        		lv1Adapter.notifyDataSetChanged();
	        		dialog.dismiss();
	        	}
	        });
	        b4.setOnClickListener(new OnClickListener()
	        {
	        	public void onClick(View arg0)
	        	{
	        		Minu = Integer.toString(progress);
	        		lv_arr[1] = "Min CPU USB:" + Minu + " MHz";
	        		lv1Adapter.notifyDataSetChanged();
	        		dialog.dismiss();		
	        	}
	        });
		}
		if (lv1.getItemIdAtPosition(position) == 2){
	        final Dialog dialog = new Dialog(Battery.this);
	        dialog.setContentView(R.layout.sliderdialog);
	        dialog.setTitle("Min CPU Battery:" + Minb  + " MHz");
	        dialog.setCancelable(true);
	        dialog.show();
	        b3=(Button) dialog.findViewById(R.id.Button02);
	        b4=(Button) dialog.findViewById(R.id.Button01);
	        final SeekBar seekBar = (SeekBar) dialog.findViewById(R.id.Seekbar01);
	        seekBar.setProgress((Integer.parseInt(Minb)-245000)/200);
		    final int progress = (seekBar.getProgress()*200)+245000;
	        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
				public void onProgressChanged(SeekBar seekBar, int progress, boolean fromTouch) {		
				dialog.setTitle(("Min CPU Battery:" + String.valueOf((progress*200)+245000))  + " MHz");
				Minb = Integer.toString((progress*200)+245000);
				}
				public void onStartTrackingTouch(SeekBar seekBar) {
				}
				public void onStopTrackingTouch(SeekBar seekBar) {		
				}
	        });
	        b3.setOnClickListener(new OnClickListener()
	        {
	        	public void onClick(View arg0)
	        	{
	        		lv_arr[2] = "Min CPU Battery:" + Minb + " MHz";
	        		lv1Adapter.notifyDataSetChanged();
	        		dialog.dismiss();
	        	}
	        });
	        b4.setOnClickListener(new OnClickListener()
	        {
	        	public void onClick(View arg0)
	        	{
	        		Minp = Integer.toString(progress);
	        		lv_arr[2] = "Min CPU Battery:" + Minb + " MHz";
	        		lv1Adapter.notifyDataSetChanged();
	        		dialog.dismiss();		
	        	}
	        });
		}
		if (lv1.getItemIdAtPosition(position) == 3){
	        final Dialog dialog = new Dialog(Battery.this);
	        dialog.setContentView(R.layout.sliderdialog);
	        dialog.setTitle("Max CPU Power:" + Maxp  + " MHz");
	        dialog.setCancelable(true);
	        dialog.show();
	        b3=(Button) dialog.findViewById(R.id.Button02);
	        b4=(Button) dialog.findViewById(R.id.Button01);
	        final SeekBar seekBar = (SeekBar) dialog.findViewById(R.id.Seekbar01);
	        seekBar.setProgress((Integer.parseInt(Maxp)-245000)/200);
		    final int progress = (seekBar.getProgress()*200)+245000;
	        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
				public void onProgressChanged(SeekBar seekBar, int progress, boolean fromTouch) {		
				dialog.setTitle(("Max CPU Power:" + String.valueOf((progress*200)+245000))  + " MHz");
				Maxp = Integer.toString((progress*200)+245000);
				}
				public void onStartTrackingTouch(SeekBar seekBar) {
				}
				public void onStopTrackingTouch(SeekBar seekBar) {		
				}
	        });
	        b3.setOnClickListener(new OnClickListener()
	        {
	        	public void onClick(View arg0)
	        	{
	        		lv_arr[3] = "Max CPU Power:" + Maxp + " MHz";
	        		lv1Adapter.notifyDataSetChanged();
	        		dialog.dismiss();
	        	}
	        });
	        b4.setOnClickListener(new OnClickListener()
	        {
	        	public void onClick(View arg0)
	        	{
	        		Maxp = Integer.toString(progress);
	        		lv_arr[3] = "Max CPU Power:" + Maxp + " MHz";
	        		lv1Adapter.notifyDataSetChanged();
	        		dialog.dismiss();		
	        	}
	        });
		}
		if (lv1.getItemIdAtPosition(position) == 4){
	        final Dialog dialog = new Dialog(Battery.this);
	        dialog.setContentView(R.layout.sliderdialog);
	        dialog.setTitle("Max CPU USB:" + Maxu  + " MHz");
	        dialog.setCancelable(true);
	        dialog.show();
	        b3=(Button) dialog.findViewById(R.id.Button02);
	        b4=(Button) dialog.findViewById(R.id.Button01);
	        final SeekBar seekBar = (SeekBar) dialog.findViewById(R.id.Seekbar01);
	        seekBar.setProgress((Integer.parseInt(Maxu)-245000)/200);
		    final int progress = (seekBar.getProgress()*200)+245000;
	        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
				public void onProgressChanged(SeekBar seekBar, int progress, boolean fromTouch) {		
				dialog.setTitle(("Max CPU USB:" + String.valueOf((progress*200)+245000))  + " MHz");
				Maxu = Integer.toString((progress*200)+245000);
				}
				public void onStartTrackingTouch(SeekBar seekBar) {
				}
				public void onStopTrackingTouch(SeekBar seekBar) {		
				}
	        });
	        b3.setOnClickListener(new OnClickListener()
	        {
	        	public void onClick(View arg0)
	        	{
	        		lv_arr[4] = "Max CPU USB:" + Maxu + " MHz";
	        		lv1Adapter.notifyDataSetChanged();
	        		dialog.dismiss();
	        	}
	        });
	        b4.setOnClickListener(new OnClickListener()
	        {
	        	public void onClick(View arg0)
	        	{
	        		Maxu = Integer.toString(progress);
	        		lv_arr[4] = "Max CPU USB:" + Maxu + " MHz";
	        		lv1Adapter.notifyDataSetChanged();
	        		dialog.dismiss();		
	        	}
	        });
		}
		if (lv1.getItemIdAtPosition(position) == 5){
	        final Dialog dialog = new Dialog(Battery.this);
	        dialog.setContentView(R.layout.sliderdialog);
	        dialog.setTitle("Max CPU Battery:" + Maxb  + " MHz");
	        dialog.setCancelable(true);
	        dialog.show();
	        b3=(Button) dialog.findViewById(R.id.Button02);
	        b4=(Button) dialog.findViewById(R.id.Button01);
	        final SeekBar seekBar = (SeekBar) dialog.findViewById(R.id.Seekbar01);
	        seekBar.setProgress((Integer.parseInt(Maxb)-245000)/200);
		    final int progress = (seekBar.getProgress()*200)+245000;
	        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
				public void onProgressChanged(SeekBar seekBar, int progress, boolean fromTouch) {		
				dialog.setTitle(("Max CPU Battery:" + String.valueOf((progress*200)+245000))  + " MHz");
				Maxb = Integer.toString((progress*200)+245000);
				}
				public void onStartTrackingTouch(SeekBar seekBar) {
				}
				public void onStopTrackingTouch(SeekBar seekBar) {		
				}
	        });
	        b3.setOnClickListener(new OnClickListener()
	        {
	        	public void onClick(View arg0)
	        	{
	        		lv_arr[5] = "Max CPU Battery:" + Maxb + " MHz";
	        		lv1Adapter.notifyDataSetChanged();
	        		dialog.dismiss();
	        	}
	        });
	        b4.setOnClickListener(new OnClickListener()
	        {
	        	public void onClick(View arg0)
	        	{
	        		Maxb = Integer.toString(progress);
	        		lv_arr[5] = "Max CPU Battery:" + Maxb + " MHz";
	        		lv1Adapter.notifyDataSetChanged();
	        		dialog.dismiss();		
	        	}
	        });
		}
		if (lv1.getItemIdAtPosition(position) == 6){
	        final Dialog dialog = new Dialog(Battery.this);
	        dialog.setContentView(R.layout.textdialog);
	        dialog.setTitle("Polling Interval Power:" + Pollp);
	        dialog.setCancelable(true);
	        final Spinner x = (Spinner) dialog.findViewById(R.id.edittext);
	        final ArrayAdapter tie = ArrayAdapter.createFromResource(dialog.getContext(), R.array.polling, android.R.layout.simple_spinner_item);
	        tie.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	        x.setAdapter(tie);
	        dialog.show();
	        b3=(Button) dialog.findViewById(R.id.Button02);
	        b4=(Button) dialog.findViewById(R.id.Button01);
	        b3.setOnClickListener(new OnClickListener()
	        {
				public void onClick(View arg0) {
			        Pollp = (String) x.getSelectedItem();
	        		lv_arr[6] = "Polling Interval Power:" + Pollp;
			        lv1Adapter.notifyDataSetChanged();
					dialog.dismiss();
				}
	        });
	        b4.setOnClickListener(new OnClickListener()
	        {

				public void onClick(View arg0) {
					dialog.dismiss();
					
				}
	        });

		}
		if (lv1.getItemIdAtPosition(position) == 7){
	        final Dialog dialog = new Dialog(Battery.this);
	        dialog.setContentView(R.layout.textdialog);
	        dialog.setTitle("Polling Interval USB:" + Pollu);
	        dialog.setCancelable(true);
	        final Spinner x = (Spinner) dialog.findViewById(R.id.edittext);
	        ArrayAdapter tie = ArrayAdapter.createFromResource(dialog.getContext(), R.array.polling, android.R.layout.simple_spinner_item);
	        tie.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	        x.setAdapter(tie);
	        dialog.show();
	        b3=(Button) dialog.findViewById(R.id.Button02);
	        b4=(Button) dialog.findViewById(R.id.Button01);
	        b3.setOnClickListener(new OnClickListener()
	        {
				public void onClick(View arg0) {
			        Pollu = (String) x.getSelectedItem();
	        		lv_arr[7] = "Polling Interval USB:" + Pollu;
			        lv1Adapter.notifyDataSetChanged();
					dialog.dismiss();
				}
	        });
	        b4.setOnClickListener(new OnClickListener()
	        {

				public void onClick(View arg0) {
					dialog.dismiss();
					
				}
	        });
		}
		if (lv1.getItemIdAtPosition(position) == 8){
	        final Dialog dialog = new Dialog(Battery.this);
	        dialog.setContentView(R.layout.textdialog);
	        dialog.setTitle("Polling Interval Battery:" + Pollb);
	        dialog.setCancelable(true);
	        final Spinner x = (Spinner) dialog.findViewById(R.id.edittext);
	        final ArrayAdapter tie = ArrayAdapter.createFromResource(dialog.getContext(), R.array.polling, android.R.layout.simple_spinner_item);
	        tie.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	        x.setAdapter(tie);
	        dialog.show();
	        b3=(Button) dialog.findViewById(R.id.Button02);
	        b4=(Button) dialog.findViewById(R.id.Button01);
	        b3.setOnClickListener(new OnClickListener()
	        {
				public void onClick(View arg0) {
			        Pollb = (String) x.getSelectedItem();
	        		lv_arr[8] = "Polling Interval Battery:" + Pollb;
			        lv1Adapter.notifyDataSetChanged();
					dialog.dismiss();
				}
	        });
	        b4.setOnClickListener(new OnClickListener()
	        {

				public void onClick(View arg0) {
					dialog.dismiss();
					
				}
	        });
	        }
		if (lv1.getItemIdAtPosition(position) == 9){
	        final Dialog dialog = new Dialog(Battery.this);
	        dialog.setContentView(R.layout.sliderdialog);
	        dialog.setTitle("Max CPU Reduction:" + CPUred  + "%");
	        dialog.setCancelable(true);
	        dialog.show();
	        b3=(Button) dialog.findViewById(R.id.Button02);
	        b4=(Button) dialog.findViewById(R.id.Button01);
	        final SeekBar seekBar = (SeekBar) dialog.findViewById(R.id.Seekbar01);
	        seekBar.setMax(100);
	        seekBar.setProgress(Integer.parseInt(CPUred));
		    final int progress = (seekBar.getProgress());
	        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
				public void onProgressChanged(SeekBar seekBar, int progress, boolean fromTouch) {		
				dialog.setTitle("Max CPU Reduction:" + String.valueOf(progress)  + "%");
				CPUred = Integer.toString(progress);
				}
				public void onStartTrackingTouch(SeekBar seekBar) {
				}
				public void onStopTrackingTouch(SeekBar seekBar) {		
				}
	        });
	        b3.setOnClickListener(new OnClickListener()
	        {
	        	public void onClick(View arg0)
	        	{
	        		lv_arr[9] = "Max CPU Reduction:" + CPUred + "%";
	        		lv1Adapter.notifyDataSetChanged();
	        		dialog.dismiss();
	        	}
	        });
	        b4.setOnClickListener(new OnClickListener()
	        {
	        	public void onClick(View arg0)
	        	{
	        		Pollp = Integer.toString(progress);
	        		lv_arr[9] = "Max CPU Reduction:" + CPUred + "%";
	        		lv1Adapter.notifyDataSetChanged();
	        		dialog.dismiss();		
	        	}
	        });
		}
		
		
		
		
		
}});
}
public void phoneset(){
}
}