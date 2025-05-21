# @anuradev/capacitor-ringtones

Capacitor plugin to get ringtones info

## Install

```bash
npm install @anuradev/capacitor-ringtones
npx cap sync
```

## API

<docgen-index>

* [`getRingerMode()`](#getringermode)
* [`getRingtones(...)`](#getringtones)
* [`getDefaultRingtone(...)`](#getdefaultringtone)
* [Interfaces](#interfaces)
* [Enums](#enums)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### getRingerMode()

```typescript
getRingerMode() => Promise<{ mode: MODE; }>
```

**Returns:** <code>Promise&lt;{ mode: <a href="#mode">MODE</a>; }&gt;</code>

--------------------


### getRingtones(...)

```typescript
getRingtones(data?: { type: TYPE; } | undefined) => Promise<{ ringtones: Ringtone[]; }>
```

| Param      | Type                                             |
| ---------- | ------------------------------------------------ |
| **`data`** | <code>{ type: <a href="#type">TYPE</a>; }</code> |

**Returns:** <code>Promise&lt;{ ringtones: Ringtone[]; }&gt;</code>

--------------------


### getDefaultRingtone(...)

```typescript
getDefaultRingtone(data?: { type: TYPE; } | undefined) => Promise<{ ringtone: Ringtone; }>
```

| Param      | Type                                             |
| ---------- | ------------------------------------------------ |
| **`data`** | <code>{ type: <a href="#type">TYPE</a>; }</code> |

**Returns:** <code>Promise&lt;{ ringtone: <a href="#ringtone">Ringtone</a>; }&gt;</code>

--------------------


### Interfaces


#### Ringtone

| Prop        | Type                |
| ----------- | ------------------- |
| **`title`** | <code>string</code> |
| **`uri`**   | <code>string</code> |


### Enums


#### MODE

| Members       | Value                  |
| ------------- | ---------------------- |
| **`NORMAL`**  | <code>'normal'</code>  |
| **`SILENT`**  | <code>'silent'</code>  |
| **`VIBRATE`** | <code>'vibrate'</code> |


#### TYPE

| Members            | Value                       |
| ------------------ | --------------------------- |
| **`CALL`**         | <code>'call'</code>         |
| **`ALARM`**        | <code>'alarm'</code>        |
| **`NOTIFICATION`** | <code>'notification'</code> |

</docgen-api>
