package rubixstudio.directorychooser.view.adapter.recyclerview;

import android.content.Context;
import android.os.Environment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.File;
import java.io.FileFilter;

import butterknife.Bind;
import butterknife.ButterKnife;
import rubixstudio.directorychooser.R;

/**
 * Created by mujeeb.r on 15-Dec-15.
 */
public class DirectoriesAdapter extends RecyclerView.Adapter<DirectoriesAdapter.ViewHolder> {

    private Context context;
    public String rootDir = Environment.getExternalStorageDirectory().getAbsolutePath();
    File[] files;

    public DirectoriesAdapter(Context context) {
        this.context = context;
        initFolderList();
    }

    private void initFolderList() {
        files = getListFiles(new File(rootDir));
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.row_folders, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(files[position].getName() + "");
    }

    @Override
    public int getItemCount() {
        return files == null ? 0 : files.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.textView)
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


    private File[] getListFiles(File parentDir) {
        FileFilter fileFilter = new FileFilter() {
            public boolean accept(File file) {
                return file.isDirectory();
            }
        };
        File[] files = parentDir.listFiles(fileFilter);
        return files;
    }


}
