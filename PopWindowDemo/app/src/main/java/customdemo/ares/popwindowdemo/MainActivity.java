package customdemo.ares.popwindowdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements PopDialog.onItemCheckedListener {

    private TextView textView;
    private int pos = PopDialog.HIDDNS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.tv);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopDialog popDialog = new PopDialog(MainActivity.this,MainActivity.this,pos);
                popDialog.show();
            }
        });
    }

    @Override
    public void onChecked(int position) {
        pos = position;
        switch (position){
            case PopDialog.HIDDNS:
                textView.setText("HiDDNS");
                break;
            case PopDialog.DOMAIN:
                textView.setText("IP/Domain");
                break;
            case PopDialog.SERVER:
                textView.setText("IP Server");
                break;
        }
    }
}
