import ApiClient from "./ApiClient";

export const loginUser = (user) => {
    return ApiClient.loginUser(process.env.REACT_APP_LOGIN_URL, user);
}
export const registerUser = (user) => {
    return ApiClient.registerUser(process.env.REACT_APP_REGISTER_URL, user);
}

