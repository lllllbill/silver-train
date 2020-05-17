package org.silver.train.schema;

import java.util.Iterator;

public class Target implements Iterable<Target>{
	//内容（暂定）
	private String content;
	//链表咯
	private Target next;
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public Iterator<Target> iterator() {
		return new Iterator<Target>(){

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public Target next() {
				// TODO Auto-generated method stub
				return null;
			}
			
		};
	}
}
