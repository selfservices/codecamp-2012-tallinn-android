package selfservice.codecamp;

import selfservice.codecamp.images.ImageUtils;
import selfservice.codecamp.net.UrlObjectConnection;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
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
			Object[][] objects = new UrlObjectConnection(Constants.IMAGE_GET_URL, Constants.SELFSERVICE_HEADER).getObject();
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
		WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		DisplayMetrics metrics = new DisplayMetrics();
		wm.getDefaultDisplay().getMetrics(metrics);

		Log.e("1","Screensize: "+metrics.heightPixels+"X"+metrics.widthPixels);
		Log.e("1","IMAGESIZE: "+result.length+"X"+result[0].length);
		int imageHeight = (metrics.heightPixels-100) / result.length;
		for (int i = 0; i < result.length; i++) {
			int imageWidth = metrics.widthPixels / result[i].length;
			TableRow row = new TableRow(context);
			for (int j = 0; j < result[i].length; j++) {
				ImageButton imageView = new ImageButton(context);
				imageView.setAdjustViewBounds(true);
				imageView.setMaxHeight(imageHeight);
				imageView.setMaxWidth(imageWidth);
				imageView.setPadding(0, 0, 0, 0);
				//imageView.set
				Bitmap map = result[i][j];
				imageView.setImageBitmap(map);
				imageView.setOnClickListener(new ImageButtonOnClickEvent(result,result[i][j],table,context,imageView,i,j));
				row.addView(imageView);
				
			}
			table.addView(row);
		}
	}

}
