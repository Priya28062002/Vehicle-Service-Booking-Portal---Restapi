import axios from 'axios'

export default class ApiClient {

    static async loginAdmin(url, body) {
        return await axios.post(process.env.REACT_APP_ADMIN_URL + url, body);
    }
    static async registerAdmin(url, body) {
        return await axios.post(process.env.REACT_APP_ADMIN_URL + url, body);
    }
    static async loginEmployee(url, body) {
        return await axios.post(process.env.REACT_APP_EMPLOYEE_URL + url, body);
    }
    static async registerEmployee(url, body) {
        return await axios.post(process.env.REACT_APP_EMPLOYEE_URL + url, body);
    }
    static async loginUser(url, body) {
        return await axios.post(process.env.REACT_APP_USER_URL + url, body);
    }
    static async registerUser(url, body) {
        return await axios.post(process.env.REACT_APP_USER_URL + url, body);
    }
    static async addService(url, body) {
        return await axios.post(process.env.REACT_APP_VEHICLE_URL + url, body);
    }

    static async fetchService(url){
        return await axios.get(process.env.REACT_APP_VEHICLE_URL + url);
    }

}