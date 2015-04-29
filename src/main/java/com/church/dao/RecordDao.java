package com.church.dao;

import java.util.List;

import com.church.model.RecordModel;

public interface RecordDao {

	public Long insert(RecordModel recordModel);
	
	public RecordModel queryOne(Long id);
	
	public List<RecordModel> queryByUid(Long uid);
	
	public List<RecordModel> queryByBid(Long bid);
	
	public Integer update(RecordModel recordModel);
}
