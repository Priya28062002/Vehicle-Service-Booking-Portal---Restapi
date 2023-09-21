import React from 'react';
import { useLocation } from 'react-router-dom';
import './History.css';

export default function History() {
  const location = useLocation();
  const serviceData = location.state.formData;

  return (
    <div className="History-table-container">
      <h1 className="History-table-title"><span className='History-span'>USER SERVICE HISTORY</span></h1>
      <table className="History-excel-table">
        <thead>
          <tr>
            <th>User Email</th>
            <th>Vehicle Brand</th>
            <th>Registration Number</th>
            <th>Service Type</th>
            <th>Delivery Type</th>
            <th>Status</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>{serviceData.userEmail}</td>
            <td>{serviceData.vehicleBrand}</td>
            <td>{serviceData.registrationNumber}</td>
            <td>{serviceData.serviceType}</td>
            <td>{serviceData.deliveryType}</td>
            <td>{serviceData.status}</td>
          </tr>
        </tbody>
      </table>
      
    </div>
  );
}
