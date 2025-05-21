'use strict';

var core = require('@capacitor/core');

exports.MODE = void 0;
(function (MODE) {
    MODE["NORMAL"] = "normal";
    MODE["SILENT"] = "silent";
    MODE["VIBRATE"] = "vibrate";
})(exports.MODE || (exports.MODE = {}));
exports.TYPE = void 0;
(function (TYPE) {
    TYPE["CALL"] = "call";
    TYPE["ALARM"] = "alarm";
    TYPE["NOTIFICATION"] = "notification";
})(exports.TYPE || (exports.TYPE = {}));

const Ringtones = core.registerPlugin('Ringtones', {
    web: () => Promise.resolve().then(function () { return web; }).then((m) => new m.RingtonesWeb()),
});

class RingtonesWeb extends core.WebPlugin {
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

var web = /*#__PURE__*/Object.freeze({
    __proto__: null,
    RingtonesWeb: RingtonesWeb
});

exports.Ringtones = Ringtones;
//# sourceMappingURL=plugin.cjs.js.map
