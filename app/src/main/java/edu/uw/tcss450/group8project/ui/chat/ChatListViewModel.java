package edu.uw.tcss450.group8project.ui.chat;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.IntFunction;

import edu.uw.tcss450.group8project.R;

public class ChatListViewModel extends AndroidViewModel {
    private MutableLiveData<List<ChatPreview>> mChatList;
    public ChatListViewModel(@NonNull Application application) {
        super(application);
        mChatList = new MutableLiveData<>();
        mChatList.setValue(new ArrayList<>());
    }
    public void addChatListObserver(@NonNull LifecycleOwner owner,
                                    @NonNull Observer<? super List<ChatPreview>> observer) {
        mChatList.observe(owner, observer);
    }

    private void handleError(final VolleyError error) {
        //you should add much better error handling in a production release.
        //i.e. YOUR PROJECT
        Log.e("CONNECTION ERROR", error.getLocalizedMessage());
        throw new IllegalStateException(error.getMessage());
    }

    private void handleResult(final JSONObject result) {
        IntFunction<String> getString =
                getApplication().getResources()::getString;
        try {
            JSONObject root = result;
            if (root.has(getString.apply(R.string.keys_json_success))) {
                JSONArray nameJSON =
                        root.getJSONArray(getString.apply(
                                R.string.keys_json_chat_name));
                JSONArray previewsJSON = root.getJSONArray(
                        getString.apply(R.string.keys_json_chat_previews));
                for(int i = 0; i < previewsJSON.length(); i++) {
                    JSONObject jsonChat = previewsJSON.getJSONObject(i);
                    JSONObject jsonName = nameJSON.getJSONObject(i);
                    ChatPreview chatPreview = new ChatPreview.Builder(
                            jsonChat.getString(
                                    getString.apply(
                                            R.string.keys_json_chat_timestamp)),
                            jsonName.getString(
                                    getString.apply(
                                            R.string.keys_json_chat_chatname)),
                            jsonChat.getInt(
                                    getString.apply(
                                            R.string.keys_json_chat_chatid)))
                            .addPreview(jsonChat.getString(
                                    getString.apply(
                                            R.string.keys_json_chat_preview)))
                            .build();
                        if (!Objects.requireNonNull(mChatList.getValue()).contains(chatPreview)) {
                            mChatList.getValue().add(chatPreview);
                        }
                    }
            } else {
                Log.e("ERROR!", "No response");
            }
        } catch (JSONException e) {
            e.printStackTrace();
            Log.e("ERROR!", e.getMessage());
        }
        mChatList.setValue(mChatList.getValue());
    }

    public void connectGet(final String jwt) {
        String url = getApplication().getResources().getString(R.string.heroku_url) +
                "previews";
        Request request = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null, //no body for this get request
                this::handleResult,
                this::handleError) {
            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> headers = new HashMap<>();
                // add headers <key,value>
                headers.put("Authorization", jwt);
                return headers;
            }
        };
        request.setRetryPolicy(new DefaultRetryPolicy(
                10_000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        //Instantiate the RequestQueue and add the request to the queue
        Volley.newRequestQueue(getApplication().getApplicationContext())
                .add(request);
    }
}
