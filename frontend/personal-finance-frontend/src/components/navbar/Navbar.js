import { Link, useNavigate } from "react-router-dom";
import { logout } from "../../services/authService";
import "./Navbar.css";

function Navbar() {

    const navigate = useNavigate();

    const username = localStorage.getItem("username") || "Usuario";

    function cerrarSesion() {

        logout();

        navigate("/");
    }

    return (
        <nav className="navbar">

            <div className="navbar-logo">
                Personal Finance
            </div>

            <div className="navbar-links">

                <Link
                    to="/metas"
                    className="navbar-link"
                >
                    Metas
                </Link>

                <span className="navbar-user">
                    {username}
                </span>

                <button
                    className="navbar-logout"
                    onClick={cerrarSesion}
                >
                    Cerrar sesión
                </button>

            </div>

        </nav>
    );
}

export default Navbar;