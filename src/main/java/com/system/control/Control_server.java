package com.system.control;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;



//负责接收客户端连接创建线程
public class Control_server {

	private ServerSocket server;
	public static final int PORT = 9999;
	private Socket client;
	// 创建集合存储当前有几个线程
	List<ControlThread> list;
	/*// 创建守护线程
	private Watch watch;*/
	//创建线程池对象
	private ExecutorService es;
	//创建被代理的对象
	private totalService ttservice;
	public Control_server() {
		super();

		try {
			System.out.print("正在开启服务器");
			/*for (int i = 0; i < 3; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.print(".");
			}*/
			System.out.println();
			list = new ArrayList<>();
			this.server = new ServerSocket(PORT);
			// 实例化代理对象
			this.ttservice=new totalServiceImpl();
//			System.out.println("实例代理对象");
			System.out.println("服务器已开启！");
			es=Executors.newCachedThreadPool();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void start() {
		// 创建while循环为死循环 服务器一旦开启 不关闭
		while (true) {
			try {
//				System.out.println("========================");
				this.client = server.accept();
//				System.out.println("===============99999999");
				System.out.println(this.client.getInetAddress() + "已连接！");
				// 创建线程对象
				ControlThread ct = new ControlThread(client,ttservice);
				//返回当前处于活跃状态的线程
				es.submit(ct);
				int activeCount = ((ThreadPoolExecutor)es).getActiveCount();
				System.out.println("当前在线活跃用户："+activeCount);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
