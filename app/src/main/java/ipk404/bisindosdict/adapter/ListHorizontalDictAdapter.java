package ipk404.bisindosdict.adapter;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ipk404.bisindosdict.Dao.DictDao;
import ipk404.bisindosdict.DetailKataActivity;
import ipk404.bisindosdict.R;

/**
 * Created by Undetected on 3/19/2018.
 */

public class ListHorizontalDictAdapter extends RecyclerView.Adapter<ListHorizontalDictAdapter.ViewHolder> {
    final ArrayList<DictDao> data = new ArrayList<>();
    final Activity activity;

    public ListHorizontalDictAdapter(List<DictDao> data, Activity activity) {
        this.data.addAll(data);
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View v;
        if (viewType == 0) {
            v = inflater.inflate(R.layout.item_common_language, parent, false);
            v.setBackgroundColor(Color.rgb(248, 177, 149));
        } else if (viewType == 1) {
            v = inflater.inflate(R.layout.item_common_language, parent, false);
            v.setBackgroundColor(Color.rgb(246, 114, 128));
        } else if (viewType == 2) {
            v = inflater.inflate(R.layout.item_common_language, parent, false);
            v.setBackgroundColor(Color.rgb(192, 108, 132));
        } else if (viewType == 3) {
            v = inflater.inflate(R.layout.item_common_language, parent, false);
            v.setBackgroundColor(Color.rgb(108, 91, 123));
        } else {
            v = inflater.inflate(R.layout.item_common_language, parent, false);
            v.setBackgroundColor(Color.rgb(53, 92, 125));
        }
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public int getItemViewType(int position) {
        return position % 5;
    }

    int randomWithRange(int min, int max) {
        int range = (max - min) + 1;
        return (int) (Math.random() * range) + min;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final DictDao dao = data.get(position);
        holder.textInisial.setText(dao.getKata().toUpperCase().charAt(0) + "");
        holder.textKata.setText(dao.getKata());
        holder.view.getRootView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DetailKataActivity.startThisActivity(activity, dao);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textInisial, textKata;
        public View view;

        public ViewHolder(View view) {
            super(view);
            this.view = view;
            this.textInisial = view.findViewById(R.id.txtInisial);
            this.textKata = view.findViewById(R.id.txtKata);
        }
    }
}
