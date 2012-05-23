package selfservice.codecamp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;

public class AndroidPuzzler extends Activity {
    /** Called when the activity is first created. */
    
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        HorizontalScrollView scrollView = new HorizontalScrollView(this);
        
        ScrollView verticalScroller = new ScrollView(this);
        scrollView.addView(verticalScroller);
        
        TableLayout mainTable = new TableLayout(this);
        
        TableRow refreshRow = new TableRow(this);

        TableRow imagesRow = new TableRow(this);
        TableRow answerRow = new TableRow(this);
        TableRow submitRow = new TableRow(this);
        TableLayout imagesTable = new TableLayout(this);
        
        initSubmitRow(submitRow,answerRow,imagesTable);
        mainTable.addView(refreshRow);
       
        mainTable.addView(imagesRow);
        mainTable.addView(answerRow);
        mainTable.addView(submitRow);

        verticalScroller.addView(mainTable);
        
        imagesRow.addView(imagesTable);
        
        new PuzzleImageLoader(imagesTable,(Context)this).execute();
        Button refreshButton = new Button(this);
        refreshButton.setText("Refresh");
        refreshButton.setOnClickListener(new PuzzleRefresher(imagesTable,(Context)this));
        refreshRow.addView(refreshButton);
        setContentView(scrollView);
        
    }
	
	public void initSubmitRow(TableRow submitRow,TableRow answerRow, TableLayout imagesTable) {
		EditText answerField = new EditText(this);
		Button answerSubmitButton = new Button(this);
		answerSubmitButton.setText("Answer");
		answerSubmitButton.setOnClickListener(new SubmitButtonOnClickListener(answerField, imagesTable, (Context)this));
		answerRow.addView(answerField);
		submitRow.addView(answerSubmitButton);
	}
}