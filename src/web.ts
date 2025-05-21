import { WebPlugin } from '@capacitor/core';

import type { RingtonesPlugin, MODE, Ringtone } from './definitions';

export class RingtonesWeb extends WebPlugin implements RingtonesPlugin {
  async getRingerMode(): Promise<{mode: MODE}>{
    throw this.unimplemented('Not implemented on web.');
  }

  async getRingtones(): Promise<{ringtones: Ringtone[]}>{
    throw this.unimplemented('Not implemented on web.');
  }

  async getDefaultRingtone(): Promise<{ringtone: Ringtone}>{
    throw this.unimplemented('Not implemented on web.');
  }
}
