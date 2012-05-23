package selfservice.codecamp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.HorizontalScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;

public class AndroidPuzzler extends Activity {
    /** Called when the activity is first created. */
    
	private final static String IMAGE_GET_URL = "http://172.17.37.69:8080/task3/puzzle";
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TableLayout mainTable = new TableLayout(this);
        TableRow refreshRow = new TableRow(this);
        TableRow imagesRow = new TableRow(this);
        TableRow submitRow = new TableRow(this);
        mainTable.addView(refreshRow);
        mainTable.addView(imagesRow);
        mainTable.addView(submitRow);

        HorizontalScrollView scrollView = new HorizontalScrollView(this);
        imagesRow.addView(scrollView);
        TableLayout table = new TableLayout(this);
        scrollView.addView(table);
        
        setContentView(mainTable);
        new PuzzleImageLoader(table,(Context)this).execute(IMAGE_GET_URL);

    }
}