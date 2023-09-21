import {useEffect, useState} from "react";
import {fetchService} from "./VehicleApi";
import {useNavigate} from "react-router-dom";
import "./FetchServices.css";

function FetchServices() {

    const [services, setServices] = useState([])

    const navigate = useNavigate()

    const fetch = (emailId) => {
        fetchService(emailId).then((response) => {
            setServices(response.data.info)
        }).catch((error) => {
            console.log("response: " + JSON.stringify(error.response.data.message))
            setTimeout(() => {
                alert(error.response.data.message)
                navigate('/')
            }, 1000)
        })
    }

    useEffect(() => {
        var count = 0;
        while(count==0) {
            const email = window.sessionStorage.getItem("email");
            console.log(email+"<><><>");
            fetch(email+"");
            count++;
        }
    });

    return (
        <div className="Fetch-table-container">
            <table border='1px'>
                <caption>VEHICLE SERVICE HISTORY OF USERS</caption>
                <thead>
                    <tr>
                        <th>Vehicle Brand</th>
                        <th>Registration Number</th>
                        <th>Service Type</th>
                        <th>Delivery Type</th>
                        <th>Status</th>
                        <th>Charge</th>
                    </tr>
                </thead>
                <tbody>
                {
                    services.map((data) =>
                        <tr key={data.vechileId}>
                            <td>{data.vehicleBrand}</td>
                            <td>{data.registrationNumber}</td>
                            <td>{data.serviceType}</td>
                            <td>{data.deliveryType}</td>
                            <td>{data.status}</td>
                            <td>{data.charges.serviceCharge}</td>
                        </tr>
                    )
                }
                </tbody>
            </table>
        </div>
    );

}

export default FetchServices;