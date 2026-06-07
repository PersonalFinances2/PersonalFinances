const API_URL = "http://localhost:8080/usuarios";

export async function crudUsuarios(method = "GET", id = "", data = null) {

    const options = {
        method,
        headers: {
            "Content-Type": "application/json"
        }
    };

    if (data) {
        options.body = JSON.stringify(data);
    }

    const response = await fetch(
        id ? `${API_URL}/${id}` : API_URL,
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