package innoli.com.aacal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.google.common.base.Strings;

import java.util.List;

import innoli.com.aacal.domain.Calculator;
import innoli.com.aacal.domain.Result;

public class MainActivity extends AppCompatActivity {

    private EditText totalPriceEditText;
    private EditText taxRateEditText;
    private EditText peopleEditText;
    private EditText driverCountEditText;
    private EditText driverDiscountEditText;
    private EditText resultEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalPriceEditText = (EditText)findViewById(R.id.editText_total);
        taxRateEditText = (EditText)findViewById(R.id.editText_tax_rate);
        peopleEditText = (EditText)findViewById(R.id.editText_people);
        driverCountEditText = (EditText)findViewById(R.id.editText_drivers);
        driverDiscountEditText = (EditText)findViewById(R.id.editText_driver_discount);
        resultEditText = (EditText)findViewById(R.id.editText_result);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.calculate) {
            doCalculate();
        }

        return super.onOptionsItemSelected(item);
    }

    private void doCalculate() {
        double totalPrice = Double.parseDouble(nullEmptyToDefault(totalPriceEditText.getText().toString(), "0.0"));
        double taxRate = Double.parseDouble(nullEmptyToDefault(taxRateEditText.getText().toString(), "0.0"));
        int peopleCount = Integer.parseInt(nullEmptyToDefault(peopleEditText.getText().toString(), "1"));
        int driverCount = Integer.parseInt(nullEmptyToDefault(driverCountEditText.getText().toString(), "0"));
        double driverDiscount = Double.parseDouble(nullEmptyToDefault(driverDiscountEditText.getText().toString(), "0"));

        List<Result> result = new Calculator().calculate(totalPrice, taxRate / 100.0, peopleCount, true,
                driverCount, driverDiscount, true);

        if (result.size() > 0) {
            resultEditText.setText(result.get(0).toString());
        }
    }

    private String nullEmptyToDefault(String input, String aDefault) {
        if (Strings.isNullOrEmpty(input)) {
            return aDefault;
        } else {
            return input;
        }
    }
}
