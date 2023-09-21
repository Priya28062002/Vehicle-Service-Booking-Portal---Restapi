import ApiClient from "./ApiClient";

export const loginEmployee = (employee) => {
    return ApiClient.loginEmployee(process.env.REACT_APP_LOGIN_URL, employee);
}
export const registerEmployee = (employee) => {
    return ApiClient.registerEmployee(process.env.REACT_APP_REGISTER_URL, employee);
}

