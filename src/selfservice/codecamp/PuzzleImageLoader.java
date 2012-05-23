package selfservice.codecamp;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class PuzzleImageLoader extends AsyncTask<String,Void,Void> {

	private TableLayout table;
	private Context context;
	public PuzzleImageLoader(TableLayout table,Context context) {
		this.table = table;
		this.context = context;
	}

	@Override
	protected Void doInBackground(String... params) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	protected void onPostExecute(Void result) {
		super.onPostExecute(result);
		TableRow row = new TableRow(context);
		TextView rowLabel = new TextView(context);
		rowLabel.setText("LAALAA");
		row.addView(rowLabel);
		table.addView(row);
	}

}
