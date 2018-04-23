package lizhongbo.taxcalc;

import android.support.v7.app.AppCompatActivity;

import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

public class HistoryActivity extends AppCompatActivity {

    @Override
    protected void onResume() {
        super.onResume();
        List<History> historyList = SQLite.select().from(History.class).orderBy(History_Table.id, false).queryList();
    }
}
