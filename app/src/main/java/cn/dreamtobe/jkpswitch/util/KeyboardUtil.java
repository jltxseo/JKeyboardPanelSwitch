package cn.dreamtobe.jkpswitch.util;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import cn.dreamtobe.jkpswitch.R;
import cn.dreamtobe.jkpswitch.app.JKeyBordApplication;

/**
 * Created by Jacksgong on 15/7/6.
 */
public class KeyboardUtil {

    public static void showKeybord(final View view) {
        view.requestFocus();
        InputMethodManager inputManager =
                (InputMethodManager) view.getContext().getSystemService(
                        Context.INPUT_METHOD_SERVICE);
        inputManager.showSoftInput(view, 0);
    }

    public static void hideKeybord(final View view) {
        InputMethodManager imm =
                (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        view.clearFocus();
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }


    private static int LAST_SAVE_KEYBORD_HEIGHT = 0;

    public static boolean saveKeybordHeight(int keybordHeight) {
        if (LAST_SAVE_KEYBORD_HEIGHT == keybordHeight) {
            return false;
        }

        if (keybordHeight < 0) {
            return false;
        }

        LAST_SAVE_KEYBORD_HEIGHT = keybordHeight;
        Log.d("KeyBordUtil", String.format("save keybord: %d", keybordHeight));

        return JKeyBordSharedPreferences.getImpl().save(keybordHeight);
    }

    public static int getKeybordHeight() {
        if (LAST_SAVE_KEYBORD_HEIGHT == 0) {
            LAST_SAVE_KEYBORD_HEIGHT = JKeyBordSharedPreferences.getImpl().get(getMinPanelHeight());
        }

        return LAST_SAVE_KEYBORD_HEIGHT;
    }

    public static int getValidPanelHeight() {
        final int maxPanelHeight = getMaxPanelHeight();
        final int minPanelHeight = getMinPanelHeight();

        int validPanelheight = getKeybordHeight();

        validPanelheight = Math.max(minPanelHeight, validPanelheight);
        validPanelheight = Math.min(maxPanelHeight, validPanelheight);
        return validPanelheight;


    }


    private static int MAX_PANEL_HEIGHT = 0;
    private static int MIN_PANEL_HEIGHT = 0;

    public static int getMaxPanelHeight() {
        if (MAX_PANEL_HEIGHT == 0) {
            MAX_PANEL_HEIGHT = JKeyBordApplication.getContext().getResources().getDimensionPixelSize(R.dimen.max_panel_height);
        }

        return MAX_PANEL_HEIGHT;
    }

    public static int getMinPanelHeight() {
        if (MIN_PANEL_HEIGHT == 0) {
            MIN_PANEL_HEIGHT = JKeyBordApplication.getContext().getResources().getDimensionPixelSize(R.dimen.min_panel_height);
        }

        return MIN_PANEL_HEIGHT;
    }


}
