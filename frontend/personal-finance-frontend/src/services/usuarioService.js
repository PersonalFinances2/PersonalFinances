const API_URL = "http://localhost:8080/usuarios";
const token = localStorage.getItem("token");

export async function crudUsuarios(method = "GET", endpoint = "", data = null) {

    const options = {
        method,
        headers: {
            "Content-Type": "application/json",
            "Authorization": `Bearer ${token}`
        }
    };

    if (data) {
        options.body = JSON.stringify(data);
    }

    const response = await fetch(
        `${API_URL}${endpoint}`,
        options
    );

    if (!response.ok) {
        throw new Error("Error al consumir la API");
    }

    if (response.status === 204) {
        return null;
    }

    return await response.json();
}