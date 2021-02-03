package com.cg.healthify.services;

import java.util.List;

import com.cg.healthify.pojo.WeightLog;
import com.cg.healthify.exceptions.InvalidIdException;

public interface WeightLogService {
	public WeightLog addWeightLog(WeightLog weightLog);

	public WeightLog updateWeightLog(WeightLog weightLog) throws InvalidIdException;

	public WeightLog deleteWeightLog(WeightLog weightLog) throws InvalidIdException;

	public WeightLog findWeightLog(WeightLog weightLog) throws InvalidIdException;
}
