package org.freebsdgr.epal_exams;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText nea, math, eid1, eid2, eidiko;
    private float result1 = 1000;
    private int nea_ellinika = 100 , mathimatika = 100 ,
            eidikotita1 = 100, eidikotita2 = 100 ,eidiko1 = 0;
    TextView result;
    MarkCalc theCalc = new MarkCalc(100,100,100,100,0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Lock screen orientation - commented out
        // setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        nea = (EditText)findViewById(R.id.nea_editText);
        math = (EditText)findViewById(R.id.math_editText);
        eid1 = (EditText)findViewById(R.id.eid1_editText);
        eid2 = (EditText)findViewById(R.id.eid2_editText);
        eidiko = (EditText)findViewById(R.id.eidiko_editText);
        result = (TextView)findViewById(R.id.result_textView);
        if (savedInstanceState!=null) {
            nea_ellinika = savedInstanceState.getInt("nea");
            mathimatika = savedInstanceState.getInt("math");
            eidikotita1 = savedInstanceState.getInt("eid1");
            eidikotita2 = savedInstanceState.getInt("eid2");
            eidiko1 = savedInstanceState.getInt("eidiko");
        }
        nea.setText(""+nea_ellinika);
        math.setText(""+mathimatika);
        eid1.setText(""+eidikotita1);
        eid2.setText(""+eidikotita2);
        eidiko.setText(""+eidiko1);
        nea.setOnFocusChangeListener(new TextListener(this));
        math.setOnFocusChangeListener(new TextListener(this));
        eid1.setOnFocusChangeListener(new TextListener(this));
        eid2.setOnFocusChangeListener(new TextListener(this));
        eidiko.setOnFocusChangeListener(new TextListener(this));
        eidiko.setOnEditorActionListener(new TextListener(this));
        if (savedInstanceState!=null) {
            showResults();
        }
    }

    public void showResults() {
        String strNea, strMath, strEid1, strEid2, strEidiko;
        strNea = nea.getText().toString();
        strMath = math.getText().toString();
        strEid1 = eid1.getText().toString();
        strEid2 = eid2.getText().toString();
        strEidiko = eidiko.getText().toString();
        if (strNea.length()>0) {
            nea_ellinika = Integer.parseInt(strNea);
        }  else {
            nea_ellinika = 0;
            nea.setText("0");
        }

        if (strMath.length()>0) {
            mathimatika = Integer.parseInt(strMath);
        } else {
            mathimatika = 0;
            math.setText("0");
        }

        if (strEid1.length()>0) {
            eidikotita1 = Integer.parseInt(strEid1);
        } else {
            eidikotita1 = 0;
            eid1.setText("0");
        }

        if (strEid2.length()>0) {
            eidikotita2 = Integer.parseInt(strEid2);
        } else {
            eidikotita2 = 0;
            eid2.setText("0");
        }

        if (strEidiko.length()>0) {
            eidiko1 = Integer.parseInt(strEidiko);
        } else {
            eidiko1 = 0;
            eidiko.setText("0");
        }
        theCalc.setGrades(nea_ellinika, mathimatika, eidikotita1, eidikotita2,eidiko1);
        result1 = theCalc.calcResult();
        result.setText(String.valueOf(result1));
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt("math",mathimatika);
        savedInstanceState.putInt("nea", nea_ellinika);
        savedInstanceState.putInt("eid1",eidikotita1);
        savedInstanceState.putInt("eid2",eidikotita2);
        savedInstanceState.putInt("eidiko",eidiko1);
    }
}