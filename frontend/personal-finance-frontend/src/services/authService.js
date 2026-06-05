const API_URL = "http://localhost:8080/auth/login";

export async function login(username, contrasenia) {

    const response = await fetch(API_URL, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            username,
            contrasenia
        })
    });

    if (!response.ok) {
        throw new Error("Usuario o contraseña incorrectos");
    }

    const data = await response.json();

    // Guardar JWT
    localStorage.setItem("token", data.token);
    localStorage.setItem("username", username);

    return data;    
}

export function getToken() {
    return localStorage.getItem("token");
}

//Cerrar sesión
export function logout() {
    localStorage.removeItem("token");
    localStorage.removeItem("username");
}

//Validar si hay sesión
export function isAuthenticated() {
    return localStorage.getItem("token") !== null;
}