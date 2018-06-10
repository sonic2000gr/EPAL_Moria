package org.freebsdgr.epal_exams;


import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;


public class TextListener implements View.OnFocusChangeListener, OnEditorActionListener {
    MainActivity caller;

    TextListener(MainActivity activity) {
        this.caller = activity;
    }

    @Override
    public void onFocusChange(View view, boolean hasFocus) {
        if (!hasFocus) {
            validateInput((EditText) view);
        }
    }

    @Override
    public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
        if (actionId==EditorInfo.IME_ACTION_DONE) {
            validateInput((EditText) textView);
            caller.showResults();
            return false;
        } else
            return true;

    }

    private void validateInput(EditText theText) {
        if (theText.getText().toString().length() > 0) {
            if (Integer.parseInt(theText.getText().toString()) > 200) {
                theText.setText("200");
            }
            caller.showResults();
        }
    }
}