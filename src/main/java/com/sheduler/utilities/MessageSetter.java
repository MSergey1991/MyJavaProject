package com.sheduler.utilities;

import com.sheduler.entities.Tasks;

import java.util.List;

public class MessageSetter {
    public static String setNoSearchResultMessage(List<Tasks> searchResults) {
        if (!searchResults.iterator().hasNext()) {
            return "There are no search results for the specified parameters";
        } else return "";
    }

    public static String setEnteredIncorrectParametersMessage(boolean parametersValidationResult) {
        if (parametersValidationResult==false){
            return "Task can't be added, because you entered incorrect parameters. Try again, please.";
        }else return "";
    }
}
