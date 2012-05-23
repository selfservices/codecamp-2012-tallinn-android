package selfservice.codecamp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;

public class AndroidPuzzler extends Activity {
    /** Called when the activity is first created. */
    
	private final static String IMAGE_GET_URL = "http://172.17.37.69:8080/task3/puzzle";
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HorizontalScrollView scrollView = new HorizontalScrollView(this);

        TableLayout mainTable = new TableLayout(this);
        TableRow refreshRow = new TableRow(this);
        TableRow imagesRow = new TableRow(this);
        TableRow submitRow = new TableRow(this);
        initSubmitRow(submitRow);
        mainTable.addView(refreshRow);
        mainTable.addView(imagesRow);
        mainTable.addView(submitRow);

        scrollView.addView(mainTable);
        TableLayout imagesTable = new TableLayout(this);
        imagesRow.addView(imagesTable);
        
        setContentView(scrollView);
        new PuzzleImageLoader(imagesTable,(Context)this).execute(IMAGE_GET_URL);
    }
	
	public void initSubmitRow(TableRow submitRow) {
		EditText answerField = new EditText(this);
		Button answerSubmitButton = new Button(this);
		answerSubmitButton.setText("Answer");
		answerSubmitButton.setOnClickListener(new SubmitButtonOnClickListener(answerField));
		submitRow.addView(answerField);
		submitRow.addView(answerSubmitButton);
	}
}