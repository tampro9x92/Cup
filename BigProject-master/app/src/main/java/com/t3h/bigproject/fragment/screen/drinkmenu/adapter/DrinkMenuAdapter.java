package com.t3h.bigproject.fragment.screen.drinkmenu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.t3h.bigproject.R;
import com.t3h.bigproject.fragment.screen.drinkmenu.api.request.DrinkMenuParagram;

import java.util.ArrayList;
import java.util.List;

public class DrinkMenuAdapter extends RecyclerView.Adapter {
	private List<DrinkMenuParagram> data = new ArrayList<>();
	private Context context;

	public DrinkMenuAdapter(List<DrinkMenuParagram> data, Context context) {
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

	}

	@Override
	public int getItemCount() {
		return 0;
	}

	public class DrinkMenuHolder extends RecyclerView.ViewHolder{

		public DrinkMenuHolder(@NonNull View itemView) {
			super(itemView);
		}


	}
}
