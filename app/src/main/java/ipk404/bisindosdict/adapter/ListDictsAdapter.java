package ipk404.bisindosdict.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import ipk404.bisindosdict.Dao.DictDao;
import ipk404.bisindosdict.R;

/**
 * Created by Undetected on 3/22/2018.
 */

public class ListDictsAdapter extends BaseAdapter {
    final ArrayList<DictDao> data = new ArrayList<>();
    final Activity activity;

    public ListDictsAdapter(List<DictDao> data, Activity activity) {
        this.data.addAll(data);
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return data.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater inflater = activity.getLayoutInflater();
            view = inflater.inflate(R.layout.list_item_dict, null);
        }
        LinearLayout linearKeliatan = view.findViewById(R.id.linearKeliatan);
        int x = i%5;
        if(x==0){
            linearKeliatan.setBackgroundResource(R.drawable.myrect);
        }else if(x==1){
            linearKeliatan.setBackgroundResource(R.drawable.myrect2);
        }else if(x==2){
            linearKeliatan.setBackgroundResource(R.drawable.myrect3);
        }else if(x==3){
            linearKeliatan.setBackgroundResource(R.drawable.myrect4);
        }else if(x==4){
            linearKeliatan.setBackgroundResource(R.drawable.myrect5);
        }
        DictDao dao = data.get(i);
        TextView txtKata = view.findViewById(R.id.txt_head);
        TextView txtArti = view.findViewById(R.id.txt_desc);
        txtKata.setText(dao.getKata());
        txtArti.setText(dao.getArti());
        String text = dao.getVideo();
        if (dao.getVideo() != null && !dao.getVideo().equalsIgnoreCase("")) {
            Picasso.with(activity).load("https://i.ytimg.com/vi/"+text.substring(text.lastIndexOf("embed/")+6, text.indexOf("?"))+"/maxresdefault.jpg").into((ImageView) view.findViewById(R.id.image_preview));
        }
        return view;
    }
}
