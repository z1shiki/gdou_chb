package gdou.gdou_chb.util.Java;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Z1shiki on 2016/11/15.
 */

public class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void jump2Activity(Class cla) {
        startActivity(new Intent(this, cla));
        this.finish();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        }

}
