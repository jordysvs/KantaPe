package com.kruma.kanta.view.fragments;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

/**
 * Created by Enrique on 21/07/2016.
 */
public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener{

    public TextView activity_editText;

    @SuppressLint("ValidFragment")
    public DatePickerFragment(TextView activity_editText) {
        this.activity_editText = activity_editText;
    }

    public DatePickerFragment() {
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), android.R.style.Theme_Holo_Dialog ,this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        activity_editText.setText(String.valueOf(year) + "-" + String.valueOf(monthOfYear + 1 ) + "-" + String.valueOf(dayOfMonth));
    }
}
