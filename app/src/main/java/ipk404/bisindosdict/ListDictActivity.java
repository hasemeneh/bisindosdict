package ipk404.bisindosdict;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import ipk404.bisindosdict.Dao.DictDao;
import ipk404.bisindosdict.DatabaseManager.DBManager;
import ipk404.bisindosdict.adapter.ListDictsAdapter;

public class ListDictActivity extends AppCompatActivity {

    private ListView listDict;
    private static String DICT_DAO="DICT_DAO";
    public static void startThisActivity(Activity activity,String keyword) {
        Intent i = new Intent(activity, ListDictActivity.class);
        i.putExtra(DICT_DAO,keyword);
        activity.startActivity(i);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_dict);
        String keyword = getIntent().getStringExtra(DICT_DAO);
        final List<DictDao> data = DBManager.getDictByName(this,keyword);
        ListDictsAdapter adapter = new ListDictsAdapter(data,this);
        listDict = findViewById(R.id.list_item_dict);
        listDict.setAdapter(adapter);
        listDict.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                DetailKataActivity.startThisActivity(ListDictActivity.this,data.get(i));
            }
        });


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
