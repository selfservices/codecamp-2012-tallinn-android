package selfservice.codecamp;

import java.util.Arrays;
import java.util.List;

import selfservice.codecamp.images.ImageUtils;
import selfservice.codecamp.net.UrlObjectConnection;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;

public class PuzzleImageLoader extends AsyncTask<String,Void,ImageTable> {

	private TableLayout table;
	private Context context;
	public PuzzleImageLoader(TableLayout table,Context context) {
		this.table = table;
		this.context = context;
	}

	@Override
	protected ImageTable doInBackground(String... params) {
		
		ImageTable iTable = new ImageTable();

		try {
			Object[][] objects = new UrlObjectConnection(params[0]).getObject();
			Bitmap[][] images = ImageUtils.toBitmapArray(objects);
			for(Bitmap[] imageRow : images) {
				iTable.addRow(Arrays.asList(imageRow));
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return iTable;
	}
	
	@Override
	protected void onPostExecute(ImageTable result) {
		super.onPostExecute(result);
		drawImageTable(result,context,table);
	}

	public static void drawImageTable(ImageTable result, Context context, TableLayout table) {
		for(List<Bitmap> rowList: result.getContents()) {
			TableRow row = new TableRow(context);
			for(Bitmap image : rowList) {
				ImageButton imageView = new ImageButton(context);
				imageView.setImageBitmap(image);
				imageView.setMaxHeight(20);
				imageView.setMaxWidth(20);
				imageView.setOnClickListener(new ImageButtonOnClickEvent(result,image,table,context,imageView));
				row.addView(imageView);
				
			}
			table.addView(row);
		}
	}

}
