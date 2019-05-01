package com.example.finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView pianoimg = findViewById(R.id.pianoimg);

        Spinner spinner = findViewById(R.id.notes);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
        TextView scaletext1 = findViewById(R.id.scaletext1);
        TextView scaletext2 = findViewById(R.id.scaletext2);
        switch (position) {
            case 0:
                scaletext1.setText("C , D , E , F , G , A , B");
                scaletext2.setText("C , D , D# , F , G , G# , A#");
                break;
            case 1:
                scaletext1.setText("C# , D# , F , F# , G# , A# , C");
                scaletext2.setText("C# , D# , E , F# , G# , A , B");
                break;
            case 2:
                scaletext1.setText("D , E , F# , G , A , B , C#");
                scaletext2.setText("D , E , F , G , A , A# , C");
                break;
            case 3:
                scaletext1.setText("E♭, F, G, A♭, B♭, C, D");
                scaletext2.setText("E♭, F, G♭, A♭, B♭, C♭, and D♭");
                break;
            case 4:
                scaletext1.setText("E , F# , G# , A , B , C# , D#");
                scaletext2.setText("E , F# , G , A , B , C , D");
                break;
            case 5:
                scaletext1.setText("F, G, A, A#, C, D, E");
                scaletext2.setText("F, G, A♭, B♭, C, D♭, and E♭");
                break;
            case 6:
                scaletext1.setText("F♯, G♯, A♯, B, C♯, D♯, E♯");
                scaletext2.setText("F♯, G♯, A, B, C♯, D, E");
                break;
            case 7:
                scaletext1.setText("G, A, B, C, D, E, F♯");
                scaletext2.setText("G, A, B♭, C, D, E♭, F");
                break;
            case 8:
                scaletext1.setText("G♯, A♯, B♯, C♯, D♯, E♯, G");
                scaletext2.setText("G♯, A♯, B, C♯, D♯, E, F♯");
                break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}