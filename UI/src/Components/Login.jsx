import React, { useState } from 'react';
import './Login.css'; 
import { useNavigate } from 'react-router-dom'
import { loginAdmin } from './AdminApi'

function Login() {
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

    const loginUser = (event) => {
        event.preventDefault()
        loginAdmin(loginData).then((response) => {
          window.sessionStorage.setItem("email", response.data.info);
            console.log('response: '+JSON.stringify(response.data))
            setTimeout(() => {
              alert(response.data.message)
              navigate('/')
            },1000)
          }).catch((error) => {
            console.log("response: "+JSON.stringify(error.response.data.message))
            setTimeout(() => {
              alert(error.response.data.message)
            },1000)
          })
    }

  return (
    <div>
      <section className="login-section">
        <div className="login-container">
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
                <input type="password" name="password" placeholder="Priya Password" value={loginData.password} onChange={handleChange} />
                
                <input type="submit" name="" value={isSignIn ? 'Login' : 'Sign Up'} onClick={loginUser}/>
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
                <input type="text" name="userName" placeholder="Username" />
                {!isSignIn && (
                  <input type="email" name="userEmail" placeholder="Email Address" />
                )}
                <input type="password" name="password" placeholder="Create Password" />
                <input type="text" name="contactNo" placeholder="contactNo" />
                <button type="submit" onClick={loginUser} >
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

export default Login;