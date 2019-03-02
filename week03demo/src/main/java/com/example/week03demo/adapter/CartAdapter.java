package com.example.week03demo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.week03demo.R;
import com.example.week03demo.bean.CartBean;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CART> {

    private Context context;
    private List<CartBean.ResultBean> list;

    public CartAdapter(Context context, List<CartBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public CART onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.cart_item, viewGroup, false);
        CART cart = new CART(view);
        return cart;
    }

    @Override
    public void onBindViewHolder(@NonNull CART cart, final int i) {
        Glide.with(context).load(list.get(i).getPic()).into(cart.Cart_image);
        cart.Cart_price.setText(list.get(i).getPrice()+"");
        cart.Cart_title.setText(list.get(i).getCommodityName());
        /**
         * 商品点击查看商品详情页
         */
        cart.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(itemOnclick != null){
                    itemOnclick.OnClick(list.get(i).getCommodityId());
                    Log.i("TAST===",list.get(i).getCommodityId()+"");
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CART extends RecyclerView.ViewHolder {
        private ImageView Cart_image;
        private TextView Cart_title,Cart_price;
        public CART(@NonNull View itemView) {
            super(itemView);
            Cart_image = itemView.findViewById(R.id.Cart_image);
            Cart_title = itemView.findViewById(R.id.Cart_title);
            Cart_price = itemView.findViewById(R.id.Cart_price);
        }
    }
    /**
     * 接口回调---用于查看详情页
     */
    public ItemOnclick itemOnclick;

    public void setItemOnclick(ItemOnclick itemOnclick) {
        this.itemOnclick = itemOnclick;
    }

    public interface ItemOnclick{
        void OnClick(int CommodityId);
    }
}
