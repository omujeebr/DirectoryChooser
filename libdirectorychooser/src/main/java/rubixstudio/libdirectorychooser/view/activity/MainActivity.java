package rubixstudio.libdirectorychooser.view.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import rubixstudio.libdirectorychooser.R;
import rubixstudio.libdirectorychooser.view.adapter.recyclerview.DirectoriesAdapter;

public class MainActivity extends BaseActivity implements DirectoriesAdapter.DirectoryEvents {


    RecyclerView rv_dir;

    TextView text_view_directory;
    private DirectoriesAdapter dirAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    @Override
    public void initUi() {
        super.initUi();
        rv_dir = (RecyclerView) findViewById(R.id.rv_dir);
        text_view_directory = (TextView) findViewById(R.id.text_view_directory);

    }

    @Override
    public void setAdapter() {
        rv_dir.setLayoutManager(new LinearLayoutManager(this));
        dirAdapter = new DirectoriesAdapter(this, this);
        rv_dir.setAdapter(dirAdapter);
    }

    @Override
    public void onChooseNewDirectory(String path) {
        text_view_directory.setText(path);
        rv_dir.scrollToPosition(0);
    }


    @Override
    public void onBackPressed() {
        if (!dirAdapter.hasParentDir())
            super.onBackPressed();
    }

    public void onDirectorySelected(View v) {
        Intent intent = new Intent();
        intent.setData(Uri.parse(dirAdapter.getSelectedpath()));
        setResult(RESULT_OK, intent);
        finish();
    }

    public void onDirBackPress(View v) {
        onBackPressed();
    }
}