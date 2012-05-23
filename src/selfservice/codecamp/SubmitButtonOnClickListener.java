package selfservice.codecamp;

import selfservice.codecamp.net.UrlGetSender.Header;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import selfservice.codecamp.net.UrlGetSender;

public class SubmitButtonOnClickListener implements OnClickListener {

	private final EditText answerField;

	public SubmitButtonOnClickListener(EditText answerField) {
		this.answerField = answerField;
	}

	@Override
	public void onClick(View v) {
		new SubmitButtonTask().execute(null,null);
		
	}
	
	class SubmitButtonTask extends AsyncTask<Void,Void,Void> {

		@Override
		protected Void doInBackground(Void... params) {
			String answer = answerField.getText().toString();
			try {
				String o = new UrlGetSender(
						"http://172.17.37.69:8080/task3/solution/" + answer,
						new Header("teamId", "test")).send();
				Log.e("Answer",o);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
			return null;
		}
		
	}

}
