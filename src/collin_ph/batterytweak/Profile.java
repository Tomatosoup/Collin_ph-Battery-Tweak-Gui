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
private int check;
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
			phone = (checkedId - R.id.option1 + 1);
			}
	
		});
		}
public void checkphone()
{
	switch(check)
	{
	case 1:
	{Phones.check(R.id.option1);}
	break;
	case 2:
	{Phones.check(R.id.option2);}
	break;
	case 3:
	{Phones.check(R.id.option3);}
	break;
	case 4:
	{Phones.check(R.id.option4);}
	break;
	case 5:
	{Phones.check(R.id.option5);}
	break;
	case 6:
	{Phones.check(R.id.option6);}
	break;
	case 7:
	{Phones.check(R.id.option7);}
	break;
	case 8:
	{Phones.check(R.id.option8);}
	break;
	case 9:
	{Phones.check(R.id.option9);}
	break;
	case 10:
	{Phones.check(R.id.option10);}
	break;
	case 11:
	{Phones.check(R.id.option11);}
	break;
	case 12:
	{Phones.check(R.id.option12);}
	break;
	case 13:
	{Phones.check(R.id.option13);}
	break;
	case 14:
	{Phones.check(R.id.option14);}
	break;
	case 15:
	{Phones.check(R.id.option15);}
	break;
	case 16:
	{Phones.check(R.id.option16);}
	break;
	case 17:
	{Phones.check(R.id.option17);}
	break;
	case 18:
	{Phones.check(R.id.option18);}
	break;
	case 19:
	{Phones.check(R.id.option19);}
	break;
	case 20:
	{Phones.check(R.id.option20);}
	break;
	}
}
}