package iam.deprest.demodatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mi_add :
                Intent intent = new Intent(getApplicationContext(), AddJokeActivity.class);
                startActivity(intent);
                break;
                //er kunnen hier nog meer cases bijkomen, als je meer opties in je menu hebt:
        }
        return super.onOptionsItemSelected(item);
    }
}
