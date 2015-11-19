package com.maxwell.warehouse.viewholders;

import android.view.View;
import android.widget.TextView;

import com.maxwell.warehouse.R;
import com.maxwell.warehouse.models.Information;
import com.maxwell.warehouse.models.SimpleItem;

/**
 * Created by lbais on 20/08/2015.
 */
public class SimpleItemViewHolder extends ViewHolderParent {
    TextView nameItem;

    public SimpleItemViewHolder(View itemView) {
        super(itemView);
        nameItem = (TextView) itemView.findViewById(R.id.nameItem);
    }

    @Override
    public void populate(Information information){
        final SimpleItem item = (SimpleItem) information;

        nameItem.setText(item.getNameItem());
    }
}
