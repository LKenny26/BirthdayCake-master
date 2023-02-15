package cs301.birthdaycake;

import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.view.MotionEvent;


public class CakeController implements View.OnClickListener, CompoundButton.OnCheckedChangeListener,
        SeekBar.OnSeekBarChangeListener, View.OnTouchListener{
    private CakeView cv;
    private CakeModel cm;

    public CakeController(CakeView cvo) {
        cv = cvo;
        cm = cv.getCakeModel();
    }

    @Override
    public void onClick(View view) {
        Log.d(null, "click");
        cm.litCandles = false;
        cv.invalidate();
    }
    public boolean onTouch(View view, MotionEvent e) {
        cm.x = (int) e.getX();
        cm.y = (int) e.getY();
        Log.d(null, "move");
        cm.balloon = true;
        cv.invalidate();
        return cm.balloon;
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        Log.d(null, "switch");
        cm.candles = b;
        cv.invalidate();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        Log.d(null, "seekbar");
        cm.numCandles = i;
        cv.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

}
