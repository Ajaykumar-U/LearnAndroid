package com.example.learnandroid.recyclerView;

public interface AdapterCallback {
    /**
     * <h> @onDeleteEmp</h>
     * <p>this method is used for deleting emp</p>
     *
     * @param position
     */
    void onDeleteEmp(int position);
    /**
     * <h> @onEditEmp</h>
     * <p>this method is used for Editing emp</p>
     *
     * @param position
     */
    void onEditEmp(int position);
}

