import { registerPlugin } from '@capacitor/core';
const Ringtones = registerPlugin('Ringtones', {
    web: () => import('./web').then((m) => new m.RingtonesWeb()),
});
export * from './definitions';
export { Ringtones };
//# sourceMappingURL=index.js.map