import { WebPlugin } from '@capacitor/core';

import type { RingtonesPlugin } from './definitions';

export class RingtonesWeb extends WebPlugin implements RingtonesPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
