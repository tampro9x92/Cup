package com.t3h.bigproject.fragment.screen.drinkmenu.presenter;

import android.app.Activity;
import android.widget.Toast;

import com.t3h.bigproject.base.presenter.BasePresenter;
import com.t3h.bigproject.fragment.screen.drinkmenu.api.DrinkMenuApiService;
import com.t3h.bigproject.fragment.screen.drinkmenu.api.request.DrinkMenuParagram;
import com.t3h.bigproject.fragment.screen.drinkmenu.view.DrinkView;

import java.util.ArrayList;
import java.util.List;

public class DrinkPresenterImpl implements BasePresenter,DrinkPresenter {
    private final DrinkView mView;
    private Activity context;
    private DrinkMenuApiService drinkMenuApiService;
    public DrinkPresenterImpl(DrinkView mView, Activity context) {
        this.mView = mView;
        this.context = context;
    }

    @Override
    public void start() {
        if (mView != null) {
            mView.onInit();
        }
    }

    @Override
    public void searchDrinkMenu(final String nameDrink) {
        drinkMenuApiService.drinkMenu(new DrinkMenuApiService.serviceCallBack() {
            @Override
            public void success(String code, Object respone) {
                List<DrinkMenuParagram> data = (List<DrinkMenuParagram>) respone;
                if (nameDrink.length()==0){
                    mView.showDrinkMenu(data);
                }else {
                    List<DrinkMenuParagram> dataSearch = new ArrayList<>();
                    for (int i = 0; i < data.size() ; i++) {
                        if (data.get(i).getName().indexOf(nameDrink)>=0){
                            dataSearch.add(data.get(i));
                        }
                    }
                    mView.showDrinkMenu(dataSearch);
                }
            }

            @Override
            public void fail(String code, String message) {
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
