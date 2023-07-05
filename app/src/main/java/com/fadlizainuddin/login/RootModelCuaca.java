package com.fadlizainuddin.login;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RootModelCuaca {
    @SerializedName("list")
    private List<ListModelCuaca> listModelCuacaList;

    public RootModelCuaca() {

    }

    public List<ListModelCuaca> getListModelList() {
        return listModelCuacaList;
    }

    public void setListModelList(List<ListModelCuaca> listModelList) {
        this.listModelCuacaList = listModelList;
    }
}
