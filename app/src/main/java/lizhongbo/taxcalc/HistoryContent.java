package lizhongbo.taxcalc;

import java.util.ArrayList;
import java.util.List;



/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class HistoryContent {

    public static final List<History> ITEMS = new ArrayList<>();

    private static void addItem(History item) {
        ITEMS.add(item);
    }


    /**
     * A dummy item representing a piece of content.
     */
    public static class HistoryItem {
        public final int income;
        public final int tax;
        public final int yingfa;

        public HistoryItem(int income, int tax) {
            this.income = income;
            this.tax = tax;
            this.yingfa = income - tax;
        }
    }
}
