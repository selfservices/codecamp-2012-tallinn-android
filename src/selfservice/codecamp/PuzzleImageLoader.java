package selfservice.codecamp;

import java.util.Arrays;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class PuzzleImageLoader extends AsyncTask<String,Void,ImageTable> {

	private TableLayout table;
	private Context context;
	public PuzzleImageLoader(TableLayout table,Context context) {
		this.table = table;
		this.context = context;
	}

	@Override
	protected ImageTable doInBackground(String... params) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImageTable iTable = new ImageTable();
		//iTable.addRow(Arrays.asList("Laalaa","Paipai","hipsu"));
		//iTable.addRow(Arrays.asList("Teletapit","muumit","foobaarit"));
		return iTable;
	}
	
	@Override
	protected void onPostExecute(ImageTable result) {
		super.onPostExecute(result);
		for(List<Bitmap> rowList: result.getContents()) {
			TableRow row = new TableRow(context);
			for(Bitmap image : rowList) {
				ImageView imageView = new ImageView(context);
				imageView.setImageBitmap(image);
				row.addView(imageView);
			}
			table.addView(row);
		}
	}

}
