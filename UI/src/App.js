import React from "react";
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom'; // Import Router and Routes

import Login from "./Components/Login";
import AdminLogin from "./Components/AdminLogin";
import Booking from "./Components/Booking";
import Dashboard from "./Components/Dashboard";
import LandingPage from "./Components/LandingPage";
import EmployeeLogin from "./Components/EmployeeLogin";
import UserLogin from "./Components/UserLogin";
import History from "./Components/History";
import FetchServices from "./Components/FetchServices";

function App() {
  return (
    <div>
      <Router>
        <Routes>
          
          <Route path="/" element={<Dashboard />} />
          <Route path="/login" element={<Login />} />
          <Route path="/adminlogin" element={<AdminLogin />} />
          <Route path="/employeelogin" element={<EmployeeLogin />} />
          <Route path="/userlogin" element={<UserLogin />} />
          <Route path='/booking' element={<Booking />} />
          <Route path='/landingpage' element={<LandingPage/>} />
          <Route path="/history" element={<History />} />
          <Route path="/fetch" element={<FetchServices />} />

        </Routes>
      </Router>
    </div>
  );
}

export default App;
