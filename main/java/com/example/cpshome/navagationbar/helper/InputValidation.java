package com.example.cpshome.navagationbar.helper;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import java.security.PrivateKey;

public class InputValidation {

    private Context context;

    public InputValidation(Context context){
        this.context = context;
    }

    public boolean isInputEditTextFilled(TextInputEditText textInputEditText, TextInputLayout textInputLayout, String message){
        String value = textInputEditText.getText().toString().trim();
        if (value.isEmpty()){
            textInputLayout.setError(message);
            hideKeyboardFrom(textInputEditText);
            return false;

        }else {
            textInputLayout.setErrorEnabled(false);
        }
        return true;
    }

    // This boolean creates the error message if the criteria is not met.


    public boolean isInputEditTextEmail(TextInputEditText textInputEditText, TextInputLayout textInputLayout, String message){
        String value = textInputEditText.getText().toString().trim();
        if (value.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(value).matches()  ){
            textInputLayout.setError(message);
            hideKeyboardFrom(textInputEditText);
            return false;

        }else {
            textInputLayout.setErrorEnabled(false);
        }
        return true;
    }

    // This boolean creates the error message that the email address entered doesn't meet any of the criteria.
    public boolean isInputEditTextMatches(TextInputEditText textInputEditText1, TextInputEditText textInputEditText2, TextInputLayout textInputLayout, String message ){
        String value1 = textInputEditText1.getText().toString().trim();
        String value2 = textInputEditText2.getText().toString().trim();
            if (!value1.contentEquals(value2)){
                textInputLayout.setError(message);
                hideKeyboardFrom(textInputEditText2);
                return false;

            }else{
                textInputLayout.setErrorEnabled(false);
            }
        return true;
    }
    //  This boolean creates the error message when it checks that the input matches the criteria already saved in the system
    private void hideKeyboardFrom(View view){
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }
}
