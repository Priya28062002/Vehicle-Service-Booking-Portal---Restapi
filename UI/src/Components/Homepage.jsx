import React, { Component } from 'react';
import './Homepage.css';
import {BsFacebook} from 'react-icons/bs';
import {GrInstagram} from 'react-icons/gr';
import {BsTwitter} from 'react-icons/bs';
 import { Link } from 'react-router-dom';


// <Link to="/login">Submit</Link>


class Homepage extends Component {
  constructor(props) {
    super(props);
    this.state = {
      isSearchActive: false,
      isMenuActive: false,
    };
  }

  handleSearchIconClick = () => {
    this.setState((prevState) => ({
      isSearchActive: !prevState.isSearchActive,
      isMenuActive: false,
    }));
  };

  handleMenuIconClick = () => {
    this.setState((prevState) => ({
      isMenuActive: !prevState.isMenuActive,
      isSearchActive: false,
    }));
  };

  handleScroll = () => {
    this.setState({
      isMenuActive: false,
      isSearchActive: false,
    });
  };

  componentDidMount() {
    window.addEventListener('scroll', this.handleScroll);
    let search = document.querySelector('.search-box');
    document.querySelector('#search-icon').onclick = () => {
      search.classList.toggle('active');
    };
    let menu = document.querySelector('.navbar');
    document.querySelector('#menu-icon').onclick = () => {
      menu.classList.toggle('active');
      search.classList.remove('active');
    };
    window.onscroll = () => {
      menu.classList.remove('active');
      search.classList.remove('active');
    };
    let header = document.querySelector('header');
    window.addEventListener('scroll', () => {
      header.classList.toggle('shadow', window.scrollY > 0);
    });
  }

  componentWillUnmount() {
    window.removeEventListener('scroll', this.handleScroll);
  }

  render() {
    const { isSearchActive, isMenuActive } = this.state;

    return (
      <div>
        <header>
          <div className="nav container">
            <i
              className={`bx ${isMenuActive ? 'bx-x' : 'bx-menu'}`}
              id="menu-icon"
              onClick={this.handleMenuIconClick}
            ></i>
            <a href="#" className="logo">
              Car<span>Point</span>
            </a>
            <ul className="navbar">
              <li><a href="#home" className="active">Home</a></li>
              <li><a href="#service">Service</a></li>
              <li><a href="#about">About</a></li>
              <li><a href="#parts">Parts</a></li>
              <li><a href="#review">Review</a></li>
              <Link to="/landingpage" className='btn'>LandingPage</Link>
            </ul>
            <i
              className={`bx ${
                isSearchActive ? 'bx-x' : 'bx-search-alt-2'
              }`}
              id="search-icon"
              onClick={this.handleSearchIconClick}
            ></i>
            <div className="search-box container">
              <input
                type="search"
                name=""
                id=""
                placeholder="Search here..."
              />
            </div>
          </div>
        </header>
        <section className="home" id="home">
          <div className="home-text">
            <h1>We Have Everything <br /> Your <span>Car</span> Need</h1>
            <p>   "WHOEVER SAID MONEY CAN'T BUY HAPPINESS JUST NEVER BOUGHT THE RIGHT CAR"  </p>
            <Link to="/booking" className="btn">Book Now</Link>
          </div>
        </section>
        <section className="service" id="service">
          <div className="heading">
            <span>Service</span>
            <h2> "Service: Where actions speak louder than words."</h2>
            <p>Service is the heart of every successful endeavor, where excellence and empathy intersect to create meaningful experiences.</p>
          </div>
          <div className="cars-container container">
            <div className="box">
              <img src="https://vehiclecare.in/static/media/car_wash.19c897f055a73008d3d8.png" alt="" />
              <h2>Car Service</h2>
            </div>
            <div className="box">
              <img src="https://vehiclecare.in/static/media/wheel_care.116bd16a99cbfb2dbb03.png" alt="" />
              <h2>Wheel care</h2>
            </div>
            <div className="box">
              <img src="https://vehiclecare.in/static/media/ac_repair.cc08496dd54911ff48a2.png" alt="" />
              <h2>Car AC Repair</h2>
            </div>
            <div className="box">
              <img src="https://vehiclecare.in/static/media/denting_painting.36404976b0e8d3e25a1e.png" alt="" />
              <h2>Denting & Painting</h2>
            </div>
            <div className="box">
              <img src="https://vehiclecare.in/static/media/battery.53172e4d89c369df90c9.png" alt="" />
              <h2>Car Battery</h2>
            </div>
            <div className="box">
              <img src="https://vehiclecare.in/static/media/custum_repair.b7d44c9e009429b069fc.png" alt="" />
              <h2>Custom Repair</h2>
            </div>
          </div>
        </section>
        <section className="about container" id="about">
          <div className="about-img">
            <img src="https://img.freepik.com/free-photo/car-repair-maintenance-theme-mechanic-uniform-working-auto-service_627829-3918.jpg?size=626&ext=jpg&uid=R115089061&ga=GA1.2.1733647200.1656571139&semt=ais" alt="" />
          </div>
          <div className="about-text">
            <h2><span>About Us</span></h2>
            

            <p>At <span>CarPoint</span>, we're your go-to destination for hassle-free vehicle maintenance and repair. Our mission is to simplify the process, connecting you with trusted service providers in your area. With transparent pricing, a user-friendly platform, and a commitment to excellence, we ensure your vehicle receives the care it deserves. Say goodbye to long wait times and hello to convenience. Your vehicle, our priority. Join us today and experience a new level of efficiency in vehicle maintenance.</p>
            <Link to="/adminlogin" className="btn">Service History</Link>
          </div>
        </section>
        <section className="parts" id="parts">
          <div className="heading">
            <span>Parts</span>
            <h3>"Quality parts make for a smooth ride. Choose reliability, choose excellence."</h3>
            <p>Precision in every piece, performance in every mile.</p>
          </div>
          <div className="parts-container container">
            <div className="box">
              <img src="https://i.pinimg.com/564x/10/e8/67/10e8670e841f87c5f915d788b3d62db4.jpg" alt="" />
              <h3>Door</h3>
              <span>Rs.7,999 - 10,500</span>
             
              <a href="#" className="btn">Buy now</a>
              <a href="#" className="details">View Details</a>
            </div>
            <div className="box">
              <img src="https://autolovins.com/wp-content/uploads/2021/02/car-Engine.jpg?ezimgfmt=ng:webp/ngcb1" alt="" />
              <h3>Engine</h3>
              <span>Rs.45,000 - 60,000</span>
              
              <a href="#" className="btn">Buy now</a>
              <a href="#" className="details">View Details</a>
            </div>
            <div className="box">
              <img src="https://autolovins.com/wp-content/uploads/2021/02/car-battery.jpg?ezimgfmt=ng:webp/ngcb1" alt="" />
              <h3>Battery</h3>
              <span>Rs.3,699 - 6,999</span>
              
              <a href="#" className="btn">Buy now</a>
              <a href="#" className="details">View Details</a>
            </div>
            <div className="box">
              <img src="https://autolovins.com/wp-content/uploads/2021/02/car-Alternator.jpg?ezimgfmt=ng:webp/ngcb1" alt="" />
              <h3>Alternator</h3>
              <span>Rs.7,000 - 16,000</span>
              
              <a href="#" className="btn">Buy now</a>
              <a href="#" className="details">View Details</a>
            </div>
            <div className="box">
              <img src="https://autolovins.com/wp-content/uploads/2021/02/Car-Mirror.jpg?ezimgfmt=ng:webp/ngcb1" alt=""/>
              <h3> Mirror</h3>
              <span>Rs.300 - 3,500</span>
              
              <a href="#" className="btn">Buy now</a>
              <a href="#" className="details">View Details</a>
              </div>
            <div className="box">
              <img src="https://autolovins.com/wp-content/uploads/2021/02/Car-Wheels-Autolovins.com_.jpg?ezimgfmt=ng:webp/ngcb1" alt="" />
              <h3>Wheel</h3>
              <span>Rs.4,499 - 14,699</span>
              
              <a href="#" className="btn">Buy now</a>
              <a href="#" className="details">View Details</a>
            </div>
          </div>
        </section>
        <section className="review" id="review">
          <div className="heading">
            <span>Review</span>
            <h2>"Quality speaks louder than words."</h2>
            <p>Thank you for your positive feedback!</p>
          </div>
          <div className="blog-container container">
            <div className="box">
              <img src="https://img.freepik.com/free-photo/young-bearded-man-with-striped-shirt_273609-5677.jpg?w=996&t=st=1693834947~exp=1693835547~hmac=3e539a5aa766d28f43d479b990daba0e30686f46734b28045bcc9544049c6652" alt="car" />
              <div className="blog-text">
                <a href="#">"Booking my vehicle service through this platform was a breeze. They have a wide network of trusted mechanics, and I received fast and efficient service. Highly recommended!"</a>
                <p><span>August 12, 2023</span></p>
                <p><i className='bx bxs-star' >4.8 Rating</i></p>
              </div>
            </div>
            <div className="box">
            <img src="https://img.freepik.com/free-photo/female-model-posing-pink-wall_114579-13995.jpg?size=626&ext=jpg&uid=R115089061&ga=GA1.2.1733647200.1656571139&semt=ais" alt="car" />
              <div className="blog-text">
                <a href="#">"I used this service to schedule my car's maintenance, and it saved me so much time and hassle. The mechanic they connected me with was skilled and professional. I'll definitely use them again."</a>
                <p><span>March 10, 2023</span></p>
                <p><i className='bx bxs-star' >4.2 Rating</i></p>
              </div>
            </div>
            <div className="box">
            <img src="https://img.freepik.com/free-photo/portrait-happy-smiley-man_23-2149022624.jpg?size=626&ext=jpg&uid=R115089061&ga=GA1.2.1733647200.1656571139&semt=ais" alt="car" />
              <div className="blog-text">
                <a href="#">"I'm so glad I found this platform. Not only did I get a great deal on my car service, but the process was incredibly convenient. No more waiting in long lines at the auto shop for me!"</a>
                <p><span>February 2,2023</span></p>
                <p><i className='bx bxs-star' >4.5 Rating</i></p>
              </div>
            </div>
          </div>
        </section>
        <section class="footer">
  <div class="footer-container container">
    <div class="footer-box">
      <a href="#" class="logo">Cars<span>Point</span></a>
      <div class="social">
      <a href="https://facebook.com"><BsFacebook /></a>
        <a href="https://instagram.com"><GrInstagram /></a>
        <a href="https://twitter.com"><BsTwitter /></a>
      </div>
    </div>
    <div class="footer-box">
      <h3>Page</h3>
      <a href="#">Home</a>
      <a href="#">Cars</a>
      <a href="#">Parts</a>
      <a href="#">Sales</a>
    </div>
    <div class="footer-box">
      <h3>Legal</h3>
      <a href="#">Privacy</a>
      <a href="#">Refund policy</a>
      <a href="#">Cookie Policy</a>
    </div>
    <div class="footer-box">
      <h3>Contact</h3>
      <p>United states</p>
      <p>Japan</p>
      <p>Germany</p>
    </div>
  </div>
</section>
<div class="copyright">
  <p> &#169; CarPoint all rigthts reserved</p>
    </div>
    </div>
    );
  }
}

export default Homepage;