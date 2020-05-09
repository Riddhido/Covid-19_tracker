package com.example.riddhi.coronatracker;

import java.util.ArrayList;

public interface MainPresenter {
    void downloadData();

    interface View{
        void showProgressBar();
        void hideProgressBar();
        void dataDownloadedSuccessfully(ArrayList<String> datesArrayList, ArrayList<Status> statusArrayList);
    }
}
