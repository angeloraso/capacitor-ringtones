export declare enum MODE {
    NORMAL = "normal",
    SILENT = "silent",
    VIBRATE = "vibrate"
}
export declare enum TYPE {
    CALL = "call",
    ALARM = "alarm",
    NOTIFICATION = "notification"
}
export interface Ringtone {
    title: string;
    uri: string;
}
export interface RingtonesPlugin {
    getRingerMode(): Promise<{
        mode: MODE;
    }>;
    getRingtones(data?: {
        type: TYPE;
    }): Promise<{
        ringtones: Ringtone[];
    }>;
    getDefaultRingtone(data?: {
        type: TYPE;
    }): Promise<{
        ringtone: Ringtone;
    }>;
}
