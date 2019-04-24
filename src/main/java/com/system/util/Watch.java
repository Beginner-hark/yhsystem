package com.system.util;

import java.util.Iterator;
import java.util.List;

import com.system.control.ControlThread;
public class Watch extends Thread {
	private List<ControlThread> list;
	private Iterator<ControlThread> it;
	public Watch(List<ControlThread> list) {
		super();
		this.list = list;
		this.setDaemon(true);
	}
	@Override
	public void run() {
		while(true){
			it=list.iterator();
			//遍历迭代器
			while(it.hasNext()){
				if(!it.next().isAlive()){
					it.remove();
				}
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
