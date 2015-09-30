package com.maxwell.warehouse.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.maxwell.warehouse.factories.ViewHolderFactory;
import com.maxwell.warehouse.models.Information;
import com.maxwell.warehouse.viewholders.ViewHolderParent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lbais on 11/09/2015.
 */
public class GenericAdapterFactory extends RecyclerView.Adapter<ViewHolderParent> {



    private List<? extends Information> mListInformation;

        public GenericAdapterFactory(List<? extends Information> informations)
        {
            if(informations == null)
                this.mListInformation = new ArrayList<>();
            else
                this.mListInformation = informations;

        }

        @Override
        public ViewHolderParent onCreateViewHolder(ViewGroup parent, int viewType) {
            return ViewHolderFactory.create(parent, viewType);
        }

        @Override
        public void onBindViewHolder(ViewHolderParent holder, int position) {
            ViewHolderFactory.populate(holder, mListInformation.get(position));
        }

        @Override
        public int getItemCount(){
            return mListInformation!=null? mListInformation.size() : 0;
        }

        @Override
        public int getItemViewType(int position) {
            return mListInformation.get(position).getViewType();
        }

    public List<? extends Information> getmListInformation() {
        return mListInformation;
    }

    public void setmListInformation(List<Information> mListInformation) {
        this.mListInformation = mListInformation;
    }
}

