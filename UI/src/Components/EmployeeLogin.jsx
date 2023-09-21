import React, { useState } from 'react';
import './AdminLogin.css'; 
import { Link, useNavigate } from 'react-router-dom';
import { loginEmployee } from './EmployeeApi';
import { registerEmployee } from './EmployeeApi';

function EmployeeLogin() {
  const [isSignIn, setIsSignIn] = useState(true);

  const toggleForm = () => {
    setIsSignIn(!isSignIn);
  };
  const navigate = useNavigate()

  const [loginData, setLoginData] = useState({
    'emailId': '',
    'password': ''
  })

  const handleChange = (event) => {
    setLoginData({
      ...loginData,
      [event.target.name]: event.target.value
    })
  }

  const loginEmployeeBtn = (event) => {
    event.preventDefault()
    loginEmployee(loginData).then((response) => {
      console.log('response: ' + JSON.stringify(response.data))
      window.sessionStorage.setItem("email", response.data.info);
      setTimeout(() => {
        alert(response.data.message)
        navigate('/')
      }, 1000)
    }).catch((error) => {
      console.log("response: " + JSON.stringify(error.response.data.message))
      setTimeout(() => {
        alert(error.response.data.message)
      }, 1000)
    })
  }

  const [registrationData, setRegistrationData] = useState({
    employerEmail: '',
    employeeName: '',
    employeeEmail: '',
    password: '',
    contactNo: ''
  });

  const handleChangeReg = (event) => {
    setRegistrationData({
      ...registrationData,
      [event.target.name]: event.target.value,
    });
  };

  const registerEmployeeBtn = (event) => {
    event.preventDefault();
    console.log(JSON.stringify(registrationData))
    console.log(registrationData)
    registerEmployee(registrationData)
      .then((response) => {
        console.log('response: ' + JSON.stringify(response.data));
        setTimeout(() => {
          alert(response.data.message);
          window.location.reload();
        }, 1000);
      })
      .catch((error) => {
        console.log('response: ' + JSON.stringify(error.response.data.message));
        setTimeout(() => {
          alert(error.response.data.message);
        }, 1000);
      });
  };

  return (
    <div>
      <section className="Adminlogin-section">
        <p className='Admin-p'></p>
        <div className="Adminlogin-container">
          <div className={`user ${isSignIn ? 'signinBx' : 'signupBx'}`}>
            <div className="imgBx">
              <img
                src=""
                alt=""
              />
            </div>
            <div className="formBx">
              <form action="" onSubmit={(e) => e.preventDefault()}>
                <h2>{isSignIn ? 'Sign In' : 'Create an account'}</h2>
                <input type="text" name="emailId" placeholder="Username" value={loginData.emailId} onChange={handleChange} />
                {!isSignIn && (
                  <input type="email" name="emailIds" placeholder="Email Address" />
                )}
                <input type="password" name="password" placeholder=" Password" value={loginData.password} onChange={handleChange} />

                <input type="submit" name="" value={isSignIn ? 'Login' : 'Sign Up'} onClick={loginEmployeeBtn} />
                <p className="signup">
                  {isSignIn ? "Don't have an account?" : 'Already have an account?'}
                  <a href="#" onClick={toggleForm}>
                    {isSignIn ? 'Sign Up.' : 'Sign in.'}
                  </a>
                </p>
              </form>
            </div>
          </div>
          <div className={`user ${isSignIn ? 'signupBx' : 'signinBx'}`}>
            <div className="formBx">
              <form action="" onSubmit={(e) => e.preventDefault()}>
                <h2>{isSignIn ? 'Create an account' : 'Sign In'}</h2>
                <input type="text" name="employerEmail" placeholder="Employer Email" value={registrationData.employerEmail} onChange={handleChangeReg} />
                <input type="text" name="employeeName" placeholder="Employee name" value={registrationData.employeeName} onChange={handleChangeReg} />
                {!isSignIn && (
                  <input type="email" name="employeeEmail" placeholder="Email Address" value={registrationData.employeeEmail} onChange={handleChangeReg} />
                )}
                <input type="password" name="password" placeholder="Password" value={registrationData.password} onChange={handleChangeReg} />
                <input type="text" name="contactNo" placeholder="contactNo" value={registrationData.contactNo} onChange={handleChangeReg} />
                <button type="submit" onClick={registerEmployeeBtn} >
                  {isSignIn ? 'Login' : 'Sign Up'}
                </button>
                <p className="signup">
                  {isSignIn ? 'Already have an account?' : "Don't have an account?"}
                  <a href="#" onClick={toggleForm}>
                    {isSignIn ? 'Sign in.' : 'Sign Up.'}
                  </a>
                </p>
              </form>
            </div>
            <div className="imgBx">
              <img
                src=""
                alt=""
              />
            </div>
          </div>
        </div>
      </section>
    </div>
  );
}

export default EmployeeLogin;
