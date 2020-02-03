package com.t3h.bigproject.base.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.t3h.bigproject.activity.MainActivity;
import com.t3h.bigproject.base.presenter.BasePresenter;

public abstract class BaseFragment<T extends BasePresenter>extends Fragment {
    protected View vFragmentLayout;
    protected MainActivity activity;
    protected T presenter;
    protected View.OnClickListener onclick;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        activity = (MainActivity) getActivity();
        vFragmentLayout = setLayoutFragment(inflater,container);
        if (vFragmentLayout==null){
            Toast.makeText(activity, "null layout", Toast.LENGTH_SHORT).show();
        }
        presenter = getPresenter();

        return vFragmentLayout;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.start();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    //khai báo view trong createView
    protected abstract View setLayoutFragment(LayoutInflater inflater,ViewGroup container);
    //lấy presenter
    protected abstract T getPresenter();

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
