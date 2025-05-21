package ar.com.anura.plugins.ringtones;

import androidx.appcompat.app.AppCompatActivity;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "Ringtones")
public class RingtonesPlugin extends Plugin {

    private Ringtones ringtones;

    public void load() {
        AppCompatActivity activity = getActivity();
        ringtones = new Ringtones(activity);
    }

    @PluginMethod
    public void getRingerMode(PluginCall call) {
        if (getActivity().isFinishing()) {
            call.reject("Ringtones plugin error: App is finishing");
            return;
        }

        JSObject ret = new JSObject();
        ret.put("mode", ringtones.getRingerMode());
        call.resolve(ret);
    }

    @PluginMethod
    public void getRingtones(PluginCall call) {
        if (getActivity().isFinishing()) {
            call.reject("Ringtones plugin error: App is finishing");
            return;
        }

        String type = call.getString("type");

        JSObject ret = new JSObject();
        ret.put("ringtones", ringtones.getRingtones(type));
        call.resolve(ret);
    }

    @PluginMethod
    public void getDefaultRingtone(PluginCall call) {
        if (getActivity().isFinishing()) {
            call.reject("Ringtones plugin error: App is finishing");
            return;
        }

        String type = call.getString("type");

        JSObject ret = new JSObject();
        ret.put("ringtone", ringtones.getDefaultRingtone(type));
        call.resolve(ret);
    }
}
