import React, { useState } from 'react';
import './AdminLogin.css'; 
import { Link, useNavigate } from 'react-router-dom';
import { loginAdmin } from './AdminApi';
import { registerAdmin } from './AdminApi';

function AdminLogin() {
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

    const loginAdminBtn = (event) => {
        event.preventDefault()
        loginAdmin(loginData).then((response) => {
            console.log('response: '+JSON.stringify(response.data))
            window.sessionStorage.setItem("email", response.data.info);
            setTimeout(() => {
              alert(response.data.message)
              navigate('/fetch')
            },1000)
          }).catch((error) => {
            console.log("response: "+JSON.stringify(error.response.data.message))
            setTimeout(() => {
              alert(error.response.data.message)
            },1000)
          })
    }

    const [registrationData, setRegistrationData] = useState({
      adminName:'',
      adminEmail:'',
      password:'',
      contactNo:''
    });
  
    const handleChangeReg = (event) => {
      setRegistrationData({
        ...registrationData,
        [event.target.name]: event.target.value,
      });
    };
  
    const registerAdminBtn = (event) => {
      event.preventDefault();
      registerAdmin(registrationData)
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
      <p className='Admin-p'><b>THIS PAGE IS ACCESSIBLE ONLY BY ADMIN</b></p>
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
                
                <input type="submit" name="" value={isSignIn ? 'Login' : 'Sign Up'} onClick={loginAdminBtn}/>
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
                <input type="text" name="adminName" placeholder="Admin name" value={registrationData.adminName} onChange={handleChangeReg} />
                {!isSignIn && (
                  <input type="email" name="adminEmail" placeholder="Email Address" value={registrationData.adminEmail} onChange={handleChangeReg} />
                )}
                <input type="password" name="password" placeholder=" Password" value={registrationData.password} onChange={handleChangeReg} />
                <input type="text" name="contactNo" placeholder="contactNo" value={registrationData.contactNo} onChange={handleChangeReg}/>
                <button type="submit" onClick={registerAdminBtn} >
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

export default AdminLogin;