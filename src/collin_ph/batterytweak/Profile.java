package collin_ph.batterytweak;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
public class Profile extends Activity
{
private RadioGroup Phones;
private Button b1;
private Button b2;
private int phone;
private long check;
@Override
public void onCreate(Bundle savedInstanceState)
{
	try 
	{
		FileInputStream fis = openFileInput("Phone");
		check = fis.read();
		fis.close();
	}
	catch (FileNotFoundException e1)
	{
	}
	catch (IOException e)
	{
	}
		setTitle("Profile");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.profile);
		Phones = (RadioGroup) findViewById(R.id.Phones1);
		checkphone();
		b1=(Button)findViewById(R.id.widget52);
		b2=(Button)findViewById(R.id.widget49);
		b1.setOnClickListener(new OnClickListener()
		{
			public void onClick(View arg0) {
			FileOutputStream fos;
			try 
			{
				fos = openFileOutput("Phone", Context.MODE_PRIVATE);
				fos.write(phone);
				fos.close();
			}
			catch (FileNotFoundException e)
			{	
			}
			catch (IOException e)
			{
			}
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
Phones.setOnCheckedChangeListener(new OnCheckedChangeListener()
		{
			public void onCheckedChanged(RadioGroup Phones, int checkedId)
			{
			phone = (checkedId - 2131034117);
			}
	
		});
		}
public void checkphone()
{
	if (check == 0)
	{
		Phones.check(R.id.option1);
	}
	if (check == 1)
	{
		Phones.check(R.id.option2);
	}
	if (check == 2)
	{
		Phones.check(R.id.option3);
	}
	if (check == 3)
	{
		Phones.check(R.id.option4);
	}
	if (check == 4)
	{
		Phones.check(R.id.option4);
	}
	if (check == 4)
	{
		Phones.check(R.id.option5);
	}
	if (check == 5)
	{
		Phones.check(R.id.option6);
	}
	if (check == 6)
	{
		Phones.check(R.id.option7);
	}
	if (check == 7)
	{
		Phones.check(R.id.option8);
	}
	if (check == 8)
	{
		Phones.check(R.id.option9);
	}
	if (check == 9)
	{
		Phones.check(R.id.option10);
	}
	if (check == 10)
	{
		Phones.check(R.id.option11);
	}
	if (check == 11)
	{
		Phones.check(R.id.option12);
	}
	if (check == 12)
	{
		Phones.check(R.id.option13);
	}
	if (check == 13)
	{
		Phones.check(R.id.option14);
	}
	if (check == 14)
	{
		Phones.check(R.id.option15);
	}
	if (check == 15)
	{
		Phones.check(R.id.option16);
	}
	if (check == 17)
	{
		Phones.check(R.id.option18);
	}
	if (check == 18)
	{
		Phones.check(R.id.option19);
	}
	if (check == 19)
	{
		Phones.check(R.id.option20);
	}
}

}