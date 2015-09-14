package innoli.com.aacal.domain;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * Created by yli on 9/11/2015.
 */
public class Result {

    private double normalPersonPay = 0.0;

    private double driverPay = 0.0;

    private double realTipRate = 0.0;

    private double realTotal = 0.0;

    public Result(double normalPersonPay, double realTipRate, double realTotal) {
        this.normalPersonPay = normalPersonPay;
        this.realTipRate = realTipRate;
        this.realTotal = realTotal;
    }

    public Result(double normalPersonPay, double realTipRate, double realTotal, double driverPay) {
        this(normalPersonPay, realTipRate, realTotal);
        this.driverPay = driverPay;
    }

    public double getNormalPersonPay() {
        return normalPersonPay;
    }

    public double getDriverPay() {
        return driverPay;
    }

    public double getRealTipRate() {
        return realTipRate;
    }

    public double getRealTotal() {
        return realTotal;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(Result.class)
                .add("normal people pay", getNormalPersonPay())
                .add("driver pay", getDriverPay())
                .add("real total", getRealTotal())
                .add("real tip rate", getRealTipRate())
                .toString();
    }
}
