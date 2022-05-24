package com.example.geektrust;

public class PodCastStream implements IStream {
	IPlan plan;
	Integer offset=6;
	public PodCastStream(IPlan plan) {
		this.plan=plan;
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
