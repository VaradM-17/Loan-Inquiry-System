import React from "react";
import { NavLink } from "react-router-dom";

const Navbar = () => {
  return (
    <nav className="navbar navbar-expand-lg bg-primary px-3">
      <div className="container-fluid">
        <NavLink className="navbar-brand text-light" to="/inquiries">
          Navkar Finance
        </NavLink>
        <button
          className="navbar-toggler border-0"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarMainMenu"
        >
          <span className="navbar-toggler-icon"></span>
        </button>
        <div className="collapse navbar-collapse" id="navbarMainMenu">
          <div className="collapse navbar-collapse" id="navbarMainMenu">
            <ul className="navbar-nav mx-auto mb-2 mb-lg-0">
              <li className="nav-item">
                <NavLink className="nav-link text-light" to="/inquiries">
                  Inquiries
                </NavLink>
              </li>
            </ul>

            {/* <ul className="navbar-nav ms-auto mb-2 mb-lg-0">
              <li className="nav-item">
                <NavLink className="nav-link p-2" to="/about">
                  About
                </NavLink>
              </li>
            </ul> */}
          </div>
        </div>
      </div>
    </nav>
  );
};

export default Navbar;
