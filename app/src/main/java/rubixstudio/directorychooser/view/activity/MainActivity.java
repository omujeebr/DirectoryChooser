package rubixstudio.directorychooser.view.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import butterknife.Bind;
import rubixstudio.directorychooser.R;
import rubixstudio.directorychooser.view.adapter.recyclerview.DirectoriesAdapter;

public class MainActivity extends BaseActivity implements DirectoriesAdapter.DirectoryEvents {


    @Bind(R.id.rv_dir)
    RecyclerView rv_dir;

    @Bind(R.id.text_view_directory)
    TextView text_view_directory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }


    @Override
    public void setAdapter() {
        rv_dir.setLayoutManager(new LinearLayoutManager(this));
        rv_dir.setAdapter(new DirectoriesAdapter(this, this));
    }

    @Override
    public void onChooseNewDirectory(String path) {
        text_view_directory.setText(path);
        rv_dir.scrollToPosition(0);
    }
}
