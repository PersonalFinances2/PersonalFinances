import { Link, useNavigate } from "react-router-dom";
import { logout, getRole } from "../../services/authService";
import "./Navbar.css";

function Navbar() {

    const navigate = useNavigate();

    const username = localStorage.getItem("username") || "Usuario";
    const rol = getRole();

    function cerrarSesion() {

        logout();

        navigate("/");
    }

    return (
        <nav className="navbar">

            <div className="navbar-logo">
                <Link
                    to="/home"
                    style={{
                        textDecoration: "none",
                        color: "inherit",
                    }}
                >
                    Personal Finance
                </Link>
            </div>

            <div className="navbar-links">

                {rol === "ROLE_ADMIN" && (
                    <Link
                        to="/listausuario"
                        className="navbar-link"
                    >
                        Usuarios
                    </Link>
                )}

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