package adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.day01test.Bean;
import com.example.day01test.R;

import java.util.List;
import java.util.zip.Inflater;

public class Adapter extends RecyclerView.Adapter<Adapter.MVH> {
private Context context;
private List<Bean> list;
    @NonNull
    @Override
    public MVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.toobar, viewGroup, false);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MVH mvh, int i) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class MVH extends RecyclerView.ViewHolder {

        public MVH(@NonNull View itemView) {
            super(itemView);

        }
    }
}

