import ApiClient from "./ApiClient";

export const addService = (vehicle) => {
    return ApiClient.addService(process.env.REACT_APP_SERVICE_ADD_URL, vehicle);
}

export const fetchService = (emailId) => {
    return ApiClient.fetchService(process.env.REACT_APP_FETCH_SERVICE_URL + "/"+ emailId);
}