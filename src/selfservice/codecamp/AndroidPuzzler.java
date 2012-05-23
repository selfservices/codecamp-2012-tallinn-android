package selfservice.codecamp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.TableLayout;

public class AndroidPuzzler extends Activity {
    /** Called when the activity is first created. */
    
	
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TableLayout table = new TableLayout(this);
        table.setStretchAllColumns(true);  
        table.setShrinkAllColumns(true);  
        setContentView(table);
        new PuzzleImageLoader(table,(Context)this).execute("");

    }
}