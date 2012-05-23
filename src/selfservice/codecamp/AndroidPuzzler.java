package selfservice.codecamp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.HorizontalScrollView;
import android.widget.TableLayout;

public class AndroidPuzzler extends Activity {
    /** Called when the activity is first created. */
    
	private final static String IMAGE_GET_URL = "http://172.17.37.69:8080/task3/puzzle";
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        HorizontalScrollView scrollView = new HorizontalScrollView(this);
        TableLayout table = new TableLayout(this);
        scrollView.addView(table);
        
        setContentView(scrollView);
        new PuzzleImageLoader(table,(Context)this).execute(IMAGE_GET_URL);

    }
}