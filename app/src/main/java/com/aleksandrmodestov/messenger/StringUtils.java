package com.aleksandrmodestov.messenger;

import android.widget.EditText;

public class StringUtils {

    public static String getTrimmedValue(EditText editText) {
        return editText.getText().toString().trim();
    }
}
