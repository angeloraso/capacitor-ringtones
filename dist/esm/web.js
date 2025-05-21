import { WebPlugin } from '@capacitor/core';
export class RingtonesWeb extends WebPlugin {
    async getRingerMode() {
        throw this.unimplemented('Not implemented on web.');
    }
    async getRingtones() {
        throw this.unimplemented('Not implemented on web.');
    }
    async getDefaultRingtone() {
        throw this.unimplemented('Not implemented on web.');
    }
}
//# sourceMappingURL=web.js.map