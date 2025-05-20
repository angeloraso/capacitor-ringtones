import { Ringtones } from '@anuradev/capacitor-ringtones';

window.testEcho = () => {
    const inputValue = document.getElementById("echoInput").value;
    Ringtones.echo({ value: inputValue })
}
