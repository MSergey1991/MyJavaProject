package com.sheduler.utilities;

import com.sheduler.entities.Tasks;

import java.util.List;

public  class MessageSetter {
    public static String setNoSearchResultMessage(List<Tasks> searchResults){
        if (!searchResults.iterator().hasNext()){
            return "There are no search results for the specified parameters";
        } else return "";
    }
}
