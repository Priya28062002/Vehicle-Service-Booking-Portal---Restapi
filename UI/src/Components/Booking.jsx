import React, { useState } from 'react';
import './Booking.css';
import { addService } from './VehicleApi';
import {  useNavigate } from 'react-router-dom';

function Booking() {
  const [formData, setFormData] = useState({
    userEmail: '',
    vehicleBrand: '',
    registrationNumber: '',
    serviceType: '',
    deliveryType: '',
    status: 'Open'
  });

  const navigate = useNavigate()

  const handleChange = (event) => {
    setFormData({
      ...formData,
      [event.target.name]: event.target.value
    })
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    addService(formData).then((response) => {
      console.log('response: ' + JSON.stringify(response.data))
      setTimeout(() => {
        alert(response.data.message)
        navigate('/history' , {state : {
          formData
        }})
      }, 1000)
    }).catch((error) => {
      console.log("response: " + JSON.stringify(error.response.data.message))
      setTimeout(() => {
        alert(error.response.data.message)
      }, 1000)
    })

  };

  // Array of vehicle brands
  const vehicleBrands = [
    'Maruti',
    'Honda',
    'Hyundai',
    'Toyota',
    'Ford',
    'Volkswagen',
    'Tata',
    'Mahindra',
    'Kia',
    'Nissan',
    'Renault',
    'Chevrolet',
    // Add more brands as needed
  ];

  // Array of service types
  const serviceTypes = [
    'Punchture',
    'Water Wash',
    'Air Filter Change',
    'Battery Change'
  ];

  return (
    <div className="BookingBody">
      <header></header>
      <form id="booking-form" onSubmit={handleSubmit}>
        <fieldset>
          <label htmlFor="userEmail">Email</label>
          <input
            id="userEmail"
            type="email"
            name="userEmail"
            placeholder="Your Email"
            value={formData.userEmail}
            onChange={handleChange}
            required
            className="form-control"
          />
        </fieldset>
        <fieldset>
          <label htmlFor="vehicleBrand">Vehicle Brand</label>
          <select
            id="vehicleBrand"
            name="vehicleBrand"
            value={formData.vehicleBrand}
            onChange={handleChange}
            required
            className="form-control"
          >
            <option value="" disabled>Select Vehicle Brand</option>
            {vehicleBrands.map((brand, index) => (
              <option key={index} value={brand}>
                {brand}
              </option>
            ))}
          </select>
        </fieldset>
        <fieldset>
          <label htmlFor="registrationNumber">Registration Number</label>
          <input
            id="registrationNumber"
            type="text"
            name="registrationNumber"
            placeholder="Your Registration Number"
            value={formData.registrationNumber}
            onChange={handleChange}
            required
            className="form-control"
          />
        </fieldset>
        <fieldset>
          <label htmlFor="serviceType">Service Type</label>
          <select
            id="serviceType"
            name="serviceType"
            value={formData.serviceType}
            onChange={handleChange}
            required
            className="form-control"
          >
            <option value="" disabled>Select Service Type</option>
            {serviceTypes.map((service, index) => (
              <option key={index} value={service}>
                {service}
              </option>
            ))}
          </select>
        </fieldset>
        <fieldset>
          <label htmlFor="deliveryType">Delivery Type</label>
          <select
            id="deliveryType"
            name="deliveryType"
            value={formData.deliveryType}
            onChange={handleChange}
            required
            className="form-control"
          >
            <option value="" disabled>Select Delivery Type</option>
            <option value="Home-Delivery">Home Delivery</option>
            <option value="In-Person_pickup">In-Person Pickup</option>
          </select>
        </fieldset>
        {/* Add other fields as needed */}
        <fieldset>
          <button type="submit" id="submit" className="submit-button">
            Submit
          </button>
        </fieldset>
      </form>
    </div>
  );
}

export default Booking;