package com.example.geektrust;

public class VideoStream implements IStream{
	IPlan plan;
	Integer offset=3;
	public VideoStream(IPlan plan) {
		this.plan = plan;
	}
	@Override
	public IPlan plan() {
		return this.plan;
	}
	@Override
	public Integer getOffset() {
		// TODO Auto-generated method stub
		return offset + plan.getOffset();
	}

}
