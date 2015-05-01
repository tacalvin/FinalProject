package KeyInputs;

import java.util.HashMap;

/**
 * Created by 1817172 on 5/1/2015.
 */
public class Keyboard
{
    private static HashMap<Integer, Boolean> keys = new HashMap<Integer, Boolean>();

    public static Boolean isKeyDown(int key) {
        if (keys.containsKey(key)) {
            return keys.get(key);
        }
        return false;
    }

    public static void setState(int key, boolean down) {
        keys.put(key, down);
    }

}
