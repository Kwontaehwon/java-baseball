package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {

    List<Integer> userInputList = new ArrayList<>();

    public User() {
    }

    public List<Integer> getUserInputList() {
        return userInputList;
    }

    public void convertGuessInputToList(String userInput) {
        userInputList.clear();
        for (int i = 0; i < userInput.length(); i++) {
            char eachCharInput = userInput.charAt(i);
            int eachIntInput = Character.getNumericValue(eachCharInput);
            userInputList.add(eachIntInput);
        }
    }

    public void getUserGuessInput() {
        String userInput = camp.nextstep.edu.missionutils.Console.readLine();
        if (validateUserGuessInput(userInput)) {
            convertGuessInputToList(userInput);
        }
    }

    public boolean validateUserGuessInput(String userInput) {
        try {
            int userInt = Integer.parseInt(userInput);
            if (userInt < 0 || userInt > 999) {
                throw new NumberFormatException();
            }
            return true;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private boolean checkUserReplayInput(String userInput) {
        return Objects.equals(userInput, "1");
    }

    public boolean getUserReplayInput() {
        String userInput = Console.readLine();
        if (validateUserReplayInput(userInput)) {
            return checkUserReplayInput(userInput);
        }
        return false;
    }

    private boolean validateUserReplayInput(String userInput) {
        try {
            int userInt = Integer.parseInt(userInput);
            if (userInt != 1 && userInt != 2) {
                throw new NumberFormatException();
            }
            return true;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
