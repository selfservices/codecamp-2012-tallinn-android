package selfservice.codecamp;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TableLayout;

public class ImageButtonOnClickEvent implements OnClickListener {

	private final Bitmap[][] result; 
	private final Bitmap image;
	private final TableLayout table;
	private final Context context;
	private final ImageButton button;
	private final int i;
	private final int j;
	
	private static int firstI = -1;
	private static int firstJ = -1;

	private static int secondI = -1;
	private static int secondJ = -1;

	public ImageButtonOnClickEvent(Bitmap[][] result, Bitmap image, TableLayout table, Context context,ImageButton button, int i, int j) {
		this.result = result;
		this.image = image;
		this.table = table;
		this.context = context;
		this.button = button;
		this.i = i;
		this.j = j;
	}

	public void onClick(View v) {
		button.setSelected(true);
//		button.set
		if (firstI < 0) {
			firstI = this.i;
			firstJ = this.j;

			Log.e("2","ONE NULL");
		} else if(secondI < 0) {
			secondI = this.i;
			secondJ = this.j;
			Log.e("2","REDRAW");
			Bitmap tmp = result[firstI][firstJ];
			result[firstI][firstJ] = result[secondI][secondJ];
			result[secondI][secondJ] = tmp;	
			//redraw
			table.removeAllViews();
			PuzzleImageLoader.drawImageTable(result, context, table);
			//Clear
			firstI = -1;
			firstJ = -1;
			secondI = -1;
			secondJ = -1;
		}
		
		
	}

}
