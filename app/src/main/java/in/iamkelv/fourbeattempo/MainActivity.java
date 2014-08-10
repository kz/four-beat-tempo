package in.iamkelv.fourbeattempo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    // Member Variables
    private Tempo mTempo = new Tempo();
    private TextView mInstructionLabel;
    private TextView mTempoLabel;
    private TextView mResetLabel;
    private RelativeLayout mRelativeLayout;
    private ProgressBar mProgressBar;

    //Methods
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Assign the views to the layout file.
        mInstructionLabel = (TextView) findViewById(R.id.textViewInstructions);
        mTempoLabel = (TextView) findViewById(R.id.textView2);
        mResetLabel = (TextView) findViewById(R.id.textView3);
        mRelativeLayout = (RelativeLayout) findViewById(R.id.rLayout);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);

        // Create a listener for the whole app screen.
        mRelativeLayout.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View v){
                onClickHandler();
           }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void onClickHandler() {
        if (mProgressBar.getProgress() != 100) {
            mProgressBar.incrementProgressBy(25);
            if (mProgressBar.getProgress() == 100) {
                // Run the tempo calculator.
                mInstructionLabel.setVisibility(View.INVISIBLE);
                mResetLabel.setVisibility(View.VISIBLE);
                mTempoLabel.setVisibility(View.VISIBLE);
                mTempoLabel.setText(Integer.toString(mTempo.returnTempo()));
            } else {
                // Store the time of button press.
                mTempo.setTimeAtPress();
            }
        } else {
            // Reset the application.
            mInstructionLabel.setVisibility(View.VISIBLE);
            mResetLabel.setVisibility(View.INVISIBLE);
            mTempoLabel.setVisibility(View.INVISIBLE);
            mTempo.resetVariables();
            Tempo mTempo = new Tempo();
            mProgressBar.setProgress(0);
        }
    }
}
