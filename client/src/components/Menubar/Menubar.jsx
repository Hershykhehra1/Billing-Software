import { Link, useNavigate } from 'react-router-dom';
import { assets } from '../../assets/assets';
import './Menubar.css';
import { useContext } from 'react';
import { AppContext } from '../../context/AppContext';

const Menubar = () => {

    const {setAuthData} = useContext(AppContext);
    const navigate = useNavigate();

    const logout = () => {
        localStorage.removeItem('token');
        localStorage.removeItem('role');
        setAuthData(null, null);
        navigate('/login');
    }

  return (
    <nav className="navbar navbar-expand-lg navbar-dark bg-dark px-2">
    <a className="navbar-brand" href="#">
        <img src={assets.logo} alt="Logo" height="40"/>
    </a>
    <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span className="navbar-toggler-icon"></span>
    </button>
    <div className="collapse navbar-collapse p-2" id="navbarNav">
        <ul className="navbar-nav me-auto mb-2 mb-lg-0">
            <li className="nav-item">
                <Link className="nav-link" to="/dashboard">Dashboard</Link>
            </li>
            <li className="nav-item">
                <Link className="nav-link" to="/explore">Explore</Link>
            </li>
            <li className="nav-item">
                <Link className="nav-link" to="/items">Manage Items</Link>
            </li>
            <li className="nav-item">
                <Link className="nav-link" to="/category">Manage Categories</Link>
            </li>
            <li className="nav-item">
                <Link className="nav-link" to="/users">Manage Users</Link>
            </li>
        </ul>
        {/* add dropdown for user profile */}
        <ul className="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
            <li className="nav-item dropdown">
                <a href="#" className="nav-link dropdown-toggle" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                    <img src={assets.profile} alt="" height={32} width={32}/>
                </a>
                <ul className="dropdown-menu dropdown-menu-end" area-labeledby="navbarDropdown">
                    <li>
                        <a href="#!" className="dropdown-item"> Settings</a>
                        <a href="#!" className="dropdown-item"> Activity</a>
                        <li>
                            <hr className="dropdown-divider"/>
                        </li>
                        <a href="#!" className="dropdown-item" onClick={logout}> Logout</a>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
</nav>
  )
}

export default Menubar;