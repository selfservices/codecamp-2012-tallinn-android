package selfservice.codecamp;

import java.net.URLEncoder;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TableLayout;
import selfservice.codecamp.net.UrlGetSender;

public class SubmitButtonOnClickListener implements OnClickListener {

	private final EditText answerField;
	private final TableLayout imagesTable;
	private final Context context;
	
	public SubmitButtonOnClickListener(EditText answerField,TableLayout imagesTable,Context context) {
		this.answerField = answerField;
		this.imagesTable = imagesTable;
		this.context = context;
	}

	@Override
	public void onClick(View v) {
		new SubmitButtonTask().execute(answerField.getText().toString());
		answerField.setText("");
		imagesTable.removeAllViews();
        new PuzzleImageLoader(imagesTable, context).execute();
	}
	
	class SubmitButtonTask extends AsyncTask<String,Void,Void> {

		@Override
		protected Void doInBackground(String... answers) {
			String answer = answers[0];
			try {
				String o = new UrlGetSender(
						 Constants.IMAGE_ANSWER_URL+ URLEncoder.encode(answer,"UTF-8"),
						Constants.SELFSERVICE_HEADER).send();
				Log.e("Answer",o);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
			return null;
		}
		
	}

}
