import { createHashHistory } from "history";


export const history = createHashHistory({
  hashType: "slash",
  getUserConfirmation: (message, callback) => callback(window.confirm(message))
});