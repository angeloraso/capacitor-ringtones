import { WebPlugin } from '@capacitor/core';
import type { RingtonesPlugin, MODE, Ringtone } from './definitions';
export declare class RingtonesWeb extends WebPlugin implements RingtonesPlugin {
    getRingerMode(): Promise<{
        mode: MODE;
    }>;
    getRingtones(): Promise<{
        ringtones: Ringtone[];
    }>;
    getDefaultRingtone(): Promise<{
        ringtone: Ringtone;
    }>;
}
