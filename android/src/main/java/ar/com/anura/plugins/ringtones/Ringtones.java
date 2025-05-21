package ar.com.anura.plugins.ringtones;

import static android.media.AudioManager.RINGER_MODE_NORMAL;
import static android.media.AudioManager.RINGER_MODE_SILENT;
import static android.media.AudioManager.RINGER_MODE_VIBRATE;

import android.content.Context;
import android.media.AudioManager;
import android.media.RingtoneManager;
import android.util.Log;

import android.database.Cursor;
import android.net.Uri;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Ringtones {

    private final String TAG = "Ringtones";
    private final AppCompatActivity activity;

    AudioManager audioManager;

    Ringtones(final AppCompatActivity activity) {
        Log.d(TAG, "constructor");
        this.activity = activity;
        audioManager = (AudioManager) activity.getSystemService(Context.AUDIO_SERVICE);
    }

    public String getRingerMode() {
        Log.d(TAG, "getRingerMode");

        if (audioManager == null) {
            return "normal";
        }

        int mode = audioManager.getRingerMode();
        return switch (mode) {
            case RINGER_MODE_NORMAL -> "normal";
            case RINGER_MODE_SILENT -> "silent";
            case RINGER_MODE_VIBRATE -> "vibrate";
            default -> "normal";
        };
    }

    public JSONArray getRingtones(String type) throws JSONException {
        Log.d(TAG, "getRingtones: " + type);

        int ringtoneType;

        if (type == null) {
            type = "call";
        }

        ringtoneType = switch (type.toLowerCase()) {
            case "call" -> RingtoneManager.TYPE_RINGTONE;
            case "notification" -> RingtoneManager.TYPE_NOTIFICATION;
            case "alarm" -> RingtoneManager.TYPE_ALARM;
            default -> {
                Log.e(TAG, "Invalid type");
                yield RingtoneManager.TYPE_RINGTONE;
            }
        };

        if (activity == null) {
            return new JSONArray();
        }

        Context context = activity.getApplicationContext();
        RingtoneManager ringtoneManager = new RingtoneManager(context);
        ringtoneManager.setType(ringtoneType);

        Cursor cursor = ringtoneManager.getCursor();
        JSONArray ringtones = new JSONArray();

        if (cursor.moveToFirst()) {
            do {
                int position = cursor.getPosition();
                Uri uri = ringtoneManager.getRingtoneUri(position);
                String title = ringtoneManager.getRingtone(position).getTitle(context);

                JSONObject ringtone = new JSONObject();
                ringtone.put("title", title);
                ringtone.put("uri", uri.toString());
                ringtones.put(ringtone);
            } while (cursor.moveToNext());
        } else {
            System.out.println("No ringtones found.");
        }

        cursor.close();
        return ringtones;
    }

    public JSONObject getDefaultRingtone(String type) throws JSONException {
        Log.d(TAG, "getDefaultRingtone: " + type);

        int ringtoneType;

        if (type == null) {
            type = "call";
        }

        switch (type.toLowerCase()) {
            case "call":
                ringtoneType = RingtoneManager.TYPE_RINGTONE;
                break;
            case "notification":
                ringtoneType = RingtoneManager.TYPE_NOTIFICATION;
                break;
            case "alarm":
                ringtoneType = RingtoneManager.TYPE_ALARM;
                break;
            default:
                Log.e(TAG, "Invalid type");
                return null;
        }

        Uri defaultUri = RingtoneManager.getDefaultUri(ringtoneType);
        if (defaultUri == null) {
            Log.e(TAG, "No default URI found");
            return null;
        }

        if (activity == null) {
            return null;
        }

        Context context = activity.getApplicationContext();

        if (RingtoneManager.getRingtone(context, defaultUri) == null) {
            return null;
        }

        String title = RingtoneManager.getRingtone(context, defaultUri).getTitle(context);
        JSONObject ringtone = new JSONObject();
        ringtone.put("title", title);
        ringtone.put("uri", defaultUri.toString());

        return ringtone;
    }
}
