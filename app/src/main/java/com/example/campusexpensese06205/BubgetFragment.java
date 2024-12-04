package com.example.campusexpensese06205;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.campusexpensese06205.adapter.BudgetListAdapter;
import com.example.campusexpensese06205.model.BudgetModel;

import java.util.ArrayList;
import java.util.List;

public class BubgetFragment extends Fragment {

    private ListView lvBudget;
    private TextView tvSpendingTab, tvCollectingTab;
    private List<BudgetModel> spendingBudgets;
    private List<BudgetModel> collectingBudgets;

    public BubgetFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bubget, container, false);

        lvBudget = view.findViewById(R.id.lvBudget);
        tvSpendingTab = view.findViewById(R.id.tvSpendingTab);
        tvCollectingTab = view.findViewById(R.id.tvCollectingTab);

        // Initialize data
        initializeData();

        // Set default tab to "Spending"
        updateBudgetList(spendingBudgets);

        // Tab click listeners
        tvSpendingTab.setOnClickListener(v -> {
            tvSpendingTab.setBackgroundColor(getResources().getColor(android.R.color.white));
            tvCollectingTab.setBackgroundColor(getResources().getColor(android.R.color.transparent));
            updateBudgetList(spendingBudgets);
        });

        tvCollectingTab.setOnClickListener(v -> {
            tvCollectingTab.setBackgroundColor(getResources().getColor(android.R.color.white));
            tvSpendingTab.setBackgroundColor(getResources().getColor(android.R.color.transparent));
            updateBudgetList(collectingBudgets);
        });

        // ListView item click listener
        lvBudget.setOnItemClickListener((parent, view1, position, id) -> {
            BudgetModel bg = (BudgetModel) lvBudget.getItemAtPosition(position);

            // Navigate to DetailActivity using Intent
            Intent intent = new Intent(getActivity(), DetailActivity.class);
            intent.putExtra("id", bg.getId());
            intent.putExtra("name", bg.getName());
            intent.putExtra("amount", bg.getPrice());
            intent.putExtra("description", bg.getDescription());
            startActivity(intent);
        });

        return view;
    }

    private void initializeData() {
        spendingBudgets = new ArrayList<>();
        collectingBudgets = new ArrayList<>();

        // Spending data
        spendingBudgets.add(new BudgetModel(1, "Ăn uống", -50000, "Thịt rau", R.drawable.home_icon));
        spendingBudgets.add(new BudgetModel(2, "Mua sắm", -500000, "Đồ đẹp, son", R.drawable.home_icon));
        spendingBudgets.add(new BudgetModel(3, "Đi lại", -200000, "Xăng và sửa xe", R.drawable.home_icon));
        spendingBudgets.add(new BudgetModel(4, "Tiền trọ", -2000000, "Tiền trọ tháng 12", R.drawable.home_icon));

        // Collecting data
        collectingBudgets.add(new BudgetModel(1, "Lương", 5000000, "Tiền lương tháng 11", R.drawable.home_icon));
        collectingBudgets.add(new BudgetModel(2, "Bố mẹ", 1000000, "Bố cho tiền sinh nhật", R.drawable.home_icon));
        collectingBudgets.add(new BudgetModel(3, "Tiền thưởng", 2000000, "Công ty thưởng", R.drawable.home_icon));
        collectingBudgets.add(new BudgetModel(4, "Tiền trợ", 2000000, "Tiền trợ tháng 12", R.drawable.home_icon));
    }

    private void updateBudgetList(List<BudgetModel> budgets) {
        // Pass the context from getActivity()
        BudgetListAdapter adapter = new BudgetListAdapter(getActivity(), budgets);
        lvBudget.setAdapter(adapter);
    }


}
