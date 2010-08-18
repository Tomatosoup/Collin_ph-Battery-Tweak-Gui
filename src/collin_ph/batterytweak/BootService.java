package collin_ph.batterytweak;

import java.io.DataOutputStream;
import java.io.IOException;

import android.content.Intent;
import android.os.IBinder;

public class BootService extends android.app.Service
{
	public BootService()
	{
		
		Process process;
		try 
		{
			process = Runtime.getRuntime().exec("su");
			DataOutputStream os = new DataOutputStream(process.getOutputStream());
			os.writeBytes("killall batt.sh\n");
			os.flush();
		} catch (IOException e1) 
			{
			}
		try 
		{
			process = Runtime.getRuntime().exec("su");
			DataOutputStream os = new DataOutputStream(process.getOutputStream());
			os.writeBytes("nohup /data/data/collin_ph.batterytweak/lib/batt.sh 2>/dev/nul &\n");
			os.flush();
		} catch (IOException e1) 
			{
			}
	}

	@Override
	public IBinder onBind(Intent arg0) 
	{
		// TODO Auto-generated method stub
		return null;
	}
}
