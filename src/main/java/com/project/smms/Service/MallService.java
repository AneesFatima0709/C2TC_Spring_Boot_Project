package com.project.smms.Service;

import java.util.List;

import com.project.smms.entity.Mall;

public interface MallService {

	public String upsert (Mall mall);

	public Mall getById(Integer id);

	public List<Mall> getAllItems();

	public String deleteById(Integer id);


}
