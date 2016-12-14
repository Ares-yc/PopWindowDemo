package customdemo.ares.popwindowdemo;

import android.app.Activity;
import android.app.Dialog;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Ares on 2016/12/14/014.
 */

public class PopDialog extends Dialog implements OnClickListener{

    private Activity context;
    private TextView cancel;
    private onItemCheckedListener listener;
    private ImageView hiddnsIv,domainIv,serverIv;

    public static final int HIDDNS = 0;
    public static final int DOMAIN = 1;
    public static final int SERVER = 2;
    public static final int CANCEL = 3;

    public PopDialog(Activity context, onItemCheckedListener listener,int position) {
        super(context, R.style.transparentFrameWindowStyle);
        this.context = context;
        this.listener = listener;

        initDialog();
        checkImage(position);
    }

    /**  初始化Dialog */
    private void initDialog() {
        View contentView = View.inflate(getContext(),R.layout.layout_pop_dialog, null);
        setContentView(contentView);
        Window window = getWindow();
        window.setWindowAnimations(R.style.bottom2up);
        WindowManager.LayoutParams wl = window.getAttributes();
        wl.width = ViewGroup.LayoutParams.MATCH_PARENT;
        wl.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        wl.gravity = Gravity.BOTTOM;

        onWindowAttributesChanged(wl);
        setCanceledOnTouchOutside(true);
        contentView.setOnClickListener(this);

        findViewById(R.id.pop_dialog_rl_hiddns).setOnClickListener(this);
        findViewById(R.id.pop_dialog_rl_domain).setOnClickListener(this);
        findViewById(R.id.pop_dialog_rl_server).setOnClickListener(this);
        findViewById(R.id.pop_dialog_tv_cancel).setOnClickListener(this);
        hiddnsIv = (ImageView) findViewById(R.id.pop_dialog_iv_hiddns);
        domainIv = (ImageView) findViewById(R.id.pop_dialog_iv_domain);
        serverIv = (ImageView) findViewById(R.id.pop_dialog_iv_server);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.pop_dialog_rl_hiddns:
                listener.onChecked(HIDDNS);
                checkImage(HIDDNS);
                break;
            case R.id.pop_dialog_rl_domain:
                listener.onChecked(DOMAIN);
                checkImage(DOMAIN);
                break;
            case R.id.pop_dialog_rl_server:
                listener.onChecked(SERVER);
                checkImage(SERVER);
                break;
        }
        dismiss();
    }

    private void checkImage(int position){
        /**  复位 */
        hiddnsIv.setBackgroundResource(R.drawable.list_rabiobox_btn);
        domainIv.setBackgroundResource(R.drawable.list_rabiobox_btn);
        serverIv.setBackgroundResource(R.drawable.list_rabiobox_btn);
        switch (position){
            case HIDDNS:
                hiddnsIv.setBackgroundResource(R.drawable.list_rabiobox_btn_sel);
                break;
            case DOMAIN:
                domainIv.setBackgroundResource(R.drawable.list_rabiobox_btn_sel);
                break;
            case SERVER:
                serverIv.setBackgroundResource(R.drawable.list_rabiobox_btn_sel);
                break;
            case CANCEL:
                dismiss();
                break;
        }

    }

    public interface onItemCheckedListener {
        public void onChecked(int position);
    }
}
