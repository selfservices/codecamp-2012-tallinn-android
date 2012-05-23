package selfservice.codecamp;

import selfservice.codecamp.images.ImageUtils;
import selfservice.codecamp.net.UrlGetSender.Header;
import selfservice.codecamp.net.UrlObjectConnection;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;

public class PuzzleImageLoader extends AsyncTask<String,Void, Bitmap[][]> {

	private TableLayout table;
	private Context context;
	public PuzzleImageLoader(TableLayout table,Context context) {
		this.table = table;
		this.context = context;
	}

	@Override
	protected Bitmap[][] doInBackground(String... params) {
		try {
			Object[][] objects = new UrlObjectConnection(params[0], new Header("teamId","selfservice")).getObject();
			return ImageUtils.toBitmapArray(objects);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	protected void onPostExecute(Bitmap[][] result) {
		super.onPostExecute(result);
		drawImageTable(result,context,table);
	}

	public static void drawImageTable(Bitmap[][] result, Context context, TableLayout table) {
		for (int i = 0; i < result.length; i++) {
			TableRow row = new TableRow(context);
			for (int j = 0; j < result[i].length; j++) {
				ImageButton imageView = new ImageButton(context);
				imageView.setImageBitmap(result[i][j]);
				imageView.setMaxHeight(20);
				imageView.setMaxWidth(20);
				imageView.setOnClickListener(new ImageButtonOnClickEvent(result,result[i][j],table,context,imageView,i,j));
				row.addView(imageView);
				
			}
			table.addView(row);
		}
	}

}
