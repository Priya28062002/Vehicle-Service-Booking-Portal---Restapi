import React from 'react';
import './LandingPage.css'; // Import your CSS file
import car from '../assets/car.gif.gif';
import { useNavigate } from 'react-router-dom';

function LandingPage()
 {
    const navigate = useNavigate();
    
    const navAdminLogin = (event) => {
        navigate("../adminlogin");
    }
    const navEmployeeLogin = (event) => {
        navigate("../employeelogin");
    }
    const navUserLogin = (event) => {
        navigate("../userlogin");
    }
  return (
    <div className='Landingpage-body'>
      <header className='Landingpage-header'>
        <h1>CarPoint</h1>
        <nav className='Landingpage-nav'>
          <ul>
          <button className='Landingpage-button' onClick={navUserLogin}>User</button>
          <button className='Landingpage-button' onClick={navAdminLogin}>Admin</button>
          <button className='Landingpage-button' onClick={navEmployeeLogin}>Employee</button> 
          </ul>
        </nav>
      </header>
      <div className="Landingpage-main">
        <div className="Landingpage-content">
          <h1>Service Care</h1>
          <h3>
            Brand New <span className='Landingpage-span'>Services</span>
          </h3>
          <p>Cheap and best Services for Your Cars</p>
        </div>
        <div className="Landingpage-image">
        <img className='Landingpage-img'src={car} alt="Landingpage-car" />
        </div>
      </div>
    </div>
  );
}

export default LandingPage;
