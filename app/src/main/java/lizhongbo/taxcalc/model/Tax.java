package lizhongbo.taxcalc.model;

/*税率接口*/

public interface Tax {
    int GetLevel();
    int GetStartPrice();
    double GetPercent();
    int GetReduced();
}
