package com.cg.healthify.daos;

import com.cg.healthify.pojo.WeightLog;

public interface WeightLogDAO {

public WeightLog addUserWeight(WeightLog weg);

public WeightLog updateUserWeight(WeightLog weg);

public WeightLog deleteUserWeight(WeightLog weg);

public WeightLog findUserWeight(WeightLog weg);


}
