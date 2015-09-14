package innoli.com.aacal.domain;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by yli on 9/11/2015.
 */
public class Calculator {

    public List<Result> calculate(double total, double tipRate, int peopleCount,
                                  boolean hasDriver, int driverCount, double driverDiscount,
                                  boolean needInteger) {
        List<Result> results = Lists.newArrayList();

        if (peopleCount > 0) {
            double sum = total * (1 + tipRate);

            if (!hasDriver || driverCount == 0) {
                double average = sum / peopleCount;

                if (needInteger) {
                    // lower
                    double lAverage = Math.round(average);
                    double lTotal = lAverage * peopleCount;
                    double lRealTip = lTotal / total - 1.0;
                    results.add(new Result(lAverage, lRealTip, lTotal));
                } else {
                    Result aResult = new Result(average, tipRate, total);
                    results.add(aResult);
                }

            } else {

                double aSum = sum + driverDiscount * driverCount;
                double average = aSum / peopleCount;

                double driverAverage = average - driverDiscount;

                if (needInteger) {
                    double lAverage = Math.round(average);
                    double rDriverAverage = Math.round(driverAverage);
                    double lTotal = lAverage * (peopleCount - driverCount) + rDriverAverage * driverCount;
                    double lRealTip = lTotal / total - 1.0;
                    results.add(new Result(lAverage, lRealTip, lTotal, rDriverAverage));
                }
            }

        }

        return results;
    }

}
