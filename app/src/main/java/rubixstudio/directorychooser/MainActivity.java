package rubixstudio.directorychooser;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.Bind;
import rubixstudio.directorychooser.view.activity.BaseActivity;
import rubixstudio.directorychooser.view.adapter.recyclerview.DirectoriesAdapter;

public class MainActivity extends BaseActivity {


    @Bind(R.id.rv_dir)
    RecyclerView rv_dir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }


    @Override
    public void setAdapter() {
        rv_dir.setLayoutManager(new LinearLayoutManager(this));
        rv_dir.setAdapter(new DirectoriesAdapter(this));
    }
}
