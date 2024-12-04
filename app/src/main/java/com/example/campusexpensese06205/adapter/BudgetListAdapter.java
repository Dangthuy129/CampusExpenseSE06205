//package com.example.campusexpensese06205.adapter;
//
//import android.graphics.drawable.Drawable;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.example.campusexpensese06205.R;
//import com.example.campusexpensese06205.model.BudgetModel;
//
//import java.util.List;
//
//public class BudgetListAdapter extends BaseAdapter {
//    List<BudgetModel> budgets;
//    public BudgetListAdapter(List<BudgetModel> model){
//        super();
//        budgets =model;
//    }
//    @Override
//    public int getCount() {
//        return budgets.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return budgets.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return budgets.get(position).id;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//       View budgetList;
//       if(convertView == null){
//           budgetList = View.inflate(parent.getContext(), R.layout.budget_listview,null);
//       }else{
//           budgetList =convertView;
//       }
//       BudgetModel budget = (BudgetModel) getItem(position);
//        ImageView icon= budgetList.findViewById(R.id.imgLogo);
//        TextView tvId =budgetList.findViewById(R.id.tvId);
//        TextView tvName = budgetList.findViewById(R.id.tvName);
//        TextView tvPrice = budgetList.findViewById(R.id.tvPrice);
//        TextView tvDes = budgetList.findViewById(R.id.tvDescription);
//
//        icon.setImageResource(budget.icon);
//        tvId.setText(String.valueOf(budget.id));
//        tvName.setText(budget.name);
//        tvPrice.setText(String.valueOf(budget.price));
//        tvDes.setText(budget.description);
//       return budgetList;
//    }
//}
package com.example.campusexpensese06205.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.campusexpensese06205.R;
import com.example.campusexpensese06205.model.BudgetModel;

import java.util.List;

public class BudgetListAdapter extends BaseAdapter {
    private Context context;
    private List<BudgetModel> budgets;

    // Modify constructor to accept both Context and List<BudgetModel>
    public BudgetListAdapter(Context context, List<BudgetModel> model) {
        this.context = context;
        this.budgets = model;
    }

    @Override
    public int getCount() {
        return budgets.size();
    }

    @Override
    public Object getItem(int position) {
        return budgets.get(position);
    }

    @Override
    public long getItemId(int position) {
        return budgets.get(position).id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View budgetList;

        // Inflate layout if needed
        if (convertView == null) {
            budgetList = View.inflate(context, R.layout.budget_listview, null);
        } else {
            budgetList = convertView;
        }

        BudgetModel budget = (BudgetModel) getItem(position);

        ImageView icon = budgetList.findViewById(R.id.imgLogo);
        TextView tvId = budgetList.findViewById(R.id.tvId);
        TextView tvName = budgetList.findViewById(R.id.tvName);
        TextView tvPrice = budgetList.findViewById(R.id.tvPrice);
        TextView tvDes = budgetList.findViewById(R.id.tvDescription);

        icon.setImageResource(budget.icon);
        tvId.setText(String.valueOf(budget.id));
        tvName.setText(budget.name);
        tvPrice.setText(String.valueOf(budget.price));
        tvDes.setText(budget.description);

        return budgetList;
    }
}

