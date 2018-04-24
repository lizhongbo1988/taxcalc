package lizhongbo.taxcalc.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;

import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

import lizhongbo.taxcalc.AppDatabase;
import lizhongbo.taxcalc.beans.History;
import lizhongbo.taxcalc.R;
import lizhongbo.taxcalc.beans.History_Table;

public class HistoryActivity extends AppCompatActivity implements View.OnClickListener {
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

        Button clearBtn = findViewById(R.id.clearHistoryBtn);
        clearBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.clearHistoryBtn:
                SQLite.delete().from(History.class);
                break;
            default:
                break;
        }
    }
}
