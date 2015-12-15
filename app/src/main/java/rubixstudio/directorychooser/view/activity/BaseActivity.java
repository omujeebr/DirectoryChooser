package rubixstudio.directorychooser.view.activity;

import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by mujeeb.r on 15-Dec-15.
 */
public class BaseActivity extends AppCompatActivity {


    public void init() {
        initUi();
        setData();
        setAdapter();
    }

    public void setAdapter() {

    }

    public void setData() {

    }

    public void initUi() {
        ButterKnife.bind(this);
    }


}
