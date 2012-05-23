package selfservice.codecamp;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TableLayout;

public class PuzzleRefresher implements OnClickListener {

	private TableLayout table;
	private Context context;
	public PuzzleRefresher(TableLayout table, Context context) {
		this.table = table;
		this.context = context;
	}
	public void onClick(View v) {
		table.removeAllViews();
        new PuzzleImageLoader(table, context).execute(Constants.IMAGE_GET_URL);

	}

}
