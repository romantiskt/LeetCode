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
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recycler)
    RecyclerView recyclerView;
    public static String[] datas = {"001", "020", "021", "028","043", "075","094","100","102","104","108",
            "136","146",
            "203", "206","226", "237", "268", "301", "326", "344","415","Z001",
                                    "Z002","Z003","Z004","Z005","Z006","Z007"};

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

    private static IEngine newInstanceByName(String name) {
        try {
            Class<?> aClass = Class.forName(name);
            return (IEngine) aClass.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void doItemClick(int position) {
        String className = "com.rolan.leetcode.tasks.Chapter" + datas[position];
        IEngine iEngine = newInstanceByName(className);
        if (iEngine != null) iEngine.doMath();
    }

    public static class ContainerAdapter extends RecyclerView.Adapter<ContainerAdapter.ContainerViewHolder> {
        Context mContext;
        OnItemClickListener itemClickListener;

        ContainerAdapter(Context mContext) {
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
            String className = "com.rolan.leetcode.tasks.Chapter" + datas[position];
            IEngine iEngine = newInstanceByName(className);
            if (iEngine != null)
                holder.desc.setText(iEngine.getQuestion());
            holder.button.setOnClickListener(v -> {
                if (itemClickListener != null) itemClickListener.click(position);
            });
        }

        @Override
        public int getItemCount() {
            return datas.length;
        }

        void setItemClickListener(OnItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        class ContainerViewHolder extends RecyclerView.ViewHolder {
             Button button;
             TextView desc;

             ContainerViewHolder(@NonNull View itemView) {
                super(itemView);
                button = itemView.findViewById(R.id.btn_item);
                desc = itemView.findViewById(R.id.tv_desc);
            }
        }

        public  interface OnItemClickListener {
            void click(int postion);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        App.activities.pop();
    }
}
