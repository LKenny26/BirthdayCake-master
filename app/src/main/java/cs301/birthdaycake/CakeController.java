package cs301.birthdaycake;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.SeekBar;

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

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        cm.x = motionEvent.getX();
        cm.y = motionEvent.getY();

        cv.invalidate();
        return false;
    }
}
