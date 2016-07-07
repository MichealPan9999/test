package com.example.testusb;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity
{

	private StoragePathsManager pathsManager;
	private TextView showResult;
	private List<String> allpaths;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		showResult = (TextView) findViewById(R.id.tv_devices);

		pathsManager = new StoragePathsManager(this);
		allpaths = pathsManager.getMountedStoragePaths();
		showResult.append("已经挂载了 的设备：\r\n");
		if (allpaths.size() == 0)
		{
			showResult.append("没有检测到外部存储.\r\n");
		} else
		{
			for (String path : allpaths)
			{
				showResult.append(path + "\r\n");
			}
		}

	}
}
