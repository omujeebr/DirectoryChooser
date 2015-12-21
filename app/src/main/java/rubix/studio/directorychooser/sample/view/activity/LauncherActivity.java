package rubix.studio.directorychooser.sample.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import rubix.studio.directorychooser.R;
import rubix.studio.libdirectorychooser.view.activity.MainActivity;

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        startActivityForResult(new Intent(this, MainActivity.class), 10);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK)
            Toast.makeText(this, data.getDataString(), Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this,"Cancelled", Toast.LENGTH_SHORT).show();

    }
}
