package com.trishla.aurora.utils;

import java.util.List;

import com.trishla.aurora.contexts.SortContext;
import com.trishla.aurora.dtos.FoundDog;
import com.trishla.aurora.dtos.LostDog;

public class SortDogsList {
    public static List<LostDog> sortLostDogsList(List<LostDog> rawList, SortContext sortContext) {   
        return rawList;
    };

    public static List<FoundDog> sortFoundDogsList(List<FoundDog> rawList, SortContext sortContext) {
        return rawList;
    };
    
}
