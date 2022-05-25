package com.example.geektrust;

public class PodCastStream implements IStream {
	private IPlan plan;
	private Integer offset = 6;
	private String renewalDate;

	public PodCastStream(IPlan plan) {
		this.plan = plan;
	}

	@Override
	public Integer getOffset() {
		// TODO Auto-generated method stub
		return offset;
	}

	@Override
	public String streamName() {
		// TODO Auto-generated method stub
		return "PODCAST";
	}

	@Override
	public void setRenewal(String renewal) {
		this.renewalDate = renewal;
	}

	@Override
	public String getRenewal() {
		// TODO Auto-generated method stub
		return renewalDate;
	}

	@Override
	public Integer getCost() {
		// TODO Auto-generated method stub
		return this.plan.cost();
	}

}
