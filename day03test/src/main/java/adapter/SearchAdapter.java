package adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.day03test.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import bean.SearchBean;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SEARCH> {
   private Context context;
   private List<SearchBean.ResultBean> list;

    public SearchAdapter(Context context, List<SearchBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public SEARCH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.toobar, viewGroup, false);
        SEARCH search = new SEARCH(view);
        return search;
    }

    @Override
    public void onBindViewHolder(@NonNull SEARCH search, int i) {

        SearchBean.ResultBean resultBean = list.get(i);
        search.icon.setImageURI(resultBean.getMasterPic());

        search.title.setText(list.get(i).getCommodityName());
        search.price.setText(list.get(i).getPrice()+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class SEARCH extends RecyclerView.ViewHolder {
       private TextView price,title;
       private SimpleDraweeView icon;
        public SEARCH(@NonNull View itemView) {
            super(itemView);
            price = itemView.findViewById(R.id.price);
            title = itemView.findViewById(R.id.title);
            icon = itemView.findViewById(R.id.image_1);
        }
    }
}
