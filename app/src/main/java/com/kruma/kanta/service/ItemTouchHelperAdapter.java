package com.kruma.kanta.service;

/**
 * Created by Jordy on 06/05/2017.
 */

public interface ItemTouchHelperAdapter {

    boolean onItemMove(int fromPosition, int toPosition);

    void onItemDismiss(int position);
}
