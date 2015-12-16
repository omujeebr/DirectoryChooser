package rubixstudio.libdirectorychooser.view.adapter.recyclerview;

import android.content.Context;
import android.os.Environment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

import rubixstudio.libdirectorychooser.R;

/**
 * Created by mujeeb.r on 15-Dec-15.
 */
public class DirectoriesAdapter extends RecyclerView.Adapter<DirectoriesAdapter.ViewHolder> {

    private Context context;
    private DirectoryEvents directoryEvents;
    public String rootDir = Environment.getExternalStorageDirectory().getAbsolutePath();
    public String selectedDir = rootDir;
    File[] files;


    public DirectoriesAdapter(Context context, DirectoryEvents directoryEvents) {
        this.context = context;
        this.directoryEvents = directoryEvents;
        initFolderList();
    }

    private void initFolderList() {
        files = getListFiles(new File(selectedDir));
        Arrays.sort(files);
        directoryEvents.onChooseNewDirectory(selectedDir);
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

    public boolean hasParentDir() {
        File file = new File(selectedDir);
        if (selectedDir.equals(rootDir))
            return false;
        else {
            selectedDir = selectedDir.substring(0, selectedDir.lastIndexOf("/"));
            initFolderList();
            notifyDataSetChanged();
            return true;
        }
    }

    public String getSelectedpath() {
        return selectedDir;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);
            itemView.findViewById(R.id.row_root).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onDirectorySelected();
                }
            });
        }


        public void onDirectorySelected() {
            selectedDir += "/" + files[getAdapterPosition()].getName();
            initFolderList();
            notifyDataSetChanged();
        }
    }

    private File[] getListFiles(File parentDir) {
        FileFilter fileFilter = new FileFilter() {
            public boolean accept(File file) {
                return file.isDirectory() && !file.getName().startsWith(".");
            }
        };
        File[] files = parentDir.listFiles(fileFilter);
        return files;
    }

    public interface DirectoryEvents {
        public void onChooseNewDirectory(String path);
    }


}
