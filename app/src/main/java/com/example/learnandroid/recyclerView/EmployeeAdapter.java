package com.example.learnandroid.recyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learnandroid.R;

import java.util.ArrayList;

public class EmployeeAdapter extends RecyclerView.Adapter {

    public ArrayList<Employee> data;
    public AdapterCallback callBack;
    public EmployeeAdapter(ArrayList<Employee> data,AdapterCallback callBack) {
        this.data=data;
        this.callBack=callBack;
    }

    /**
     * <p>Creating view holder </p>
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View Item = LayoutInflater.from(parent.getContext()).inflate(R.layout.employee_recycler_list, parent, false);
        return new ViewHolder(Item);
    }

    /**
     * <p>Binding the data to the view holder by knowing its position</p>
     * @param holder1
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder1, int position) {
        ViewHolder holder = (ViewHolder)holder1;
        Employee employee=data.get(position);
        holder.Id.setText(String.valueOf(employee.getId()));
        holder.Name.setText(employee.getName());
        holder.Job.setText(employee.getJob());
    }

    /**
     * getting the item count
     * @return
     */
    @Override
    public int getItemCount() {
        return data.size();
    }

    /**
     * <p>Setting up view holder and its details</p>
     */
    class ViewHolder extends RecyclerView.ViewHolder {
        TextView Id, Name, Job;
        Button btnEdit, btnDelete;

        ViewHolder(@NonNull View view) {
            super(view);
            Id= view.findViewById(R.id.tvId);
            Name =view.findViewById(R.id.tvName);
            Job=view.findViewById(R.id.tvJob);
            btnDelete = view.findViewById(R.id.btnDelete);
            btnEdit = view.findViewById(R.id.btnEdit);

            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (callBack != null)
                        callBack.onDeleteEmp(getAdapterPosition());
                }
            });

            btnEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(callBack!=null){
                        callBack.onEditEmp(getAdapterPosition());
                    }
                }
            });
        }
    }
}