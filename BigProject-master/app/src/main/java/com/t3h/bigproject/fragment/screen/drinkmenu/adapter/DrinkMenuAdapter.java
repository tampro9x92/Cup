package com.t3h.bigproject.fragment.screen.drinkmenu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.t3h.bigproject.R;
import com.t3h.bigproject.model.Product;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class DrinkMenuAdapter extends RecyclerView.Adapter {
	private List<Product> data = new ArrayList<>();
	private Context context;

	public DrinkMenuAdapter(List<Product> data, Context context) {
		this.data = data;
		this.context = context;
	}

	@NonNull
	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		return new DrinkMenuHolder(LayoutInflater.from(context).inflate(R.layout.item_drink,parent,false));
	}

	@Override
	public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
		DrinkMenuHolder drinkMenuHolder = (DrinkMenuHolder) holder;
		drinkMenuHolder.bindData(data.get(position));
	}

	@Override
	public int getItemCount() {
		return data == null?0:data.size();
	}

	public class DrinkMenuHolder extends RecyclerView.ViewHolder{
		public CircleImageView cimvProduct;
		public TextView tvNameDrink;
		public TextView tvPrice;
		public RatingBar rateDrink;
		public TextView tvRate;

		public DrinkMenuHolder(@NonNull View itemView) {
			super(itemView);
			cimvProduct = itemView.findViewById(R.id.cimvProduct);
			tvNameDrink = itemView.findViewById(R.id.tvNameDrink);
			tvPrice = itemView.findViewById(R.id.tvPrice);
			rateDrink = itemView.findViewById(R.id.rateDrink);
			tvRate = itemView.findViewById(R.id.tvRate);
		}

		public void bindData(Product product){
			tvNameDrink.setText(product.getName());
			tvPrice.setText(product.getPrice());

		}
	}
}
