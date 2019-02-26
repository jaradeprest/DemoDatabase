package iam.deprest.demodatabase;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Date;

import iam.deprest.demodatabase.model.Joke;
import iam.deprest.demodatabase.model.JokeDatabaseSingleton;

public class AddJokeActivity extends AppCompatActivity {

    private EditText etJoke;
    private FloatingActionButton fabSave;

    private View.OnClickListener saveClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //entity maken:
            Joke njoke = new Joke(etJoke.getText().toString(), new Date()); //constructor van Date geeft u byDefault de datum van vandaag
            //insert entity in db:
            JokeDatabaseSingleton.getInstance(getApplicationContext()).getJokeDAO().insertJoke(njoke);
            //go back to mainactivity:
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_joke);

        etJoke = findViewById(R.id.et_joke);
        fabSave = findViewById(R.id.fab_save);
        fabSave.setOnClickListener(saveClickListener);
    }
}
