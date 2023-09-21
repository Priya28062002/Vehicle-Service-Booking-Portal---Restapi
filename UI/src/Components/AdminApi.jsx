import ApiClient from "./ApiClient";

export const loginAdmin = (admin) => {
    return ApiClient.loginAdmin(process.env.REACT_APP_LOGIN_URL, admin);
}
export const registerAdmin = (admin) => {
    return ApiClient.registerAdmin(process.env.REACT_APP_REGISTER_URL, admin);
}

