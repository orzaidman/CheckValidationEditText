package com.or.checkvalidationlibrary;

import android.widget.EditText;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckEditText {
    private Map<EditText,Type> allEditTexts;

    public enum Type {NUMBERS, MAIL, SMALL_LETTERS, CAPITAL_LETTERS, PHONE_NUMBER_ISRAEL, PHONE_NUMBER, AGE, LETTERS, DATE}

    public CheckEditText() {
        this.allEditTexts = new HashMap<>();
    }

    public void add(EditText editText, Type type) {
        allEditTexts.put(editText, type);
    }

    public boolean checkForm() {
        List<EditText> keys = new ArrayList(allEditTexts.keySet());
        List<Type> values = new ArrayList(allEditTexts.values());
        for (int i = 0; i < allEditTexts.size(); i++) {
            if (!checkOneEditText(keys.get(i), values.get(i)))
                return false;
        }
        return true;
    }

    private boolean checkOneEditText(EditText editTextToCheck, Type type) {
        String data = editTextToCheck.getText().toString();
        switch (type) {

            case DATE:
                return checkDate(data);
            case PHONE_NUMBER:
                return checkPhoneNumber(data);

            case PHONE_NUMBER_ISRAEL:
                return checkPhoneNumberISRAEL(data);

            case AGE:
                return checkAge(data);

            case SMALL_LETTERS:
                return checkSmallLetters(data);

            case CAPITAL_LETTERS:
                return checkCapitalLetters(data);

            case NUMBERS:
                return checkNumbers(data);

            case LETTERS:
                return checkLetters(data);

            case MAIL:
                return checkMail(data);

        }
        return false;
    }

    public Map<EditText, Type> getAllEditTexts() {
        return allEditTexts;
    }

    public void setAllEditTexts(Map<EditText, Type> allEditTexts) {
        this.allEditTexts = allEditTexts;
    }

    private Boolean checkNumbers(String text) {
        return text.matches("[0-9]*");
    }

    private Boolean checkAge(String text) {
        return text.matches("[0-9][0-9]");
    }

    private Boolean checkSmallLetters(String text) {
        return text.matches("[a-z]*");
    }

    private Boolean checkCapitalLetters(String text) {
        return text.matches("[A-Z]*");
    }

    private Boolean checkMail(String text) {
        return text.matches("^[a-zA-Z0-9._]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+$");
    }

    private Boolean checkLetters(String text) {
        return text.matches("[A-Z][a-z]");
    }

    private Boolean checkDate(String text) {
        if (text.matches("^(((0[13-9]|1[012])[-/.]?(0[1-9]|[12][0-9]|30)|(0[13578]|1[02])[-/.]?31|02[-/.]?(0[1-9]|1[0-9]|2[0-8]))[-/.]?[0-9]{4}|02[-/.]?29[-/.]?([0-9]{2}(([2468][048]|[02468][48])|[13579][26])|([13579][26]|[02468][048]|0[0-9]|1[0-6])00))$"))
            return true;
        if (text.matches("^(((0[1-9]|[12][0-9]|30)[-/.]?(0[13-9]|1[012])|31[-/.]?(0[13578]|1[02])|(0[1-9]|1[0-9]|2[0-8])[-/.]?02)[-/.]?[0-9]{4}|29[-/.]?02[-/.]?([0-9]{2}(([2468][048]|[02468][48])|[13579][26])|([13579][26]|[02468][048]|0[0-9]|1[0-6])00))$"))
            return true;

        if (text.matches("^([0-9]{4}[-/.]?((0[13-9]|1[012])[-/.]?(0[1-9]|[12][0-9]|30)|(0[13578]|1[02])[-/.]?31|02[-/.]?(0[1-9]|1[0-9]|2[0-8]))|([0-9]{2}(([2468][048]|[02468][48])|[13579][26])|([13579][26]|[02468][048]|0[0-9]|1[0-6])00)[-/.]?02[-/.]?29)$"))
            return true;

        return false;

    }


    private Boolean checkPhoneNumberISRAEL(String text) {
        return text.matches("^[0][5][0-9]{7}$");
    }

    private Boolean checkPhoneNumber(String text) {
        return text.matches("\\+?([0-9]{11})");
    }

}
