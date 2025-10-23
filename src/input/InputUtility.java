package input;

import javafx.scene.input.KeyCode;

import java.util.ArrayList;

//Obtain key press form user
public class InputUtility {
    private boolean leftClickTrigger, leftClickPressed;
    private static final ArrayList<KeyCode> keyboardInputs = new ArrayList<KeyCode>();

    public static void setKeyPressed(KeyCode keycode, boolean pressed) {
        if (pressed) {
            if (!keyboardInputs.contains(keycode)) {
                keyboardInputs.add(keycode);
            }
        } else {
            keyboardInputs.remove(keycode);
        }
    }

    public static boolean getKeyPressed(KeyCode keyCode) {
        return keyboardInputs.contains(keyCode);
    }

    public static ArrayList<KeyCode> getKeyboardInputs() {
        return keyboardInputs;
    }
}
