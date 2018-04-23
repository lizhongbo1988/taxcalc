package lizhongbo.taxcalc.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

import lizhongbo.taxcalc.beans.History;
import lizhongbo.taxcalc.R;
import lizhongbo.taxcalc.beans.History_Table;

public class HistoryActivity extends AppCompatActivity {
    private ListView mListView;
    private HistoryListAdapter mHistoryListAdapter;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        mHistoryListAdapter = new HistoryListAdapter(this);
    }
    @Override
    protected void onResume() {
        super.onResume();
        mListView = findViewById(R.id.history_list);
        List<History> historyList = SQLite.select().from(History.class).orderBy(History_Table.id, false).queryList();
        mHistoryListAdapter.setHistoryList(historyList);
        mListView.setAdapter(mHistoryListAdapter);
    }
}
