import { useState } from "react";
import { login } from "../../services/authService";
import "./Login.css";

function Login() {

    const [username, setUsername] = useState("");
    const [contrasenia, setContrasenia] = useState("");
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState("");

    async function iniciarSesion(e) {

        const token = localStorage.getItem("token");

        if (token) {
            window.location.href = "/home";
        }

        e.preventDefault();

        setError("");
        setLoading(true);

        try {

            await login(username, contrasenia);

            window.location.href = "/home";

        } catch (err) {

            setError("Usuario o contraseña incorrectos");

        } finally {

            setLoading(false);
        }
    }

    return (
        <div className="login-container">

            <div className="login-card">

                <h1 className="login-title">
                    Personal Finance
                </h1>

                <p className="login-subtitle">
                    Inicia sesión para continuar
                </p>

                <form
                    className="login-form"
                    onSubmit={iniciarSesion}
                >

                    <div className="form-group">
                        <label>Usuario</label>

                        <input
                            type="text"
                            value={username}
                            onChange={(e) =>
                                setUsername(e.target.value)
                            }
                            placeholder="Ingrese su usuario"
                            required
                        />
                    </div>

                    <div className="form-group">
                        <label>Contraseña</label>

                        <input
                            type="password"
                            value={contrasenia}
                            onChange={(e) =>
                                setContrasenia(e.target.value)
                            }
                            placeholder="Ingrese su contraseña"
                            required
                        />
                    </div>

                    {error && (
                        <div className="error-message">
                            {error}
                        </div>
                    )}

                    <button
                        type="submit"
                        className="login-button"
                        disabled={loading}
                    >
                        {loading
                            ? "Ingresando..."
                            : "Ingresar"}
                    </button>

                </form>

            </div>

        </div>
    );
}

export default Login;