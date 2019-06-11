package com.rolan.leetcode;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recycler)
    RecyclerView recyclerView;
    public static String[] datas = {"001", "075","146","203","206", "237","268", "344", "004", "005", "006", "007"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.activities.push(this);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initUI();
    }

    private void initUI() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ContainerAdapter containerAdapter = new ContainerAdapter(this);
        containerAdapter.setItemClickListener(this::doItemClick);
        recyclerView.setAdapter(containerAdapter);
    }

    private void doItemClick(int postion) {
        String className = "com.rolan.leetcode.tasks.Chapter" + datas[postion];
        try {
            Class<?> aClass = Class.forName(className);
            IEngine engine = (IEngine) aClass.newInstance();
            engine.doMath();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    public static class ContainerAdapter extends RecyclerView.Adapter<ContainerAdapter.ContainerViewHolder> {
        Context mContext;
        OnItemClickListener itemClickListener;

        public ContainerAdapter(Context mContext) {
            this.mContext = mContext;
        }

        @NonNull
        @Override
        public ContainerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View inflate = View.inflate(mContext, R.layout.item_container, null);
            return new ContainerViewHolder(inflate);
        }

        @Override
        public void onBindViewHolder(@NonNull ContainerViewHolder holder, int position) {
            holder.button.setText(datas[position]);
            holder.button.setOnClickListener(v -> {
                if (itemClickListener != null) itemClickListener.click(position);
            });
        }

        @Override
        public int getItemCount() {
            return datas.length;
        }

        public void setItemClickListener(OnItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        public static class ContainerViewHolder extends RecyclerView.ViewHolder {
            public Button button;

            public ContainerViewHolder(@NonNull View itemView) {
                super(itemView);
                button = itemView.findViewById(R.id.btn_item);
            }
        }

        public interface OnItemClickListener {
            void click(int postion);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        App.activities.pop();
    }
}
