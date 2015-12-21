package rubix.studio.libdirectorychooser.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;


/**
 * Created by mujeeb.r on 15-Dec-15.
 */
public class BaseActivity extends AppCompatActivity {


    public void init() {
        initUi();
        setData();
        setAdapter();
        initActionBar();
    }

    public void initActionBar() {

    }

    public void setAdapter() {

    }

    public void setData() {

    }

    public void initUi() {
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                setResult(RESULT_CANCELED);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
